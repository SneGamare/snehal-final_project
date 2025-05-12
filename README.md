
package com.kotak.orchestrator.orchestrator.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import com.kotak.orchestrator.orchestrator.repository.PlutusFinacleDataRepository;
import com.kotak.orchestrator.orchestrator.validator.PlutusDataValidator;
import com.kotak.plutus.common.consumer.GenericAvroConsumer;
import com.kotak.plutus.common.schema.PlutusFinacleData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PlutusFinacleDataConsumer extends GenericAvroConsumer<PlutusFinacleData> {

    private final PlutusFinacleDataRepository repository;
    private final PlutusDataValidator plutusDataValidator;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PlutusFinacleDataConsumer(PlutusFinacleDataRepository repository, PlutusDataValidator plutusDataValidator) {
        this.repository = repository;
        this.plutusDataValidator = plutusDataValidator;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "plutus-finacle-group")
    public void listen(ConsumerRecord<String, PlutusFinacleData> record) {
        consume(record);
    }

    @Override
    protected void handleMessage(PlutusFinacleData data, ConsumerRecord<String, PlutusFinacleData> record) {
        try {
            // Validate mandatory fields
            plutusDataValidator.validate(data);

            PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();
            entity.setTranId(toStr(data.getTranId()));
            entity.setTranDate(toStr(data.getTranDate()));
            entity.setTranAmt(data.getTranAmt());
            entity.setAcid(toStr(data.getAcid()));
            entity.setForacid(toStr(data.getForacid()));
            entity.setRefNum(toStr(data.getRefNum()));
            entity.setReceivedAt(LocalDateTime.now());

            // Build rawData with all remaining fields (except the 6 already used above)
            Map<String, Object> rawMap = new HashMap<>();

            rawMap.put("acctName", toStr(data.getAcctName()));
            rawMap.put("lastTranDateCr", toStr(data.getLastTranDateCr()));
            rawMap.put("partTranSrlNum", toStr(data.getPartTranSrlNum()));
            rawMap.put("delFlg", toStr(data.getDelFlg()));
            rawMap.put("tranType", toStr(data.getTranType()));
            rawMap.put("tranSubType", toStr(data.getTranSubType()));
            rawMap.put("partTranType", toStr(data.getPartTranType()));
            rawMap.put("glSubHeadCode", toStr(data.getGlSubHeadCode()));
            rawMap.put("valueDate", toStr(data.getValueDate()));
            rawMap.put("tranParticular", toStr(data.getTranParticular()));
            rawMap.put("entryDate", toStr(data.getEntryDate()));
            rawMap.put("pstdDate", toStr(data.getPstdDate()));
            rawMap.put("instrmntType", toStr(data.getInstrmntType()));
            rawMap.put("instrmntDate", toStr(data.getInstrmntDate()));
            rawMap.put("instrmntNum", toStr(data.getInstrmntNum()));
            rawMap.put("tranRmks", toStr(data.getTranRmks()));
            rawMap.put("custId", toStr(data.getCustId()));
            rawMap.put("brCode", toStr(data.getBrCode()));
            rawMap.put("crncyCode", toStr(data.getCrncyCode()));
            rawMap.put("tranCrncyCode", toStr(data.getTranCrncyCode()));
            rawMap.put("refAmt", data.getRefAmt());
            rawMap.put("solId", toStr(data.getSolId()));
            rawMap.put("bankCode", toStr(data.getBankCode()));
            rawMap.put("treaRefNum", toStr(data.getTreaRefNum()));
            rawMap.put("reversalDate", toStr(data.getReversalDate()));

            entity.setRawData(objectMapper.writeValueAsString(rawMap));

            repository.save(entity);
            System.out.println(" Saved PlutusFinacleData to DB, tranId: {}"+ entity.getTranId());

        } catch (IllegalArgumentException e) {
            System.out.println(" Validation failed: {}"+ e.getMessage());
        } catch (Exception e) {
            System.out.println(" Error saving record: {}"+ e.getMessage()+ e);
        }
    }

    private String toStr(CharSequence input) {
        return input != null ? input.toString() : null;
    }
}










package com.kmbl.cros.accountinquiryservice.service.kafka.consumer;

import static com.kmbl.cros.accountinquiryservice.utils.PartitionUtils.inMemoryPartitionId;

import com.kmbl.cros.accountinquiryservice.utils.MetricUtil;
import io.micrometer.core.instrument.binder.kafka.KafkaClientMetrics;
import io.micrometer.observation.ObservationRegistry;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import reactor.core.Disposable;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.observation.KafkaReceiverObservation.DefaultKafkaReceiverObservationConvention;
import reactor.util.retry.Retry;

/**
 * Reactive Kafka Consumer for processing events of generic type {@code T}.
 *
 * <p>
 * This class provides a reactive implementation of a Kafka consumer, designed for processing events
 * asynchronously and efficiently. It extends the {@link Thread} class and implements the
 * {@link AutoCloseable} interface to allow for proper resource management.
 *
 * <p>
 * Usage: - Create an instance of this class by supplying a {@link ConsumerConfiguration} during
 * instantiation. - Start the Kafka consumer by invoking the {@code run()} method. - Implement
 * custom logic for processing received Kafka records by overriding the {@code processRecord}
 * method. - Gracefully close the Kafka consumer by invoking the {@code close()} method when it is
 * no longer needed.
 *
 * @param <T> The generic type representing the value type of Kafka records.
 * @see ConsumerConfiguration
 * @see Disposable
 * @see ReceiverRecord
 * @see AutoCloseable
 */
@Slf4j
public class ReactiveKafkaConsumer<T> extends Thread implements AutoCloseable {

  private final ConsumerConfiguration<T> config;
  private final KafkaReceiver<String, T> receiver;
  protected MetricUtil metricUtil;
  private Disposable flux;

  /**
   * Constructor for creating a Reactive Kafka Consumer.
   *
   * @param config The configuration for the Kafka consumer, including properties like bootstrap
   *               servers, group ID, topic, SSL settings, and more.
   */
  public ReactiveKafkaConsumer(ConsumerConfiguration<T> config, MetricUtil metricUtil) {

    this.config = config;
    this.metricUtil = metricUtil;

    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
    props.put(ConsumerConfig.GROUP_ID_CONFIG, config.getGroupId());
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
    props.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "false");
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, config.getMaxPollRecords());
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        config.getValueDeserializer().getName());
    if ("AWS_MSK_IAM".equals(config.getSecurityProtocol())) {
      props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
      props.put(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
      props.put(SaslConfigs.SASL_JAAS_CONFIG,
          "software.amazon.msk.auth.iam.IAMLoginModule required;");
      props.put(SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS,
          "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
    }

    log.info("Kafka Consumer Properties: {}", props);

    var registry = ObservationRegistry.create();
    var commitIntervalMillis = config.getDeferredCommitConfig().getCommitIntervalMillis();
    var options = ReceiverOptions.<String, T>create(props)
        .subscription(List.of(config.getTopic(), config.getDlqConfig().getDlqTopic()))
        .maxDeferredCommits(config.getDeferredCommitConfig().getMaxDeferredCommits())
        .commitInterval(Duration.ofMillis(commitIntervalMillis))
        .commitBatchSize(config.getDeferredCommitConfig().getCommitBatchSize())
        .withObservation(registry, DefaultKafkaReceiverObservationConvention.INSTANCE)
        .addAssignListener(partitions -> log.info("Partitions assigned: {}", partitions))
        .addRevokeListener(partitions -> log.info("Partitions revoked: {}", partitions));
    this.receiver = KafkaReceiver.create(new ReactiveConsumerFactory(), options);
  }

  class ReactiveConsumerFactory extends ConsumerFactory {

    @Override
    public <K, V> Consumer<K, V> createConsumer(ReceiverOptions<K, V> config) {
      var consumer = super.createConsumer(config);
      var kmetrics = new KafkaClientMetrics(consumer);
      kmetrics.bindTo(metricUtil.getRegistry());
      return consumer;
    }
  }

  /**
   * Starts the Kafka consumer to receive and process Kafka records asynchronously.
   *
   * <p>
   * Overrides the {@code run()} method from the {@link Thread} class. Creates a reactive flow using
   * Reactor's {@link Disposable} to handle Kafka message reception and processing.
   */
  @Override
  public void run() {
    log.info("CROS Kafka consumer started successfully for topic: {}.", config.getTopic());
    var scheduler = scheduler();
    flux = receiver.receive()
        .doOnError(e -> log.error("Error receiving event in Kafka consumer. Will retry", e))
        .retryWhen(Retry.fixedDelay(60L, Duration.ofMinutes(1)))
        .groupBy(r -> inMemoryPartitionId(config.getProcessor().partitionKey(r.value()),
            config.getInMemoryPartitions()))
        .flatMap(pf -> pf.publishOn(scheduler).map(this::processRecord))
        .subscribe();
    log.info("Kafka consumer stopped for topic: {}", config.getTopic());
  }

  /**
   * Processes a received Kafka record.
   *
   * <p>
   * Implement this method to define custom logic for processing each Kafka record. This method is
   * called for each record received by the Kafka consumer.
   *
   * @param message The Kafka record encapsulated in a {@link ReceiverRecord}. returns
   *                ReceiverRecord.
   */
  private ReceiverRecord<String, T> processRecord(ReceiverRecord<String, T> message) {
    try (var timeIt = metricUtil.timeIt("MessageProcessingLatency")) {
      log.debug("Processing message: {} from topic: {}", message, config.getTopic());
      var startTime = System.nanoTime();
      try {
        var currInstant = Instant.now();
        // This timestamp is set by either the producer or Kafka
        var kafkaTimestamp = Instant.ofEpochMilli(message.timestamp());
        var klag = Duration.between(kafkaTimestamp, currInstant);
        timeIt.emitTimeMetric("ConsumptionLag." + config.getTopic(), klag.toMillis());
        config.getProcessor().process(message);

      } catch (Exception e) {
        log.error(
            "Error processing event with key: {}, value: {} from topic: {}",
            message.key(),
            message.value(),
            config.getTopic(),
            e);
        if (config.getFailureHandler() != null) {
          config.getFailureHandler()
              .handle(
                  config.getBootstrapServers(),
                  config.getDlqConfig(),
                  config.getSecurityProtocol(),
                  message);
        } else {
          // TODO : not to acknowledge message in case of failed to push in DLQ topic.
          log.error("DLQ Failure Handler is not configured for topic: {}", config.getTopic());
        }
      }

      message.receiverOffset().acknowledge();
      var endTime = System.nanoTime();
      var totalTimeMillis = (endTime - startTime) / 1000_000L;
      timeIt.emitTimeMetric("Latency." + config.getTopic(), totalTimeMillis);
      log.trace("Finished processing message: {} from topic: {}", message, config.getTopic());
      return message;
    }
  }

  private Scheduler scheduler() {
    var scheduler = Schedulers.newBoundedElastic(
        config.getInMemoryPartitions(),
        Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE,
        config.getProcessorThreadPoolName());
    return Micrometer.timedScheduler(scheduler, metricUtil.getRegistry(),
        config.getTopic() + "-consumers.scheduler");
  }

  /**
   * Closes the Kafka consumer, releasing associated resources.
   *
   * <p>
   * Overrides the {@code close()} method from the {@link AutoCloseable} interface. Invoking this
   * method ensures a graceful shutdown of the Kafka consumer.
   */
  @Override
  public void close() {
    log.info("CROS-ReactiveKafkaConsumer termination initiated for topic: {}", config.getTopic());
    try {
      this.flux.dispose();
    } catch (Exception e) {
      log.info("Ignoring error while disposing consumer flux for topic: {} with exception: {}",
          config.getTopic(), e);
    }
  }
}




package com.kmbl.cros.accountinquiryservice.service.kafka.consumer;

import reactor.kafka.receiver.ReceiverRecord;

/**
 * Interface for a generic message consumer.
 *
 * <p>
 * This interface defines the contract for a message consumer that processes Kafka records with key
 * of type {@code String} and value of generic type {@code T}.
 *
 * <p>
 * Methods: - {@code process}: This method is responsible for processing a Kafka record encapsulated
 * in a {@link ReceiverRecord}. Implementations should define the logic for handling the events.
 *
 * @param <T> The generic type representing the value type of Kafka records.
 *            <p>
 *            Usage: - Implement this interface in classes that will handle the processing of Kafka
 *            records. - The `process` method is invoked by the Kafka consumer to handle each
 *            received message.
 * @see ReceiverRecord
 */
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








package com.kmbl.cros.accountinquiryservice.service.kafka.consumer;

import com.kmbl.cros.accountinquiryservice.service.kafka.failurehandler.FailureHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Configuration class for Kafka Consumers handling events of generic type {@code T}.
 *
 * <p>
 * This class encapsulates the configuration parameters required for setting up a Kafka consumer to
 * receive events in Avro format. It provides flexibility by allowing the specification of the
 * generic type for the deserialization of event values.
 *
 * <p>
 * Properties:
 * - {@code bootstrapServers}: The Kafka bootstrap servers' addresses.
 * - {@code topic}: The Kafka topic from which events will be consumed.
 * - {@code groupId}: The consumer group ID.
 * - {@code valueDeserializer}: The class of the deserializer for decoding Avro-encoded values.
 * - {@code processor}: The {@link MessageConsumer} responsible for processing the received events.
 * - {@Code securityProtocol}: Security protocol for msk authentication.
 *
 * @param <T> The generic type representing the deserialized value type of Kafka events.
 *            <p>
 *            Usage: - This class is used to configure a Kafka consumer with specific parameters for
 *            consuming Avro-encoded events. - The properties are set through the constructor or
 *            appropriate setter methods. - It is intended for use in conjunction with a Kafka
 *            consumer implementation, such as {@link ReactiveKafkaConsumer}, to handle the
 *            reception and processing of events.
 * @see ReactiveKafkaConsumer
 * @see MessageConsumer
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerConfiguration<T> {

  private String bootstrapServers;
  private String topic;
  private String groupId;
  private Class<? extends Deserializer<T>> valueDeserializer;
  private int inMemoryPartitions;
  private int maxPollRecords;
  private String processorThreadPoolName;
  private MessageConsumer<T> processor;
  private DeferredCommitConfiguration deferredCommitConfig;
  private String securityProtocol;
  private FailureHandler<T> failureHandler;
  private DlqConfiguration<T> dlqConfig;

  @Builder
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class DeferredCommitConfiguration {

    /**
     * Maximum number of messages that are not yet committed after which we pause the consumer to
     * apply backpressure.
     */
    private int maxDeferredCommits;

    /**
     * Frequency of committing the earliest contiguous offset (if possible) since the last commit
     * for a partition.
     * <p>
     * A commit is triggered (if possible) when either the commitIntervalMillis timer expires or the
     * batch size is exceeded.
     */
    private long commitIntervalMillis;

    /**
     * Maximum batch size after which the earliest contiguous offset (if possible) since the last
     * commit for a partition is committed.
     */
    private int commitBatchSize;
  }

  @Builder
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class DlqConfiguration<T> {
    /**
     * dead-letter queue topic name, The failed consumer events will be published to.
     */
    private String dlqTopic;

    /**
     * Class to use for Serializing a Kafka message before publishing to
     */
    private Class<? extends Serializer> valueSerializer;
  }
}
