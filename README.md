import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_transaction_details")
public class FinacleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Primary Account Fields
    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_cls_flg")
    private String acctClsFlg;

    @Column(name = "acct_crncy_code")
    private String acctCrncyCode;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_ownership")
    private String acctOwnership;

    @Column(name = "acct_opn_date")
    private String acctOpnDate;

    @Column(name = "acct_type")
    private String acctType;

    @Column(name = "acct_bal")
    private Double acctBal;

    @Column(name = "avail_bal")
    private Double availBal;

    // Transaction Fields
    @Column(name = "tran_amt")
    private Double tranAmt;

    @Column(name = "tran_date")
    private String tranDate;

    @Column(name = "tran_particular")
    private String tranParticular;

    @Column(name = "tran_time")
    private String tranTime;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "txn_code")
    private String txnCode;

    @Column(name = "txn_sub_type")
    private String txnSubType;

    // Reference and Narration Fields
    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "ref_doc_num")
    private String refDocNum;

    @Column(name = "narrative")
    private String narrative;

    @Column(name = "part_tran_type")
    private String partTranType;

    // Linked/Counterparty Fields
    @Column(name = "linked_acc_no")
    private String linkedAccNo;

    @Column(name = "linked_branch_code")
    private String linkedBranchCode;

    @Column(name = "linked_crncy_code")
    private String linkedCrncyCode;

    @Column(name = "linked_name")
    private String linkedName;

    // Timestamp Fields
    @Column(name = "msg_ts")
    private String msgTs;

    // Add a created timestamp (optional)
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters below

    // ... (use Lombok or generate them manually)
}
