
{
  "type": "record",
  "name": "PlutusFinacleData",
  "namespace": "com.kotak.plutus.common.schema",
  "fields": [
    {"name": "foracid", "type": ["null", "string"], "default": null},
    {"name": "acctName", "type": ["null", "string"], "default": null},
    {"name": "lastTranDateCr", "type": ["null", "string"], "default": null},
    {"name": "tranDate", "type": ["null", "string"], "default": null},
    {"name": "tranId", "type": ["null", "string"], "default": null},
    {"name": "partTranSrlNum", "type": ["null", "string"], "default": null},
    {"name": "delFlg", "type": ["null", "string"], "default": null},
    {"name": "tranType", "type": ["null", "string"], "default": null},
    {"name": "tranSubType", "type": ["null", "string"], "default": null},
    {"name": "partTranType", "type": ["null", "string"], "default": null},
    {"name": "glSubHeadCode", "type": ["null", "string"], "default": null},
    {"name": "acid", "type": ["null", "string"], "default": null},
    {"name": "valueDate", "type": ["null", "string"], "default": null},
    {"name": "tranAmt", "type": ["null", "double"], "default": null},
    {"name": "tranParticular", "type": ["null", "string"], "default": null},
    {"name": "entryDate", "type": ["null", "string"], "default": null},
    {"name": "pstdDate", "type": ["null", "string"], "default": null},
    {"name": "refNum", "type": ["null", "string"], "default": null},
    {"name": "instrmntType", "type": ["null", "string"], "default": null},
    {"name": "instrmntDate", "type": ["null", "string"], "default": null},
    {"name": "instrmntNum", "type": ["null", "string"], "default": null},
    {"name": "tranRmks", "type": ["null", "string"], "default": null},
    {"name": "custId", "type": ["null", "string"], "default": null},
    {"name": "brCode", "type": ["null", "string"], "default": null},
    {"name": "crncyCode", "type": ["null", "string"], "default": null},
    {"name": "tranCrncyCode", "type": ["null", "string"], "default": null},
    {"name": "refAmt", "type": ["null", "double"], "default": null},
    {"name": "solId", "type": ["null", "string"], "default": null},
    {"name": "bankCode", "type": ["null", "string"], "default": null},
    {"name": "treaRefNum", "type": ["null", "string"], "default": null},
    {"name": "reversalDate", "type": ["null", "string"], "default": null}
  ]
} 







package com.example.dto;

import lombok.Data;

@Data
public class PlutusFinacleDataDTO {

    private String foracid;
    private String acctName;
    private String lastTranDateCr;
    private String tranDate;
    private String tranId;
    private String partTranSrlNum;
    private String delFlg;
    private String tranType;
    private String tranSubType;
    private String partTranType;
    private String glSubHeadCode;
    private String acid;
    private String valueDate;
    private Double tranAmt;
    private String tranParticular;
    private String entryDate;
    private String pstdDate;
    private String refNum;
    private String instrmntType;
    private String instrmntDate;
    private String instrmntNum;
    private String tranRmks;
    private String custId;
    private String brCode;
    private String crncyCode;
    private String tranCrncyCode;
    private Double refAmt;
    private String solId;
    private String bankCode;
    private String treaRefNum;
    private String reversalDate;
}

