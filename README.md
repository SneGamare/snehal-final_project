SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;



GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;


CREATE ROLE app_user WITH LOGIN PASSWORD 'your_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO app_user;




-- Create the user if not already present
CREATE ROLE plutus_app_user WITH LOGIN PASSWORD 'your_password';

-- Grant access to the schema and tables
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user;

-- Run as admin or schema owner
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user_dev;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user_dev;





private PlutusFinacleDataEntity mapToEntity(BusinessEvent data) {
    PlutusFinacleDataEntity entity = new PlutusFinacleDataEntity();

    entity.setForacid(CbsUtils.byteBufferToStr(data.getFORACID()));
    entity.setAcctCrncyCode(CbsUtils.byteBufferToStr(data.getCRNCYCODE()));
    entity.setAcctName(CbsUtils.byteBufferToStr(data.getACCTNAME()));
    entity.setAcctBal(CbsUtils.safeDouble(data.getACCTBALANCE()));
    entity.setAvailBal(CbsUtils.safeDouble(data.getAVAILABLEAMT()));
    entity.setTranAmt(CbsUtils.safeDouble(data.getTRANAMT()));
    entity.setTranDate(CbsUtils.charSeqToStr(data.getTRANDATE()));
    entity.setTranTime(CbsUtils.byteBufferToStr(data.getTRANTIME())); // If applicable
    entity.setTranParticular(CbsUtils.byteBufferToStr(data.getTRANPARTICULAR()));
    entity.setTranType(CbsUtils.byteBufferToStr(data.getTRANTYPE()));
    entity.setTxnCode(CbsUtils.byteBufferToStr(data.getGLSUBHEADCODE()));
    entity.setTxnSubType(CbsUtils.byteBufferToStr(data.getTRANSUBTYPE()));
    entity.setRefNum(CbsUtils.byteBufferToStr(data.getREFNUM()));
    entity.setRefDocNum(CbsUtils.byteBufferToStr(data.getREFDOCNUM()));
    entity.setPartTranType(CbsUtils.byteBufferToStr(data.getPARTTRANTYPE()));
    entity.setLinkedAccNo(CbsUtils.byteBufferToStr(data.getACID()));
    entity.setLinkedBranchCode(CbsUtils.byteBufferToStr(data.getBRCODE()));
    entity.setLinkedCrncyCode(CbsUtils.byteBufferToStr(data.getTRANCRNCYCODE()));
    entity.setLinkedName(CbsUtils.byteBufferToStr(data.getBANKCODE()));
    entity.setNarrative(CbsUtils.byteBufferToStr(data.getTRANRMKS()));

    entity.setAcctClsFlg(CbsUtils.byteBufferToStr(data.getACCTCLFLG()));
    entity.setAcctOwnership(CbsUtils.byteBufferToStr(data.getACCTOWNERSHIP()));
    entity.setAcctOpnDate(CbsUtils.byteBufferToStr(data.getOPNDATE()));
    entity.setAcctType(CbsUtils.byteBufferToStr(data.getACCTYPE()));

    entity.setMsgTs(LocalDateTime.now().toString());
    entity.setCreatedAt(LocalDateTime.now());
    entity.setReceivedAt(LocalDateTime.now());

    // Optional: save raw JSON
    // entity.setRawData(objectMapper.writeValueAsString(data));

    return entity;
}
