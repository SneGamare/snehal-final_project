package com.kotak.nifi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.generic.GenericDatumWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class TransformationUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private TransformationUtils() {}

    // -------- JSON → CAMT (XML) --------
    public static String jsonToCamt(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("CamtMessage");
        doc.appendChild(root);

        for (Map.Entry<String, String> e : mapping.entrySet()) {
            String source = e.getKey();
            String targetPath = e.getValue(); // supports "Acct/Id" style nested paths
            String value = readJsonValue(jsonNode, source);

            appendElementPath(doc, root, targetPath, value);
        }
        return toXmlString(doc);
    }

    // -------- JSON → Generic XML --------
    public static String jsonToXml(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("Root");
        doc.appendChild(root);

        for (Map.Entry<String, String> e : mapping.entrySet()) {
            String source = e.getKey();
            String targetPath = e.getValue(); // supports "Parent/Child"
            String value = readJsonValue(jsonNode, source);

            appendElementPath(doc, root, targetPath, value);
        }
        return toXmlString(doc);
    }

    // -------- JSON → Avro (JSON-encoded for readability) --------
    public static String jsonToAvro(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        // Build dynamic schema from target field LAST SEGMENT (for paths like "Acct/Id" -> "Id")
        List<String> fieldNames = new ArrayList<>();
        for (String target : mapping.values()) {
            fieldNames.add(toAvroFieldName(lastSegment(target)));
        }

        String schemaStr = buildAvroSchema("MappedRecord", fieldNames);
        Schema schema = new Schema.Parser().parse(schemaStr);

        GenericRecord record = new GenericData.Record(schema);
        for (Map.Entry<String, String> e : mapping.entrySet()) {
            String source = e.getKey();
            String target = toAvroFieldName(lastSegment(e.getValue()));
            String value = readJsonValue(jsonNode, source);
            record.put(target, value);
        }

        // Return JSON-encoded Avro (human-readable). Switch to BinaryEncoder if you want binary.
        StringWriter out = new StringWriter();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, out);
        writer.write(record, jsonEncoder);
        jsonEncoder.flush();
        return out.toString();
    }

    // ----------------- Helpers -----------------

    /** Read JSON by simple field or JSON Pointer (if source starts with '/'). */
    private static String readJsonValue(JsonNode node, String source) {
        JsonNode v = source.startsWith("/") ? node.at(source) : node.path(source);
        return v.isMissingNode() || v.isNull() ? "" : v.asText();
    }

    /** Append nested elements from a path like "Acct/Id". */
    private static void appendElementPath(Document doc, Element parent, String path, String value) {
        String[] parts = path.split("/");
        Element current = parent;
        for (int i = 0; i < parts.length; i++) {
            String safeName = sanitizeXmlName(parts[i]);
            Element next = findChild(current, safeName);
            if (next == null) {
                next = doc.createElement(safeName);
                current.appendChild(next);
            }
            current = next;
        }
        current.setTextContent(value);
    }

    /** Try to find an existing child element with given name (to share parents across mappings). */
    private static Element findChild(Element parent, String name) {
        for (int i = 0; i < parent.getChildNodes().getLength(); i++) {
            if (parent.getChildNodes().item(i) instanceof Element) {
                Element el = (Element) parent.getChildNodes().item(i);
                if (el.getTagName().equals(name)) return el;
            }
        }
        return null;
    }

    /** Sanitize XML element names to avoid INVALID_CHARACTER_ERR. */
    public static String sanitizeXmlName(String raw) {
        if (raw == null || raw.isEmpty()) return "F_";
        String s = raw.replaceAll("[^A-Za-z0-9._-]", "_");
        if (!Character.isLetter(s.charAt(0)) && s.charAt(0) != '_') {
            s = "F_" + s; // must start with letter or underscore
        }
        return s;
    }

    private static String toXmlString(Document doc) throws Exception {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        StringWriter w = new StringWriter();
        t.transform(new DOMSource(doc), new StreamResult(w));
        return w.toString();
    }

    private static String lastSegment(String path) {
        int idx = path.lastIndexOf('/');
        return idx >= 0 ? path.substring(idx + 1) : path;
    }

    private static String toAvroFieldName(String raw) {
        // Avro: [A-Za-z_][A-Za-z0-9_]*
        String s = raw == null ? "f" : raw.replaceAll("[^A-Za-z0-9_]", "_");
        if (!s.matches("^[A-Za-z_].*")) s = "_" + s;
        return s;
    }

    private static String buildAvroSchema(String name, List<String> fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"type\":\"record\",\"name\":\"").append(name).append("\",\"fields\":[");
        for (int i = 0; i < fields.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append("{\"name\":\"").append(fields.get(i)).append("\",\"type\":\"string\"}");
        }
        sb.append("]}");
        return sb.toString();
    }
}





package com.kotak.nifi.processors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.nifi.util.TransformationUtils;
import org.apache.nifi.annotation.behavior.InputRequirement;
import org.apache.nifi.annotation.behavior.InputRequirement.Requirement;
import org.apache.nifi.annotation.behavior.SideEffectFree;
import org.apache.nifi.annotation.behavior.SupportsBatching;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.capability.CapabilityDescription;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.dbcp.DBCPService;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.logging.ComponentLog;
import org.apache.nifi.processor.*;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.util.StandardValidators;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
    import java.util.*;

@Tags({"transform", "json", "xml", "avro", "camt", "mapping", "template"})
@CapabilityDescription("Transforms JSON FlowFile content to CAMT XML, generic XML, or Avro(JSON) using DB-stored mapping templates.")
@SideEffectFree
@SupportsBatching
@InputRequirement(Requirement.INPUT_REQUIRED)
@WritesAttributes({
    @WritesAttribute(attribute = "mime.type", description = "Set to application/xml for XML/CAMT or application/json for Avro(JSON)"),
    @WritesAttribute(attribute = "transform.template.id", description = "Template ID used")
})
public class TransformJsonProcessor extends AbstractProcessor {

    public static final PropertyDescriptor DBCP_SERVICE = new PropertyDescriptor.Builder()
            .name("dbcp-service")
            .displayName("DBCPConnectionPool")
            .description("DBCP service for connecting to the template database (H2)")
            .required(true)
            .identifiesControllerService(DBCPService.class)
            .build();

    public static final PropertyDescriptor DEFAULT_TEMPLATE_ID = new PropertyDescriptor.Builder()
            .name("default-template-id")
            .displayName("Default Template ID")
            .description("Fallback Template ID if not provided as attribute or query param")
            .required(false)
            .addValidator(StandardValidators.LONG_VALIDATOR)
            .build();

    public static final Relationship REL_SUCCESS = new Relationship.Builder()
            .name("success")
            .description("Successful transformation")
            .build();

    public static final Relationship REL_FAILURE = new Relationship.Builder()
            .name("failure")
            .description("Failed transformation")
            .build();

    private List<PropertyDescriptor> descriptors;
    private Set<Relationship> relationships;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void init(final ProcessorInitializationContext context) {
        List<PropertyDescriptor> d = new ArrayList<>();
        d.add(DBCP_SERVICE);
        d.add(DEFAULT_TEMPLATE_ID);
        descriptors = Collections.unmodifiableList(d);

        Set<Relationship> r = new HashSet<>();
        r.add(REL_SUCCESS);
        r.add(REL_FAILURE);
        relationships = Collections.unmodifiableSet(r);
    }

    @Override
    public Set<Relationship> getRelationships() {
        return relationships;
    }

    @Override
    public List<PropertyDescriptor> getSupportedPropertyDescriptors() {
        return descriptors;
    }

    @OnScheduled
    public void onScheduled(final ProcessContext context) {}

    @Override
    public void onTrigger(final ProcessContext context, final ProcessSession session) throws ProcessException {
        final ComponentLog log = getLogger();
        FlowFile flowFile = session.get();
        if (flowFile == null) return;

        try {
            // ---- Resolve templateId ----
            String templateIdStr = flowFile.getAttribute("templateId");
            if (templateIdStr == null) {
                // try query string: http.query.string e.g. "templateId=1&x=y"
                String qs = flowFile.getAttribute("http.query.string");
                if (qs != null) {
                    Map<String,String> q = parseQueryString(qs);
                    templateIdStr = q.get("templateId");
                }
            }
            if (templateIdStr == null) {
                templateIdStr = context.getProperty(DEFAULT_TEMPLATE_ID).getValue();
            }
            if (templateIdStr == null) {
                throw new IllegalArgumentException("templateId not provided (attribute, query param, or default)");
            }
            long templateId = Long.parseLong(templateIdStr);

            // ---- Read request body (JSON) ----
            final String inputJson;
            try (InputStream in = session.read(flowFile)) {
                inputJson = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            }
            JsonNode inputNode = mapper.readTree(inputJson);

            // ---- Query template from DB ----
            final DBCPService dbcp = context.getProperty(DBCP_SERVICE).asControllerService(DBCPService.class);
            String output;
            String outputFormat;
            try (Connection conn = dbcp.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                    "SELECT MAPPING_LOGIC, INPUT_FORMAT, OUTPUT_FORMAT FROM TRANSFORMATION_TEMPLATES WHERE ID = ?")) {
                ps.setLong(1, templateId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        throw new IllegalArgumentException("Template not found: " + templateId);
                    }
                    String mappingJson = rs.getString("MAPPING_LOGIC");
                    String inputFormat = rs.getString("INPUT_FORMAT");
                    outputFormat = rs.getString("OUTPUT_FORMAT");

                    if (!"JSON".equalsIgnoreCase(inputFormat)) {
                        throw new UnsupportedOperationException("Only JSON input supported currently");
                    }
                    @SuppressWarnings("unchecked")
                    Map<String, String> mapping = mapper.readValue(mappingJson, Map.class);

                    // ---- Transform ----
                    if ("CAMT".equalsIgnoreCase(outputFormat)) {
                        output = TransformationUtils.jsonToCamt(inputNode, mapping);
                        flowFile = session.putAttribute(flowFile, "mime.type", "application/xml");
                    } else if ("XML".equalsIgnoreCase(outputFormat)) {
                        output = TransformationUtils.jsonToXml(inputNode, mapping);
                        flowFile = session.putAttribute(flowFile, "mime.type", "application/xml");
                    } else if ("AVRO".equalsIgnoreCase(outputFormat)) {
                        output = TransformationUtils.jsonToAvro(inputNode, mapping); // JSON-encoded Avro
                        flowFile = session.putAttribute(flowFile, "mime.type", "application/json");
                    } else {
                        throw new UnsupportedOperationException("Unsupported OUTPUT_FORMAT: " + outputFormat);
                    }
                }
            }

            // ---- Write result and attributes ----
            final String result = output;
            flowFile = session.write(flowFile, out -> out.write(result.getBytes(StandardCharsets.UTF_8)));
            flowFile = session.putAttribute(flowFile, "transform.template.id", String.valueOf(templateId));
            flowFile = session.putAttribute(flowFile, "transform.output.format", outputFormat.toUpperCase(Locale.ROOT));

            session.transfer(flowFile, REL_SUCCESS);

        } catch (Exception ex) {
            getLogger().error("Transformation failed", ex);
            session.transfer(flowFile, REL_FAILURE);
        }
    }

    private static Map<String,String> parseQueryString(String qs) {
        Map<String,String> map = new HashMap<>();
        for (String p : qs.split("&")) {
            int i = p.indexOf('=');
            if (i >= 0) map.put(urlDecode(p.substring(0,i)), urlDecode(p.substring(i+1)));
            else map.put(urlDecode(p), "");
        }
        return map;
    }

    private static String urlDecode(String s) {
        try {
            return java.net.URLDecoder.decode(s, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return s;
        }
    }
}
