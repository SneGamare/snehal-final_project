package com.kotak.transform_engine.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.transform_engine.model.TransformationTemplate;
import com.kotak.transform_engine.repository.TemplateRepository;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

@Service
public class TransformationService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TemplateRepository templateRepository;

    public TransformationService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public String transform(Long templateId, String inputPayload) throws Exception {
        TransformationTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new IllegalArgumentException("Template not found"));

        JsonNode jsonNode = objectMapper.readTree(inputPayload);
        Map<String, String> mapping = objectMapper.readValue(template.getMappingLogic(), Map.class);

        String inputFormat = template.getInputFormat().toUpperCase();
        String outputFormat = template.getOutputFormat().toUpperCase();

        if ("JSON".equals(inputFormat) && "CAMT".equals(outputFormat)) {
            return transformJsonToCamt(jsonNode, mapping);
        } else if ("JSON".equals(inputFormat) && "XML".equals(outputFormat)) {
            return transformJsonToXml(jsonNode, mapping);
        } else if ("JSON".equals(inputFormat) && "AVRO".equals(outputFormat)) {
            return transformJsonToAvro(jsonNode, mapping);
        } else {
            throw new UnsupportedOperationException("Transformation " + inputFormat + " to " + outputFormat + " not supported");
        }
    }

    private String transformJsonToCamt(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        Document camtDoc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        Element root = camtDoc.createElement("CamtMessage");
        camtDoc.appendChild(root);

        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            String sourceField = entry.getKey();
            String targetField = entry.getValue();

            JsonNode valueNode = jsonNode.at("/" + sourceField);
            String value = valueNode.isMissingNode() ? "" : valueNode.asText();

            Element fieldElement = camtDoc.createElement(targetField);
            fieldElement.setTextContent(value);
            root.appendChild(fieldElement);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(camtDoc), new StreamResult(writer));

        return writer.toString();
    }

    private String transformJsonToXml(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        Document xmlDoc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        Element root = xmlDoc.createElement("Root");
        xmlDoc.appendChild(root);

        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            String sourceField = entry.getKey();
            String targetField = entry.getValue();

            JsonNode valueNode = jsonNode.at("/" + sourceField);
            String value = valueNode.isMissingNode() ? "" : valueNode.asText();

            Element fieldElement = xmlDoc.createElement(targetField);
            fieldElement.setTextContent(value);
            root.appendChild(fieldElement);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(xmlDoc), new StreamResult(writer));

        return writer.toString();
    }

    private String transformJsonToAvro(JsonNode jsonNode, Map<String, String> mapping) throws Exception {
        // Build schema dynamically from mapping
        StringBuilder schemaBuilder = new StringBuilder();
        schemaBuilder.append("{\"type\":\"record\",\"name\":\"MappedRecord\",\"fields\":[");
        boolean first = true;
        for (String targetField : mapping.values()) {
            if (!first) schemaBuilder.append(",");
            schemaBuilder.append("{\"name\":\"").append(targetField).append("\",\"type\":\"string\"}");
            first = false;
        }
        schemaBuilder.append("]}");

        Schema schema = new Schema.Parser().parse(schemaBuilder.toString());

        // Populate Avro record
        GenericRecord record = new GenericData.Record(schema);
        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            JsonNode valueNode = jsonNode.at("/" + entry.getKey());
            String value = valueNode.isMissingNode() ? "" : valueNode.asText();
            record.put(entry.getValue(), value);
        }

        // Serialize Avro to Base64 String
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new SpecificDatumWriter<>(schema);
        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        writer.write(record, encoder);
        encoder.flush();

        return java.util.Base64.getEncoder().encodeToString(out.toByteArray());
    }
}




-- 1. JSON → CAMT
INSERT INTO TRANSFORMATION_TEMPLATES 
(DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES (
  'JSON to CAMT Account Mapping',
  'JSON',
  'CAMT',
  'AccountTemplate',
  '{"accountNumber":"AcctId", "amount":"Amt"}'
);

-- 2. JSON → XML
INSERT INTO TRANSFORMATION_TEMPLATES 
(DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES (
  'JSON to XML Account Mapping',
  'JSON',
  'XML',
  'AccountXMLTemplate',
  '{"accountNumber":"AccountId", "amount":"AmountValue"}'
);

-- 3. JSON → AVRO
INSERT INTO TRANSFORMATION_TEMPLATES 
(DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES (
  'JSON to AVRO Account Mapping',
  'JSON',
  'AVRO',
  'AccountAvroTemplate',
  '{"accountNumber":"AcctId", "amount":"Amt"}'
);




curl -X POST "http://localhost:8080/transform/1" \
  -H "Content-Type: application/json" \
  -d '{"accountNumber":"1234567890","amount":"5000"}'



curl -X POST "http://localhost:8080/transform/2" \
  -H "Content-Type: application/json" \
  -d '{"accountNumber":"1234567890","amount":"5000"}'


curl -X POST "http://localhost:8080/transform/3" \
  -H "Content-Type: application/json" \
  -d '{"accountNumber":"1234567890","amount":"5000"}'


FDEyMzQ1Njc4OTAINTAwMA==

