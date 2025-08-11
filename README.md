INSERT INTO templates (id, name, description, input_format, output_format, mapping_logic)
VALUES (1, 'JSON to CAMT', 'Test mapping for CAMT message', 'JSON', 'CAMT', 
'{"accountNumber":"AcctId", "amount":"Amt", "currency":"Ccy"}');


curl -X POST "http://localhost:8080/transform/1" \
     -H "Content-Type: application/json" \
     -d '{"accountNumber":"123456","amount":"1000","currency":"USD"}'
