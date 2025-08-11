package com.kotak.transform_engine.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.transform_engine.model.TransformationTemplate;
import com.kotak.transform_engine.repository.TemplateRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringWriter;
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

        if (!"JSON".equalsIgnoreCase(template.getInputFormat()) ||
                !"CAMT".equalsIgnoreCase(template.getOutputFormat())) {
            throw new UnsupportedOperationException("Only JSON to CAMT supported currently");
        }

        JsonNode jsonNode = objectMapper.readTree(inputPayload);
        Map<String, String> mapping = objectMapper.readValue(template.getMappingLogic(), Map.class);

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
}


