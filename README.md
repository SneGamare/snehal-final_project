@Service
public class ReconciliationService {

    @Autowired
    private PlutusFinacleDataRepository finacleRepo;

    @Autowired
    private VirtualApacRepository apacRepo;

    @Autowired
    private ReconciledTransactionRepository reconciledRepo;

    public void reconcileAndSave() {
        List<VirtualApacEntity> upiList = apacRepo.findAll();

        for (VirtualApacEntity apac : upiList) {
            String ref = apac.getRef1(); // Assume Ref1 contains tranId or matching key

            if (ref != null && finacleRepo.existsById(ref)) {
                PlutusFinacleDataEntity finacle = finacleRepo.findById(ref).get();

                ReconciledTransaction reconciled = new ReconciledTransaction();
                reconciled.setTranId(finacle.getTranId());
                reconciled.setForacid(finacle.getForacid());
                reconciled.setTranAmt(finacle.getTranAmt());
                reconciled.setTranDate(finacle.getTranDate());

                reconciled.setTxnRefNo(apac.getTxnRefNo());
                reconciled.setAmount(apac.getAmount());
                reconciled.setECollAccNo(apac.getECollAccNo());
                reconciled.setRemittInfo(apac.getRemittInfo());

                reconciled.setFinacleRaw(finacle.getRawData());
                reconciled.setVirtualApacRaw(apac.getRawJson());

                reconciledRepo.save(reconciled);
            }
        }
    }
}
