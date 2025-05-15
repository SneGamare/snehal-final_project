package com.kotak.orchestrator.orchestrator.serializer;

import com.kotak.orchestrator.orchestrator.schema.PlutusFinacleData;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlutusFinacleDeserializerTest {

    private PlutusAvroDeserializer<PlutusFinacleData> plutusAvroDeserializer;

    @BeforeEach
    void setUp() {
        plutusAvroDeserializer = new PlutusAvroDeserializer<>(PlutusFinacleData.class);
    }

    @Test
    void givenValidHexAvroData_whenDeserialize_thenReturnsExpectedObject() throws DecoderException {
        // Sample hex encoded AVRO message for PlutusFinacleData
        String hexEvent =
                "02143132333435363738393402104a6f686e20446f650214323032342d30332d32300214323032342d30332d323002105452313233343537020a505431323302024e0204435202065354310206505431020a474c313233020a41433132330214323032342d30332d3230020000000000448f40021c53616c617279205061796d656e740214323032342d30332d32300214323032342d30332d3230020c52454631323302064954310214323032342d30332d3230020a494e313233021c4d6f6e74686c792053616c617279020e43555354313233020a425230303102065553440206555344020000000000448f40020c534f4c313233020a424b303031020a545231323300";

        byte[] decodedBytes = Hex.decodeHex(hexEvent);

        PlutusFinacleData result = plutusAvroDeserializer.deserialize("dtd-business-event", decodedBytes);

        assertThat(result).isNotNull();
        assertThat(result.getTranId().toString()).isEqualTo("TR123457");  // Sample field check
        assertThat(result.getForacid().toString()).isEqualTo("1234567894");
    }

    @Test
    void givenInvalidAvroData_whenDeserialize_thenThrowsSerializationException() throws DecoderException {
        // This hex string represents an AVRO binary from a different schema, or corrupted
        String invalidHex = "00010203040506070809";
        byte[] corruptedBytes = Hex.decodeHex(invalidHex);

        assertThatThrownBy(() ->
                plutusAvroDeserializer.deserialize("invalid-topic", corruptedBytes)
        )
        .isInstanceOf(SerializationException.class)
        .hasMessageContaining("Error deserializing byte[] to");
    }

    @Test
    void givenNullByteArray_whenDeserialize_thenReturnsNull() {
        PlutusFinacleData result = plutusAvroDeserializer.deserialize("null-topic", null);
        assertThat(result).isNull();
    }
}
