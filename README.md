package com.example.transformer.parser;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

@Component("avro")
public class AvroParser implements InputParser {

    @Override
    public Map<String, Object> parse(String base64EncodedAvro) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(base64EncodedAvro);
        try (ByteArrayInputStream in = new ByteArrayInputStream(decoded);
             DataFileStream<GenericRecord> reader =
                     new DataFileStream<>(in, new GenericDatumReader<>())) {

            GenericRecord record = reader.next();  // read one record for now
            Map<String, Object> result = new HashMap<>();
            for (Schema.Field field : record.getSchema().getFields()) {
                result.put(field.name(), record.get(field.name()));
            }
            return result;
        }
    }
}
