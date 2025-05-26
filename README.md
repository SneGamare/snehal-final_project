package com.kotak.orchestrator.orchestrator.serializer;


import lombok.extern.slf4j.Slf4j;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.codec.binary.Hex;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;

/**
 * Generic Avro Deserializer for Plutus Kafka consumers.
 *
 * <p>
 * This class deserializes Avro-encoded byte arrays into specific Avro record types.
 * It also provides enhanced logging (including hex-encoded payloads) to simplify debugging
 * in UAT and production environments.
 *
 * @param <T> The Avro-generated class extending {@link SpecificRecord}.
 */
@Slf4j
public class PlutusAvroDeserializer<T extends SpecificRecord> implements Deserializer<T> {

    private final Class<T> targetClass;

    /**
     * Constructs a new Plutus Avro Deserializer.
     *
     * @param targetClass The Avro class to deserialize to (e.g., PlutusFinacleData.class).
     */
    public PlutusAvroDeserializer(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            System.out.println("Received null data for topic '{}', skipping deserialization."+ topic);
            return null;
        }

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data)) {
            BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
            DatumReader<T> reader = new SpecificDatumReader<>(targetClass);
            return reader.read(null, decoder);
        } catch (Exception e) {
            System.out.println("Failed to deserialize Avro data to type {}: {}"+ targetClass.getSimpleName()+ e.getMessage()+ e);
            throw new SerializationException("Error deserializing byte[] to " + targetClass.getName(), e);
        }
    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        // Log hex payload for debugging (especially useful during UAT)
        if (data != null) {
            String hexData = Hex.encodeHexString(data);
            System.out.println("PlutusAvroDeserializer received Hex payload for topic '{}': {}"+ topic+ hexData);
        }

        try {
            return deserialize(topic, data);
        } catch (SerializationException e) {
            return null; // Optional: allow downstream code to handle nulls gracefully
        }
    }
}
