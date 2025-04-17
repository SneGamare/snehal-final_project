Validation , transformation , saved    transformation ->   before saving the data we need to validate the data mandatory fileds   transform into plates format   Enrichment -> virtual apache table  h2 DB mai table create then   connection with REF_NUM 

Then saved db in H2   row data we need to manage in JSON   only finacle_upi we need to store 
  UPI _data store -> DTO we need to discuss     



 

ACID
ID
pp_ID
TRAN_DATE
TRAN_ID
ACID
TRAN_AMT
FORACID
REF_NUM
PP_cr_dt
Raw_Data
PP_cr_dt
Create_date
Modified_date




entity.setTranId(toStr(data.getTranId()));
        entity.setTranDate(toStr(data.getTranDate()));
        entity.setTranAmt(data.getTranAmt());
        entity.setAcid(toStr(data.getAcid()));
        entity.setForacid(toStr(data.getForacid()));
        entity.setRefNum(toStr(data.getRefNum()));

        // Other fields
        entity.setAcctName(toStr(data.getAcctName()));
        entity.setLastTranDateCr(toStr(data.getLastTranDateCr()));
        entity.setPartTranSrlNum(toStr(data.getPartTranSrlNum()));
        entity.setDelFlg(toStr(data.getDelFlg()));
        entity.setTranType(toStr(data.getTranType()));
        entity.setTranSubType(toStr(data.getTranSubType()));
        entity.setPartTranType(toStr(data.getPartTranType()));
        entity.setGlSubHeadCode(toStr(data.getGlSubHeadCode()));
        entity.setValueDate(toStr(data.getValueDate()));
        entity.setTranParticular(toStr(data.getTranParticular()));
        entity.setEntryDate(toStr(data.getEntryDate()));
        entity.setPstdDate(toStr(data.getPstdDate()));
        entity.setInstrmntType(toStr(data.getInstrmntType()));
        entity.setInstrmntDate(toStr(data.getInstrmntDate()));
        entity.setInstrmntNum(toStr(data.getInstrmntNum()));
        entity.setTranRmks(toStr(data.getTranRmks()));
        entity.setCustId(toStr(data.getCustId()));
        entity.setBrCode(toStr(data.getBrCode()));
        entity.setCrncyCode(toStr(data.getCrncyCode()));
        entity.setTranCrncyCode(toStr(data.getTranCrncyCode()));
        entity.setRefAmt(data.getRefAmt());
        entity.setSolId(toStr(data.getSolId()));
        entity.setBankCode(toStr(data.getBankCode()));
        entity.setTreaRefNum(toStr(data.getTreaRefNum()));
        entity.setReversalDate(toStr(data.getReversalDate()));
        entity.setReceivedAt(LocalDateTime.now());
Created_by
Modified_by
SourceSystem
PP_txn_dt![image](https://github.com/user-attachments/assets/02ae98ca-fcfd-40e3-972c-9f20da6a3126)

 
