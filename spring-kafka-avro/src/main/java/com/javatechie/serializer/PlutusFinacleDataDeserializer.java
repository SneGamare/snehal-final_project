package com.javatechie.serializer;

import com.javatechie.dto.PlutusFinacleData;

public class PlutusFinacleDataDeserializer extends AvroDeserializer<PlutusFinacleData> {

    public PlutusFinacleDataDeserializer() {
        super(PlutusFinacleData.class);
    }
}
