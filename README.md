package com.example.transformer.output;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.file.DataFileWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;

@Component
public class AvroFormatter {

    // For simplicity, using hardcoded schema. You can pull from DB per template ID if needed.
    private static final String HARDCODED_SCHEMA = """
        {
          "type": "record",
          "name": "TransformedData",
          "fields": [
            {"name": "id", "type": "string"},
            {"name": "amount", "type": "double"},
            {"name": "currency", "type": "string"}
          ]
        }
        """;

    private final Schema schema = new Schema.Parser().parse(HARDCODED_SCHEMA);

    public String format(Object transformed) throws Exception {
        Map<String, Object> data = (Map<String, Object>) transformed;
        GenericRecord record = new GenericData.Record(schema);
        for (Schema.Field field : schema.getFields()) {
            Object value = data.get(field.name());
            record.put(field.name(), value);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> writer = new DataFileWriter<>(datumWriter);
        writer.create(schema, outputStream);
        writer.append(record);
        writer.close();

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
