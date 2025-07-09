String rawJson = avroToJson(data);
        entity.setRawJson(rawJson);
        log.info("about to  BusinessEvent Json :{}",entity.getRawJson());
        return entity;
    }

    private String avroToJson(BusinessEvent data) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            DatumWriter<BusinessEvent> writer = new SpecificDatumWriter<>(data.getSchema());
            Encoder encoder = EncoderFactory.get().jsonEncoder(data.getSchema(), out);
            writer.write(data, encoder);
            encoder.flush();
            return out.toString("UTF-8");
        } catch (Exception e) {
            log.error("Failed to convert Avro to JSON", e);
            return "{}";
        }
    }
