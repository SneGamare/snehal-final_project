import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(PlutusDto dto) {
        try {
            String json = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send("your-json-topic-name", json);
            System.out.println("Produced JSON to Kafka: " + json);
        } catch (Exception e) {
            System.err.println("Error producing JSON to Kafka: " + e.getMessage());
        }
    }
}
