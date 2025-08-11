INSERT INTO TRANSFORMATION_TEMPLATES 
(DESCRIPTION, INPUT_FORMAT, OUTPUT_FORMAT, TEMPLATE_NAME, MAPPING_LOGIC)
VALUES (
  'JSON to CAMT Account Mapping',
  'JSON',
  'CAMT',
  'AccountTemplate',
  '{"accountNumber":"AcctId", "amount":"Amt"}'
);
