@Entity
@Table(name = "plutus_finacle_transaction_details", schema = "plutus_ecollection")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlutusFinacleDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tran_date")
    private LocalDate tranDate;

    @Column(name = "tran_id")
    private String tranId;

    @Column(name = "part_tran_srl_num")
    private String partTranSrlNum;

    @Column(name = "del_flg")
    private String delFlg;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "tran_sub_type")
    private String tranSubType;

    @Column(name = "part_tran_type")
    private String partTranType;

    @Column(name = "gl_sub_head_code")
    private String glSubHeadCode;

    @Column(name = "acid")
    private String acid;

    @Column(name = "value_date")
    private LocalDate valueDate;

    @Column(name = "tran_amt")
    private BigDecimal tranAmt;

    @Column(name = "tran_particular")
    private String tranParticular;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "pstd_date")
    private LocalDateTime pstdDate;

    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "instrmnt_type")
    private String instrmntType;

    @Column(name = "instrmnt_date")
    private LocalDate instrmntDate;

    @Column(name = "instrmnt_num")
    private String instrmntNum;

    @Column(name = "tran_rmks")
    private String tranRmks;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "br_code")
    private String brCode;

    @Column(name = "crncy_code")
    private String crncyCode;

    @Column(name = "tran_crncy_code")
    private String tranCrncyCode;

    @Column(name = "ref_amt")
    private BigDecimal refAmt;

    @Column(name = "sol_id")
    private String solId;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "trea_ref_num")
    private String treaRefNum;

    @Column(name = "reversal_date")
    private LocalDate reversalDate;

    @Column(name = "reversal_value_date")
    private LocalDate reversalValueDate;

    @Column(name = "tran_particular_2")
    private String tranParticular2;

    @Column(name = "tran_particular_code")
    private String tranParticularCode;

    @Column(name = "tr_status")
    private String trStatus;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "gl_date")
    private LocalDate glDate;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "tran_free_code1")
    private String tranFreeCode1;

    @Column(name = "tran_free_code2")
    private String tranFreeCode2;

    @Column(name = "reversal_status")
    private String reversalStatus;

    @Column(name = "available_amt")
    private BigDecimal availableAmt;

    @Column(name = "acct_balance")
    private BigDecimal acctBalance;

    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_short_name")
    private String acctShortName;

    @Column(name = "last_tran_date_cr")
    private LocalDate lastTranDateCr;
}


CREATE SCHEMA IF NOT EXISTS plutus_ecollection;

CREATE TABLE plutus_ecollection.plutus_finacle_transaction_details (
    id BIGSERIAL PRIMARY KEY,

    tran_date DATE,
    tran_id VARCHAR(100),
    part_tran_srl_num VARCHAR(100),
    del_flg VARCHAR(10),
    tran_type VARCHAR(50),
    tran_sub_type VARCHAR(50),
    part_tran_type VARCHAR(50),
    gl_sub_head_code VARCHAR(50),
    acid VARCHAR(100),
    value_date DATE,
    tran_amt NUMERIC(20, 2),
    tran_particular VARCHAR(255),
    entry_date TIMESTAMP,
    pstd_date TIMESTAMP,
    ref_num VARCHAR(100),
    instrmnt_type VARCHAR(50),
    instrmnt_date DATE,
    instrmnt_num VARCHAR(100),
    tran_rmks VARCHAR(500),
    cust_id VARCHAR(100),
    br_code VARCHAR(50),
    crncy_code VARCHAR(10),
    tran_crncy_code VARCHAR(10),
    ref_amt NUMERIC(20, 2),
    sol_id VARCHAR(50),
    bank_code VARCHAR(50),
    trea_ref_num VARCHAR(100),
    reversal_date DATE,
    reversal_value_date DATE,
    tran_particular_2 VARCHAR(255),
    tran_particular_code VARCHAR(50),
    tr_status VARCHAR(50),
    party_code VARCHAR(100),
    gl_date DATE,
    bank_id VARCHAR(50),
    tran_free_code1 VARCHAR(50),
    tran_free_code2 VARCHAR(50),
    reversal_status VARCHAR(50),
    available_amt NUMERIC(20, 2),
    acct_balance NUMERIC(20, 2),
    foracid VARCHAR(100),
    acct_name VARCHAR(255),
    acct_short_name VARCHAR(255),
    last_tran_date_cr DATE
);
