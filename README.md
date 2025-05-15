import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlutusFinacleDataAvroDeserializationTest {

    private final GamAvroDeserializer gamDeser = new GamAvroDeserializer(); // Your custom deserializer

    @Test
    void avroDeserialize_plutus_success() throws DecoderException {
        // Hex string representing serialized Avro message
        String hexEvent =
                "02143132333435363738393402104a6f686e20446f650214323032342d30332d32300214323032342d30332d323002105452313233343537020a505431323302024e0204435202065354310206505431020a474c313233020a41433132330214323032342d30332d3230020000000000448f40021c53616c617279205061796d656e740214323032342d30332d32300214323032342d30332d3230020c52454631323302064954310214323032342d30332d3230020a494e313233021c4d6f6e74686c792053616c617279020e43555354313233020a425230303102065553440206555344020000000000448f40020c534f4c313233020a424b303031020a545231323300";

        // Deserialize the hex string into a PlutusFinacleData object
        byte[] avroBytes = Hex.decodeHex(hexEvent);
        PlutusFinacleData event = gamDeser.deserialize("cros-account-master-events", avroBytes);

        // Assert specific fields (you can add more depending on what you want to validate)
        assertThat(event).isNotNull();
        assertThat(event.getForacid()).isEqualTo("1234567894");
        assertThat(event.getAcctName()).isEqualTo("John Doe");
        assertThat(event.getTranId()).isEqualTo("TR123457");
        assertThat(event.getTranAmt()).isEqualTo(52.3); // Assuming this was the encoded amount

        // Optional: Print the full object
        System.out.println("Deserialized Event: " + event);
    }
}
