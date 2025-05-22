import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtdGamBusinessEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Surrogate key for JPA

    private String sourceScn;
    private String pos;
    private String tableOpTs;

    private Long rosOpTs;

    @Embedded
    private BusinessEvent event;
}


import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessEvent {

    private Double effectiveBal;
    private Double clrBal;

    @Lob
    private byte[] foracid;

    private Long lastBalUpdatedDate;

    @Lob
    private byte[] schmCode;
    @Lob
    private byte[] cifId;
    @Lob
    private byte[] acctName;
    @Lob
    private byte[] acctShortName;
    @Lob
    private byte[] schmSubType;
    @Lob
    private byte[] schmType;

    private String tranDate;

    @Lob
    private byte[] tranId;
    @Lob
    private byte[] partTranSrlNum;
    @Lob
    private byte[] delFlg;
    @Lob
    private byte[] tranType;
    @Lob
    private byte[] tranSubType;
    @Lob
    private byte[] partTranType;
    @Lob
    private byte[] glSubHeadCode;
    @Lob
    private byte[] acid;

    private String valueDate;

    private Double tranAmt;

    @Lob
    private byte[] tranParticular;
    @Lob
    private byte[] entryUserId;
    @Lob
    private byte[] pstdUserId;
    @Lob
    private byte[] vfdUserId;

    private String entryDate;
    private String pstdDate;
    private String vfdDate;

    @Lob
    private byte[] rptCode;
    @Lob
    private byte[] refNum;
    @Lob
    private byte[] instrmntType;

    private String instrmntDate;

    @Lob
    private byte[] instrmntNum;
    @Lob
    private byte[] instrmntAlpha;
    @Lob
    private byte[] tranRmks;
    @Lob
    private byte[] pstdFlg;
    @Lob
    private byte[] prntAdvcInd;
    @Lob
    private byte[] amtReservationInd;

    private Double reservationAmt;

    @Lob
    private byte[] restrictModifyInd;
    @Lob
    private byte[] lchgUserId;

    private String lchgTime;

    @Lob
    private byte[] rcreUserId;

    private String rcreTime;

    @Lob
    private byte[] custId;
    @Lob
    private byte[] voucherPrintFlg;
    @Lob
    private byte[] moduleId;
    @Lob
    private byte[] brCode;

    private Double fxTranAmt;

    @Lob
    private byte[] rateCode;
    private Double rate;

    @Lob
    private byte[] crncyCode;
    @Lob
    private byte[] navigationFlg;
    @Lob
    private byte[] tranCrncyCode;
    @Lob
    private byte[] refCrncyCode;

    private Double refAmt;

    @Lob
    private byte[] solId;
    @Lob
    private byte[] bankCode;
    @Lob
    private byte[] treaRefNum;

    private Double treaRate;

    private Long tsCnt;

    @Lob
    private byte[] gstUpdFlg;
    @Lob
    private byte[] isoFlg;
    @Lob
    private byte[] eabfabUpdFlg;
    @Lob
    private byte[] liftLienFlg;
    @Lob
    private byte[] proxyPostInd;
    @Lob
    private byte[] siSrlNum;

    private String siOrgExecDate;

    @Lob
    private byte[] prSrlNum;
    @Lob
    private byte[] serialNum;
    @Lob
    private byte[] delMemoPad;
    @Lob
    private byte[] uadModuleId;
    @Lob
    private byte[] uadModuleKey;

    private String reversalDate;
    private String reversalValueDate;

    @Lob
    private byte[] pttmEventType;
    @Lob
    private byte[] proxyAcid;
    @Lob
    private byte[] todEntityType;
    @Lob
    private byte[] todEntityId;
    @Lob
    private byte[] dthInitSolId;

    private Double regularizationAmt;
    private Double principalPortionAmt;

    @Lob
    private byte[] tfEntitySolId;
    @Lob
    private byte[] tranParticular2;
    @Lob
    private byte[] tranParticularCode;
    @Lob
    private byte[] trStatus;
    @Lob
    private byte[] svsTranId;
    @Lob
    private byte[] crncyHolChkDoneFlg;
    @Lob
    private byte[] referralId;
    @Lob
    private byte[] partyCode;

    private String glDate;

    @Lob
    private byte[] bkdtTranFlg;
    @Lob
    private byte[] bankId;
    @Lob
    private byte[] implCashPartTranFlg;
    @Lob
    private byte[] ptranChrgExistsFlg;
    @Lob
    private byte[] mudPoolBalBuildFlg;
    @Lob
    private byte[] glSegmentString;
    @Lob
    private byte[] sysPartTranCode;
    @Lob
    private byte[] userPartTranCode;
    @Lob
    private byte[] tranFreeCode1;
    @Lob
    private byte[] tranFreeCode2;

    private Long pstdSrlNum;

    @Lob
    private byte[] reversalStatus;

    private Double availableAmt;
    private Double acctBalance;
}
