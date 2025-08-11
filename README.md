API Functionality:
Accepts a JSON payload and a transformation template ID.
Applies transformation logic as defined in the template.
Returns the transformed output in the expected format.
Template Management UI:
Allows users to create new transformation templates.
Enables editing and deletion of existing templates.
Provides a visual interface to map source fields to target fields.
Validates template structure and transformation rules.
Template Storage:
Templates are stored in a persistent database.
Each template has a unique ID, name, description, and mapping logic.
Error Handling:
Returns appropriate error messages for invalid payloads or template IDs.
Logs transformation failures for debugging.


As a developer,
I want to create an API that accepts an input payload and a transformation template ID,
So that it can apply the transformation logic defined in the template and return the transformed output.
Additionally, I want to provide a UI to create and manage transformation templates, enabling users to map source structures to target structures.


Apache Camel







<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>json-to-camt</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot + JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>

        <!-- Apache Camel (Spring Boot) -->
        <dependency>
            <groupId>org.apache.camel.springboot</groupId>
            <artifactId>camel-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.camel.springboot</groupId>
            <artifactId>camel-servlet-starter</artifactId>
        </dependency>

        <!-- JSONPath for mapping extraction -->
        <dependency>
            <groupId>com.jayway.jsonpath</groupId>
            <artifactId>json-path</artifactId>
            <version>2.8.0</version>
        </dependency>

        <!-- Jackson -->
        <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-databind</artifactId>
        </dependency>

        <!-- Tests (optional) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>



package com.example.camt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



package com.example.camt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transformation_templates")
public class TransformationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;

    @Column(columnDefinition = "text")
    private String description;

    @Lob
    @Column(columnDefinition = "text")
    private String mappingLogic; // JSON string with mapping rules

    private String inputFormat;
    private String outputFormat;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getMappingLogic() { return mappingLogic; }
    public void setMappingLogic(String mappingLogic) { this.mappingLogic = mappingLogic; }
    public String getInputFormat() { return inputFormat; }
    public void setInputFormat(String inputFormat) { this.inputFormat = inputFormat; }
    public String getOutputFormat() { return outputFormat; }
    public void setOutputFormat(String outputFormat) { this.outputFormat = outputFormat; }
}


package com.example.camt.repository;

import com.example.camt.model.TransformationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TransformationTemplate, Long> {
}


package com.example.camt.service;

import com.example.camt.model.TransformationTemplate;
import com.example.camt.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateService {
    private final TemplateRepository repo;
    public TemplateService(TemplateRepository repo) { this.repo = repo; }

    public Optional<TransformationTemplate> getTemplate(Long id) {
        return repo.findById(id);
    }
}




package com.example.camt.route;

import com.example.camt.model.TransformationTemplate;
import com.example.camt.service.TemplateService;
import com.example.camt.service.TransformationService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class TransformRoute extends RouteBuilder {

    private final TemplateService templateService;
    private final TransformationService transformationService;

    public TransformRoute(TemplateService templateService, TransformationService transformationService) {
        this.templateService = templateService;
        this.transformationService = transformationService;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").contextPath("/").bindingMode(RestBindingMode.off);

        onException(Exception.class)
            .handled(true)
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
            .setBody().simple("{\"error\":\"${exception.message}\"}");

        rest("/transform")
            .post("/{templateId}")
            .consumes("application/json")
            .produces("application/xml")
            .route()
            .process(exchange -> {
                String tmpl = exchange.getIn().getHeader("templateId", String.class);
                Long templateId = Long.valueOf(tmpl);

                TransformationTemplate template = templateService.getTemplate(templateId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid template id: " + templateId));

                String json = exchange.getIn().getBody(String.class);
                String camtXml = transformationService.transformJsonToCamt(json, template);

                exchange.getMessage().setBody(camtXml);
                exchange.getMessage().setHeader(Exchange.CONTENT_TYPE, "application/xml");
            });
    }
}





package com.example.camel.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Optional;

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

    public String transformJsonToCamt(String jsonPayload, Long templateId) throws Exception {
        Optional<TemplateEntity> templateOpt = templateRepository.findById(templateId);

        if (templateOpt.isEmpty()) {
            throw new IllegalArgumentException("Template not found for ID: " + templateId);
        }

        TemplateEntity template = templateOpt.get();

        JsonNode jsonNode = objectMapper.readTree(jsonPayload);
        Map<String, String> mapping = objectMapper.readValue(template.getMappingLogic(), Map.class);

        Document camtDoc = createCamtDocument(jsonNode, mapping);

        return convertDocumentToString(camtDoc);
    }

    private Document createCamtDocument(JsonNode jsonNode, Map<String, String> mapping)
            throws ParserConfigurationException {

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        Element root = doc.createElement("CamtMessage");
        doc.appendChild(root);

        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            String sourceField = entry.getKey();
            String targetField = entry.getValue();

            JsonNode valueNode = jsonNode.at("/" + sourceField);
            String value = valueNode.isMissingNode() ? "" : valueNode.asText();

            Element fieldElement = doc.createElement(targetField);
            fieldElement.setTextContent(value);
            root.appendChild(fieldElement);
        }

        return doc;
    }

    private String convertDocumentToString(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.toString();
    }
}

