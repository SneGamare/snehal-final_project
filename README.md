import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import java.io.ByteArrayOutputStream;

private String avroToJson(BusinessEvent data) {
    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
        DatumWriter<BusinessEvent> writer = new SpecificDatumWriter<>(data.getSchema());
        Encoder encoder = EncoderFactory.get().jsonEncoder(data.getSchema(), out);
        writer.write(data, encoder);
        encoder.flush();
        return out.toString();
    } catch (Exception e) {
        log.error("Failed to convert Avro to JSON", e);
        return "{}";
    }
}
