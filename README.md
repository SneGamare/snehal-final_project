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
