import jakarta.persistence.*;

@Entity
@Table(name = "reconciled_transaction")
public class ReconciledTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finacle_tran_id", referencedColumnName = "tranId")
    private PlutusFinacleDataEntity plutusFinacleDataEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apac_txn_ref_no", referencedColumnName = "txnRefNo")
    private VirtualApacEntity virtualApacEntity;

    // Getters and Setters
}




import java.math.BigDecimal;
import java.util.Date;

public class VirtualApacDTO {

    private String txnRefNo;
    private Date txnDate;
    private String eCollAccNo;
    private String masterAccNo;
    private String dealerName;
    private BigDecimal amount;
    private String beneCustAcName;
    private String sendCustAcName;
    private String remittInfo;
    private String senderAddress;
    private String ref1;
    private String ref2;
    private String ref3;
    private String processedFlag;

    // Optional: any other fields you want to expose to services or REST

    // Getters and Setters
}
