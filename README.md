package com.kotak.orchestrator.orchestrator.serializer;

import com.kotak.orchestrator.orchestrator.dto.PlutusFinacleData;
import com.kotak.plutus.commonlib.serializer.PlutusAvroDeserializer;


public class PlutusFinacleDeserializer extends PlutusAvroDeserializer<PlutusFinacleData> {
    public PlutusFinacleDeserializer() {
        super(PlutusFinacleData.class);
    }
}
