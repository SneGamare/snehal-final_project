INSERT INTO transformation_template (id, name, input_format, output_format, transformation_spec)
VALUES (
  'camt-to-json',
  'CAMT XML to JSON',
  'xml',
  'json',
  '[
    {
      "operation": "shift",
      "spec": {
        "Document": {
          "Amt": "amount",
          "Ccy": "currency"
        }
      }
    }
  ]'
);
