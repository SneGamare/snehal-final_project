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
