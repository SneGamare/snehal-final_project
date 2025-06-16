@Column(name = "navigation_flg")
private String navigationFlg;

@Column(name = "prnt_advc_ind")
private String prntAdvcInd;

@Column(name = "instrmnt_type")
private String instrmntType;

@Column(name = "instrmnt_date")
private LocalDate instrmntDate;

@Column(name = "instrmnt_num")
private String instrmntNum;

@Column(name = "instrmnt_alpha")
private String instrmntAlpha;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_data")
public class PlutusFinacleDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_scn")
    private String sourceScn;

    @Column(name = "pos")
    private String pos;

    @Column(name = "table_op_ts")
    private LocalDateTime tableOpTs;

    @Column(name = "ros_op_ts")
    private LocalDateTime rosOpTs;

    @Column(name = "effective_bal")
    private BigDecimal effectiveBal;

    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_cls_flg")
    private String acctClsFlg;

    @Column(name = "acct_cls_date")
    private LocalDate acctClsDate;

    @Column(name = "acct_crncy_code")
    private String acctCrncyCode;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_short_name")
    private String acctShortName;

    @Column(name = "acct_opn_date")
    private LocalDate acctOpnDate;

    @Column(name = "active_status")
    private String activeStatus;

    @Column(name = "adhoc_lim")
    private BigDecimal adhocLim;

    @Column(name = "allow_sweeps")
    private String allowSweeps;

    @Column(name = "cif_id")
    private String cifId;

    @Column(name = "clean_adhoc_lim")
    private BigDecimal cleanAdhocLim;

    @Column(name = "clean_single_tran_lim")
    private BigDecimal cleanSingleTranLim;

    @Column(name = "clean_emer_advn")
    private BigDecimal cleanEmerAdvn;

    @Column(name = "clr_bal_amt")
    private BigDecimal clrBalAmt;

    @Column(name = "dacc_lim")
    private BigDecimal daccLim;

    @Column(name = "dafa_lim")
    private BigDecimal dafaLim;

    @Column(name = "drwng_power")
    private BigDecimal drwngPower;

    @Column(name = "emer_advn")
    private BigDecimal emerAdvn;

    @Column(name = "entity_cre_flg")
    private String entityCreFlg;

    @Column(name = "ffd_contrib_to_acct")
    private BigDecimal ffdContribToAcct;

    @Column(name = "acct_num")
    private String acctNum;

    @Column(name = "frez_code")
    private String frezCode;

    @Column(name = "frez_reason_code")
    private String frezReasonCode;

    @Column(name = "frez_reason_code_2")
    private String frezReasonCode2;

    @Column(name = "frez_reason_code_3")
    private String frezReasonCode3;

    @Column(name = "frez_reason_code_4")
    private String frezReasonCode4;

    @Column(name = "frez_reason_code_5")
    private String frezReasonCode5;

    @Column(name = "fx_clr_bal_amt")
    private BigDecimal fxClrBalAmt;

    @Column(name = "future_oc_tod_amt")
    private BigDecimal futureOcTodAmt;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;

    @Column(name = "last_tran_date_cr")
    private LocalDate lastTranDateCr;

    @Column(name = "last_tran_date_dr")
    private LocalDate lastTranDateDr;

    @Column(name = "lien_amt")
    private BigDecimal lienAmt;

    @Column(name = "mode_of_oper_code")
    private String modeOfOperCode;

    @Column(name = "next_tran_srl_num")
    private String nextTranSrlNum;

    @Column(name = "pool_id")
    private String poolId;

    @Column(name = "sanct_lim")
    private BigDecimal sanctLim;

    @Column(name = "schm_type")
    private String schmType;

    @Column(name = "schm_code")
    private String schmCode;

    @Column(name = "schm_sub_type")
    private String schmSubType;

    @Column(name = "single_tran_flg")
    private String singleTranFlg;

    @Column(name = "single_tran_lim")
    private BigDecimal singleTranLim;

    @Column(name = "system_reserved_amt")
    private BigDecimal systemReservedAmt;

    @Column(name = "system_gen_lim")
    private BigDecimal systemGenLim;

    @Column(name = "sys_behavior_code")
    private String sysBehaviorCode;

    @Column(name = "un_clr_bal_amt")
    private BigDecimal unClrBalAmt;

    @Column(name = "used_clean_single_tran_lim")
    private BigDecimal usedCleanSingleTranLim;

    @Column(name = "used_oc_cln_single_tran_lim")
    private BigDecimal usedOcClnSingleTranLim;

    @Column(name = "used_single_tran_lim")
    private BigDecimal usedSingleTranLim;

    @Column(name = "used_un_clr_over_dacc_amt")
    private BigDecimal usedUnClrOverDaccAmt;

    @Column(name = "util_future_bal_amt")
    private BigDecimal utilFutureBalAmt;

    @Column(name = "utilised_amt")
    private BigDecimal utilisedAmt;

    @Column(name = "last_bal_updated_date")
    private LocalDateTime lastBalUpdatedDate;

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

    @Column(name = "entry_user_id")
    private String entryUserId;

    @Column(name = "pstd_user_id")
    private String pstdUserId;

    @Column(name = "vfd_user_id")
    private String vfdUserId;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "pstd_date")
    private LocalDateTime pstdDate;

    @Column(name = "vfd_date")
    private LocalDateTime vfdDate;

    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "tran_rmks")
    private String tranRmks;

    @Column(name = "pstd_flg")
    private String pstdFlg;

    @Column(name = "amt_reservation_ind")
    private String amtReservationInd;

    @Column(name = "reservation_amt")
    private BigDecimal reservationAmt;

    @Column(name = "restrict_modify_ind")
    private String restrictModifyInd;

    @Column(name = "lchg_user_id")
    private String lchgUserId;

    @Column(name = "lchg_time")
    private LocalDateTime lchgTime;

    @Column(name = "rcre_user_id")
    private String rcreUserId;

    @Column(name = "rcre_time")
    private LocalDateTime rcreTime;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "voucher_print_flg")
    private String voucherPrintFlg;

    @Column(name = "module_id")
    private String moduleId;

    @Column(name = "br_code")
    private String brCode;

    @Column(name = "fx_tran_amt")
    private BigDecimal fxTranAmt;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "crncy_code")
    private String crncyCode;

    @Column(name = "tran_crncy_code")
    private String tranCrncyCode;

    @Column(name = "ref_crncy_code")
    private String refCrncyCode;

    @Column(name = "ref_amt")
    private BigDecimal refAmt;

    @Column(name = "sol_id")
    private String solId;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "trea_ref_num")
    private String treaRefNum;

    @Column(name = "trea_rate")
    private BigDecimal treaRate;

    @Column(name = "ts_cnt")
    private Integer tsCnt;

    @Column(name = "gst_upd_flg")
    private String gstUpdFlg;

    @Column(name = "iso_flg")
    private String isoFlg;

    @Column(name = "eabfab_upd_flg")
    private String eabfabUpdFlg;

    @Column(name = "lift_lien_flg")
    private String liftLienFlg;

    @Column(name = "proxy_post_ind")
    private String proxyPostInd;

    @Column(name = "si_srl_num")
    private String siSrlNum;

    @Column(name = "si_org_exec_date")
    private LocalDate siOrgExecDate;

    @Column(name = "pr_srl_num")
    private String prSrlNum;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "del_memo_pad")
    private String delMemoPad;

    @Column(name = "uad_module_id")
    private String uadModuleId;

    @Column(name = "uad_module_key")
    private String uadModuleKey;

    @Column(name = "reversal_date")
    private LocalDate reversalDate;

    @Column(name = "reversal_value_date")
    private LocalDate reversalValueDate;

    @Column(name = "pttm_event_type")
    private String pttmEventType;

    @Column(name = "proxy_acid")
    private String proxyAcid;

    @Column(name = "tod_entity_type")
    private String todEntityType;

    @Column(name = "tod_entity_id")
    private String todEntityId;

    @Column(name = "dth_init_sol_id")
    private String dthInitSolId;

    @Column(name = "regularization_amt")
    private BigDecimal regularizationAmt;

    @Column(name = "principal_portion_amt")
    private BigDecimal principalPortionAmt;

    @Column(name = "tf_entity_sol_id")
    private String tfEntitySolId;

    @Column(name = "tran_particular_2")
    private String tranParticular2;

    @Column(name = "tran_particular_code")
    private String tranParticularCode;

    @Column(name = "tr_status")
    private String trStatus;

    @Column(name = "svs_tran_id")
    private String svsTranId;

    @Column(name = "crncy_hol_chk_done_flg")
    private String crncyHolChkDoneFlg;

    @Column(name = "referral_id")
    private String referralId;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "gl_date")
    private LocalDate glDate;

    @Column(name = "bkdt_tran_flg")
    private String bkdtTranFlg;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "impl_cash_part_tran_flg")
    private String implCashPartTranFlg;

    @Column(name = "ptran_chrg_exists_flg")
    private String ptranChrgExistsFlg;

    @Column(name = "mud_pool_bal_build_flg")
    private String mudPoolBalBuildFlg;

    @Column(name = "gl_segment_string")
    private String glSegmentString;

    @Column(name = "sys_part_tran_code")
    private String sysPartTranCode;

    @Column(name = "user_part_tran_code")
    private String userPartTranCode;

    @Column(name = "tran_free_code1")
    private String tranFreeCode1;

    @Column(name = "tran_free_code2")
    private String tranFreeCode2;

    @Column(name = "pstd_srl_num")
    private Integer pstdSrlNum;

    @Column(name = "reversal_status")
    private String reversalStatus;

    @Column(name = "available_amt")
    private BigDecimal availableAmt;

    @Column(name = "acct_balance")
    private BigDecimal acctBalance;

    // Getters and Setters
    // (You can generate these using your IDE or manually if needed)
}
