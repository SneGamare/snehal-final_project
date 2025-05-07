@Service
public class ReconciliationService {

    @Autowired
    private PlutusFinacleDataRepository finacleRepo;

    @Autowired
    private VirtualApacRepository apacRepo;

    @Autowired
    private ReconciledTransactionRepository reconciledRepo;

    @Autowired
    private UnmatchedTransactionRepository unmatchedRepo;

    public void reconcileAndSave() {
        List<VirtualApacEntity> upiList = apacRepo.findAll();  // Fetch all Virtual APAC data

        for (VirtualApacEntity apac : upiList) {
            String ref = apac.getRef3();  // UPI reference to match with tranId from Finacle

            // Find matching Finacle transaction
            Optional<PlutusFinacleDataEntity> matchingFinacle = finacleRepo.findById(ref);  // Match with ref3 (Virtual APAC) and tranId (Finacle)

            if (matchingFinacle.isPresent()) {
                // If a match is found, save the reconciled data
                PlutusFinacleDataEntity finacle = matchingFinacle.get();

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

                reconciledRepo.save(reconciled);  // Save reconciled transaction
            } else {
                // If no match is found, save the unmatched data
                UnmatchedTransaction unmatched = new UnmatchedTransaction();
                unmatched.setRef3(apac.getRef3());
                unmatched.setTxnRefNo(apac.getTxnRefNo());
                unmatched.setAmount(apac.getAmount());
                unmatched.setECollAccNo(apac.getECollAccNo());
                unmatched.setRemittInfo(apac.getRemittInfo());

                unmatched.setVirtualApacRaw(apac.getRawJson());
                unmatched.setMessage("No matching Finacle data found.");

                unmatchedRepo.save(unmatched);  // Save unmatched transaction
            }
        }
    }
}
