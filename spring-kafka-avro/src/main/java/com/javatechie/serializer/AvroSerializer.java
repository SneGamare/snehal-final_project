package com.javatechie.serializer;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroSerializer<T extends SpecificRecord> implements Serializer<T> {

    @Override
    public byte[] serialize(String topic, T data) {
        if (data == null) {
            return null;
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
            DatumWriter<T> writer = new SpecificDatumWriter<>(data.getSchema());
            writer.write(data, encoder);
            encoder.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error serializing Avro message", e);
        }
    }
} 