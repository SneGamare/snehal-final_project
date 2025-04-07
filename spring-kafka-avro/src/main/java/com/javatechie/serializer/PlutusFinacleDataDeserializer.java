package com.javatechie.serializer;

import com.javatechie.dto.PlutusFinacleData;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlutusFinacleDataDeserializer implements Deserializer<PlutusFinacleData> {

    @Override
    public PlutusFinacleData deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
            DatumReader<PlutusFinacleData> reader = new SpecificDatumReader<>(PlutusFinacleData.class);
            return reader.read(null, decoder);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing PlutusFinacleData", e);
        }
    }
} 