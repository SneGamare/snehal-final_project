@RequiredArgsConstructor
@Slf4j
@Component
public class PlutusDtdBusinessEventConsumer implements MessageConsumer<DtdGamBusinessEvent> {

    private final PlutusFinacleDataRepository repository;
    private final PlutusClientConfigurationRepository configurationRepository;

    @Override
    public void process(ReceiverRecord<String, DtdGamBusinessEvent> receiverRecord) {
        BusinessEvent data = receiverRecord.value().getEvent();

        if (data == null) {
            log.warn("Received null BusinessEvent.");
            return;
        }

        String foracid = CbsUtils.byteBufferToStr(data.getFORACID());

        try {
            boolean isValid = configurationRepository.findByMasterAccount(foracid)
                    .filter(PlutusClientConfiguration::getActiveFlag)
                    .isPresent();

            if (!isValid) {
                log.info("FORACID {} not found in configuration or inactive. Skipping record.", foracid);
                return;
            }

            PlutusFinacleDataEntity entity = mapToEntity(data);
            repository.save(entity);

            log.info("Saved DTD Event with TRAN_ID: {}", CbsUtils.byteBufferToStr(data.getTRANID()));
            receiverRecord.receiverOffset().acknowledge();

        } catch (Exception e) {
            log.error("Error while processing DTD Event for FORACID {}: {}", foracid, e.getMessage(), e);
        }
    }

    @Override
    public String partitionKey(DtdGamBusinessEvent data) {
        return CbsUtils.byteBufferToStr(data.getEvent() != null ? data.getEvent().getTRANID() : null);
    }

    private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
        // unchanged mapping logic...
    }
}
