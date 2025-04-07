package com.javatechie.serializer;

import com.javatechie.dto.PlutusFinacleData;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PlutusFinacleDataSerializer implements Serializer<PlutusFinacleData> {

    @Override
    public byte[] serialize(String topic, PlutusFinacleData data) {
        if (data == null) {
            return null;
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
            DatumWriter<PlutusFinacleData> writer = new SpecificDatumWriter<>(PlutusFinacleData.class);
            writer.write(data, encoder);
            encoder.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error serializing PlutusFinacleData", e);
        }
    }
} 