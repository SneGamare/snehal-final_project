@Slf4j
public class PlutusAvroDeserializer<T extends SpecificRecord> implements Deserializer<T> {

    private final Class<T> targetClass;

    public PlutusAvroDeserializer(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            log.info("Received null data for topic '{}', skipping deserialization.", topic);
            return null;
        }

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data)) {
            BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
            DatumReader<T> reader = new SpecificDatumReader<>(targetClass);
            return reader.read(null, decoder);
        } catch (Exception e) {
            log.error("Failed to deserialize Avro data to type {}: {}", targetClass.getSimpleName(), e.getMessage(), e);
            throw new SerializationException("Error deserializing byte[] to " + targetClass.getName(), e);
        }
    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        if (data != null) {
            String hexData = Hex.encodeHexString(data);
            log.debug("PlutusAvroDeserializer received Hex payload for topic '{}': {}", topic, hexData);
        }

        try {
            return deserialize(topic, data);
        } catch (SerializationException e) {
            log.error("Deserialization failed for topic '{}': {}", topic, e.getMessage(), e);
            return null;
        }
    }
}
