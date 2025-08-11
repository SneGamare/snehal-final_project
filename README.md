INSERT INTO templates (id, name, description, input_format, output_format, mapping_logic)
VALUES (1, 'JSON to CAMT', 'Test mapping for CAMT message', 'JSON', 'CAMT', 
'{"accountNumber":"AcctId", "amount":"Amt", "currency":"Ccy"}');


SELECT * FROM TRANSFORMATION_TEMPLATES;
ID  	DESCRIPTION  	INPUT_FORMAT  	OUTPUT_FORMAT  	TEMPLATE_NAME  	MAPPING_LOGIC  
(no rows, 4 ms)

package com.example.camel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRANSFORMATION_TEMPLATES")
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "INPUT_FORMAT")
    private String inputFormat;  // e.g., "JSON"

    @Column(name = "OUTPUT_FORMAT")
    private String outputFormat; // e.g., "CAMT"

    @Column(name = "TEMPLATE_NAME")
    private String templateName;

    @Lob
    @Column(name = "MAPPING_LOGIC")
    private String mappingLogic; // JSON mapping rules

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getInputFormat() { return inputFormat; }
    public void setInputFormat(String inputFormat) { this.inputFormat = inputFormat; }

    public String getOutputFormat() { return outputFormat; }
    public void setOutputFormat(String outputFormat) { this.outputFormat = outputFormat; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public String getMappingLogic() { return mappingLogic; }
    public void setMappingLogic(String mappingLogic) { this.mappingLogic = mappingLogic; }
}




INSERT INTO TRANSFORMATION_TEMPLATES 
(DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES (
  'JSON to CAMT Account Mapping',
  'JSON',
  'CAMT',
  'AccountTemplate',
  '{"accountNumber":"AcctId", "amount":"Amt"}'
);




if (!template.getInputFormat().equalsIgnoreCase("JSON")) {
    throw new IllegalArgumentException("Only JSON input supported right now.");
}

if (!template.getOutputFormat().equalsIgnoreCase("CAMT")) {
    throw new IllegalArgumentException("Only CAMT output supported right now.");
}



curl -X POST "http://localhost:8080/transform/1" \
     -H "Content-Type: application/json" \
     -d '{"accountNumber": "1234567890", "amount": "1000.50"}'


INSERT INTO TRANSFORMATION_TEMPLATES
(ID, DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES
(
  1,
  'Sample CAMT transformation template',
  'JSON',
  'CAMT',
  'Sample CAMT Template',
  '{"accountNumber": "Acct/Id", "amount": "Bal/Amt"}'
);



{
  "templateId": 1,
  "templateName": "Sample CAMT Template",
  "payload": {
    "accountNumber": "1234567890",
    "amount": "1000.50"
  }
}



curl -X POST "http://localhost:8080/transform" \
     -H "Content-Type: application/json" \
     -d '{
           "templateId": 1,
           "templateName": "Sample CAMT Template",
           "payload": {
               "accountNumber": "1234567890",
               "amount": "1000.50"
           }
         }'
