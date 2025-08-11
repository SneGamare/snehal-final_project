INSERT INTO templates (id, name, description, input_format, output_format, mapping_logic)
VALUES (1, 'JSON to CAMT', 'Test mapping for CAMT message', 'JSON', 'CAMT', 
'{"accountNumber":"AcctId", "amount":"Amt", "currency":"Ccy"}');


SELECT * FROM TRANSFORMATION_TEMPLATES;
ID  	DESCRIPTION  	INPUT_FORMAT  	OUTPUT_FORMAT  	TEMPLATE_NAME  	MAPPING_LOGIC  
(no rows, 4 ms)

