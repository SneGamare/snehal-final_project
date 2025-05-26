package com.kmbl.cros.accountinquiryservice.repository.dao.dynamodb.models;

import static com.kmbl.cros.accountinquiryservice.constants.AppConstants.ATTR_ACID_INDEX;
import static com.kmbl.cros.accountinquiryservice.constants.AppConstants.GAM_DATE_TIME;
import static com.kmbl.cros.accountinquiryservice.constants.AppConstants.INGESTION_DATE_FORMAT;
import static com.kmbl.cros.accountinquiryservice.constants.AppConstants.ORACLE_GG_EVENT;
import static com.kmbl.cros.accountinquiryservice.constants.DataFieldsConstants.*;
import static com.kmbl.cros.accountinquiryservice.utils.AppUtils.getParquetLocalDateTimeNullableData;
import static com.kmbl.cros.accountinquiryservice.utils.AppUtils.getParquetLongNullableData;
import static com.kmbl.cros.accountinquiryservice.utils.AppUtils.getParquetStringNullableData;
import static com.kmbl.cros.accountinquiryservice.utils.CbsUtils.byteBufferToStr;
import static com.kmbl.cros.accountinquiryservice.utils.CbsUtils.doubleToBigDecimal;
import static com.kmbl.cros.accountinquiryservice.utils.CbsUtils.numberToLong;
import static com.kmbl.cros.accountinquiryservice.utils.CbsUtils.strToLocalDateTime;

import com.kmbl.cros.accountinquiryservice.event.schema.GamEvents.GamColumns;
import com.kmbl.cros.accountinquiryservice.service.dtos.AccountBalanceMasterData;
import com.kmbl.cros.accountinquiryservice.utils.EpochProvider;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.parquet.example.data.Group;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;

/**
 * DynamoDb Schema for General_Account_Master (GAM) Table.
 */
@DynamoDbBean
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DbAccountMasterData {

    public static final String TABLE_NAME = "CROS_ACCOUNT_MASTER";

    public static final TableSchema<DbAccountMasterData> SCHEMA = TableSchema.fromBean(DbAccountMasterData.class);

    public static final String ATTR_ACID = "acid";
    public static final String ACCOUNT_ID_ATTRIBUTE_NAME = "accountId";

    private String accountId;
    private LocalDateTime accountClosureDate;
    private String accountClosedFlag;
    private String accountCurrencyCode;
    private String acid;
    private String accountActiveStatus;
    private String accountName;
    private LocalDateTime accountOpenDate;
    private BigDecimal adhocLimit;
    private String allowSweeps;
    private String cifId;
    private String customerId;
    private BigDecimal cleanAdhocLimit;
    private BigDecimal cleanEmergencyAdvance;
    private BigDecimal cleanSingleTranLimit;
    private BigDecimal clearBalanceAmount;
    private String currencyCode;
    private BigDecimal daccLimit;
    private BigDecimal dafaLimit;
    private String deletedFlag;
    private BigDecimal drawingPower;
    private BigDecimal emergencyAdvance;
    private String entityCreatedFlag;
    private BigDecimal ffdContributionToAccount;
    private String accountNumber;
    private String freezeCode;
    private BigDecimal fxClearBalanceAmount;
    private BigDecimal futureOcTodAmount;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime lastTranDateCr;
    private LocalDateTime lastTranDateDr;
    private Long lastChangeTime;
    private BigDecimal lienAmount;
    private String modeOfOperationCode;
    private Long nextTranSerialNumber;
    private String poolId;
    private BigDecimal sanctionedLimit;
    private String schemeCode;
    private String schemeSubType;
    private String schemeType;
    private String singleTranFlag;
    private BigDecimal singleTranLimit;
    private String solId;
    private BigDecimal systemGenLimit;
    private BigDecimal systemReservedAmount;
    private String systemBehaviorCode;
    public BigDecimal unClearBalanceAmount;
    private BigDecimal usedCleanSingleTranLimit;
    private BigDecimal usedOcCleanSingleTranLimit;
    private BigDecimal usedSingleTranLimit;
    private BigDecimal usedUnClearOverDaccAmount;
    private BigDecimal utilisedAmount;
    private BigDecimal utilFutureBalanceAmount;
    private Long ingestionTime;
    private String ingestionSource;
    private String scnPosNumber;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(value = ACCOUNT_ID_ATTRIBUTE_NAME)
    public String getAccountId() {
        return accountId;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = {ATTR_ACID_INDEX})
    @DynamoDbAttribute(ATTR_ACID)
    public String getAcid() {
        return acid;
    }

    public DbAccountMasterData(String accountId) {
        this.accountId = accountId;
    }

    public DbAccountMasterData toAccountMasterData() {
        return DbAccountMasterData.builder()
                .accountId(accountId)
                .accountName(accountName)
                .accountCurrencyCode(accountCurrencyCode)
                .schemeType(schemeType)
                .schemeCode(schemeCode)
                .solId(solId)
                .accountOpenDate(accountOpenDate)
                .modeOfOperationCode(modeOfOperationCode)
                .freezeCode(freezeCode)
                .acid(acid)
                .deletedFlag(deletedFlag)
                .accountClosedFlag(accountClosedFlag)
                .build();
    }
    /**
     * Constructs and returns an {@link AccountBalanceMasterData} object populated with data from this
     * instance.
     *
     * @return An {@link AccountBalanceMasterData} object containing the account balance master data.
     */
    public AccountBalanceMasterData to() {
        return AccountBalanceMasterData.builder()
                .accountId(accountId)
                .accountClosureDate(accountClosureDate)
                .accountClosedFlag(accountClosedFlag)
                .accountCurrencyCode(accountCurrencyCode)
                .accountName(accountName)
                .accountOpenDate(accountOpenDate)
                .acid(acid)
                .adhocLimit(adhocLimit)
                .allowSweeps(allowSweeps)
                .cifId(cifId)
                .cleanAdhocLimit(cleanAdhocLimit)
                .cleanAdhocLimit(cleanAdhocLimit)
                .cleanEmergencyAdvance(cleanEmergencyAdvance)
                .cleanSingleTranLimit(cleanSingleTranLimit)
                .clearBalanceAmount(clearBalanceAmount)
                .currencyCode(currencyCode)
                .daccLimit(daccLimit)
                .dafaLimit(dafaLimit)
                .deletedFlag(deletedFlag)
                .drawingPower(drawingPower)
                .emergencyAdvance(emergencyAdvance)
                .entityCreatedFlag(entityCreatedFlag)
                .ffdContributionToAccount(ffdContributionToAccount)
                .accountNumber(accountNumber)
                .freezeCode(freezeCode)
                .fxClearBalanceAmount(fxClearBalanceAmount)
                .futureOcTodAmount(futureOcTodAmount)
                .lienAmount(lienAmount)
                .lastChangeTime(lastChangeTime)
                .modeOfOperationCode(modeOfOperationCode)
                .poolId(poolId)
                .sanctionedLimit(sanctionedLimit)
                .schemeCode(schemeCode)
                .schemeType(schemeType)
                .singleTranFlag(singleTranFlag)
                .singleTranLimit(singleTranLimit)
                .systemGenLimit(systemGenLimit)
                .systemReservedAmount(systemReservedAmount)
                .unClearBalanceAmount(unClearBalanceAmount)
                .usedCleanSingleTranLimit(usedCleanSingleTranLimit)
                .usedOcCleanSingleTranLimit(usedOcCleanSingleTranLimit)
                .usedSingleTranLimit(usedSingleTranLimit)
                .usedUnClearOverDaccAmount(usedUnClearOverDaccAmount)
                .utilisedAmount(utilisedAmount)
                .utilFutureBalanceAmount(utilFutureBalanceAmount)
                .build();
    }

    /**
     * Constructs and returns an {@link DbAccountMasterData} object populated with data from this
     * instance.
     *
     * @return An {@link DbAccountMasterData} object containing the account balance master data.
     */
    public static DbAccountMasterData from(GamColumns request) {
        return DbAccountMasterData.builder()
                .accountId(byteBufferToStr(request.getFORACID()))
                .accountClosedFlag(byteBufferToStr(request.getACCTCLSFLG()))
                .accountClosureDate(strToLocalDateTime(request.getACCTCLSDATE()))
                .accountCurrencyCode(byteBufferToStr(request.getACCTCRNCYCODE()))
                .accountName(byteBufferToStr(request.getACCTNAME()))
                .accountOpenDate(strToLocalDateTime(request.getACCTOPNDATE()))
                .acid(byteBufferToStr(request.getACID()))
                .accountActiveStatus(byteBufferToStr(request.getACTIVESTATUS()))
                .adhocLimit(doubleToBigDecimal(request.getADHOCLIM()))
                .allowSweeps(byteBufferToStr(request.getALLOWSWEEPS()))
                .cifId(byteBufferToStr(request.getCIFID()))
                .customerId(byteBufferToStr(request.getCUSTID()))
                .cleanAdhocLimit(doubleToBigDecimal(request.getCLEANADHOCLIM()))
                .cleanEmergencyAdvance(doubleToBigDecimal(request.getCLEANEMERADVN()))
                .cleanSingleTranLimit(doubleToBigDecimal(request.getCLEANSINGLETRANLIM()))
                .clearBalanceAmount(doubleToBigDecimal(request.getCLRBALAMT()))
                .currencyCode(byteBufferToStr(request.getCRNCYCODE()))
                .daccLimit(doubleToBigDecimal(request.getDACCLIM()))
                .dafaLimit(doubleToBigDecimal(request.getDAFALIM()))
                .deletedFlag(byteBufferToStr(request.getDELFLG()))
                .drawingPower(doubleToBigDecimal(request.getDRWNGPOWER()))
                .emergencyAdvance(doubleToBigDecimal(request.getEMERADVN()))
                .entityCreatedFlag(byteBufferToStr(request.getENTITYCREFLG()))
                .ffdContributionToAccount(doubleToBigDecimal(request.getFFDCONTRIBTOACCT()))
                .accountNumber(byteBufferToStr(request.getACCTNUM()))
                .freezeCode(byteBufferToStr(request.getFREZCODE()))
                .fxClearBalanceAmount(doubleToBigDecimal(request.getFXCLRBALAMT()))
                .futureOcTodAmount(doubleToBigDecimal(request.getFUTUREOCTODAMT()))
                .lastModifiedDate(strToLocalDateTime(request.getLASTMODIFIEDDATE()))
                .lastTranDateCr(strToLocalDateTime(request.getLASTTRANDATECR()))
                .lastTranDateDr(strToLocalDateTime(request.getLASTTRANDATEDR()))
                .lienAmount(doubleToBigDecimal(request.getLIENAMT()))
                .modeOfOperationCode(byteBufferToStr(request.getMODEOFOPERCODE()))
                .nextTranSerialNumber(numberToLong(request.getNEXTTRANSRLNUM()))
                .poolId(byteBufferToStr(request.getPOOLID()))
                .sanctionedLimit(doubleToBigDecimal(request.getSANCTLIM()))
                .schemeCode(byteBufferToStr(request.getSCHMCODE()))
                .schemeSubType(byteBufferToStr(request.getSCHMSUBTYPE()))
                .schemeType(byteBufferToStr(request.getSCHMTYPE()))
                .singleTranFlag(byteBufferToStr(request.getSINGLETRANFLG()))
                .singleTranLimit(doubleToBigDecimal(request.getSINGLETRANLIM()))
                .solId(byteBufferToStr(request.getSOLID()))
                .systemGenLimit(doubleToBigDecimal(request.getSYSTEMGENLIM()))
                .systemReservedAmount(doubleToBigDecimal(request.getSYSTEMRESERVEDAMT()))
                .systemBehaviorCode(byteBufferToStr(request.getSYSBEHAVIORCODE()))
                .unClearBalanceAmount(doubleToBigDecimal(request.getUNCLRBALAMT()))
                .usedCleanSingleTranLimit(doubleToBigDecimal(request.getUSEDCLEANSINGLETRANLIM()))
                .usedOcCleanSingleTranLimit(doubleToBigDecimal(request.getUSEDOCCLNSINGLETRANLIM()))
                .usedSingleTranLimit(doubleToBigDecimal(request.getUSEDSINGLETRANLIM()))
                .usedUnClearOverDaccAmount(doubleToBigDecimal(request.getUSEDUNCLROVERDACCAMT()))
                .utilisedAmount(doubleToBigDecimal(request.getUTILISEDAMT()))
                .utilFutureBalanceAmount(doubleToBigDecimal(request.getUTILFUTUREBALAMT()))
                .ingestionSource(ORACLE_GG_EVENT)
                .build();
    }

    /**
     * To give instance of DbAccountMasterData from Parquet Group.
     *
     * @param record          instance of Group object contains data.
     * @param epochProvider   timestamp object.
     * @param ingestionSource source information for dynamoDb.
     * @return A new {@link DbAccountMasterData} object representing the provided transaction data.
     */
    public static DbAccountMasterData from(Group record, EpochProvider epochProvider, String ingestionSource) {
        return DbAccountMasterData.builder()
                .accountId(record.getString(FORACID, 0).strip())
                .accountClosedFlag(record.getString(ACCT_CLS_FLG, 0).strip())
                .accountClosureDate(getParquetLocalDateTimeNullableData(record, ACCT_CLS_DATE, 0, GAM_DATE_TIME))
                .accountCurrencyCode(record.getString(ACCT_CRNCY_CODE, 0).strip())
                .accountName(getParquetStringNullableData(record, ACCT_NAME, 0))
                .accountOpenDate(getParquetLocalDateTimeNullableData(record, ACCT_OPN_DATE, 0, GAM_DATE_TIME))
                .acid(record.getString(ACID, 0).strip())
                .accountActiveStatus(getParquetStringNullableData(record, ACTIVE_STATUS, 0))
                .adhocLimit(doubleToBigDecimal(record.getDouble(ADHOC_LIM, 0)))
                .allowSweeps(getParquetStringNullableData(record, ALLOW_SWEEPS, 0))
                .cifId(getParquetStringNullableData(record, CIF_ID, 0))
                .customerId(getParquetStringNullableData(record, CUST_ID, 0))
                .cleanAdhocLimit(doubleToBigDecimal(record.getDouble(CLEAN_ADHOC_LIM, 0)))
                .cleanEmergencyAdvance(doubleToBigDecimal(record.getDouble(CLEAN_EMER_ADVN, 0)))
                .cleanSingleTranLimit(doubleToBigDecimal(record.getDouble(CLEAN_SINGLE_TRAN_LIM, 0)))
                .clearBalanceAmount(doubleToBigDecimal(record.getDouble(CLR_BAL_AMT, 0)))
                .currencyCode(getParquetStringNullableData(record, CRNCY_CODE, 0))
                .daccLimit(doubleToBigDecimal(record.getDouble(DACC_LIM, 0)))
                .dafaLimit(doubleToBigDecimal(record.getDouble(DAFA_LIM, 0)))
                .deletedFlag(record.getString(DEL_FLG, 0).strip())
                .drawingPower(doubleToBigDecimal(record.getDouble(DRWNG_POWER, 0)))
                .emergencyAdvance(doubleToBigDecimal(record.getDouble(EMER_ADVN, 0)))
                .entityCreatedFlag(record.getString(ENTITY_CRE_FLG, 0).strip())
                .ffdContributionToAccount(doubleToBigDecimal(record.getDouble(FFD_CONTRIB_TO_ACCT, 0)))
                .accountNumber(getParquetStringNullableData(record, ACCT_NUM, 0))
                .freezeCode(getParquetStringNullableData(record, FREZ_CODE, 0))
                .fxClearBalanceAmount(doubleToBigDecimal(record.getDouble(FX_CLR_BAL_AMT, 0)))
                .futureOcTodAmount(doubleToBigDecimal(record.getDouble(FUTURE_OC_TOD_AMT, 0)))
                .lastModifiedDate(getParquetLocalDateTimeNullableData(record, LAST_MODIFIED_DATE, 0, GAM_DATE_TIME))
                .lastTranDateCr(getParquetLocalDateTimeNullableData(record, LAST_TRAN_DATE_CR, 0, GAM_DATE_TIME))
                .lastTranDateDr(getParquetLocalDateTimeNullableData(record, LAST_TRAN_DATE_DR, 0, GAM_DATE_TIME))
                .lastChangeTime(epochProvider.toEpoch(record.getString(LCHG_TIME, 0), INGESTION_DATE_FORMAT))
                .lienAmount(doubleToBigDecimal(record.getDouble(LIEN_AMT, 0)))
                .modeOfOperationCode(getParquetStringNullableData(record, MODE_OF_OPER_CODE, 0))
                .nextTranSerialNumber(getParquetLongNullableData(record, NEXT_TRAN_SRL_NUM, 0))
                .poolId(getParquetStringNullableData(record, POOL_ID, 0))
                .sanctionedLimit(doubleToBigDecimal(record.getDouble(SANCT_LIM, 0)))
                .schemeCode(record.getString(SCHM_CODE, 0).strip())
                .schemeSubType(getParquetStringNullableData(record, SCHM_SUB_TYPE, 0))
                .schemeType(record.getString(SCHM_TYPE, 0).strip())
                .singleTranFlag(getParquetStringNullableData(record, SINGLE_TRAN_FLG, 0))
                .singleTranLimit(doubleToBigDecimal(record.getDouble(SINGLE_TRAN_LIM, 0)))
                .solId(record.getString(SOL_ID, 0).strip())
                .systemGenLimit(doubleToBigDecimal(record.getDouble(SYSTEM_GEN_LIM, 0)))
                .systemReservedAmount(doubleToBigDecimal(record.getDouble(SYSTEM_RESERVED_AMT, 0)))
                .systemBehaviorCode(getParquetStringNullableData(record, SYS_BEHAVIOR_CODE, 0))
                .unClearBalanceAmount(doubleToBigDecimal(record.getDouble(UN_CLR_BAL_AMT, 0)))
                .usedCleanSingleTranLimit(doubleToBigDecimal(record.getDouble(USED_CLEAN_SINGLE_TRAN_LIM, 0)))
                .usedOcCleanSingleTranLimit(doubleToBigDecimal(record.getDouble(USED_OC_CLN_SINGLE_TRAN_LIM, 0)))
                .usedSingleTranLimit(doubleToBigDecimal(record.getDouble(USED_SINGLE_TRAN_LIM, 0)))
                .usedUnClearOverDaccAmount(doubleToBigDecimal(record.getDouble(USED_UN_CLR_OVER_DACC_AMT, 0)))
                .utilisedAmount(doubleToBigDecimal(record.getDouble(UTILISED_AMT, 0)))
                .utilFutureBalanceAmount(doubleToBigDecimal(record.getDouble(UTIL_FUTURE_BAL_AMT, 0)))
                .scnPosNumber(
                        StringUtils.stripStart(record.getString(SOURCE_SCN, 0).strip(), "0")
                                + StringUtils.leftPad(record.getString(POS, 0).strip(), 20, "0"))
                .ingestionSource(ingestionSource)
                .ingestionTime(epochProvider.currentEpoch())
                .build();
    }
}
