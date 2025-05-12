@Data
public class PlutusDto {
    PlutusFinacleDataDTO plutusFinacleDataDTO;
}



@Service
public class KafkaEventConsumer  extends GenericAvroConsumer<PlutusFinacleData> {
    private final JsonKafkaProducer jsonKafkaProducer;

    public KafkaEventConsumer(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }


    @Override
    protected void handleMessage(PlutusFinacleData plutusFinacleData, ConsumerRecord<String, PlutusFinacleData> consumerRecord) {
        jsonKafkaProducer.send(plutusFinacleData);

    }
}
