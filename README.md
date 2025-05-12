public interface MessageConsumer<T> {

        /**
         * Processes a Kafka record.
         *
         * <p>
         * Implementations of this method should define the logic for handling the received Kafka record.
         *
         * @param message The Kafka record encapsulated in a {@link ReceiverRecord}.
         */
        void process(ReceiverRecord<String, T> message);

        String partitionKey(T message);
}




@Slf4j
public class PlutusFinacleDataConsumer implements MessageConsumer<PlutusFinacleData> {


    @Override
    public void process(ReceiverRecord<String, PlutusFinacleData> receiverRecord) {

    }

    @Override
    public String partitionKey(PlutusFinacleData plutusFinacleData) {
        return "";
    }
