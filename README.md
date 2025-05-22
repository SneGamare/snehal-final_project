{
  "type" : "record",
  "name" : "DtdGamBusinessEvent",
  "namespace" : "com.kotak.orchestrator.orchestrator.schema",
  "fields" : [ {
    "name" : "source_scn",
    "type" : [ "null", "string" ],
    "default" : null
  }, {
    "name" : "pos",
    "type" : [ "null", "string" ],
    "default" : null
  }, {
    "name" : "table_op_ts",
    "type" : [ "null", "string" ],
    "default" : null
  }, {
    "name" : "ros_op_ts",
    "type" : [ "null", "long" ],
    "default" : null
  }, {
    "name": "Event",
    "type" : [ "null", {
      "type" : "record",
      "name" : "BusinessEvent",
      "fields": [
        {
          "name" : "EFFECTIVE_BAL",
          "type" : [ "null", "double" ],
          "default" : null
        },{
          "name" : "CLR_BAL",
          "type" : [ "null", "double" ],
          "default" : null
        },{
          "name" : "FORACID",
          "type" : [ "null", "bytes" ],
          "default" : null
        },{
          "name" : "LAST_BAL_UPDATED_DATE",
          "type" : [ "null", "long" ],
          "default" : null
        }, {
          "name" : "SCHM_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        },{
          "name" : "CIF_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        },{
          "name" : "ACCT_NAME",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "ACCT_SHORT_NAME",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SCHM_SUB_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SCHM_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        },
        // DTD Events
        {
          "name" : "TRAN_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "TRAN_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PART_TRAN_SRL_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "DEL_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_SUB_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PART_TRAN_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "GL_SUB_HEAD_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "ACID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "VALUE_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "TRAN_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "TRAN_PARTICULAR",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "ENTRY_USER_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PSTD_USER_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "VFD_USER_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "ENTRY_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "PSTD_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "VFD_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "RPT_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REF_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "INSTRMNT_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "INSTRMNT_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "INSTRMNT_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "INSTRMNT_ALPHA",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_RMKS",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PSTD_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PRNT_ADVC_IND",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "AMT_RESERVATION_IND",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "RESERVATION_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "RESTRICT_MODIFY_IND",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "LCHG_USER_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "LCHG_TIME",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "RCRE_USER_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "RCRE_TIME",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "CUST_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "VOUCHER_PRINT_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "MODULE_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "BR_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "FX_TRAN_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "RATE_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "RATE",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "CRNCY_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "NAVIGATION_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_CRNCY_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REF_CRNCY_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REF_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "SOL_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "BANK_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TREA_REF_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TREA_RATE",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "TS_CNT",
          "type" : [ "null", "long" ],
          "default" : null
        }, {
          "name" : "GST_UPD_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "ISO_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "EABFAB_UPD_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "LIFT_LIEN_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PROXY_POST_IND",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SI_SRL_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SI_ORG_EXEC_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "PR_SRL_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SERIAL_NUM",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "DEL_MEMO_PAD",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "UAD_MODULE_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "UAD_MODULE_KEY",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REVERSAL_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "REVERSAL_VALUE_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "PTTM_EVENT_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PROXY_ACID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TOD_ENTITY_TYPE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TOD_ENTITY_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "DTH_INIT_SOL_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REGULARIZATION_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "PRINCIPAL_PORTION_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "TF_ENTITY_SOL_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_PARTICULAR_2",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_PARTICULAR_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TR_STATUS",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SVS_TRAN_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "CRNCY_HOL_CHK_DONE_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "REFERRAL_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PARTY_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "GL_DATE",
          "type" : [ "null", "string" ],
          "default" : null
        }, {
          "name" : "BKDT_TRAN_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "BANK_ID",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "IMPL_CASH_PART_TRAN_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PTRAN_CHRG_EXISTS_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "MUD_POOL_BAL_BUILD_FLG",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "GL_SEGMENT_STRING",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "SYS_PART_TRAN_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "USER_PART_TRAN_CODE",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_FREE_CODE1",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "TRAN_FREE_CODE2",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "PSTD_SRL_NUM",
          "type" : [ "null", "long" ],
          "default" : null
        }, {
          "name" : "REVERSAL_STATUS",
          "type" : [ "null", "bytes" ],
          "default" : null
        }, {
          "name" : "AVAILABLE_AMT",
          "type" : [ "null", "double" ],
          "default" : null
        }, {
          "name" : "ACCT_BALANCE",
          "type" : [ "null", "double" ],
          "default" : null
        }
      ]
    }]
  }
  ]
}





/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kotak.orchestrator.orchestrator.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BusinessEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7464432313330385922L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BusinessEvent\",\"namespace\":\"com.kotak.orchestrator.orchestrator.schema\",\"fields\":[{\"name\":\"EFFECTIVE_BAL\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"CLR_BAL\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"FORACID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"LAST_BAL_UPDATED_DATE\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"SCHM_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"CIF_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ACCT_NAME\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ACCT_SHORT_NAME\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SCHM_SUB_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SCHM_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"TRAN_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PART_TRAN_SRL_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"DEL_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_SUB_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PART_TRAN_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"GL_SUB_HEAD_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ACID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"VALUE_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"TRAN_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"TRAN_PARTICULAR\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ENTRY_USER_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PSTD_USER_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"VFD_USER_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ENTRY_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PSTD_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"VFD_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"RPT_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REF_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"INSTRMNT_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"INSTRMNT_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"INSTRMNT_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"INSTRMNT_ALPHA\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_RMKS\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PSTD_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PRNT_ADVC_IND\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"AMT_RESERVATION_IND\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"RESERVATION_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"RESTRICT_MODIFY_IND\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"LCHG_USER_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"LCHG_TIME\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"RCRE_USER_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"RCRE_TIME\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CUST_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"VOUCHER_PRINT_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"MODULE_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"BR_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"FX_TRAN_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"RATE_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"RATE\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"CRNCY_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"NAVIGATION_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_CRNCY_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REF_CRNCY_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REF_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"SOL_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"BANK_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TREA_REF_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TREA_RATE\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"TS_CNT\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"GST_UPD_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"ISO_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"EABFAB_UPD_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"LIFT_LIEN_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PROXY_POST_IND\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SI_SRL_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SI_ORG_EXEC_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PR_SRL_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SERIAL_NUM\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"DEL_MEMO_PAD\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"UAD_MODULE_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"UAD_MODULE_KEY\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REVERSAL_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"REVERSAL_VALUE_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PTTM_EVENT_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PROXY_ACID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TOD_ENTITY_TYPE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TOD_ENTITY_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"DTH_INIT_SOL_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REGULARIZATION_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"PRINCIPAL_PORTION_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"TF_ENTITY_SOL_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_PARTICULAR_2\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_PARTICULAR_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TR_STATUS\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SVS_TRAN_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"CRNCY_HOL_CHK_DONE_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"REFERRAL_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PARTY_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"GL_DATE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"BKDT_TRAN_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"BANK_ID\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"IMPL_CASH_PART_TRAN_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PTRAN_CHRG_EXISTS_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"MUD_POOL_BAL_BUILD_FLG\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"GL_SEGMENT_STRING\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"SYS_PART_TRAN_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"USER_PART_TRAN_CODE\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_FREE_CODE1\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"TRAN_FREE_CODE2\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"PSTD_SRL_NUM\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"REVERSAL_STATUS\",\"type\":[\"null\",\"bytes\"],\"default\":null},{\"name\":\"AVAILABLE_AMT\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"ACCT_BALANCE\",\"type\":[\"null\",\"double\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<BusinessEvent> ENCODER =
      new BinaryMessageEncoder<BusinessEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<BusinessEvent> DECODER =
      new BinaryMessageDecoder<BusinessEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<BusinessEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<BusinessEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<BusinessEvent>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this BusinessEvent to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a BusinessEvent from a ByteBuffer. */
  public static BusinessEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.Double EFFECTIVE_BAL;
  @Deprecated public java.lang.Double CLR_BAL;
  @Deprecated public java.nio.ByteBuffer FORACID;
  @Deprecated public java.lang.Long LAST_BAL_UPDATED_DATE;
  @Deprecated public java.nio.ByteBuffer SCHM_CODE;
  @Deprecated public java.nio.ByteBuffer CIF_ID;
  @Deprecated public java.nio.ByteBuffer ACCT_NAME;
  @Deprecated public java.nio.ByteBuffer ACCT_SHORT_NAME;
  @Deprecated public java.nio.ByteBuffer SCHM_SUB_TYPE;
  @Deprecated public java.nio.ByteBuffer SCHM_TYPE;
  @Deprecated public java.lang.CharSequence TRAN_DATE;
  @Deprecated public java.nio.ByteBuffer TRAN_ID;
  @Deprecated public java.nio.ByteBuffer PART_TRAN_SRL_NUM;
  @Deprecated public java.nio.ByteBuffer DEL_FLG;
  @Deprecated public java.nio.ByteBuffer TRAN_TYPE;
  @Deprecated public java.nio.ByteBuffer TRAN_SUB_TYPE;
  @Deprecated public java.nio.ByteBuffer PART_TRAN_TYPE;
  @Deprecated public java.nio.ByteBuffer GL_SUB_HEAD_CODE;
  @Deprecated public java.nio.ByteBuffer ACID;
  @Deprecated public java.lang.CharSequence VALUE_DATE;
  @Deprecated public java.lang.Double TRAN_AMT;
  @Deprecated public java.nio.ByteBuffer TRAN_PARTICULAR;
  @Deprecated public java.nio.ByteBuffer ENTRY_USER_ID;
  @Deprecated public java.nio.ByteBuffer PSTD_USER_ID;
  @Deprecated public java.nio.ByteBuffer VFD_USER_ID;
  @Deprecated public java.lang.CharSequence ENTRY_DATE;
  @Deprecated public java.lang.CharSequence PSTD_DATE;
  @Deprecated public java.lang.CharSequence VFD_DATE;
  @Deprecated public java.nio.ByteBuffer RPT_CODE;
  @Deprecated public java.nio.ByteBuffer REF_NUM;
  @Deprecated public java.nio.ByteBuffer INSTRMNT_TYPE;
  @Deprecated public java.lang.CharSequence INSTRMNT_DATE;
  @Deprecated public java.nio.ByteBuffer INSTRMNT_NUM;
  @Deprecated public java.nio.ByteBuffer INSTRMNT_ALPHA;
  @Deprecated public java.nio.ByteBuffer TRAN_RMKS;
  @Deprecated public java.nio.ByteBuffer PSTD_FLG;
  @Deprecated public java.nio.ByteBuffer PRNT_ADVC_IND;
  @Deprecated public java.nio.ByteBuffer AMT_RESERVATION_IND;
  @Deprecated public java.lang.Double RESERVATION_AMT;
  @Deprecated public java.nio.ByteBuffer RESTRICT_MODIFY_IND;
  @Deprecated public java.nio.ByteBuffer LCHG_USER_ID;
  @Deprecated public java.lang.CharSequence LCHG_TIME;
  @Deprecated public java.nio.ByteBuffer RCRE_USER_ID;
  @Deprecated public java.lang.CharSequence RCRE_TIME;
  @Deprecated public java.nio.ByteBuffer CUST_ID;
  @Deprecated public java.nio.ByteBuffer VOUCHER_PRINT_FLG;
  @Deprecated public java.nio.ByteBuffer MODULE_ID;
  @Deprecated public java.nio.ByteBuffer BR_CODE;
  @Deprecated public java.lang.Double FX_TRAN_AMT;
  @Deprecated public java.nio.ByteBuffer RATE_CODE;
  @Deprecated public java.lang.Double RATE;
  @Deprecated public java.nio.ByteBuffer CRNCY_CODE;
  @Deprecated public java.nio.ByteBuffer NAVIGATION_FLG;
  @Deprecated public java.nio.ByteBuffer TRAN_CRNCY_CODE;
  @Deprecated public java.nio.ByteBuffer REF_CRNCY_CODE;
  @Deprecated public java.lang.Double REF_AMT;
  @Deprecated public java.nio.ByteBuffer SOL_ID;
  @Deprecated public java.nio.ByteBuffer BANK_CODE;
  @Deprecated public java.nio.ByteBuffer TREA_REF_NUM;
  @Deprecated public java.lang.Double TREA_RATE;
  @Deprecated public java.lang.Long TS_CNT;
  @Deprecated public java.nio.ByteBuffer GST_UPD_FLG;
  @Deprecated public java.nio.ByteBuffer ISO_FLG;
  @Deprecated public java.nio.ByteBuffer EABFAB_UPD_FLG;
  @Deprecated public java.nio.ByteBuffer LIFT_LIEN_FLG;
  @Deprecated public java.nio.ByteBuffer PROXY_POST_IND;
  @Deprecated public java.nio.ByteBuffer SI_SRL_NUM;
  @Deprecated public java.lang.CharSequence SI_ORG_EXEC_DATE;
  @Deprecated public java.nio.ByteBuffer PR_SRL_NUM;
  @Deprecated public java.nio.ByteBuffer SERIAL_NUM;
  @Deprecated public java.nio.ByteBuffer DEL_MEMO_PAD;
  @Deprecated public java.nio.ByteBuffer UAD_MODULE_ID;
  @Deprecated public java.nio.ByteBuffer UAD_MODULE_KEY;
  @Deprecated public java.lang.CharSequence REVERSAL_DATE;
  @Deprecated public java.lang.CharSequence REVERSAL_VALUE_DATE;
  @Deprecated public java.nio.ByteBuffer PTTM_EVENT_TYPE;
  @Deprecated public java.nio.ByteBuffer PROXY_ACID;
  @Deprecated public java.nio.ByteBuffer TOD_ENTITY_TYPE;
  @Deprecated public java.nio.ByteBuffer TOD_ENTITY_ID;
  @Deprecated public java.nio.ByteBuffer DTH_INIT_SOL_ID;
  @Deprecated public java.lang.Double REGULARIZATION_AMT;
  @Deprecated public java.lang.Double PRINCIPAL_PORTION_AMT;
  @Deprecated public java.nio.ByteBuffer TF_ENTITY_SOL_ID;
  @Deprecated public java.nio.ByteBuffer TRAN_PARTICULAR_2;
  @Deprecated public java.nio.ByteBuffer TRAN_PARTICULAR_CODE;
  @Deprecated public java.nio.ByteBuffer TR_STATUS;
  @Deprecated public java.nio.ByteBuffer SVS_TRAN_ID;
  @Deprecated public java.nio.ByteBuffer CRNCY_HOL_CHK_DONE_FLG;
  @Deprecated public java.nio.ByteBuffer REFERRAL_ID;
  @Deprecated public java.nio.ByteBuffer PARTY_CODE;
  @Deprecated public java.lang.CharSequence GL_DATE;
  @Deprecated public java.nio.ByteBuffer BKDT_TRAN_FLG;
  @Deprecated public java.nio.ByteBuffer BANK_ID;
  @Deprecated public java.nio.ByteBuffer IMPL_CASH_PART_TRAN_FLG;
  @Deprecated public java.nio.ByteBuffer PTRAN_CHRG_EXISTS_FLG;
  @Deprecated public java.nio.ByteBuffer MUD_POOL_BAL_BUILD_FLG;
  @Deprecated public java.nio.ByteBuffer GL_SEGMENT_STRING;
  @Deprecated public java.nio.ByteBuffer SYS_PART_TRAN_CODE;
  @Deprecated public java.nio.ByteBuffer USER_PART_TRAN_CODE;
  @Deprecated public java.nio.ByteBuffer TRAN_FREE_CODE1;
  @Deprecated public java.nio.ByteBuffer TRAN_FREE_CODE2;
  @Deprecated public java.lang.Long PSTD_SRL_NUM;
  @Deprecated public java.nio.ByteBuffer REVERSAL_STATUS;
  @Deprecated public java.lang.Double AVAILABLE_AMT;
  @Deprecated public java.lang.Double ACCT_BALANCE;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BusinessEvent() {}

  /**
   * All-args constructor.
   * @param EFFECTIVE_BAL The new value for EFFECTIVE_BAL
   * @param CLR_BAL The new value for CLR_BAL
   * @param FORACID The new value for FORACID
   * @param LAST_BAL_UPDATED_DATE The new value for LAST_BAL_UPDATED_DATE
   * @param SCHM_CODE The new value for SCHM_CODE
   * @param CIF_ID The new value for CIF_ID
   * @param ACCT_NAME The new value for ACCT_NAME
   * @param ACCT_SHORT_NAME The new value for ACCT_SHORT_NAME
   * @param SCHM_SUB_TYPE The new value for SCHM_SUB_TYPE
   * @param SCHM_TYPE The new value for SCHM_TYPE
   * @param TRAN_DATE The new value for TRAN_DATE
   * @param TRAN_ID The new value for TRAN_ID
   * @param PART_TRAN_SRL_NUM The new value for PART_TRAN_SRL_NUM
   * @param DEL_FLG The new value for DEL_FLG
   * @param TRAN_TYPE The new value for TRAN_TYPE
   * @param TRAN_SUB_TYPE The new value for TRAN_SUB_TYPE
   * @param PART_TRAN_TYPE The new value for PART_TRAN_TYPE
   * @param GL_SUB_HEAD_CODE The new value for GL_SUB_HEAD_CODE
   * @param ACID The new value for ACID
   * @param VALUE_DATE The new value for VALUE_DATE
   * @param TRAN_AMT The new value for TRAN_AMT
   * @param TRAN_PARTICULAR The new value for TRAN_PARTICULAR
   * @param ENTRY_USER_ID The new value for ENTRY_USER_ID
   * @param PSTD_USER_ID The new value for PSTD_USER_ID
   * @param VFD_USER_ID The new value for VFD_USER_ID
   * @param ENTRY_DATE The new value for ENTRY_DATE
   * @param PSTD_DATE The new value for PSTD_DATE
   * @param VFD_DATE The new value for VFD_DATE
   * @param RPT_CODE The new value for RPT_CODE
   * @param REF_NUM The new value for REF_NUM
   * @param INSTRMNT_TYPE The new value for INSTRMNT_TYPE
   * @param INSTRMNT_DATE The new value for INSTRMNT_DATE
   * @param INSTRMNT_NUM The new value for INSTRMNT_NUM
   * @param INSTRMNT_ALPHA The new value for INSTRMNT_ALPHA
   * @param TRAN_RMKS The new value for TRAN_RMKS
   * @param PSTD_FLG The new value for PSTD_FLG
   * @param PRNT_ADVC_IND The new value for PRNT_ADVC_IND
   * @param AMT_RESERVATION_IND The new value for AMT_RESERVATION_IND
   * @param RESERVATION_AMT The new value for RESERVATION_AMT
   * @param RESTRICT_MODIFY_IND The new value for RESTRICT_MODIFY_IND
   * @param LCHG_USER_ID The new value for LCHG_USER_ID
   * @param LCHG_TIME The new value for LCHG_TIME
   * @param RCRE_USER_ID The new value for RCRE_USER_ID
   * @param RCRE_TIME The new value for RCRE_TIME
   * @param CUST_ID The new value for CUST_ID
   * @param VOUCHER_PRINT_FLG The new value for VOUCHER_PRINT_FLG
   * @param MODULE_ID The new value for MODULE_ID
   * @param BR_CODE The new value for BR_CODE
   * @param FX_TRAN_AMT The new value for FX_TRAN_AMT
   * @param RATE_CODE The new value for RATE_CODE
   * @param RATE The new value for RATE
   * @param CRNCY_CODE The new value for CRNCY_CODE
   * @param NAVIGATION_FLG The new value for NAVIGATION_FLG
   * @param TRAN_CRNCY_CODE The new value for TRAN_CRNCY_CODE
   * @param REF_CRNCY_CODE The new value for REF_CRNCY_CODE
   * @param REF_AMT The new value for REF_AMT
   * @param SOL_ID The new value for SOL_ID
   * @param BANK_CODE The new value for BANK_CODE
   * @param TREA_REF_NUM The new value for TREA_REF_NUM
   * @param TREA_RATE The new value for TREA_RATE
   * @param TS_CNT The new value for TS_CNT
   * @param GST_UPD_FLG The new value for GST_UPD_FLG
   * @param ISO_FLG The new value for ISO_FLG
   * @param EABFAB_UPD_FLG The new value for EABFAB_UPD_FLG
   * @param LIFT_LIEN_FLG The new value for LIFT_LIEN_FLG
   * @param PROXY_POST_IND The new value for PROXY_POST_IND
   * @param SI_SRL_NUM The new value for SI_SRL_NUM
   * @param SI_ORG_EXEC_DATE The new value for SI_ORG_EXEC_DATE
   * @param PR_SRL_NUM The new value for PR_SRL_NUM
   * @param SERIAL_NUM The new value for SERIAL_NUM
   * @param DEL_MEMO_PAD The new value for DEL_MEMO_PAD
   * @param UAD_MODULE_ID The new value for UAD_MODULE_ID
   * @param UAD_MODULE_KEY The new value for UAD_MODULE_KEY
   * @param REVERSAL_DATE The new value for REVERSAL_DATE
   * @param REVERSAL_VALUE_DATE The new value for REVERSAL_VALUE_DATE
   * @param PTTM_EVENT_TYPE The new value for PTTM_EVENT_TYPE
   * @param PROXY_ACID The new value for PROXY_ACID
   * @param TOD_ENTITY_TYPE The new value for TOD_ENTITY_TYPE
   * @param TOD_ENTITY_ID The new value for TOD_ENTITY_ID
   * @param DTH_INIT_SOL_ID The new value for DTH_INIT_SOL_ID
   * @param REGULARIZATION_AMT The new value for REGULARIZATION_AMT
   * @param PRINCIPAL_PORTION_AMT The new value for PRINCIPAL_PORTION_AMT
   * @param TF_ENTITY_SOL_ID The new value for TF_ENTITY_SOL_ID
   * @param TRAN_PARTICULAR_2 The new value for TRAN_PARTICULAR_2
   * @param TRAN_PARTICULAR_CODE The new value for TRAN_PARTICULAR_CODE
   * @param TR_STATUS The new value for TR_STATUS
   * @param SVS_TRAN_ID The new value for SVS_TRAN_ID
   * @param CRNCY_HOL_CHK_DONE_FLG The new value for CRNCY_HOL_CHK_DONE_FLG
   * @param REFERRAL_ID The new value for REFERRAL_ID
   * @param PARTY_CODE The new value for PARTY_CODE
   * @param GL_DATE The new value for GL_DATE
   * @param BKDT_TRAN_FLG The new value for BKDT_TRAN_FLG
   * @param BANK_ID The new value for BANK_ID
   * @param IMPL_CASH_PART_TRAN_FLG The new value for IMPL_CASH_PART_TRAN_FLG
   * @param PTRAN_CHRG_EXISTS_FLG The new value for PTRAN_CHRG_EXISTS_FLG
   * @param MUD_POOL_BAL_BUILD_FLG The new value for MUD_POOL_BAL_BUILD_FLG
   * @param GL_SEGMENT_STRING The new value for GL_SEGMENT_STRING
   * @param SYS_PART_TRAN_CODE The new value for SYS_PART_TRAN_CODE
   * @param USER_PART_TRAN_CODE The new value for USER_PART_TRAN_CODE
   * @param TRAN_FREE_CODE1 The new value for TRAN_FREE_CODE1
   * @param TRAN_FREE_CODE2 The new value for TRAN_FREE_CODE2
   * @param PSTD_SRL_NUM The new value for PSTD_SRL_NUM
   * @param REVERSAL_STATUS The new value for REVERSAL_STATUS
   * @param AVAILABLE_AMT The new value for AVAILABLE_AMT
   * @param ACCT_BALANCE The new value for ACCT_BALANCE
   */
  public BusinessEvent(java.lang.Double EFFECTIVE_BAL, java.lang.Double CLR_BAL, java.nio.ByteBuffer FORACID, java.lang.Long LAST_BAL_UPDATED_DATE, java.nio.ByteBuffer SCHM_CODE, java.nio.ByteBuffer CIF_ID, java.nio.ByteBuffer ACCT_NAME, java.nio.ByteBuffer ACCT_SHORT_NAME, java.nio.ByteBuffer SCHM_SUB_TYPE, java.nio.ByteBuffer SCHM_TYPE, java.lang.CharSequence TRAN_DATE, java.nio.ByteBuffer TRAN_ID, java.nio.ByteBuffer PART_TRAN_SRL_NUM, java.nio.ByteBuffer DEL_FLG, java.nio.ByteBuffer TRAN_TYPE, java.nio.ByteBuffer TRAN_SUB_TYPE, java.nio.ByteBuffer PART_TRAN_TYPE, java.nio.ByteBuffer GL_SUB_HEAD_CODE, java.nio.ByteBuffer ACID, java.lang.CharSequence VALUE_DATE, java.lang.Double TRAN_AMT, java.nio.ByteBuffer TRAN_PARTICULAR, java.nio.ByteBuffer ENTRY_USER_ID, java.nio.ByteBuffer PSTD_USER_ID, java.nio.ByteBuffer VFD_USER_ID, java.lang.CharSequence ENTRY_DATE, java.lang.CharSequence PSTD_DATE, java.lang.CharSequence VFD_DATE, java.nio.ByteBuffer RPT_CODE, java.nio.ByteBuffer REF_NUM, java.nio.ByteBuffer INSTRMNT_TYPE, java.lang.CharSequence INSTRMNT_DATE, java.nio.ByteBuffer INSTRMNT_NUM, java.nio.ByteBuffer INSTRMNT_ALPHA, java.nio.ByteBuffer TRAN_RMKS, java.nio.ByteBuffer PSTD_FLG, java.nio.ByteBuffer PRNT_ADVC_IND, java.nio.ByteBuffer AMT_RESERVATION_IND, java.lang.Double RESERVATION_AMT, java.nio.ByteBuffer RESTRICT_MODIFY_IND, java.nio.ByteBuffer LCHG_USER_ID, java.lang.CharSequence LCHG_TIME, java.nio.ByteBuffer RCRE_USER_ID, java.lang.CharSequence RCRE_TIME, java.nio.ByteBuffer CUST_ID, java.nio.ByteBuffer VOUCHER_PRINT_FLG, java.nio.ByteBuffer MODULE_ID, java.nio.ByteBuffer BR_CODE, java.lang.Double FX_TRAN_AMT, java.nio.ByteBuffer RATE_CODE, java.lang.Double RATE, java.nio.ByteBuffer CRNCY_CODE, java.nio.ByteBuffer NAVIGATION_FLG, java.nio.ByteBuffer TRAN_CRNCY_CODE, java.nio.ByteBuffer REF_CRNCY_CODE, java.lang.Double REF_AMT, java.nio.ByteBuffer SOL_ID, java.nio.ByteBuffer BANK_CODE, java.nio.ByteBuffer TREA_REF_NUM, java.lang.Double TREA_RATE, java.lang.Long TS_CNT, java.nio.ByteBuffer GST_UPD_FLG, java.nio.ByteBuffer ISO_FLG, java.nio.ByteBuffer EABFAB_UPD_FLG, java.nio.ByteBuffer LIFT_LIEN_FLG, java.nio.ByteBuffer PROXY_POST_IND, java.nio.ByteBuffer SI_SRL_NUM, java.lang.CharSequence SI_ORG_EXEC_DATE, java.nio.ByteBuffer PR_SRL_NUM, java.nio.ByteBuffer SERIAL_NUM, java.nio.ByteBuffer DEL_MEMO_PAD, java.nio.ByteBuffer UAD_MODULE_ID, java.nio.ByteBuffer UAD_MODULE_KEY, java.lang.CharSequence REVERSAL_DATE, java.lang.CharSequence REVERSAL_VALUE_DATE, java.nio.ByteBuffer PTTM_EVENT_TYPE, java.nio.ByteBuffer PROXY_ACID, java.nio.ByteBuffer TOD_ENTITY_TYPE, java.nio.ByteBuffer TOD_ENTITY_ID, java.nio.ByteBuffer DTH_INIT_SOL_ID, java.lang.Double REGULARIZATION_AMT, java.lang.Double PRINCIPAL_PORTION_AMT, java.nio.ByteBuffer TF_ENTITY_SOL_ID, java.nio.ByteBuffer TRAN_PARTICULAR_2, java.nio.ByteBuffer TRAN_PARTICULAR_CODE, java.nio.ByteBuffer TR_STATUS, java.nio.ByteBuffer SVS_TRAN_ID, java.nio.ByteBuffer CRNCY_HOL_CHK_DONE_FLG, java.nio.ByteBuffer REFERRAL_ID, java.nio.ByteBuffer PARTY_CODE, java.lang.CharSequence GL_DATE, java.nio.ByteBuffer BKDT_TRAN_FLG, java.nio.ByteBuffer BANK_ID, java.nio.ByteBuffer IMPL_CASH_PART_TRAN_FLG, java.nio.ByteBuffer PTRAN_CHRG_EXISTS_FLG, java.nio.ByteBuffer MUD_POOL_BAL_BUILD_FLG, java.nio.ByteBuffer GL_SEGMENT_STRING, java.nio.ByteBuffer SYS_PART_TRAN_CODE, java.nio.ByteBuffer USER_PART_TRAN_CODE, java.nio.ByteBuffer TRAN_FREE_CODE1, java.nio.ByteBuffer TRAN_FREE_CODE2, java.lang.Long PSTD_SRL_NUM, java.nio.ByteBuffer REVERSAL_STATUS, java.lang.Double AVAILABLE_AMT, java.lang.Double ACCT_BALANCE) {
    this.EFFECTIVE_BAL = EFFECTIVE_BAL;
    this.CLR_BAL = CLR_BAL;
    this.FORACID = FORACID;
    this.LAST_BAL_UPDATED_DATE = LAST_BAL_UPDATED_DATE;
    this.SCHM_CODE = SCHM_CODE;
    this.CIF_ID = CIF_ID;
    this.ACCT_NAME = ACCT_NAME;
    this.ACCT_SHORT_NAME = ACCT_SHORT_NAME;
    this.SCHM_SUB_TYPE = SCHM_SUB_TYPE;
    this.SCHM_TYPE = SCHM_TYPE;
    this.TRAN_DATE = TRAN_DATE;
    this.TRAN_ID = TRAN_ID;
    this.PART_TRAN_SRL_NUM = PART_TRAN_SRL_NUM;
    this.DEL_FLG = DEL_FLG;
    this.TRAN_TYPE = TRAN_TYPE;
    this.TRAN_SUB_TYPE = TRAN_SUB_TYPE;
    this.PART_TRAN_TYPE = PART_TRAN_TYPE;
    this.GL_SUB_HEAD_CODE = GL_SUB_HEAD_CODE;
    this.ACID = ACID;
    this.VALUE_DATE = VALUE_DATE;
    this.TRAN_AMT = TRAN_AMT;
    this.TRAN_PARTICULAR = TRAN_PARTICULAR;
    this.ENTRY_USER_ID = ENTRY_USER_ID;
    this.PSTD_USER_ID = PSTD_USER_ID;
    this.VFD_USER_ID = VFD_USER_ID;
    this.ENTRY_DATE = ENTRY_DATE;
    this.PSTD_DATE = PSTD_DATE;
    this.VFD_DATE = VFD_DATE;
    this.RPT_CODE = RPT_CODE;
    this.REF_NUM = REF_NUM;
    this.INSTRMNT_TYPE = INSTRMNT_TYPE;
    this.INSTRMNT_DATE = INSTRMNT_DATE;
    this.INSTRMNT_NUM = INSTRMNT_NUM;
    this.INSTRMNT_ALPHA = INSTRMNT_ALPHA;
    this.TRAN_RMKS = TRAN_RMKS;
    this.PSTD_FLG = PSTD_FLG;
    this.PRNT_ADVC_IND = PRNT_ADVC_IND;
    this.AMT_RESERVATION_IND = AMT_RESERVATION_IND;
    this.RESERVATION_AMT = RESERVATION_AMT;
    this.RESTRICT_MODIFY_IND = RESTRICT_MODIFY_IND;
    this.LCHG_USER_ID = LCHG_USER_ID;
    this.LCHG_TIME = LCHG_TIME;
    this.RCRE_USER_ID = RCRE_USER_ID;
    this.RCRE_TIME = RCRE_TIME;
    this.CUST_ID = CUST_ID;
    this.VOUCHER_PRINT_FLG = VOUCHER_PRINT_FLG;
    this.MODULE_ID = MODULE_ID;
    this.BR_CODE = BR_CODE;
    this.FX_TRAN_AMT = FX_TRAN_AMT;
    this.RATE_CODE = RATE_CODE;
    this.RATE = RATE;
    this.CRNCY_CODE = CRNCY_CODE;
    this.NAVIGATION_FLG = NAVIGATION_FLG;
    this.TRAN_CRNCY_CODE = TRAN_CRNCY_CODE;
    this.REF_CRNCY_CODE = REF_CRNCY_CODE;
    this.REF_AMT = REF_AMT;
    this.SOL_ID = SOL_ID;
    this.BANK_CODE = BANK_CODE;
    this.TREA_REF_NUM = TREA_REF_NUM;
    this.TREA_RATE = TREA_RATE;
    this.TS_CNT = TS_CNT;
    this.GST_UPD_FLG = GST_UPD_FLG;
    this.ISO_FLG = ISO_FLG;
    this.EABFAB_UPD_FLG = EABFAB_UPD_FLG;
    this.LIFT_LIEN_FLG = LIFT_LIEN_FLG;
    this.PROXY_POST_IND = PROXY_POST_IND;
    this.SI_SRL_NUM = SI_SRL_NUM;
    this.SI_ORG_EXEC_DATE = SI_ORG_EXEC_DATE;
    this.PR_SRL_NUM = PR_SRL_NUM;
    this.SERIAL_NUM = SERIAL_NUM;
    this.DEL_MEMO_PAD = DEL_MEMO_PAD;
    this.UAD_MODULE_ID = UAD_MODULE_ID;
    this.UAD_MODULE_KEY = UAD_MODULE_KEY;
    this.REVERSAL_DATE = REVERSAL_DATE;
    this.REVERSAL_VALUE_DATE = REVERSAL_VALUE_DATE;
    this.PTTM_EVENT_TYPE = PTTM_EVENT_TYPE;
    this.PROXY_ACID = PROXY_ACID;
    this.TOD_ENTITY_TYPE = TOD_ENTITY_TYPE;
    this.TOD_ENTITY_ID = TOD_ENTITY_ID;
    this.DTH_INIT_SOL_ID = DTH_INIT_SOL_ID;
    this.REGULARIZATION_AMT = REGULARIZATION_AMT;
    this.PRINCIPAL_PORTION_AMT = PRINCIPAL_PORTION_AMT;
    this.TF_ENTITY_SOL_ID = TF_ENTITY_SOL_ID;
    this.TRAN_PARTICULAR_2 = TRAN_PARTICULAR_2;
    this.TRAN_PARTICULAR_CODE = TRAN_PARTICULAR_CODE;
    this.TR_STATUS = TR_STATUS;
    this.SVS_TRAN_ID = SVS_TRAN_ID;
    this.CRNCY_HOL_CHK_DONE_FLG = CRNCY_HOL_CHK_DONE_FLG;
    this.REFERRAL_ID = REFERRAL_ID;
    this.PARTY_CODE = PARTY_CODE;
    this.GL_DATE = GL_DATE;
    this.BKDT_TRAN_FLG = BKDT_TRAN_FLG;
    this.BANK_ID = BANK_ID;
    this.IMPL_CASH_PART_TRAN_FLG = IMPL_CASH_PART_TRAN_FLG;
    this.PTRAN_CHRG_EXISTS_FLG = PTRAN_CHRG_EXISTS_FLG;
    this.MUD_POOL_BAL_BUILD_FLG = MUD_POOL_BAL_BUILD_FLG;
    this.GL_SEGMENT_STRING = GL_SEGMENT_STRING;
    this.SYS_PART_TRAN_CODE = SYS_PART_TRAN_CODE;
    this.USER_PART_TRAN_CODE = USER_PART_TRAN_CODE;
    this.TRAN_FREE_CODE1 = TRAN_FREE_CODE1;
    this.TRAN_FREE_CODE2 = TRAN_FREE_CODE2;
    this.PSTD_SRL_NUM = PSTD_SRL_NUM;
    this.REVERSAL_STATUS = REVERSAL_STATUS;
    this.AVAILABLE_AMT = AVAILABLE_AMT;
    this.ACCT_BALANCE = ACCT_BALANCE;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return EFFECTIVE_BAL;
    case 1: return CLR_BAL;
    case 2: return FORACID;
    case 3: return LAST_BAL_UPDATED_DATE;
    case 4: return SCHM_CODE;
    case 5: return CIF_ID;
    case 6: return ACCT_NAME;
    case 7: return ACCT_SHORT_NAME;
    case 8: return SCHM_SUB_TYPE;
    case 9: return SCHM_TYPE;
    case 10: return TRAN_DATE;
    case 11: return TRAN_ID;
    case 12: return PART_TRAN_SRL_NUM;
    case 13: return DEL_FLG;
    case 14: return TRAN_TYPE;
    case 15: return TRAN_SUB_TYPE;
    case 16: return PART_TRAN_TYPE;
    case 17: return GL_SUB_HEAD_CODE;
    case 18: return ACID;
    case 19: return VALUE_DATE;
    case 20: return TRAN_AMT;
    case 21: return TRAN_PARTICULAR;
    case 22: return ENTRY_USER_ID;
    case 23: return PSTD_USER_ID;
    case 24: return VFD_USER_ID;
    case 25: return ENTRY_DATE;
    case 26: return PSTD_DATE;
    case 27: return VFD_DATE;
    case 28: return RPT_CODE;
    case 29: return REF_NUM;
    case 30: return INSTRMNT_TYPE;
    case 31: return INSTRMNT_DATE;
    case 32: return INSTRMNT_NUM;
    case 33: return INSTRMNT_ALPHA;
    case 34: return TRAN_RMKS;
    case 35: return PSTD_FLG;
    case 36: return PRNT_ADVC_IND;
    case 37: return AMT_RESERVATION_IND;
    case 38: return RESERVATION_AMT;
    case 39: return RESTRICT_MODIFY_IND;
    case 40: return LCHG_USER_ID;
    case 41: return LCHG_TIME;
    case 42: return RCRE_USER_ID;
    case 43: return RCRE_TIME;
    case 44: return CUST_ID;
    case 45: return VOUCHER_PRINT_FLG;
    case 46: return MODULE_ID;
    case 47: return BR_CODE;
    case 48: return FX_TRAN_AMT;
    case 49: return RATE_CODE;
    case 50: return RATE;
    case 51: return CRNCY_CODE;
    case 52: return NAVIGATION_FLG;
    case 53: return TRAN_CRNCY_CODE;
    case 54: return REF_CRNCY_CODE;
    case 55: return REF_AMT;
    case 56: return SOL_ID;
    case 57: return BANK_CODE;
    case 58: return TREA_REF_NUM;
    case 59: return TREA_RATE;
    case 60: return TS_CNT;
    case 61: return GST_UPD_FLG;
    case 62: return ISO_FLG;
    case 63: return EABFAB_UPD_FLG;
    case 64: return LIFT_LIEN_FLG;
    case 65: return PROXY_POST_IND;
    case 66: return SI_SRL_NUM;
    case 67: return SI_ORG_EXEC_DATE;
    case 68: return PR_SRL_NUM;
    case 69: return SERIAL_NUM;
    case 70: return DEL_MEMO_PAD;
    case 71: return UAD_MODULE_ID;
    case 72: return UAD_MODULE_KEY;
    case 73: return REVERSAL_DATE;
    case 74: return REVERSAL_VALUE_DATE;
    case 75: return PTTM_EVENT_TYPE;
    case 76: return PROXY_ACID;
    case 77: return TOD_ENTITY_TYPE;
    case 78: return TOD_ENTITY_ID;
    case 79: return DTH_INIT_SOL_ID;
    case 80: return REGULARIZATION_AMT;
    case 81: return PRINCIPAL_PORTION_AMT;
    case 82: return TF_ENTITY_SOL_ID;
    case 83: return TRAN_PARTICULAR_2;
    case 84: return TRAN_PARTICULAR_CODE;
    case 85: return TR_STATUS;
    case 86: return SVS_TRAN_ID;
    case 87: return CRNCY_HOL_CHK_DONE_FLG;
    case 88: return REFERRAL_ID;
    case 89: return PARTY_CODE;
    case 90: return GL_DATE;
    case 91: return BKDT_TRAN_FLG;
    case 92: return BANK_ID;
    case 93: return IMPL_CASH_PART_TRAN_FLG;
    case 94: return PTRAN_CHRG_EXISTS_FLG;
    case 95: return MUD_POOL_BAL_BUILD_FLG;
    case 96: return GL_SEGMENT_STRING;
    case 97: return SYS_PART_TRAN_CODE;
    case 98: return USER_PART_TRAN_CODE;
    case 99: return TRAN_FREE_CODE1;
    case 100: return TRAN_FREE_CODE2;
    case 101: return PSTD_SRL_NUM;
    case 102: return REVERSAL_STATUS;
    case 103: return AVAILABLE_AMT;
    case 104: return ACCT_BALANCE;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: EFFECTIVE_BAL = (java.lang.Double)value$; break;
    case 1: CLR_BAL = (java.lang.Double)value$; break;
    case 2: FORACID = (java.nio.ByteBuffer)value$; break;
    case 3: LAST_BAL_UPDATED_DATE = (java.lang.Long)value$; break;
    case 4: SCHM_CODE = (java.nio.ByteBuffer)value$; break;
    case 5: CIF_ID = (java.nio.ByteBuffer)value$; break;
    case 6: ACCT_NAME = (java.nio.ByteBuffer)value$; break;
    case 7: ACCT_SHORT_NAME = (java.nio.ByteBuffer)value$; break;
    case 8: SCHM_SUB_TYPE = (java.nio.ByteBuffer)value$; break;
    case 9: SCHM_TYPE = (java.nio.ByteBuffer)value$; break;
    case 10: TRAN_DATE = (java.lang.CharSequence)value$; break;
    case 11: TRAN_ID = (java.nio.ByteBuffer)value$; break;
    case 12: PART_TRAN_SRL_NUM = (java.nio.ByteBuffer)value$; break;
    case 13: DEL_FLG = (java.nio.ByteBuffer)value$; break;
    case 14: TRAN_TYPE = (java.nio.ByteBuffer)value$; break;
    case 15: TRAN_SUB_TYPE = (java.nio.ByteBuffer)value$; break;
    case 16: PART_TRAN_TYPE = (java.nio.ByteBuffer)value$; break;
    case 17: GL_SUB_HEAD_CODE = (java.nio.ByteBuffer)value$; break;
    case 18: ACID = (java.nio.ByteBuffer)value$; break;
    case 19: VALUE_DATE = (java.lang.CharSequence)value$; break;
    case 20: TRAN_AMT = (java.lang.Double)value$; break;
    case 21: TRAN_PARTICULAR = (java.nio.ByteBuffer)value$; break;
    case 22: ENTRY_USER_ID = (java.nio.ByteBuffer)value$; break;
    case 23: PSTD_USER_ID = (java.nio.ByteBuffer)value$; break;
    case 24: VFD_USER_ID = (java.nio.ByteBuffer)value$; break;
    case 25: ENTRY_DATE = (java.lang.CharSequence)value$; break;
    case 26: PSTD_DATE = (java.lang.CharSequence)value$; break;
    case 27: VFD_DATE = (java.lang.CharSequence)value$; break;
    case 28: RPT_CODE = (java.nio.ByteBuffer)value$; break;
    case 29: REF_NUM = (java.nio.ByteBuffer)value$; break;
    case 30: INSTRMNT_TYPE = (java.nio.ByteBuffer)value$; break;
    case 31: INSTRMNT_DATE = (java.lang.CharSequence)value$; break;
    case 32: INSTRMNT_NUM = (java.nio.ByteBuffer)value$; break;
    case 33: INSTRMNT_ALPHA = (java.nio.ByteBuffer)value$; break;
    case 34: TRAN_RMKS = (java.nio.ByteBuffer)value$; break;
    case 35: PSTD_FLG = (java.nio.ByteBuffer)value$; break;
    case 36: PRNT_ADVC_IND = (java.nio.ByteBuffer)value$; break;
    case 37: AMT_RESERVATION_IND = (java.nio.ByteBuffer)value$; break;
    case 38: RESERVATION_AMT = (java.lang.Double)value$; break;
    case 39: RESTRICT_MODIFY_IND = (java.nio.ByteBuffer)value$; break;
    case 40: LCHG_USER_ID = (java.nio.ByteBuffer)value$; break;
    case 41: LCHG_TIME = (java.lang.CharSequence)value$; break;
    case 42: RCRE_USER_ID = (java.nio.ByteBuffer)value$; break;
    case 43: RCRE_TIME = (java.lang.CharSequence)value$; break;
    case 44: CUST_ID = (java.nio.ByteBuffer)value$; break;
    case 45: VOUCHER_PRINT_FLG = (java.nio.ByteBuffer)value$; break;
    case 46: MODULE_ID = (java.nio.ByteBuffer)value$; break;
    case 47: BR_CODE = (java.nio.ByteBuffer)value$; break;
    case 48: FX_TRAN_AMT = (java.lang.Double)value$; break;
    case 49: RATE_CODE = (java.nio.ByteBuffer)value$; break;
    case 50: RATE = (java.lang.Double)value$; break;
    case 51: CRNCY_CODE = (java.nio.ByteBuffer)value$; break;
    case 52: NAVIGATION_FLG = (java.nio.ByteBuffer)value$; break;
    case 53: TRAN_CRNCY_CODE = (java.nio.ByteBuffer)value$; break;
    case 54: REF_CRNCY_CODE = (java.nio.ByteBuffer)value$; break;
    case 55: REF_AMT = (java.lang.Double)value$; break;
    case 56: SOL_ID = (java.nio.ByteBuffer)value$; break;
    case 57: BANK_CODE = (java.nio.ByteBuffer)value$; break;
    case 58: TREA_REF_NUM = (java.nio.ByteBuffer)value$; break;
    case 59: TREA_RATE = (java.lang.Double)value$; break;
    case 60: TS_CNT = (java.lang.Long)value$; break;
    case 61: GST_UPD_FLG = (java.nio.ByteBuffer)value$; break;
    case 62: ISO_FLG = (java.nio.ByteBuffer)value$; break;
    case 63: EABFAB_UPD_FLG = (java.nio.ByteBuffer)value$; break;
    case 64: LIFT_LIEN_FLG = (java.nio.ByteBuffer)value$; break;
    case 65: PROXY_POST_IND = (java.nio.ByteBuffer)value$; break;
    case 66: SI_SRL_NUM = (java.nio.ByteBuffer)value$; break;
    case 67: SI_ORG_EXEC_DATE = (java.lang.CharSequence)value$; break;
    case 68: PR_SRL_NUM = (java.nio.ByteBuffer)value$; break;
    case 69: SERIAL_NUM = (java.nio.ByteBuffer)value$; break;
    case 70: DEL_MEMO_PAD = (java.nio.ByteBuffer)value$; break;
    case 71: UAD_MODULE_ID = (java.nio.ByteBuffer)value$; break;
    case 72: UAD_MODULE_KEY = (java.nio.ByteBuffer)value$; break;
    case 73: REVERSAL_DATE = (java.lang.CharSequence)value$; break;
    case 74: REVERSAL_VALUE_DATE = (java.lang.CharSequence)value$; break;
    case 75: PTTM_EVENT_TYPE = (java.nio.ByteBuffer)value$; break;
    case 76: PROXY_ACID = (java.nio.ByteBuffer)value$; break;
    case 77: TOD_ENTITY_TYPE = (java.nio.ByteBuffer)value$; break;
    case 78: TOD_ENTITY_ID = (java.nio.ByteBuffer)value$; break;
    case 79: DTH_INIT_SOL_ID = (java.nio.ByteBuffer)value$; break;
    case 80: REGULARIZATION_AMT = (java.lang.Double)value$; break;
    case 81: PRINCIPAL_PORTION_AMT = (java.lang.Double)value$; break;
    case 82: TF_ENTITY_SOL_ID = (java.nio.ByteBuffer)value$; break;
    case 83: TRAN_PARTICULAR_2 = (java.nio.ByteBuffer)value$; break;
    case 84: TRAN_PARTICULAR_CODE = (java.nio.ByteBuffer)value$; break;
    case 85: TR_STATUS = (java.nio.ByteBuffer)value$; break;
    case 86: SVS_TRAN_ID = (java.nio.ByteBuffer)value$; break;
    case 87: CRNCY_HOL_CHK_DONE_FLG = (java.nio.ByteBuffer)value$; break;
    case 88: REFERRAL_ID = (java.nio.ByteBuffer)value$; break;
    case 89: PARTY_CODE = (java.nio.ByteBuffer)value$; break;
    case 90: GL_DATE = (java.lang.CharSequence)value$; break;
    case 91: BKDT_TRAN_FLG = (java.nio.ByteBuffer)value$; break;
    case 92: BANK_ID = (java.nio.ByteBuffer)value$; break;
    case 93: IMPL_CASH_PART_TRAN_FLG = (java.nio.ByteBuffer)value$; break;
    case 94: PTRAN_CHRG_EXISTS_FLG = (java.nio.ByteBuffer)value$; break;
    case 95: MUD_POOL_BAL_BUILD_FLG = (java.nio.ByteBuffer)value$; break;
    case 96: GL_SEGMENT_STRING = (java.nio.ByteBuffer)value$; break;
    case 97: SYS_PART_TRAN_CODE = (java.nio.ByteBuffer)value$; break;
    case 98: USER_PART_TRAN_CODE = (java.nio.ByteBuffer)value$; break;
    case 99: TRAN_FREE_CODE1 = (java.nio.ByteBuffer)value$; break;
    case 100: TRAN_FREE_CODE2 = (java.nio.ByteBuffer)value$; break;
    case 101: PSTD_SRL_NUM = (java.lang.Long)value$; break;
    case 102: REVERSAL_STATUS = (java.nio.ByteBuffer)value$; break;
    case 103: AVAILABLE_AMT = (java.lang.Double)value$; break;
    case 104: ACCT_BALANCE = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'EFFECTIVE_BAL' field.
   * @return The value of the 'EFFECTIVE_BAL' field.
   */
  public java.lang.Double getEFFECTIVEBAL() {
    return EFFECTIVE_BAL;
  }

  /**
   * Sets the value of the 'EFFECTIVE_BAL' field.
   * @param value the value to set.
   */
  public void setEFFECTIVEBAL(java.lang.Double value) {
    this.EFFECTIVE_BAL = value;
  }

  /**
   * Gets the value of the 'CLR_BAL' field.
   * @return The value of the 'CLR_BAL' field.
   */
  public java.lang.Double getCLRBAL() {
    return CLR_BAL;
  }

  /**
   * Sets the value of the 'CLR_BAL' field.
   * @param value the value to set.
   */
  public void setCLRBAL(java.lang.Double value) {
    this.CLR_BAL = value;
  }

  /**
   * Gets the value of the 'FORACID' field.
   * @return The value of the 'FORACID' field.
   */
  public java.nio.ByteBuffer getFORACID() {
    return FORACID;
  }

  /**
   * Sets the value of the 'FORACID' field.
   * @param value the value to set.
   */
  public void setFORACID(java.nio.ByteBuffer value) {
    this.FORACID = value;
  }

  /**
   * Gets the value of the 'LAST_BAL_UPDATED_DATE' field.
   * @return The value of the 'LAST_BAL_UPDATED_DATE' field.
   */
  public java.lang.Long getLASTBALUPDATEDDATE() {
    return LAST_BAL_UPDATED_DATE;
  }

  /**
   * Sets the value of the 'LAST_BAL_UPDATED_DATE' field.
   * @param value the value to set.
   */
  public void setLASTBALUPDATEDDATE(java.lang.Long value) {
    this.LAST_BAL_UPDATED_DATE = value;
  }

  /**
   * Gets the value of the 'SCHM_CODE' field.
   * @return The value of the 'SCHM_CODE' field.
   */
  public java.nio.ByteBuffer getSCHMCODE() {
    return SCHM_CODE;
  }

  /**
   * Sets the value of the 'SCHM_CODE' field.
   * @param value the value to set.
   */
  public void setSCHMCODE(java.nio.ByteBuffer value) {
    this.SCHM_CODE = value;
  }

  /**
   * Gets the value of the 'CIF_ID' field.
   * @return The value of the 'CIF_ID' field.
   */
  public java.nio.ByteBuffer getCIFID() {
    return CIF_ID;
  }

  /**
   * Sets the value of the 'CIF_ID' field.
   * @param value the value to set.
   */
  public void setCIFID(java.nio.ByteBuffer value) {
    this.CIF_ID = value;
  }

  /**
   * Gets the value of the 'ACCT_NAME' field.
   * @return The value of the 'ACCT_NAME' field.
   */
  public java.nio.ByteBuffer getACCTNAME() {
    return ACCT_NAME;
  }

  /**
   * Sets the value of the 'ACCT_NAME' field.
   * @param value the value to set.
   */
  public void setACCTNAME(java.nio.ByteBuffer value) {
    this.ACCT_NAME = value;
  }

  /**
   * Gets the value of the 'ACCT_SHORT_NAME' field.
   * @return The value of the 'ACCT_SHORT_NAME' field.
   */
  public java.nio.ByteBuffer getACCTSHORTNAME() {
    return ACCT_SHORT_NAME;
  }

  /**
   * Sets the value of the 'ACCT_SHORT_NAME' field.
   * @param value the value to set.
   */
  public void setACCTSHORTNAME(java.nio.ByteBuffer value) {
    this.ACCT_SHORT_NAME = value;
  }

  /**
   * Gets the value of the 'SCHM_SUB_TYPE' field.
   * @return The value of the 'SCHM_SUB_TYPE' field.
   */
  public java.nio.ByteBuffer getSCHMSUBTYPE() {
    return SCHM_SUB_TYPE;
  }

  /**
   * Sets the value of the 'SCHM_SUB_TYPE' field.
   * @param value the value to set.
   */
  public void setSCHMSUBTYPE(java.nio.ByteBuffer value) {
    this.SCHM_SUB_TYPE = value;
  }

  /**
   * Gets the value of the 'SCHM_TYPE' field.
   * @return The value of the 'SCHM_TYPE' field.
   */
  public java.nio.ByteBuffer getSCHMTYPE() {
    return SCHM_TYPE;
  }

  /**
   * Sets the value of the 'SCHM_TYPE' field.
   * @param value the value to set.
   */
  public void setSCHMTYPE(java.nio.ByteBuffer value) {
    this.SCHM_TYPE = value;
  }

  /**
   * Gets the value of the 'TRAN_DATE' field.
   * @return The value of the 'TRAN_DATE' field.
   */
  public java.lang.CharSequence getTRANDATE() {
    return TRAN_DATE;
  }

  /**
   * Sets the value of the 'TRAN_DATE' field.
   * @param value the value to set.
   */
  public void setTRANDATE(java.lang.CharSequence value) {
    this.TRAN_DATE = value;
  }

  /**
   * Gets the value of the 'TRAN_ID' field.
   * @return The value of the 'TRAN_ID' field.
   */
  public java.nio.ByteBuffer getTRANID() {
    return TRAN_ID;
  }

  /**
   * Sets the value of the 'TRAN_ID' field.
   * @param value the value to set.
   */
  public void setTRANID(java.nio.ByteBuffer value) {
    this.TRAN_ID = value;
  }

  /**
   * Gets the value of the 'PART_TRAN_SRL_NUM' field.
   * @return The value of the 'PART_TRAN_SRL_NUM' field.
   */
  public java.nio.ByteBuffer getPARTTRANSRLNUM() {
    return PART_TRAN_SRL_NUM;
  }

  /**
   * Sets the value of the 'PART_TRAN_SRL_NUM' field.
   * @param value the value to set.
   */
  public void setPARTTRANSRLNUM(java.nio.ByteBuffer value) {
    this.PART_TRAN_SRL_NUM = value;
  }

  /**
   * Gets the value of the 'DEL_FLG' field.
   * @return The value of the 'DEL_FLG' field.
   */
  public java.nio.ByteBuffer getDELFLG() {
    return DEL_FLG;
  }

  /**
   * Sets the value of the 'DEL_FLG' field.
   * @param value the value to set.
   */
  public void setDELFLG(java.nio.ByteBuffer value) {
    this.DEL_FLG = value;
  }

  /**
   * Gets the value of the 'TRAN_TYPE' field.
   * @return The value of the 'TRAN_TYPE' field.
   */
  public java.nio.ByteBuffer getTRANTYPE() {
    return TRAN_TYPE;
  }

  /**
   * Sets the value of the 'TRAN_TYPE' field.
   * @param value the value to set.
   */
  public void setTRANTYPE(java.nio.ByteBuffer value) {
    this.TRAN_TYPE = value;
  }

  /**
   * Gets the value of the 'TRAN_SUB_TYPE' field.
   * @return The value of the 'TRAN_SUB_TYPE' field.
   */
  public java.nio.ByteBuffer getTRANSUBTYPE() {
    return TRAN_SUB_TYPE;
  }

  /**
   * Sets the value of the 'TRAN_SUB_TYPE' field.
   * @param value the value to set.
   */
  public void setTRANSUBTYPE(java.nio.ByteBuffer value) {
    this.TRAN_SUB_TYPE = value;
  }

  /**
   * Gets the value of the 'PART_TRAN_TYPE' field.
   * @return The value of the 'PART_TRAN_TYPE' field.
   */
  public java.nio.ByteBuffer getPARTTRANTYPE() {
    return PART_TRAN_TYPE;
  }

  /**
   * Sets the value of the 'PART_TRAN_TYPE' field.
   * @param value the value to set.
   */
  public void setPARTTRANTYPE(java.nio.ByteBuffer value) {
    this.PART_TRAN_TYPE = value;
  }

  /**
   * Gets the value of the 'GL_SUB_HEAD_CODE' field.
   * @return The value of the 'GL_SUB_HEAD_CODE' field.
   */
  public java.nio.ByteBuffer getGLSUBHEADCODE() {
    return GL_SUB_HEAD_CODE;
  }

  /**
   * Sets the value of the 'GL_SUB_HEAD_CODE' field.
   * @param value the value to set.
   */
  public void setGLSUBHEADCODE(java.nio.ByteBuffer value) {
    this.GL_SUB_HEAD_CODE = value;
  }

  /**
   * Gets the value of the 'ACID' field.
   * @return The value of the 'ACID' field.
   */
  public java.nio.ByteBuffer getACID() {
    return ACID;
  }

  /**
   * Sets the value of the 'ACID' field.
   * @param value the value to set.
   */
  public void setACID(java.nio.ByteBuffer value) {
    this.ACID = value;
  }

  /**
   * Gets the value of the 'VALUE_DATE' field.
   * @return The value of the 'VALUE_DATE' field.
   */
  public java.lang.CharSequence getVALUEDATE() {
    return VALUE_DATE;
  }

  /**
   * Sets the value of the 'VALUE_DATE' field.
   * @param value the value to set.
   */
  public void setVALUEDATE(java.lang.CharSequence value) {
    this.VALUE_DATE = value;
  }

  /**
   * Gets the value of the 'TRAN_AMT' field.
   * @return The value of the 'TRAN_AMT' field.
   */
  public java.lang.Double getTRANAMT() {
    return TRAN_AMT;
  }

  /**
   * Sets the value of the 'TRAN_AMT' field.
   * @param value the value to set.
   */
  public void setTRANAMT(java.lang.Double value) {
    this.TRAN_AMT = value;
  }

  /**
   * Gets the value of the 'TRAN_PARTICULAR' field.
   * @return The value of the 'TRAN_PARTICULAR' field.
   */
  public java.nio.ByteBuffer getTRANPARTICULAR() {
    return TRAN_PARTICULAR;
  }

  /**
   * Sets the value of the 'TRAN_PARTICULAR' field.
   * @param value the value to set.
   */
  public void setTRANPARTICULAR(java.nio.ByteBuffer value) {
    this.TRAN_PARTICULAR = value;
  }

  /**
   * Gets the value of the 'ENTRY_USER_ID' field.
   * @return The value of the 'ENTRY_USER_ID' field.
   */
  public java.nio.ByteBuffer getENTRYUSERID() {
    return ENTRY_USER_ID;
  }

  /**
   * Sets the value of the 'ENTRY_USER_ID' field.
   * @param value the value to set.
   */
  public void setENTRYUSERID(java.nio.ByteBuffer value) {
    this.ENTRY_USER_ID = value;
  }

  /**
   * Gets the value of the 'PSTD_USER_ID' field.
   * @return The value of the 'PSTD_USER_ID' field.
   */
  public java.nio.ByteBuffer getPSTDUSERID() {
    return PSTD_USER_ID;
  }

  /**
   * Sets the value of the 'PSTD_USER_ID' field.
   * @param value the value to set.
   */
  public void setPSTDUSERID(java.nio.ByteBuffer value) {
    this.PSTD_USER_ID = value;
  }

  /**
   * Gets the value of the 'VFD_USER_ID' field.
   * @return The value of the 'VFD_USER_ID' field.
   */
  public java.nio.ByteBuffer getVFDUSERID() {
    return VFD_USER_ID;
  }

  /**
   * Sets the value of the 'VFD_USER_ID' field.
   * @param value the value to set.
   */
  public void setVFDUSERID(java.nio.ByteBuffer value) {
    this.VFD_USER_ID = value;
  }

  /**
   * Gets the value of the 'ENTRY_DATE' field.
   * @return The value of the 'ENTRY_DATE' field.
   */
  public java.lang.CharSequence getENTRYDATE() {
    return ENTRY_DATE;
  }

  /**
   * Sets the value of the 'ENTRY_DATE' field.
   * @param value the value to set.
   */
  public void setENTRYDATE(java.lang.CharSequence value) {
    this.ENTRY_DATE = value;
  }

  /**
   * Gets the value of the 'PSTD_DATE' field.
   * @return The value of the 'PSTD_DATE' field.
   */
  public java.lang.CharSequence getPSTDDATE() {
    return PSTD_DATE;
  }

  /**
   * Sets the value of the 'PSTD_DATE' field.
   * @param value the value to set.
   */
  public void setPSTDDATE(java.lang.CharSequence value) {
    this.PSTD_DATE = value;
  }

  /**
   * Gets the value of the 'VFD_DATE' field.
   * @return The value of the 'VFD_DATE' field.
   */
  public java.lang.CharSequence getVFDDATE() {
    return VFD_DATE;
  }

  /**
   * Sets the value of the 'VFD_DATE' field.
   * @param value the value to set.
   */
  public void setVFDDATE(java.lang.CharSequence value) {
    this.VFD_DATE = value;
  }

  /**
   * Gets the value of the 'RPT_CODE' field.
   * @return The value of the 'RPT_CODE' field.
   */
  public java.nio.ByteBuffer getRPTCODE() {
    return RPT_CODE;
  }

  /**
   * Sets the value of the 'RPT_CODE' field.
   * @param value the value to set.
   */
  public void setRPTCODE(java.nio.ByteBuffer value) {
    this.RPT_CODE = value;
  }

  /**
   * Gets the value of the 'REF_NUM' field.
   * @return The value of the 'REF_NUM' field.
   */
  public java.nio.ByteBuffer getREFNUM() {
    return REF_NUM;
  }

  /**
   * Sets the value of the 'REF_NUM' field.
   * @param value the value to set.
   */
  public void setREFNUM(java.nio.ByteBuffer value) {
    this.REF_NUM = value;
  }

  /**
   * Gets the value of the 'INSTRMNT_TYPE' field.
   * @return The value of the 'INSTRMNT_TYPE' field.
   */
  public java.nio.ByteBuffer getINSTRMNTTYPE() {
    return INSTRMNT_TYPE;
  }

  /**
   * Sets the value of the 'INSTRMNT_TYPE' field.
   * @param value the value to set.
   */
  public void setINSTRMNTTYPE(java.nio.ByteBuffer value) {
    this.INSTRMNT_TYPE = value;
  }

  /**
   * Gets the value of the 'INSTRMNT_DATE' field.
   * @return The value of the 'INSTRMNT_DATE' field.
   */
  public java.lang.CharSequence getINSTRMNTDATE() {
    return INSTRMNT_DATE;
  }

  /**
   * Sets the value of the 'INSTRMNT_DATE' field.
   * @param value the value to set.
   */
  public void setINSTRMNTDATE(java.lang.CharSequence value) {
    this.INSTRMNT_DATE = value;
  }

  /**
   * Gets the value of the 'INSTRMNT_NUM' field.
   * @return The value of the 'INSTRMNT_NUM' field.
   */
  public java.nio.ByteBuffer getINSTRMNTNUM() {
    return INSTRMNT_NUM;
  }

  /**
   * Sets the value of the 'INSTRMNT_NUM' field.
   * @param value the value to set.
   */
  public void setINSTRMNTNUM(java.nio.ByteBuffer value) {
    this.INSTRMNT_NUM = value;
  }

  /**
   * Gets the value of the 'INSTRMNT_ALPHA' field.
   * @return The value of the 'INSTRMNT_ALPHA' field.
   */
  public java.nio.ByteBuffer getINSTRMNTALPHA() {
    return INSTRMNT_ALPHA;
  }

  /**
   * Sets the value of the 'INSTRMNT_ALPHA' field.
   * @param value the value to set.
   */
  public void setINSTRMNTALPHA(java.nio.ByteBuffer value) {
    this.INSTRMNT_ALPHA = value;
  }

  /**
   * Gets the value of the 'TRAN_RMKS' field.
   * @return The value of the 'TRAN_RMKS' field.
   */
  public java.nio.ByteBuffer getTRANRMKS() {
    return TRAN_RMKS;
  }

  /**
   * Sets the value of the 'TRAN_RMKS' field.
   * @param value the value to set.
   */
  public void setTRANRMKS(java.nio.ByteBuffer value) {
    this.TRAN_RMKS = value;
  }

  /**
   * Gets the value of the 'PSTD_FLG' field.
   * @return The value of the 'PSTD_FLG' field.
   */
  public java.nio.ByteBuffer getPSTDFLG() {
    return PSTD_FLG;
  }

  /**
   * Sets the value of the 'PSTD_FLG' field.
   * @param value the value to set.
   */
  public void setPSTDFLG(java.nio.ByteBuffer value) {
    this.PSTD_FLG = value;
  }

  /**
   * Gets the value of the 'PRNT_ADVC_IND' field.
   * @return The value of the 'PRNT_ADVC_IND' field.
   */
  public java.nio.ByteBuffer getPRNTADVCIND() {
    return PRNT_ADVC_IND;
  }

  /**
   * Sets the value of the 'PRNT_ADVC_IND' field.
   * @param value the value to set.
   */
  public void setPRNTADVCIND(java.nio.ByteBuffer value) {
    this.PRNT_ADVC_IND = value;
  }

  /**
   * Gets the value of the 'AMT_RESERVATION_IND' field.
   * @return The value of the 'AMT_RESERVATION_IND' field.
   */
  public java.nio.ByteBuffer getAMTRESERVATIONIND() {
    return AMT_RESERVATION_IND;
  }

  /**
   * Sets the value of the 'AMT_RESERVATION_IND' field.
   * @param value the value to set.
   */
  public void setAMTRESERVATIONIND(java.nio.ByteBuffer value) {
    this.AMT_RESERVATION_IND = value;
  }

  /**
   * Gets the value of the 'RESERVATION_AMT' field.
   * @return The value of the 'RESERVATION_AMT' field.
   */
  public java.lang.Double getRESERVATIONAMT() {
    return RESERVATION_AMT;
  }

  /**
   * Sets the value of the 'RESERVATION_AMT' field.
   * @param value the value to set.
   */
  public void setRESERVATIONAMT(java.lang.Double value) {
    this.RESERVATION_AMT = value;
  }

  /**
   * Gets the value of the 'RESTRICT_MODIFY_IND' field.
   * @return The value of the 'RESTRICT_MODIFY_IND' field.
   */
  public java.nio.ByteBuffer getRESTRICTMODIFYIND() {
    return RESTRICT_MODIFY_IND;
  }

  /**
   * Sets the value of the 'RESTRICT_MODIFY_IND' field.
   * @param value the value to set.
   */
  public void setRESTRICTMODIFYIND(java.nio.ByteBuffer value) {
    this.RESTRICT_MODIFY_IND = value;
  }

  /**
   * Gets the value of the 'LCHG_USER_ID' field.
   * @return The value of the 'LCHG_USER_ID' field.
   */
  public java.nio.ByteBuffer getLCHGUSERID() {
    return LCHG_USER_ID;
  }

  /**
   * Sets the value of the 'LCHG_USER_ID' field.
   * @param value the value to set.
   */
  public void setLCHGUSERID(java.nio.ByteBuffer value) {
    this.LCHG_USER_ID = value;
  }

  /**
   * Gets the value of the 'LCHG_TIME' field.
   * @return The value of the 'LCHG_TIME' field.
   */
  public java.lang.CharSequence getLCHGTIME() {
    return LCHG_TIME;
  }

  /**
   * Sets the value of the 'LCHG_TIME' field.
   * @param value the value to set.
   */
  public void setLCHGTIME(java.lang.CharSequence value) {
    this.LCHG_TIME = value;
  }

  /**
   * Gets the value of the 'RCRE_USER_ID' field.
   * @return The value of the 'RCRE_USER_ID' field.
   */
  public java.nio.ByteBuffer getRCREUSERID() {
    return RCRE_USER_ID;
  }

  /**
   * Sets the value of the 'RCRE_USER_ID' field.
   * @param value the value to set.
   */
  public void setRCREUSERID(java.nio.ByteBuffer value) {
    this.RCRE_USER_ID = value;
  }

  /**
   * Gets the value of the 'RCRE_TIME' field.
   * @return The value of the 'RCRE_TIME' field.
   */
  public java.lang.CharSequence getRCRETIME() {
    return RCRE_TIME;
  }

  /**
   * Sets the value of the 'RCRE_TIME' field.
   * @param value the value to set.
   */
  public void setRCRETIME(java.lang.CharSequence value) {
    this.RCRE_TIME = value;
  }

  /**
   * Gets the value of the 'CUST_ID' field.
   * @return The value of the 'CUST_ID' field.
   */
  public java.nio.ByteBuffer getCUSTID() {
    return CUST_ID;
  }

  /**
   * Sets the value of the 'CUST_ID' field.
   * @param value the value to set.
   */
  public void setCUSTID(java.nio.ByteBuffer value) {
    this.CUST_ID = value;
  }

  /**
   * Gets the value of the 'VOUCHER_PRINT_FLG' field.
   * @return The value of the 'VOUCHER_PRINT_FLG' field.
   */
  public java.nio.ByteBuffer getVOUCHERPRINTFLG() {
    return VOUCHER_PRINT_FLG;
  }

  /**
   * Sets the value of the 'VOUCHER_PRINT_FLG' field.
   * @param value the value to set.
   */
  public void setVOUCHERPRINTFLG(java.nio.ByteBuffer value) {
    this.VOUCHER_PRINT_FLG = value;
  }

  /**
   * Gets the value of the 'MODULE_ID' field.
   * @return The value of the 'MODULE_ID' field.
   */
  public java.nio.ByteBuffer getMODULEID() {
    return MODULE_ID;
  }

  /**
   * Sets the value of the 'MODULE_ID' field.
   * @param value the value to set.
   */
  public void setMODULEID(java.nio.ByteBuffer value) {
    this.MODULE_ID = value;
  }

  /**
   * Gets the value of the 'BR_CODE' field.
   * @return The value of the 'BR_CODE' field.
   */
  public java.nio.ByteBuffer getBRCODE() {
    return BR_CODE;
  }

  /**
   * Sets the value of the 'BR_CODE' field.
   * @param value the value to set.
   */
  public void setBRCODE(java.nio.ByteBuffer value) {
    this.BR_CODE = value;
  }

  /**
   * Gets the value of the 'FX_TRAN_AMT' field.
   * @return The value of the 'FX_TRAN_AMT' field.
   */
  public java.lang.Double getFXTRANAMT() {
    return FX_TRAN_AMT;
  }

  /**
   * Sets the value of the 'FX_TRAN_AMT' field.
   * @param value the value to set.
   */
  public void setFXTRANAMT(java.lang.Double value) {
    this.FX_TRAN_AMT = value;
  }

  /**
   * Gets the value of the 'RATE_CODE' field.
   * @return The value of the 'RATE_CODE' field.
   */
  public java.nio.ByteBuffer getRATECODE() {
    return RATE_CODE;
  }

  /**
   * Sets the value of the 'RATE_CODE' field.
   * @param value the value to set.
   */
  public void setRATECODE(java.nio.ByteBuffer value) {
    this.RATE_CODE = value;
  }

  /**
   * Gets the value of the 'RATE' field.
   * @return The value of the 'RATE' field.
   */
  public java.lang.Double getRATE() {
    return RATE;
  }

  /**
   * Sets the value of the 'RATE' field.
   * @param value the value to set.
   */
  public void setRATE(java.lang.Double value) {
    this.RATE = value;
  }

  /**
   * Gets the value of the 'CRNCY_CODE' field.
   * @return The value of the 'CRNCY_CODE' field.
   */
  public java.nio.ByteBuffer getCRNCYCODE() {
    return CRNCY_CODE;
  }

  /**
   * Sets the value of the 'CRNCY_CODE' field.
   * @param value the value to set.
   */
  public void setCRNCYCODE(java.nio.ByteBuffer value) {
    this.CRNCY_CODE = value;
  }

  /**
   * Gets the value of the 'NAVIGATION_FLG' field.
   * @return The value of the 'NAVIGATION_FLG' field.
   */
  public java.nio.ByteBuffer getNAVIGATIONFLG() {
    return NAVIGATION_FLG;
  }

  /**
   * Sets the value of the 'NAVIGATION_FLG' field.
   * @param value the value to set.
   */
  public void setNAVIGATIONFLG(java.nio.ByteBuffer value) {
    this.NAVIGATION_FLG = value;
  }

  /**
   * Gets the value of the 'TRAN_CRNCY_CODE' field.
   * @return The value of the 'TRAN_CRNCY_CODE' field.
   */
  public java.nio.ByteBuffer getTRANCRNCYCODE() {
    return TRAN_CRNCY_CODE;
  }

  /**
   * Sets the value of the 'TRAN_CRNCY_CODE' field.
   * @param value the value to set.
   */
  public void setTRANCRNCYCODE(java.nio.ByteBuffer value) {
    this.TRAN_CRNCY_CODE = value;
  }

  /**
   * Gets the value of the 'REF_CRNCY_CODE' field.
   * @return The value of the 'REF_CRNCY_CODE' field.
   */
  public java.nio.ByteBuffer getREFCRNCYCODE() {
    return REF_CRNCY_CODE;
  }

  /**
   * Sets the value of the 'REF_CRNCY_CODE' field.
   * @param value the value to set.
   */
  public void setREFCRNCYCODE(java.nio.ByteBuffer value) {
    this.REF_CRNCY_CODE = value;
  }

  /**
   * Gets the value of the 'REF_AMT' field.
   * @return The value of the 'REF_AMT' field.
   */
  public java.lang.Double getREFAMT() {
    return REF_AMT;
  }

  /**
   * Sets the value of the 'REF_AMT' field.
   * @param value the value to set.
   */
  public void setREFAMT(java.lang.Double value) {
    this.REF_AMT = value;
  }

  /**
   * Gets the value of the 'SOL_ID' field.
   * @return The value of the 'SOL_ID' field.
   */
  public java.nio.ByteBuffer getSOLID() {
    return SOL_ID;
  }

  /**
   * Sets the value of the 'SOL_ID' field.
   * @param value the value to set.
   */
  public void setSOLID(java.nio.ByteBuffer value) {
    this.SOL_ID = value;
  }

  /**
   * Gets the value of the 'BANK_CODE' field.
   * @return The value of the 'BANK_CODE' field.
   */
  public java.nio.ByteBuffer getBANKCODE() {
    return BANK_CODE;
  }

  /**
   * Sets the value of the 'BANK_CODE' field.
   * @param value the value to set.
   */
  public void setBANKCODE(java.nio.ByteBuffer value) {
    this.BANK_CODE = value;
  }

  /**
   * Gets the value of the 'TREA_REF_NUM' field.
   * @return The value of the 'TREA_REF_NUM' field.
   */
  public java.nio.ByteBuffer getTREAREFNUM() {
    return TREA_REF_NUM;
  }

  /**
   * Sets the value of the 'TREA_REF_NUM' field.
   * @param value the value to set.
   */
  public void setTREAREFNUM(java.nio.ByteBuffer value) {
    this.TREA_REF_NUM = value;
  }

  /**
   * Gets the value of the 'TREA_RATE' field.
   * @return The value of the 'TREA_RATE' field.
   */
  public java.lang.Double getTREARATE() {
    return TREA_RATE;
  }

  /**
   * Sets the value of the 'TREA_RATE' field.
   * @param value the value to set.
   */
  public void setTREARATE(java.lang.Double value) {
    this.TREA_RATE = value;
  }

  /**
   * Gets the value of the 'TS_CNT' field.
   * @return The value of the 'TS_CNT' field.
   */
  public java.lang.Long getTSCNT() {
    return TS_CNT;
  }

  /**
   * Sets the value of the 'TS_CNT' field.
   * @param value the value to set.
   */
  public void setTSCNT(java.lang.Long value) {
    this.TS_CNT = value;
  }

  /**
   * Gets the value of the 'GST_UPD_FLG' field.
   * @return The value of the 'GST_UPD_FLG' field.
   */
  public java.nio.ByteBuffer getGSTUPDFLG() {
    return GST_UPD_FLG;
  }

  /**
   * Sets the value of the 'GST_UPD_FLG' field.
   * @param value the value to set.
   */
  public void setGSTUPDFLG(java.nio.ByteBuffer value) {
    this.GST_UPD_FLG = value;
  }

  /**
   * Gets the value of the 'ISO_FLG' field.
   * @return The value of the 'ISO_FLG' field.
   */
  public java.nio.ByteBuffer getISOFLG() {
    return ISO_FLG;
  }

  /**
   * Sets the value of the 'ISO_FLG' field.
   * @param value the value to set.
   */
  public void setISOFLG(java.nio.ByteBuffer value) {
    this.ISO_FLG = value;
  }

  /**
   * Gets the value of the 'EABFAB_UPD_FLG' field.
   * @return The value of the 'EABFAB_UPD_FLG' field.
   */
  public java.nio.ByteBuffer getEABFABUPDFLG() {
    return EABFAB_UPD_FLG;
  }

  /**
   * Sets the value of the 'EABFAB_UPD_FLG' field.
   * @param value the value to set.
   */
  public void setEABFABUPDFLG(java.nio.ByteBuffer value) {
    this.EABFAB_UPD_FLG = value;
  }

  /**
   * Gets the value of the 'LIFT_LIEN_FLG' field.
   * @return The value of the 'LIFT_LIEN_FLG' field.
   */
  public java.nio.ByteBuffer getLIFTLIENFLG() {
    return LIFT_LIEN_FLG;
  }

  /**
   * Sets the value of the 'LIFT_LIEN_FLG' field.
   * @param value the value to set.
   */
  public void setLIFTLIENFLG(java.nio.ByteBuffer value) {
    this.LIFT_LIEN_FLG = value;
  }

  /**
   * Gets the value of the 'PROXY_POST_IND' field.
   * @return The value of the 'PROXY_POST_IND' field.
   */
  public java.nio.ByteBuffer getPROXYPOSTIND() {
    return PROXY_POST_IND;
  }

  /**
   * Sets the value of the 'PROXY_POST_IND' field.
   * @param value the value to set.
   */
  public void setPROXYPOSTIND(java.nio.ByteBuffer value) {
    this.PROXY_POST_IND = value;
  }

  /**
   * Gets the value of the 'SI_SRL_NUM' field.
   * @return The value of the 'SI_SRL_NUM' field.
   */
  public java.nio.ByteBuffer getSISRLNUM() {
    return SI_SRL_NUM;
  }

  /**
   * Sets the value of the 'SI_SRL_NUM' field.
   * @param value the value to set.
   */
  public void setSISRLNUM(java.nio.ByteBuffer value) {
    this.SI_SRL_NUM = value;
  }

  /**
   * Gets the value of the 'SI_ORG_EXEC_DATE' field.
   * @return The value of the 'SI_ORG_EXEC_DATE' field.
   */
  public java.lang.CharSequence getSIORGEXECDATE() {
    return SI_ORG_EXEC_DATE;
  }

  /**
   * Sets the value of the 'SI_ORG_EXEC_DATE' field.
   * @param value the value to set.
   */
  public void setSIORGEXECDATE(java.lang.CharSequence value) {
    this.SI_ORG_EXEC_DATE = value;
  }

  /**
   * Gets the value of the 'PR_SRL_NUM' field.
   * @return The value of the 'PR_SRL_NUM' field.
   */
  public java.nio.ByteBuffer getPRSRLNUM() {
    return PR_SRL_NUM;
  }

  /**
   * Sets the value of the 'PR_SRL_NUM' field.
   * @param value the value to set.
   */
  public void setPRSRLNUM(java.nio.ByteBuffer value) {
    this.PR_SRL_NUM = value;
  }

  /**
   * Gets the value of the 'SERIAL_NUM' field.
   * @return The value of the 'SERIAL_NUM' field.
   */
  public java.nio.ByteBuffer getSERIALNUM() {
    return SERIAL_NUM;
  }

  /**
   * Sets the value of the 'SERIAL_NUM' field.
   * @param value the value to set.
   */
  public void setSERIALNUM(java.nio.ByteBuffer value) {
    this.SERIAL_NUM = value;
  }

  /**
   * Gets the value of the 'DEL_MEMO_PAD' field.
   * @return The value of the 'DEL_MEMO_PAD' field.
   */
  public java.nio.ByteBuffer getDELMEMOPAD() {
    return DEL_MEMO_PAD;
  }

  /**
   * Sets the value of the 'DEL_MEMO_PAD' field.
   * @param value the value to set.
   */
  public void setDELMEMOPAD(java.nio.ByteBuffer value) {
    this.DEL_MEMO_PAD = value;
  }

  /**
   * Gets the value of the 'UAD_MODULE_ID' field.
   * @return The value of the 'UAD_MODULE_ID' field.
   */
  public java.nio.ByteBuffer getUADMODULEID() {
    return UAD_MODULE_ID;
  }

  /**
   * Sets the value of the 'UAD_MODULE_ID' field.
   * @param value the value to set.
   */
  public void setUADMODULEID(java.nio.ByteBuffer value) {
    this.UAD_MODULE_ID = value;
  }

  /**
   * Gets the value of the 'UAD_MODULE_KEY' field.
   * @return The value of the 'UAD_MODULE_KEY' field.
   */
  public java.nio.ByteBuffer getUADMODULEKEY() {
    return UAD_MODULE_KEY;
  }

  /**
   * Sets the value of the 'UAD_MODULE_KEY' field.
   * @param value the value to set.
   */
  public void setUADMODULEKEY(java.nio.ByteBuffer value) {
    this.UAD_MODULE_KEY = value;
  }

  /**
   * Gets the value of the 'REVERSAL_DATE' field.
   * @return The value of the 'REVERSAL_DATE' field.
   */
  public java.lang.CharSequence getREVERSALDATE() {
    return REVERSAL_DATE;
  }

  /**
   * Sets the value of the 'REVERSAL_DATE' field.
   * @param value the value to set.
   */
  public void setREVERSALDATE(java.lang.CharSequence value) {
    this.REVERSAL_DATE = value;
  }

  /**
   * Gets the value of the 'REVERSAL_VALUE_DATE' field.
   * @return The value of the 'REVERSAL_VALUE_DATE' field.
   */
  public java.lang.CharSequence getREVERSALVALUEDATE() {
    return REVERSAL_VALUE_DATE;
  }

  /**
   * Sets the value of the 'REVERSAL_VALUE_DATE' field.
   * @param value the value to set.
   */
  public void setREVERSALVALUEDATE(java.lang.CharSequence value) {
    this.REVERSAL_VALUE_DATE = value;
  }

  /**
   * Gets the value of the 'PTTM_EVENT_TYPE' field.
   * @return The value of the 'PTTM_EVENT_TYPE' field.
   */
  public java.nio.ByteBuffer getPTTMEVENTTYPE() {
    return PTTM_EVENT_TYPE;
  }

  /**
   * Sets the value of the 'PTTM_EVENT_TYPE' field.
   * @param value the value to set.
   */
  public void setPTTMEVENTTYPE(java.nio.ByteBuffer value) {
    this.PTTM_EVENT_TYPE = value;
  }

  /**
   * Gets the value of the 'PROXY_ACID' field.
   * @return The value of the 'PROXY_ACID' field.
   */
  public java.nio.ByteBuffer getPROXYACID() {
    return PROXY_ACID;
  }

  /**
   * Sets the value of the 'PROXY_ACID' field.
   * @param value the value to set.
   */
  public void setPROXYACID(java.nio.ByteBuffer value) {
    this.PROXY_ACID = value;
  }

  /**
   * Gets the value of the 'TOD_ENTITY_TYPE' field.
   * @return The value of the 'TOD_ENTITY_TYPE' field.
   */
  public java.nio.ByteBuffer getTODENTITYTYPE() {
    return TOD_ENTITY_TYPE;
  }

  /**
   * Sets the value of the 'TOD_ENTITY_TYPE' field.
   * @param value the value to set.
   */
  public void setTODENTITYTYPE(java.nio.ByteBuffer value) {
    this.TOD_ENTITY_TYPE = value;
  }

  /**
   * Gets the value of the 'TOD_ENTITY_ID' field.
   * @return The value of the 'TOD_ENTITY_ID' field.
   */
  public java.nio.ByteBuffer getTODENTITYID() {
    return TOD_ENTITY_ID;
  }

  /**
   * Sets the value of the 'TOD_ENTITY_ID' field.
   * @param value the value to set.
   */
  public void setTODENTITYID(java.nio.ByteBuffer value) {
    this.TOD_ENTITY_ID = value;
  }

  /**
   * Gets the value of the 'DTH_INIT_SOL_ID' field.
   * @return The value of the 'DTH_INIT_SOL_ID' field.
   */
  public java.nio.ByteBuffer getDTHINITSOLID() {
    return DTH_INIT_SOL_ID;
  }

  /**
   * Sets the value of the 'DTH_INIT_SOL_ID' field.
   * @param value the value to set.
   */
  public void setDTHINITSOLID(java.nio.ByteBuffer value) {
    this.DTH_INIT_SOL_ID = value;
  }

  /**
   * Gets the value of the 'REGULARIZATION_AMT' field.
   * @return The value of the 'REGULARIZATION_AMT' field.
   */
  public java.lang.Double getREGULARIZATIONAMT() {
    return REGULARIZATION_AMT;
  }

  /**
   * Sets the value of the 'REGULARIZATION_AMT' field.
   * @param value the value to set.
   */
  public void setREGULARIZATIONAMT(java.lang.Double value) {
    this.REGULARIZATION_AMT = value;
  }

  /**
   * Gets the value of the 'PRINCIPAL_PORTION_AMT' field.
   * @return The value of the 'PRINCIPAL_PORTION_AMT' field.
   */
  public java.lang.Double getPRINCIPALPORTIONAMT() {
    return PRINCIPAL_PORTION_AMT;
  }

  /**
   * Sets the value of the 'PRINCIPAL_PORTION_AMT' field.
   * @param value the value to set.
   */
  public void setPRINCIPALPORTIONAMT(java.lang.Double value) {
    this.PRINCIPAL_PORTION_AMT = value;
  }

  /**
   * Gets the value of the 'TF_ENTITY_SOL_ID' field.
   * @return The value of the 'TF_ENTITY_SOL_ID' field.
   */
  public java.nio.ByteBuffer getTFENTITYSOLID() {
    return TF_ENTITY_SOL_ID;
  }

  /**
   * Sets the value of the 'TF_ENTITY_SOL_ID' field.
   * @param value the value to set.
   */
  public void setTFENTITYSOLID(java.nio.ByteBuffer value) {
    this.TF_ENTITY_SOL_ID = value;
  }

  /**
   * Gets the value of the 'TRAN_PARTICULAR_2' field.
   * @return The value of the 'TRAN_PARTICULAR_2' field.
   */
  public java.nio.ByteBuffer getTRANPARTICULAR2() {
    return TRAN_PARTICULAR_2;
  }

  /**
   * Sets the value of the 'TRAN_PARTICULAR_2' field.
   * @param value the value to set.
   */
  public void setTRANPARTICULAR2(java.nio.ByteBuffer value) {
    this.TRAN_PARTICULAR_2 = value;
  }

  /**
   * Gets the value of the 'TRAN_PARTICULAR_CODE' field.
   * @return The value of the 'TRAN_PARTICULAR_CODE' field.
   */
  public java.nio.ByteBuffer getTRANPARTICULARCODE() {
    return TRAN_PARTICULAR_CODE;
  }

  /**
   * Sets the value of the 'TRAN_PARTICULAR_CODE' field.
   * @param value the value to set.
   */
  public void setTRANPARTICULARCODE(java.nio.ByteBuffer value) {
    this.TRAN_PARTICULAR_CODE = value;
  }

  /**
   * Gets the value of the 'TR_STATUS' field.
   * @return The value of the 'TR_STATUS' field.
   */
  public java.nio.ByteBuffer getTRSTATUS() {
    return TR_STATUS;
  }

  /**
   * Sets the value of the 'TR_STATUS' field.
   * @param value the value to set.
   */
  public void setTRSTATUS(java.nio.ByteBuffer value) {
    this.TR_STATUS = value;
  }

  /**
   * Gets the value of the 'SVS_TRAN_ID' field.
   * @return The value of the 'SVS_TRAN_ID' field.
   */
  public java.nio.ByteBuffer getSVSTRANID() {
    return SVS_TRAN_ID;
  }

  /**
   * Sets the value of the 'SVS_TRAN_ID' field.
   * @param value the value to set.
   */
  public void setSVSTRANID(java.nio.ByteBuffer value) {
    this.SVS_TRAN_ID = value;
  }

  /**
   * Gets the value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
   * @return The value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
   */
  public java.nio.ByteBuffer getCRNCYHOLCHKDONEFLG() {
    return CRNCY_HOL_CHK_DONE_FLG;
  }

  /**
   * Sets the value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
   * @param value the value to set.
   */
  public void setCRNCYHOLCHKDONEFLG(java.nio.ByteBuffer value) {
    this.CRNCY_HOL_CHK_DONE_FLG = value;
  }

  /**
   * Gets the value of the 'REFERRAL_ID' field.
   * @return The value of the 'REFERRAL_ID' field.
   */
  public java.nio.ByteBuffer getREFERRALID() {
    return REFERRAL_ID;
  }

  /**
   * Sets the value of the 'REFERRAL_ID' field.
   * @param value the value to set.
   */
  public void setREFERRALID(java.nio.ByteBuffer value) {
    this.REFERRAL_ID = value;
  }

  /**
   * Gets the value of the 'PARTY_CODE' field.
   * @return The value of the 'PARTY_CODE' field.
   */
  public java.nio.ByteBuffer getPARTYCODE() {
    return PARTY_CODE;
  }

  /**
   * Sets the value of the 'PARTY_CODE' field.
   * @param value the value to set.
   */
  public void setPARTYCODE(java.nio.ByteBuffer value) {
    this.PARTY_CODE = value;
  }

  /**
   * Gets the value of the 'GL_DATE' field.
   * @return The value of the 'GL_DATE' field.
   */
  public java.lang.CharSequence getGLDATE() {
    return GL_DATE;
  }

  /**
   * Sets the value of the 'GL_DATE' field.
   * @param value the value to set.
   */
  public void setGLDATE(java.lang.CharSequence value) {
    this.GL_DATE = value;
  }

  /**
   * Gets the value of the 'BKDT_TRAN_FLG' field.
   * @return The value of the 'BKDT_TRAN_FLG' field.
   */
  public java.nio.ByteBuffer getBKDTTRANFLG() {
    return BKDT_TRAN_FLG;
  }

  /**
   * Sets the value of the 'BKDT_TRAN_FLG' field.
   * @param value the value to set.
   */
  public void setBKDTTRANFLG(java.nio.ByteBuffer value) {
    this.BKDT_TRAN_FLG = value;
  }

  /**
   * Gets the value of the 'BANK_ID' field.
   * @return The value of the 'BANK_ID' field.
   */
  public java.nio.ByteBuffer getBANKID() {
    return BANK_ID;
  }

  /**
   * Sets the value of the 'BANK_ID' field.
   * @param value the value to set.
   */
  public void setBANKID(java.nio.ByteBuffer value) {
    this.BANK_ID = value;
  }

  /**
   * Gets the value of the 'IMPL_CASH_PART_TRAN_FLG' field.
   * @return The value of the 'IMPL_CASH_PART_TRAN_FLG' field.
   */
  public java.nio.ByteBuffer getIMPLCASHPARTTRANFLG() {
    return IMPL_CASH_PART_TRAN_FLG;
  }

  /**
   * Sets the value of the 'IMPL_CASH_PART_TRAN_FLG' field.
   * @param value the value to set.
   */
  public void setIMPLCASHPARTTRANFLG(java.nio.ByteBuffer value) {
    this.IMPL_CASH_PART_TRAN_FLG = value;
  }

  /**
   * Gets the value of the 'PTRAN_CHRG_EXISTS_FLG' field.
   * @return The value of the 'PTRAN_CHRG_EXISTS_FLG' field.
   */
  public java.nio.ByteBuffer getPTRANCHRGEXISTSFLG() {
    return PTRAN_CHRG_EXISTS_FLG;
  }

  /**
   * Sets the value of the 'PTRAN_CHRG_EXISTS_FLG' field.
   * @param value the value to set.
   */
  public void setPTRANCHRGEXISTSFLG(java.nio.ByteBuffer value) {
    this.PTRAN_CHRG_EXISTS_FLG = value;
  }

  /**
   * Gets the value of the 'MUD_POOL_BAL_BUILD_FLG' field.
   * @return The value of the 'MUD_POOL_BAL_BUILD_FLG' field.
   */
  public java.nio.ByteBuffer getMUDPOOLBALBUILDFLG() {
    return MUD_POOL_BAL_BUILD_FLG;
  }

  /**
   * Sets the value of the 'MUD_POOL_BAL_BUILD_FLG' field.
   * @param value the value to set.
   */
  public void setMUDPOOLBALBUILDFLG(java.nio.ByteBuffer value) {
    this.MUD_POOL_BAL_BUILD_FLG = value;
  }

  /**
   * Gets the value of the 'GL_SEGMENT_STRING' field.
   * @return The value of the 'GL_SEGMENT_STRING' field.
   */
  public java.nio.ByteBuffer getGLSEGMENTSTRING() {
    return GL_SEGMENT_STRING;
  }

  /**
   * Sets the value of the 'GL_SEGMENT_STRING' field.
   * @param value the value to set.
   */
  public void setGLSEGMENTSTRING(java.nio.ByteBuffer value) {
    this.GL_SEGMENT_STRING = value;
  }

  /**
   * Gets the value of the 'SYS_PART_TRAN_CODE' field.
   * @return The value of the 'SYS_PART_TRAN_CODE' field.
   */
  public java.nio.ByteBuffer getSYSPARTTRANCODE() {
    return SYS_PART_TRAN_CODE;
  }

  /**
   * Sets the value of the 'SYS_PART_TRAN_CODE' field.
   * @param value the value to set.
   */
  public void setSYSPARTTRANCODE(java.nio.ByteBuffer value) {
    this.SYS_PART_TRAN_CODE = value;
  }

  /**
   * Gets the value of the 'USER_PART_TRAN_CODE' field.
   * @return The value of the 'USER_PART_TRAN_CODE' field.
   */
  public java.nio.ByteBuffer getUSERPARTTRANCODE() {
    return USER_PART_TRAN_CODE;
  }

  /**
   * Sets the value of the 'USER_PART_TRAN_CODE' field.
   * @param value the value to set.
   */
  public void setUSERPARTTRANCODE(java.nio.ByteBuffer value) {
    this.USER_PART_TRAN_CODE = value;
  }

  /**
   * Gets the value of the 'TRAN_FREE_CODE1' field.
   * @return The value of the 'TRAN_FREE_CODE1' field.
   */
  public java.nio.ByteBuffer getTRANFREECODE1() {
    return TRAN_FREE_CODE1;
  }

  /**
   * Sets the value of the 'TRAN_FREE_CODE1' field.
   * @param value the value to set.
   */
  public void setTRANFREECODE1(java.nio.ByteBuffer value) {
    this.TRAN_FREE_CODE1 = value;
  }

  /**
   * Gets the value of the 'TRAN_FREE_CODE2' field.
   * @return The value of the 'TRAN_FREE_CODE2' field.
   */
  public java.nio.ByteBuffer getTRANFREECODE2() {
    return TRAN_FREE_CODE2;
  }

  /**
   * Sets the value of the 'TRAN_FREE_CODE2' field.
   * @param value the value to set.
   */
  public void setTRANFREECODE2(java.nio.ByteBuffer value) {
    this.TRAN_FREE_CODE2 = value;
  }

  /**
   * Gets the value of the 'PSTD_SRL_NUM' field.
   * @return The value of the 'PSTD_SRL_NUM' field.
   */
  public java.lang.Long getPSTDSRLNUM() {
    return PSTD_SRL_NUM;
  }

  /**
   * Sets the value of the 'PSTD_SRL_NUM' field.
   * @param value the value to set.
   */
  public void setPSTDSRLNUM(java.lang.Long value) {
    this.PSTD_SRL_NUM = value;
  }

  /**
   * Gets the value of the 'REVERSAL_STATUS' field.
   * @return The value of the 'REVERSAL_STATUS' field.
   */
  public java.nio.ByteBuffer getREVERSALSTATUS() {
    return REVERSAL_STATUS;
  }

  /**
   * Sets the value of the 'REVERSAL_STATUS' field.
   * @param value the value to set.
   */
  public void setREVERSALSTATUS(java.nio.ByteBuffer value) {
    this.REVERSAL_STATUS = value;
  }

  /**
   * Gets the value of the 'AVAILABLE_AMT' field.
   * @return The value of the 'AVAILABLE_AMT' field.
   */
  public java.lang.Double getAVAILABLEAMT() {
    return AVAILABLE_AMT;
  }

  /**
   * Sets the value of the 'AVAILABLE_AMT' field.
   * @param value the value to set.
   */
  public void setAVAILABLEAMT(java.lang.Double value) {
    this.AVAILABLE_AMT = value;
  }

  /**
   * Gets the value of the 'ACCT_BALANCE' field.
   * @return The value of the 'ACCT_BALANCE' field.
   */
  public java.lang.Double getACCTBALANCE() {
    return ACCT_BALANCE;
  }

  /**
   * Sets the value of the 'ACCT_BALANCE' field.
   * @param value the value to set.
   */
  public void setACCTBALANCE(java.lang.Double value) {
    this.ACCT_BALANCE = value;
  }

  /**
   * Creates a new BusinessEvent RecordBuilder.
   * @return A new BusinessEvent RecordBuilder
   */
  public static com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder newBuilder() {
    return new com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder();
  }

  /**
   * Creates a new BusinessEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BusinessEvent RecordBuilder
   */
  public static com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder newBuilder(com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder other) {
    return new com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder(other);
  }

  /**
   * Creates a new BusinessEvent RecordBuilder by copying an existing BusinessEvent instance.
   * @param other The existing instance to copy.
   * @return A new BusinessEvent RecordBuilder
   */
  public static com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder newBuilder(com.kotak.orchestrator.orchestrator.schema.BusinessEvent other) {
    return new com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder(other);
  }

  /**
   * RecordBuilder for BusinessEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BusinessEvent>
    implements org.apache.avro.data.RecordBuilder<BusinessEvent> {

    private java.lang.Double EFFECTIVE_BAL;
    private java.lang.Double CLR_BAL;
    private java.nio.ByteBuffer FORACID;
    private java.lang.Long LAST_BAL_UPDATED_DATE;
    private java.nio.ByteBuffer SCHM_CODE;
    private java.nio.ByteBuffer CIF_ID;
    private java.nio.ByteBuffer ACCT_NAME;
    private java.nio.ByteBuffer ACCT_SHORT_NAME;
    private java.nio.ByteBuffer SCHM_SUB_TYPE;
    private java.nio.ByteBuffer SCHM_TYPE;
    private java.lang.CharSequence TRAN_DATE;
    private java.nio.ByteBuffer TRAN_ID;
    private java.nio.ByteBuffer PART_TRAN_SRL_NUM;
    private java.nio.ByteBuffer DEL_FLG;
    private java.nio.ByteBuffer TRAN_TYPE;
    private java.nio.ByteBuffer TRAN_SUB_TYPE;
    private java.nio.ByteBuffer PART_TRAN_TYPE;
    private java.nio.ByteBuffer GL_SUB_HEAD_CODE;
    private java.nio.ByteBuffer ACID;
    private java.lang.CharSequence VALUE_DATE;
    private java.lang.Double TRAN_AMT;
    private java.nio.ByteBuffer TRAN_PARTICULAR;
    private java.nio.ByteBuffer ENTRY_USER_ID;
    private java.nio.ByteBuffer PSTD_USER_ID;
    private java.nio.ByteBuffer VFD_USER_ID;
    private java.lang.CharSequence ENTRY_DATE;
    private java.lang.CharSequence PSTD_DATE;
    private java.lang.CharSequence VFD_DATE;
    private java.nio.ByteBuffer RPT_CODE;
    private java.nio.ByteBuffer REF_NUM;
    private java.nio.ByteBuffer INSTRMNT_TYPE;
    private java.lang.CharSequence INSTRMNT_DATE;
    private java.nio.ByteBuffer INSTRMNT_NUM;
    private java.nio.ByteBuffer INSTRMNT_ALPHA;
    private java.nio.ByteBuffer TRAN_RMKS;
    private java.nio.ByteBuffer PSTD_FLG;
    private java.nio.ByteBuffer PRNT_ADVC_IND;
    private java.nio.ByteBuffer AMT_RESERVATION_IND;
    private java.lang.Double RESERVATION_AMT;
    private java.nio.ByteBuffer RESTRICT_MODIFY_IND;
    private java.nio.ByteBuffer LCHG_USER_ID;
    private java.lang.CharSequence LCHG_TIME;
    private java.nio.ByteBuffer RCRE_USER_ID;
    private java.lang.CharSequence RCRE_TIME;
    private java.nio.ByteBuffer CUST_ID;
    private java.nio.ByteBuffer VOUCHER_PRINT_FLG;
    private java.nio.ByteBuffer MODULE_ID;
    private java.nio.ByteBuffer BR_CODE;
    private java.lang.Double FX_TRAN_AMT;
    private java.nio.ByteBuffer RATE_CODE;
    private java.lang.Double RATE;
    private java.nio.ByteBuffer CRNCY_CODE;
    private java.nio.ByteBuffer NAVIGATION_FLG;
    private java.nio.ByteBuffer TRAN_CRNCY_CODE;
    private java.nio.ByteBuffer REF_CRNCY_CODE;
    private java.lang.Double REF_AMT;
    private java.nio.ByteBuffer SOL_ID;
    private java.nio.ByteBuffer BANK_CODE;
    private java.nio.ByteBuffer TREA_REF_NUM;
    private java.lang.Double TREA_RATE;
    private java.lang.Long TS_CNT;
    private java.nio.ByteBuffer GST_UPD_FLG;
    private java.nio.ByteBuffer ISO_FLG;
    private java.nio.ByteBuffer EABFAB_UPD_FLG;
    private java.nio.ByteBuffer LIFT_LIEN_FLG;
    private java.nio.ByteBuffer PROXY_POST_IND;
    private java.nio.ByteBuffer SI_SRL_NUM;
    private java.lang.CharSequence SI_ORG_EXEC_DATE;
    private java.nio.ByteBuffer PR_SRL_NUM;
    private java.nio.ByteBuffer SERIAL_NUM;
    private java.nio.ByteBuffer DEL_MEMO_PAD;
    private java.nio.ByteBuffer UAD_MODULE_ID;
    private java.nio.ByteBuffer UAD_MODULE_KEY;
    private java.lang.CharSequence REVERSAL_DATE;
    private java.lang.CharSequence REVERSAL_VALUE_DATE;
    private java.nio.ByteBuffer PTTM_EVENT_TYPE;
    private java.nio.ByteBuffer PROXY_ACID;
    private java.nio.ByteBuffer TOD_ENTITY_TYPE;
    private java.nio.ByteBuffer TOD_ENTITY_ID;
    private java.nio.ByteBuffer DTH_INIT_SOL_ID;
    private java.lang.Double REGULARIZATION_AMT;
    private java.lang.Double PRINCIPAL_PORTION_AMT;
    private java.nio.ByteBuffer TF_ENTITY_SOL_ID;
    private java.nio.ByteBuffer TRAN_PARTICULAR_2;
    private java.nio.ByteBuffer TRAN_PARTICULAR_CODE;
    private java.nio.ByteBuffer TR_STATUS;
    private java.nio.ByteBuffer SVS_TRAN_ID;
    private java.nio.ByteBuffer CRNCY_HOL_CHK_DONE_FLG;
    private java.nio.ByteBuffer REFERRAL_ID;
    private java.nio.ByteBuffer PARTY_CODE;
    private java.lang.CharSequence GL_DATE;
    private java.nio.ByteBuffer BKDT_TRAN_FLG;
    private java.nio.ByteBuffer BANK_ID;
    private java.nio.ByteBuffer IMPL_CASH_PART_TRAN_FLG;
    private java.nio.ByteBuffer PTRAN_CHRG_EXISTS_FLG;
    private java.nio.ByteBuffer MUD_POOL_BAL_BUILD_FLG;
    private java.nio.ByteBuffer GL_SEGMENT_STRING;
    private java.nio.ByteBuffer SYS_PART_TRAN_CODE;
    private java.nio.ByteBuffer USER_PART_TRAN_CODE;
    private java.nio.ByteBuffer TRAN_FREE_CODE1;
    private java.nio.ByteBuffer TRAN_FREE_CODE2;
    private java.lang.Long PSTD_SRL_NUM;
    private java.nio.ByteBuffer REVERSAL_STATUS;
    private java.lang.Double AVAILABLE_AMT;
    private java.lang.Double ACCT_BALANCE;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.EFFECTIVE_BAL)) {
        this.EFFECTIVE_BAL = data().deepCopy(fields()[0].schema(), other.EFFECTIVE_BAL);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CLR_BAL)) {
        this.CLR_BAL = data().deepCopy(fields()[1].schema(), other.CLR_BAL);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.FORACID)) {
        this.FORACID = data().deepCopy(fields()[2].schema(), other.FORACID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.LAST_BAL_UPDATED_DATE)) {
        this.LAST_BAL_UPDATED_DATE = data().deepCopy(fields()[3].schema(), other.LAST_BAL_UPDATED_DATE);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.SCHM_CODE)) {
        this.SCHM_CODE = data().deepCopy(fields()[4].schema(), other.SCHM_CODE);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.CIF_ID)) {
        this.CIF_ID = data().deepCopy(fields()[5].schema(), other.CIF_ID);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ACCT_NAME)) {
        this.ACCT_NAME = data().deepCopy(fields()[6].schema(), other.ACCT_NAME);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.ACCT_SHORT_NAME)) {
        this.ACCT_SHORT_NAME = data().deepCopy(fields()[7].schema(), other.ACCT_SHORT_NAME);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.SCHM_SUB_TYPE)) {
        this.SCHM_SUB_TYPE = data().deepCopy(fields()[8].schema(), other.SCHM_SUB_TYPE);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.SCHM_TYPE)) {
        this.SCHM_TYPE = data().deepCopy(fields()[9].schema(), other.SCHM_TYPE);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.TRAN_DATE)) {
        this.TRAN_DATE = data().deepCopy(fields()[10].schema(), other.TRAN_DATE);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.TRAN_ID)) {
        this.TRAN_ID = data().deepCopy(fields()[11].schema(), other.TRAN_ID);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.PART_TRAN_SRL_NUM)) {
        this.PART_TRAN_SRL_NUM = data().deepCopy(fields()[12].schema(), other.PART_TRAN_SRL_NUM);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.DEL_FLG)) {
        this.DEL_FLG = data().deepCopy(fields()[13].schema(), other.DEL_FLG);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.TRAN_TYPE)) {
        this.TRAN_TYPE = data().deepCopy(fields()[14].schema(), other.TRAN_TYPE);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.TRAN_SUB_TYPE)) {
        this.TRAN_SUB_TYPE = data().deepCopy(fields()[15].schema(), other.TRAN_SUB_TYPE);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.PART_TRAN_TYPE)) {
        this.PART_TRAN_TYPE = data().deepCopy(fields()[16].schema(), other.PART_TRAN_TYPE);
        fieldSetFlags()[16] = true;
      }
      if (isValidValue(fields()[17], other.GL_SUB_HEAD_CODE)) {
        this.GL_SUB_HEAD_CODE = data().deepCopy(fields()[17].schema(), other.GL_SUB_HEAD_CODE);
        fieldSetFlags()[17] = true;
      }
      if (isValidValue(fields()[18], other.ACID)) {
        this.ACID = data().deepCopy(fields()[18].schema(), other.ACID);
        fieldSetFlags()[18] = true;
      }
      if (isValidValue(fields()[19], other.VALUE_DATE)) {
        this.VALUE_DATE = data().deepCopy(fields()[19].schema(), other.VALUE_DATE);
        fieldSetFlags()[19] = true;
      }
      if (isValidValue(fields()[20], other.TRAN_AMT)) {
        this.TRAN_AMT = data().deepCopy(fields()[20].schema(), other.TRAN_AMT);
        fieldSetFlags()[20] = true;
      }
      if (isValidValue(fields()[21], other.TRAN_PARTICULAR)) {
        this.TRAN_PARTICULAR = data().deepCopy(fields()[21].schema(), other.TRAN_PARTICULAR);
        fieldSetFlags()[21] = true;
      }
      if (isValidValue(fields()[22], other.ENTRY_USER_ID)) {
        this.ENTRY_USER_ID = data().deepCopy(fields()[22].schema(), other.ENTRY_USER_ID);
        fieldSetFlags()[22] = true;
      }
      if (isValidValue(fields()[23], other.PSTD_USER_ID)) {
        this.PSTD_USER_ID = data().deepCopy(fields()[23].schema(), other.PSTD_USER_ID);
        fieldSetFlags()[23] = true;
      }
      if (isValidValue(fields()[24], other.VFD_USER_ID)) {
        this.VFD_USER_ID = data().deepCopy(fields()[24].schema(), other.VFD_USER_ID);
        fieldSetFlags()[24] = true;
      }
      if (isValidValue(fields()[25], other.ENTRY_DATE)) {
        this.ENTRY_DATE = data().deepCopy(fields()[25].schema(), other.ENTRY_DATE);
        fieldSetFlags()[25] = true;
      }
      if (isValidValue(fields()[26], other.PSTD_DATE)) {
        this.PSTD_DATE = data().deepCopy(fields()[26].schema(), other.PSTD_DATE);
        fieldSetFlags()[26] = true;
      }
      if (isValidValue(fields()[27], other.VFD_DATE)) {
        this.VFD_DATE = data().deepCopy(fields()[27].schema(), other.VFD_DATE);
        fieldSetFlags()[27] = true;
      }
      if (isValidValue(fields()[28], other.RPT_CODE)) {
        this.RPT_CODE = data().deepCopy(fields()[28].schema(), other.RPT_CODE);
        fieldSetFlags()[28] = true;
      }
      if (isValidValue(fields()[29], other.REF_NUM)) {
        this.REF_NUM = data().deepCopy(fields()[29].schema(), other.REF_NUM);
        fieldSetFlags()[29] = true;
      }
      if (isValidValue(fields()[30], other.INSTRMNT_TYPE)) {
        this.INSTRMNT_TYPE = data().deepCopy(fields()[30].schema(), other.INSTRMNT_TYPE);
        fieldSetFlags()[30] = true;
      }
      if (isValidValue(fields()[31], other.INSTRMNT_DATE)) {
        this.INSTRMNT_DATE = data().deepCopy(fields()[31].schema(), other.INSTRMNT_DATE);
        fieldSetFlags()[31] = true;
      }
      if (isValidValue(fields()[32], other.INSTRMNT_NUM)) {
        this.INSTRMNT_NUM = data().deepCopy(fields()[32].schema(), other.INSTRMNT_NUM);
        fieldSetFlags()[32] = true;
      }
      if (isValidValue(fields()[33], other.INSTRMNT_ALPHA)) {
        this.INSTRMNT_ALPHA = data().deepCopy(fields()[33].schema(), other.INSTRMNT_ALPHA);
        fieldSetFlags()[33] = true;
      }
      if (isValidValue(fields()[34], other.TRAN_RMKS)) {
        this.TRAN_RMKS = data().deepCopy(fields()[34].schema(), other.TRAN_RMKS);
        fieldSetFlags()[34] = true;
      }
      if (isValidValue(fields()[35], other.PSTD_FLG)) {
        this.PSTD_FLG = data().deepCopy(fields()[35].schema(), other.PSTD_FLG);
        fieldSetFlags()[35] = true;
      }
      if (isValidValue(fields()[36], other.PRNT_ADVC_IND)) {
        this.PRNT_ADVC_IND = data().deepCopy(fields()[36].schema(), other.PRNT_ADVC_IND);
        fieldSetFlags()[36] = true;
      }
      if (isValidValue(fields()[37], other.AMT_RESERVATION_IND)) {
        this.AMT_RESERVATION_IND = data().deepCopy(fields()[37].schema(), other.AMT_RESERVATION_IND);
        fieldSetFlags()[37] = true;
      }
      if (isValidValue(fields()[38], other.RESERVATION_AMT)) {
        this.RESERVATION_AMT = data().deepCopy(fields()[38].schema(), other.RESERVATION_AMT);
        fieldSetFlags()[38] = true;
      }
      if (isValidValue(fields()[39], other.RESTRICT_MODIFY_IND)) {
        this.RESTRICT_MODIFY_IND = data().deepCopy(fields()[39].schema(), other.RESTRICT_MODIFY_IND);
        fieldSetFlags()[39] = true;
      }
      if (isValidValue(fields()[40], other.LCHG_USER_ID)) {
        this.LCHG_USER_ID = data().deepCopy(fields()[40].schema(), other.LCHG_USER_ID);
        fieldSetFlags()[40] = true;
      }
      if (isValidValue(fields()[41], other.LCHG_TIME)) {
        this.LCHG_TIME = data().deepCopy(fields()[41].schema(), other.LCHG_TIME);
        fieldSetFlags()[41] = true;
      }
      if (isValidValue(fields()[42], other.RCRE_USER_ID)) {
        this.RCRE_USER_ID = data().deepCopy(fields()[42].schema(), other.RCRE_USER_ID);
        fieldSetFlags()[42] = true;
      }
      if (isValidValue(fields()[43], other.RCRE_TIME)) {
        this.RCRE_TIME = data().deepCopy(fields()[43].schema(), other.RCRE_TIME);
        fieldSetFlags()[43] = true;
      }
      if (isValidValue(fields()[44], other.CUST_ID)) {
        this.CUST_ID = data().deepCopy(fields()[44].schema(), other.CUST_ID);
        fieldSetFlags()[44] = true;
      }
      if (isValidValue(fields()[45], other.VOUCHER_PRINT_FLG)) {
        this.VOUCHER_PRINT_FLG = data().deepCopy(fields()[45].schema(), other.VOUCHER_PRINT_FLG);
        fieldSetFlags()[45] = true;
      }
      if (isValidValue(fields()[46], other.MODULE_ID)) {
        this.MODULE_ID = data().deepCopy(fields()[46].schema(), other.MODULE_ID);
        fieldSetFlags()[46] = true;
      }
      if (isValidValue(fields()[47], other.BR_CODE)) {
        this.BR_CODE = data().deepCopy(fields()[47].schema(), other.BR_CODE);
        fieldSetFlags()[47] = true;
      }
      if (isValidValue(fields()[48], other.FX_TRAN_AMT)) {
        this.FX_TRAN_AMT = data().deepCopy(fields()[48].schema(), other.FX_TRAN_AMT);
        fieldSetFlags()[48] = true;
      }
      if (isValidValue(fields()[49], other.RATE_CODE)) {
        this.RATE_CODE = data().deepCopy(fields()[49].schema(), other.RATE_CODE);
        fieldSetFlags()[49] = true;
      }
      if (isValidValue(fields()[50], other.RATE)) {
        this.RATE = data().deepCopy(fields()[50].schema(), other.RATE);
        fieldSetFlags()[50] = true;
      }
      if (isValidValue(fields()[51], other.CRNCY_CODE)) {
        this.CRNCY_CODE = data().deepCopy(fields()[51].schema(), other.CRNCY_CODE);
        fieldSetFlags()[51] = true;
      }
      if (isValidValue(fields()[52], other.NAVIGATION_FLG)) {
        this.NAVIGATION_FLG = data().deepCopy(fields()[52].schema(), other.NAVIGATION_FLG);
        fieldSetFlags()[52] = true;
      }
      if (isValidValue(fields()[53], other.TRAN_CRNCY_CODE)) {
        this.TRAN_CRNCY_CODE = data().deepCopy(fields()[53].schema(), other.TRAN_CRNCY_CODE);
        fieldSetFlags()[53] = true;
      }
      if (isValidValue(fields()[54], other.REF_CRNCY_CODE)) {
        this.REF_CRNCY_CODE = data().deepCopy(fields()[54].schema(), other.REF_CRNCY_CODE);
        fieldSetFlags()[54] = true;
      }
      if (isValidValue(fields()[55], other.REF_AMT)) {
        this.REF_AMT = data().deepCopy(fields()[55].schema(), other.REF_AMT);
        fieldSetFlags()[55] = true;
      }
      if (isValidValue(fields()[56], other.SOL_ID)) {
        this.SOL_ID = data().deepCopy(fields()[56].schema(), other.SOL_ID);
        fieldSetFlags()[56] = true;
      }
      if (isValidValue(fields()[57], other.BANK_CODE)) {
        this.BANK_CODE = data().deepCopy(fields()[57].schema(), other.BANK_CODE);
        fieldSetFlags()[57] = true;
      }
      if (isValidValue(fields()[58], other.TREA_REF_NUM)) {
        this.TREA_REF_NUM = data().deepCopy(fields()[58].schema(), other.TREA_REF_NUM);
        fieldSetFlags()[58] = true;
      }
      if (isValidValue(fields()[59], other.TREA_RATE)) {
        this.TREA_RATE = data().deepCopy(fields()[59].schema(), other.TREA_RATE);
        fieldSetFlags()[59] = true;
      }
      if (isValidValue(fields()[60], other.TS_CNT)) {
        this.TS_CNT = data().deepCopy(fields()[60].schema(), other.TS_CNT);
        fieldSetFlags()[60] = true;
      }
      if (isValidValue(fields()[61], other.GST_UPD_FLG)) {
        this.GST_UPD_FLG = data().deepCopy(fields()[61].schema(), other.GST_UPD_FLG);
        fieldSetFlags()[61] = true;
      }
      if (isValidValue(fields()[62], other.ISO_FLG)) {
        this.ISO_FLG = data().deepCopy(fields()[62].schema(), other.ISO_FLG);
        fieldSetFlags()[62] = true;
      }
      if (isValidValue(fields()[63], other.EABFAB_UPD_FLG)) {
        this.EABFAB_UPD_FLG = data().deepCopy(fields()[63].schema(), other.EABFAB_UPD_FLG);
        fieldSetFlags()[63] = true;
      }
      if (isValidValue(fields()[64], other.LIFT_LIEN_FLG)) {
        this.LIFT_LIEN_FLG = data().deepCopy(fields()[64].schema(), other.LIFT_LIEN_FLG);
        fieldSetFlags()[64] = true;
      }
      if (isValidValue(fields()[65], other.PROXY_POST_IND)) {
        this.PROXY_POST_IND = data().deepCopy(fields()[65].schema(), other.PROXY_POST_IND);
        fieldSetFlags()[65] = true;
      }
      if (isValidValue(fields()[66], other.SI_SRL_NUM)) {
        this.SI_SRL_NUM = data().deepCopy(fields()[66].schema(), other.SI_SRL_NUM);
        fieldSetFlags()[66] = true;
      }
      if (isValidValue(fields()[67], other.SI_ORG_EXEC_DATE)) {
        this.SI_ORG_EXEC_DATE = data().deepCopy(fields()[67].schema(), other.SI_ORG_EXEC_DATE);
        fieldSetFlags()[67] = true;
      }
      if (isValidValue(fields()[68], other.PR_SRL_NUM)) {
        this.PR_SRL_NUM = data().deepCopy(fields()[68].schema(), other.PR_SRL_NUM);
        fieldSetFlags()[68] = true;
      }
      if (isValidValue(fields()[69], other.SERIAL_NUM)) {
        this.SERIAL_NUM = data().deepCopy(fields()[69].schema(), other.SERIAL_NUM);
        fieldSetFlags()[69] = true;
      }
      if (isValidValue(fields()[70], other.DEL_MEMO_PAD)) {
        this.DEL_MEMO_PAD = data().deepCopy(fields()[70].schema(), other.DEL_MEMO_PAD);
        fieldSetFlags()[70] = true;
      }
      if (isValidValue(fields()[71], other.UAD_MODULE_ID)) {
        this.UAD_MODULE_ID = data().deepCopy(fields()[71].schema(), other.UAD_MODULE_ID);
        fieldSetFlags()[71] = true;
      }
      if (isValidValue(fields()[72], other.UAD_MODULE_KEY)) {
        this.UAD_MODULE_KEY = data().deepCopy(fields()[72].schema(), other.UAD_MODULE_KEY);
        fieldSetFlags()[72] = true;
      }
      if (isValidValue(fields()[73], other.REVERSAL_DATE)) {
        this.REVERSAL_DATE = data().deepCopy(fields()[73].schema(), other.REVERSAL_DATE);
        fieldSetFlags()[73] = true;
      }
      if (isValidValue(fields()[74], other.REVERSAL_VALUE_DATE)) {
        this.REVERSAL_VALUE_DATE = data().deepCopy(fields()[74].schema(), other.REVERSAL_VALUE_DATE);
        fieldSetFlags()[74] = true;
      }
      if (isValidValue(fields()[75], other.PTTM_EVENT_TYPE)) {
        this.PTTM_EVENT_TYPE = data().deepCopy(fields()[75].schema(), other.PTTM_EVENT_TYPE);
        fieldSetFlags()[75] = true;
      }
      if (isValidValue(fields()[76], other.PROXY_ACID)) {
        this.PROXY_ACID = data().deepCopy(fields()[76].schema(), other.PROXY_ACID);
        fieldSetFlags()[76] = true;
      }
      if (isValidValue(fields()[77], other.TOD_ENTITY_TYPE)) {
        this.TOD_ENTITY_TYPE = data().deepCopy(fields()[77].schema(), other.TOD_ENTITY_TYPE);
        fieldSetFlags()[77] = true;
      }
      if (isValidValue(fields()[78], other.TOD_ENTITY_ID)) {
        this.TOD_ENTITY_ID = data().deepCopy(fields()[78].schema(), other.TOD_ENTITY_ID);
        fieldSetFlags()[78] = true;
      }
      if (isValidValue(fields()[79], other.DTH_INIT_SOL_ID)) {
        this.DTH_INIT_SOL_ID = data().deepCopy(fields()[79].schema(), other.DTH_INIT_SOL_ID);
        fieldSetFlags()[79] = true;
      }
      if (isValidValue(fields()[80], other.REGULARIZATION_AMT)) {
        this.REGULARIZATION_AMT = data().deepCopy(fields()[80].schema(), other.REGULARIZATION_AMT);
        fieldSetFlags()[80] = true;
      }
      if (isValidValue(fields()[81], other.PRINCIPAL_PORTION_AMT)) {
        this.PRINCIPAL_PORTION_AMT = data().deepCopy(fields()[81].schema(), other.PRINCIPAL_PORTION_AMT);
        fieldSetFlags()[81] = true;
      }
      if (isValidValue(fields()[82], other.TF_ENTITY_SOL_ID)) {
        this.TF_ENTITY_SOL_ID = data().deepCopy(fields()[82].schema(), other.TF_ENTITY_SOL_ID);
        fieldSetFlags()[82] = true;
      }
      if (isValidValue(fields()[83], other.TRAN_PARTICULAR_2)) {
        this.TRAN_PARTICULAR_2 = data().deepCopy(fields()[83].schema(), other.TRAN_PARTICULAR_2);
        fieldSetFlags()[83] = true;
      }
      if (isValidValue(fields()[84], other.TRAN_PARTICULAR_CODE)) {
        this.TRAN_PARTICULAR_CODE = data().deepCopy(fields()[84].schema(), other.TRAN_PARTICULAR_CODE);
        fieldSetFlags()[84] = true;
      }
      if (isValidValue(fields()[85], other.TR_STATUS)) {
        this.TR_STATUS = data().deepCopy(fields()[85].schema(), other.TR_STATUS);
        fieldSetFlags()[85] = true;
      }
      if (isValidValue(fields()[86], other.SVS_TRAN_ID)) {
        this.SVS_TRAN_ID = data().deepCopy(fields()[86].schema(), other.SVS_TRAN_ID);
        fieldSetFlags()[86] = true;
      }
      if (isValidValue(fields()[87], other.CRNCY_HOL_CHK_DONE_FLG)) {
        this.CRNCY_HOL_CHK_DONE_FLG = data().deepCopy(fields()[87].schema(), other.CRNCY_HOL_CHK_DONE_FLG);
        fieldSetFlags()[87] = true;
      }
      if (isValidValue(fields()[88], other.REFERRAL_ID)) {
        this.REFERRAL_ID = data().deepCopy(fields()[88].schema(), other.REFERRAL_ID);
        fieldSetFlags()[88] = true;
      }
      if (isValidValue(fields()[89], other.PARTY_CODE)) {
        this.PARTY_CODE = data().deepCopy(fields()[89].schema(), other.PARTY_CODE);
        fieldSetFlags()[89] = true;
      }
      if (isValidValue(fields()[90], other.GL_DATE)) {
        this.GL_DATE = data().deepCopy(fields()[90].schema(), other.GL_DATE);
        fieldSetFlags()[90] = true;
      }
      if (isValidValue(fields()[91], other.BKDT_TRAN_FLG)) {
        this.BKDT_TRAN_FLG = data().deepCopy(fields()[91].schema(), other.BKDT_TRAN_FLG);
        fieldSetFlags()[91] = true;
      }
      if (isValidValue(fields()[92], other.BANK_ID)) {
        this.BANK_ID = data().deepCopy(fields()[92].schema(), other.BANK_ID);
        fieldSetFlags()[92] = true;
      }
      if (isValidValue(fields()[93], other.IMPL_CASH_PART_TRAN_FLG)) {
        this.IMPL_CASH_PART_TRAN_FLG = data().deepCopy(fields()[93].schema(), other.IMPL_CASH_PART_TRAN_FLG);
        fieldSetFlags()[93] = true;
      }
      if (isValidValue(fields()[94], other.PTRAN_CHRG_EXISTS_FLG)) {
        this.PTRAN_CHRG_EXISTS_FLG = data().deepCopy(fields()[94].schema(), other.PTRAN_CHRG_EXISTS_FLG);
        fieldSetFlags()[94] = true;
      }
      if (isValidValue(fields()[95], other.MUD_POOL_BAL_BUILD_FLG)) {
        this.MUD_POOL_BAL_BUILD_FLG = data().deepCopy(fields()[95].schema(), other.MUD_POOL_BAL_BUILD_FLG);
        fieldSetFlags()[95] = true;
      }
      if (isValidValue(fields()[96], other.GL_SEGMENT_STRING)) {
        this.GL_SEGMENT_STRING = data().deepCopy(fields()[96].schema(), other.GL_SEGMENT_STRING);
        fieldSetFlags()[96] = true;
      }
      if (isValidValue(fields()[97], other.SYS_PART_TRAN_CODE)) {
        this.SYS_PART_TRAN_CODE = data().deepCopy(fields()[97].schema(), other.SYS_PART_TRAN_CODE);
        fieldSetFlags()[97] = true;
      }
      if (isValidValue(fields()[98], other.USER_PART_TRAN_CODE)) {
        this.USER_PART_TRAN_CODE = data().deepCopy(fields()[98].schema(), other.USER_PART_TRAN_CODE);
        fieldSetFlags()[98] = true;
      }
      if (isValidValue(fields()[99], other.TRAN_FREE_CODE1)) {
        this.TRAN_FREE_CODE1 = data().deepCopy(fields()[99].schema(), other.TRAN_FREE_CODE1);
        fieldSetFlags()[99] = true;
      }
      if (isValidValue(fields()[100], other.TRAN_FREE_CODE2)) {
        this.TRAN_FREE_CODE2 = data().deepCopy(fields()[100].schema(), other.TRAN_FREE_CODE2);
        fieldSetFlags()[100] = true;
      }
      if (isValidValue(fields()[101], other.PSTD_SRL_NUM)) {
        this.PSTD_SRL_NUM = data().deepCopy(fields()[101].schema(), other.PSTD_SRL_NUM);
        fieldSetFlags()[101] = true;
      }
      if (isValidValue(fields()[102], other.REVERSAL_STATUS)) {
        this.REVERSAL_STATUS = data().deepCopy(fields()[102].schema(), other.REVERSAL_STATUS);
        fieldSetFlags()[102] = true;
      }
      if (isValidValue(fields()[103], other.AVAILABLE_AMT)) {
        this.AVAILABLE_AMT = data().deepCopy(fields()[103].schema(), other.AVAILABLE_AMT);
        fieldSetFlags()[103] = true;
      }
      if (isValidValue(fields()[104], other.ACCT_BALANCE)) {
        this.ACCT_BALANCE = data().deepCopy(fields()[104].schema(), other.ACCT_BALANCE);
        fieldSetFlags()[104] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing BusinessEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kotak.orchestrator.orchestrator.schema.BusinessEvent other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.EFFECTIVE_BAL)) {
        this.EFFECTIVE_BAL = data().deepCopy(fields()[0].schema(), other.EFFECTIVE_BAL);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.CLR_BAL)) {
        this.CLR_BAL = data().deepCopy(fields()[1].schema(), other.CLR_BAL);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.FORACID)) {
        this.FORACID = data().deepCopy(fields()[2].schema(), other.FORACID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.LAST_BAL_UPDATED_DATE)) {
        this.LAST_BAL_UPDATED_DATE = data().deepCopy(fields()[3].schema(), other.LAST_BAL_UPDATED_DATE);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.SCHM_CODE)) {
        this.SCHM_CODE = data().deepCopy(fields()[4].schema(), other.SCHM_CODE);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.CIF_ID)) {
        this.CIF_ID = data().deepCopy(fields()[5].schema(), other.CIF_ID);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ACCT_NAME)) {
        this.ACCT_NAME = data().deepCopy(fields()[6].schema(), other.ACCT_NAME);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.ACCT_SHORT_NAME)) {
        this.ACCT_SHORT_NAME = data().deepCopy(fields()[7].schema(), other.ACCT_SHORT_NAME);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.SCHM_SUB_TYPE)) {
        this.SCHM_SUB_TYPE = data().deepCopy(fields()[8].schema(), other.SCHM_SUB_TYPE);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.SCHM_TYPE)) {
        this.SCHM_TYPE = data().deepCopy(fields()[9].schema(), other.SCHM_TYPE);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.TRAN_DATE)) {
        this.TRAN_DATE = data().deepCopy(fields()[10].schema(), other.TRAN_DATE);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.TRAN_ID)) {
        this.TRAN_ID = data().deepCopy(fields()[11].schema(), other.TRAN_ID);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.PART_TRAN_SRL_NUM)) {
        this.PART_TRAN_SRL_NUM = data().deepCopy(fields()[12].schema(), other.PART_TRAN_SRL_NUM);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.DEL_FLG)) {
        this.DEL_FLG = data().deepCopy(fields()[13].schema(), other.DEL_FLG);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.TRAN_TYPE)) {
        this.TRAN_TYPE = data().deepCopy(fields()[14].schema(), other.TRAN_TYPE);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.TRAN_SUB_TYPE)) {
        this.TRAN_SUB_TYPE = data().deepCopy(fields()[15].schema(), other.TRAN_SUB_TYPE);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.PART_TRAN_TYPE)) {
        this.PART_TRAN_TYPE = data().deepCopy(fields()[16].schema(), other.PART_TRAN_TYPE);
        fieldSetFlags()[16] = true;
      }
      if (isValidValue(fields()[17], other.GL_SUB_HEAD_CODE)) {
        this.GL_SUB_HEAD_CODE = data().deepCopy(fields()[17].schema(), other.GL_SUB_HEAD_CODE);
        fieldSetFlags()[17] = true;
      }
      if (isValidValue(fields()[18], other.ACID)) {
        this.ACID = data().deepCopy(fields()[18].schema(), other.ACID);
        fieldSetFlags()[18] = true;
      }
      if (isValidValue(fields()[19], other.VALUE_DATE)) {
        this.VALUE_DATE = data().deepCopy(fields()[19].schema(), other.VALUE_DATE);
        fieldSetFlags()[19] = true;
      }
      if (isValidValue(fields()[20], other.TRAN_AMT)) {
        this.TRAN_AMT = data().deepCopy(fields()[20].schema(), other.TRAN_AMT);
        fieldSetFlags()[20] = true;
      }
      if (isValidValue(fields()[21], other.TRAN_PARTICULAR)) {
        this.TRAN_PARTICULAR = data().deepCopy(fields()[21].schema(), other.TRAN_PARTICULAR);
        fieldSetFlags()[21] = true;
      }
      if (isValidValue(fields()[22], other.ENTRY_USER_ID)) {
        this.ENTRY_USER_ID = data().deepCopy(fields()[22].schema(), other.ENTRY_USER_ID);
        fieldSetFlags()[22] = true;
      }
      if (isValidValue(fields()[23], other.PSTD_USER_ID)) {
        this.PSTD_USER_ID = data().deepCopy(fields()[23].schema(), other.PSTD_USER_ID);
        fieldSetFlags()[23] = true;
      }
      if (isValidValue(fields()[24], other.VFD_USER_ID)) {
        this.VFD_USER_ID = data().deepCopy(fields()[24].schema(), other.VFD_USER_ID);
        fieldSetFlags()[24] = true;
      }
      if (isValidValue(fields()[25], other.ENTRY_DATE)) {
        this.ENTRY_DATE = data().deepCopy(fields()[25].schema(), other.ENTRY_DATE);
        fieldSetFlags()[25] = true;
      }
      if (isValidValue(fields()[26], other.PSTD_DATE)) {
        this.PSTD_DATE = data().deepCopy(fields()[26].schema(), other.PSTD_DATE);
        fieldSetFlags()[26] = true;
      }
      if (isValidValue(fields()[27], other.VFD_DATE)) {
        this.VFD_DATE = data().deepCopy(fields()[27].schema(), other.VFD_DATE);
        fieldSetFlags()[27] = true;
      }
      if (isValidValue(fields()[28], other.RPT_CODE)) {
        this.RPT_CODE = data().deepCopy(fields()[28].schema(), other.RPT_CODE);
        fieldSetFlags()[28] = true;
      }
      if (isValidValue(fields()[29], other.REF_NUM)) {
        this.REF_NUM = data().deepCopy(fields()[29].schema(), other.REF_NUM);
        fieldSetFlags()[29] = true;
      }
      if (isValidValue(fields()[30], other.INSTRMNT_TYPE)) {
        this.INSTRMNT_TYPE = data().deepCopy(fields()[30].schema(), other.INSTRMNT_TYPE);
        fieldSetFlags()[30] = true;
      }
      if (isValidValue(fields()[31], other.INSTRMNT_DATE)) {
        this.INSTRMNT_DATE = data().deepCopy(fields()[31].schema(), other.INSTRMNT_DATE);
        fieldSetFlags()[31] = true;
      }
      if (isValidValue(fields()[32], other.INSTRMNT_NUM)) {
        this.INSTRMNT_NUM = data().deepCopy(fields()[32].schema(), other.INSTRMNT_NUM);
        fieldSetFlags()[32] = true;
      }
      if (isValidValue(fields()[33], other.INSTRMNT_ALPHA)) {
        this.INSTRMNT_ALPHA = data().deepCopy(fields()[33].schema(), other.INSTRMNT_ALPHA);
        fieldSetFlags()[33] = true;
      }
      if (isValidValue(fields()[34], other.TRAN_RMKS)) {
        this.TRAN_RMKS = data().deepCopy(fields()[34].schema(), other.TRAN_RMKS);
        fieldSetFlags()[34] = true;
      }
      if (isValidValue(fields()[35], other.PSTD_FLG)) {
        this.PSTD_FLG = data().deepCopy(fields()[35].schema(), other.PSTD_FLG);
        fieldSetFlags()[35] = true;
      }
      if (isValidValue(fields()[36], other.PRNT_ADVC_IND)) {
        this.PRNT_ADVC_IND = data().deepCopy(fields()[36].schema(), other.PRNT_ADVC_IND);
        fieldSetFlags()[36] = true;
      }
      if (isValidValue(fields()[37], other.AMT_RESERVATION_IND)) {
        this.AMT_RESERVATION_IND = data().deepCopy(fields()[37].schema(), other.AMT_RESERVATION_IND);
        fieldSetFlags()[37] = true;
      }
      if (isValidValue(fields()[38], other.RESERVATION_AMT)) {
        this.RESERVATION_AMT = data().deepCopy(fields()[38].schema(), other.RESERVATION_AMT);
        fieldSetFlags()[38] = true;
      }
      if (isValidValue(fields()[39], other.RESTRICT_MODIFY_IND)) {
        this.RESTRICT_MODIFY_IND = data().deepCopy(fields()[39].schema(), other.RESTRICT_MODIFY_IND);
        fieldSetFlags()[39] = true;
      }
      if (isValidValue(fields()[40], other.LCHG_USER_ID)) {
        this.LCHG_USER_ID = data().deepCopy(fields()[40].schema(), other.LCHG_USER_ID);
        fieldSetFlags()[40] = true;
      }
      if (isValidValue(fields()[41], other.LCHG_TIME)) {
        this.LCHG_TIME = data().deepCopy(fields()[41].schema(), other.LCHG_TIME);
        fieldSetFlags()[41] = true;
      }
      if (isValidValue(fields()[42], other.RCRE_USER_ID)) {
        this.RCRE_USER_ID = data().deepCopy(fields()[42].schema(), other.RCRE_USER_ID);
        fieldSetFlags()[42] = true;
      }
      if (isValidValue(fields()[43], other.RCRE_TIME)) {
        this.RCRE_TIME = data().deepCopy(fields()[43].schema(), other.RCRE_TIME);
        fieldSetFlags()[43] = true;
      }
      if (isValidValue(fields()[44], other.CUST_ID)) {
        this.CUST_ID = data().deepCopy(fields()[44].schema(), other.CUST_ID);
        fieldSetFlags()[44] = true;
      }
      if (isValidValue(fields()[45], other.VOUCHER_PRINT_FLG)) {
        this.VOUCHER_PRINT_FLG = data().deepCopy(fields()[45].schema(), other.VOUCHER_PRINT_FLG);
        fieldSetFlags()[45] = true;
      }
      if (isValidValue(fields()[46], other.MODULE_ID)) {
        this.MODULE_ID = data().deepCopy(fields()[46].schema(), other.MODULE_ID);
        fieldSetFlags()[46] = true;
      }
      if (isValidValue(fields()[47], other.BR_CODE)) {
        this.BR_CODE = data().deepCopy(fields()[47].schema(), other.BR_CODE);
        fieldSetFlags()[47] = true;
      }
      if (isValidValue(fields()[48], other.FX_TRAN_AMT)) {
        this.FX_TRAN_AMT = data().deepCopy(fields()[48].schema(), other.FX_TRAN_AMT);
        fieldSetFlags()[48] = true;
      }
      if (isValidValue(fields()[49], other.RATE_CODE)) {
        this.RATE_CODE = data().deepCopy(fields()[49].schema(), other.RATE_CODE);
        fieldSetFlags()[49] = true;
      }
      if (isValidValue(fields()[50], other.RATE)) {
        this.RATE = data().deepCopy(fields()[50].schema(), other.RATE);
        fieldSetFlags()[50] = true;
      }
      if (isValidValue(fields()[51], other.CRNCY_CODE)) {
        this.CRNCY_CODE = data().deepCopy(fields()[51].schema(), other.CRNCY_CODE);
        fieldSetFlags()[51] = true;
      }
      if (isValidValue(fields()[52], other.NAVIGATION_FLG)) {
        this.NAVIGATION_FLG = data().deepCopy(fields()[52].schema(), other.NAVIGATION_FLG);
        fieldSetFlags()[52] = true;
      }
      if (isValidValue(fields()[53], other.TRAN_CRNCY_CODE)) {
        this.TRAN_CRNCY_CODE = data().deepCopy(fields()[53].schema(), other.TRAN_CRNCY_CODE);
        fieldSetFlags()[53] = true;
      }
      if (isValidValue(fields()[54], other.REF_CRNCY_CODE)) {
        this.REF_CRNCY_CODE = data().deepCopy(fields()[54].schema(), other.REF_CRNCY_CODE);
        fieldSetFlags()[54] = true;
      }
      if (isValidValue(fields()[55], other.REF_AMT)) {
        this.REF_AMT = data().deepCopy(fields()[55].schema(), other.REF_AMT);
        fieldSetFlags()[55] = true;
      }
      if (isValidValue(fields()[56], other.SOL_ID)) {
        this.SOL_ID = data().deepCopy(fields()[56].schema(), other.SOL_ID);
        fieldSetFlags()[56] = true;
      }
      if (isValidValue(fields()[57], other.BANK_CODE)) {
        this.BANK_CODE = data().deepCopy(fields()[57].schema(), other.BANK_CODE);
        fieldSetFlags()[57] = true;
      }
      if (isValidValue(fields()[58], other.TREA_REF_NUM)) {
        this.TREA_REF_NUM = data().deepCopy(fields()[58].schema(), other.TREA_REF_NUM);
        fieldSetFlags()[58] = true;
      }
      if (isValidValue(fields()[59], other.TREA_RATE)) {
        this.TREA_RATE = data().deepCopy(fields()[59].schema(), other.TREA_RATE);
        fieldSetFlags()[59] = true;
      }
      if (isValidValue(fields()[60], other.TS_CNT)) {
        this.TS_CNT = data().deepCopy(fields()[60].schema(), other.TS_CNT);
        fieldSetFlags()[60] = true;
      }
      if (isValidValue(fields()[61], other.GST_UPD_FLG)) {
        this.GST_UPD_FLG = data().deepCopy(fields()[61].schema(), other.GST_UPD_FLG);
        fieldSetFlags()[61] = true;
      }
      if (isValidValue(fields()[62], other.ISO_FLG)) {
        this.ISO_FLG = data().deepCopy(fields()[62].schema(), other.ISO_FLG);
        fieldSetFlags()[62] = true;
      }
      if (isValidValue(fields()[63], other.EABFAB_UPD_FLG)) {
        this.EABFAB_UPD_FLG = data().deepCopy(fields()[63].schema(), other.EABFAB_UPD_FLG);
        fieldSetFlags()[63] = true;
      }
      if (isValidValue(fields()[64], other.LIFT_LIEN_FLG)) {
        this.LIFT_LIEN_FLG = data().deepCopy(fields()[64].schema(), other.LIFT_LIEN_FLG);
        fieldSetFlags()[64] = true;
      }
      if (isValidValue(fields()[65], other.PROXY_POST_IND)) {
        this.PROXY_POST_IND = data().deepCopy(fields()[65].schema(), other.PROXY_POST_IND);
        fieldSetFlags()[65] = true;
      }
      if (isValidValue(fields()[66], other.SI_SRL_NUM)) {
        this.SI_SRL_NUM = data().deepCopy(fields()[66].schema(), other.SI_SRL_NUM);
        fieldSetFlags()[66] = true;
      }
      if (isValidValue(fields()[67], other.SI_ORG_EXEC_DATE)) {
        this.SI_ORG_EXEC_DATE = data().deepCopy(fields()[67].schema(), other.SI_ORG_EXEC_DATE);
        fieldSetFlags()[67] = true;
      }
      if (isValidValue(fields()[68], other.PR_SRL_NUM)) {
        this.PR_SRL_NUM = data().deepCopy(fields()[68].schema(), other.PR_SRL_NUM);
        fieldSetFlags()[68] = true;
      }
      if (isValidValue(fields()[69], other.SERIAL_NUM)) {
        this.SERIAL_NUM = data().deepCopy(fields()[69].schema(), other.SERIAL_NUM);
        fieldSetFlags()[69] = true;
      }
      if (isValidValue(fields()[70], other.DEL_MEMO_PAD)) {
        this.DEL_MEMO_PAD = data().deepCopy(fields()[70].schema(), other.DEL_MEMO_PAD);
        fieldSetFlags()[70] = true;
      }
      if (isValidValue(fields()[71], other.UAD_MODULE_ID)) {
        this.UAD_MODULE_ID = data().deepCopy(fields()[71].schema(), other.UAD_MODULE_ID);
        fieldSetFlags()[71] = true;
      }
      if (isValidValue(fields()[72], other.UAD_MODULE_KEY)) {
        this.UAD_MODULE_KEY = data().deepCopy(fields()[72].schema(), other.UAD_MODULE_KEY);
        fieldSetFlags()[72] = true;
      }
      if (isValidValue(fields()[73], other.REVERSAL_DATE)) {
        this.REVERSAL_DATE = data().deepCopy(fields()[73].schema(), other.REVERSAL_DATE);
        fieldSetFlags()[73] = true;
      }
      if (isValidValue(fields()[74], other.REVERSAL_VALUE_DATE)) {
        this.REVERSAL_VALUE_DATE = data().deepCopy(fields()[74].schema(), other.REVERSAL_VALUE_DATE);
        fieldSetFlags()[74] = true;
      }
      if (isValidValue(fields()[75], other.PTTM_EVENT_TYPE)) {
        this.PTTM_EVENT_TYPE = data().deepCopy(fields()[75].schema(), other.PTTM_EVENT_TYPE);
        fieldSetFlags()[75] = true;
      }
      if (isValidValue(fields()[76], other.PROXY_ACID)) {
        this.PROXY_ACID = data().deepCopy(fields()[76].schema(), other.PROXY_ACID);
        fieldSetFlags()[76] = true;
      }
      if (isValidValue(fields()[77], other.TOD_ENTITY_TYPE)) {
        this.TOD_ENTITY_TYPE = data().deepCopy(fields()[77].schema(), other.TOD_ENTITY_TYPE);
        fieldSetFlags()[77] = true;
      }
      if (isValidValue(fields()[78], other.TOD_ENTITY_ID)) {
        this.TOD_ENTITY_ID = data().deepCopy(fields()[78].schema(), other.TOD_ENTITY_ID);
        fieldSetFlags()[78] = true;
      }
      if (isValidValue(fields()[79], other.DTH_INIT_SOL_ID)) {
        this.DTH_INIT_SOL_ID = data().deepCopy(fields()[79].schema(), other.DTH_INIT_SOL_ID);
        fieldSetFlags()[79] = true;
      }
      if (isValidValue(fields()[80], other.REGULARIZATION_AMT)) {
        this.REGULARIZATION_AMT = data().deepCopy(fields()[80].schema(), other.REGULARIZATION_AMT);
        fieldSetFlags()[80] = true;
      }
      if (isValidValue(fields()[81], other.PRINCIPAL_PORTION_AMT)) {
        this.PRINCIPAL_PORTION_AMT = data().deepCopy(fields()[81].schema(), other.PRINCIPAL_PORTION_AMT);
        fieldSetFlags()[81] = true;
      }
      if (isValidValue(fields()[82], other.TF_ENTITY_SOL_ID)) {
        this.TF_ENTITY_SOL_ID = data().deepCopy(fields()[82].schema(), other.TF_ENTITY_SOL_ID);
        fieldSetFlags()[82] = true;
      }
      if (isValidValue(fields()[83], other.TRAN_PARTICULAR_2)) {
        this.TRAN_PARTICULAR_2 = data().deepCopy(fields()[83].schema(), other.TRAN_PARTICULAR_2);
        fieldSetFlags()[83] = true;
      }
      if (isValidValue(fields()[84], other.TRAN_PARTICULAR_CODE)) {
        this.TRAN_PARTICULAR_CODE = data().deepCopy(fields()[84].schema(), other.TRAN_PARTICULAR_CODE);
        fieldSetFlags()[84] = true;
      }
      if (isValidValue(fields()[85], other.TR_STATUS)) {
        this.TR_STATUS = data().deepCopy(fields()[85].schema(), other.TR_STATUS);
        fieldSetFlags()[85] = true;
      }
      if (isValidValue(fields()[86], other.SVS_TRAN_ID)) {
        this.SVS_TRAN_ID = data().deepCopy(fields()[86].schema(), other.SVS_TRAN_ID);
        fieldSetFlags()[86] = true;
      }
      if (isValidValue(fields()[87], other.CRNCY_HOL_CHK_DONE_FLG)) {
        this.CRNCY_HOL_CHK_DONE_FLG = data().deepCopy(fields()[87].schema(), other.CRNCY_HOL_CHK_DONE_FLG);
        fieldSetFlags()[87] = true;
      }
      if (isValidValue(fields()[88], other.REFERRAL_ID)) {
        this.REFERRAL_ID = data().deepCopy(fields()[88].schema(), other.REFERRAL_ID);
        fieldSetFlags()[88] = true;
      }
      if (isValidValue(fields()[89], other.PARTY_CODE)) {
        this.PARTY_CODE = data().deepCopy(fields()[89].schema(), other.PARTY_CODE);
        fieldSetFlags()[89] = true;
      }
      if (isValidValue(fields()[90], other.GL_DATE)) {
        this.GL_DATE = data().deepCopy(fields()[90].schema(), other.GL_DATE);
        fieldSetFlags()[90] = true;
      }
      if (isValidValue(fields()[91], other.BKDT_TRAN_FLG)) {
        this.BKDT_TRAN_FLG = data().deepCopy(fields()[91].schema(), other.BKDT_TRAN_FLG);
        fieldSetFlags()[91] = true;
      }
      if (isValidValue(fields()[92], other.BANK_ID)) {
        this.BANK_ID = data().deepCopy(fields()[92].schema(), other.BANK_ID);
        fieldSetFlags()[92] = true;
      }
      if (isValidValue(fields()[93], other.IMPL_CASH_PART_TRAN_FLG)) {
        this.IMPL_CASH_PART_TRAN_FLG = data().deepCopy(fields()[93].schema(), other.IMPL_CASH_PART_TRAN_FLG);
        fieldSetFlags()[93] = true;
      }
      if (isValidValue(fields()[94], other.PTRAN_CHRG_EXISTS_FLG)) {
        this.PTRAN_CHRG_EXISTS_FLG = data().deepCopy(fields()[94].schema(), other.PTRAN_CHRG_EXISTS_FLG);
        fieldSetFlags()[94] = true;
      }
      if (isValidValue(fields()[95], other.MUD_POOL_BAL_BUILD_FLG)) {
        this.MUD_POOL_BAL_BUILD_FLG = data().deepCopy(fields()[95].schema(), other.MUD_POOL_BAL_BUILD_FLG);
        fieldSetFlags()[95] = true;
      }
      if (isValidValue(fields()[96], other.GL_SEGMENT_STRING)) {
        this.GL_SEGMENT_STRING = data().deepCopy(fields()[96].schema(), other.GL_SEGMENT_STRING);
        fieldSetFlags()[96] = true;
      }
      if (isValidValue(fields()[97], other.SYS_PART_TRAN_CODE)) {
        this.SYS_PART_TRAN_CODE = data().deepCopy(fields()[97].schema(), other.SYS_PART_TRAN_CODE);
        fieldSetFlags()[97] = true;
      }
      if (isValidValue(fields()[98], other.USER_PART_TRAN_CODE)) {
        this.USER_PART_TRAN_CODE = data().deepCopy(fields()[98].schema(), other.USER_PART_TRAN_CODE);
        fieldSetFlags()[98] = true;
      }
      if (isValidValue(fields()[99], other.TRAN_FREE_CODE1)) {
        this.TRAN_FREE_CODE1 = data().deepCopy(fields()[99].schema(), other.TRAN_FREE_CODE1);
        fieldSetFlags()[99] = true;
      }
      if (isValidValue(fields()[100], other.TRAN_FREE_CODE2)) {
        this.TRAN_FREE_CODE2 = data().deepCopy(fields()[100].schema(), other.TRAN_FREE_CODE2);
        fieldSetFlags()[100] = true;
      }
      if (isValidValue(fields()[101], other.PSTD_SRL_NUM)) {
        this.PSTD_SRL_NUM = data().deepCopy(fields()[101].schema(), other.PSTD_SRL_NUM);
        fieldSetFlags()[101] = true;
      }
      if (isValidValue(fields()[102], other.REVERSAL_STATUS)) {
        this.REVERSAL_STATUS = data().deepCopy(fields()[102].schema(), other.REVERSAL_STATUS);
        fieldSetFlags()[102] = true;
      }
      if (isValidValue(fields()[103], other.AVAILABLE_AMT)) {
        this.AVAILABLE_AMT = data().deepCopy(fields()[103].schema(), other.AVAILABLE_AMT);
        fieldSetFlags()[103] = true;
      }
      if (isValidValue(fields()[104], other.ACCT_BALANCE)) {
        this.ACCT_BALANCE = data().deepCopy(fields()[104].schema(), other.ACCT_BALANCE);
        fieldSetFlags()[104] = true;
      }
    }

    /**
      * Gets the value of the 'EFFECTIVE_BAL' field.
      * @return The value.
      */
    public java.lang.Double getEFFECTIVEBAL() {
      return EFFECTIVE_BAL;
    }

    /**
      * Sets the value of the 'EFFECTIVE_BAL' field.
      * @param value The value of 'EFFECTIVE_BAL'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setEFFECTIVEBAL(java.lang.Double value) {
      validate(fields()[0], value);
      this.EFFECTIVE_BAL = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'EFFECTIVE_BAL' field has been set.
      * @return True if the 'EFFECTIVE_BAL' field has been set, false otherwise.
      */
    public boolean hasEFFECTIVEBAL() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'EFFECTIVE_BAL' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearEFFECTIVEBAL() {
      EFFECTIVE_BAL = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'CLR_BAL' field.
      * @return The value.
      */
    public java.lang.Double getCLRBAL() {
      return CLR_BAL;
    }

    /**
      * Sets the value of the 'CLR_BAL' field.
      * @param value The value of 'CLR_BAL'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setCLRBAL(java.lang.Double value) {
      validate(fields()[1], value);
      this.CLR_BAL = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'CLR_BAL' field has been set.
      * @return True if the 'CLR_BAL' field has been set, false otherwise.
      */
    public boolean hasCLRBAL() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'CLR_BAL' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearCLRBAL() {
      CLR_BAL = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'FORACID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getFORACID() {
      return FORACID;
    }

    /**
      * Sets the value of the 'FORACID' field.
      * @param value The value of 'FORACID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setFORACID(java.nio.ByteBuffer value) {
      validate(fields()[2], value);
      this.FORACID = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'FORACID' field has been set.
      * @return True if the 'FORACID' field has been set, false otherwise.
      */
    public boolean hasFORACID() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'FORACID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearFORACID() {
      FORACID = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'LAST_BAL_UPDATED_DATE' field.
      * @return The value.
      */
    public java.lang.Long getLASTBALUPDATEDDATE() {
      return LAST_BAL_UPDATED_DATE;
    }

    /**
      * Sets the value of the 'LAST_BAL_UPDATED_DATE' field.
      * @param value The value of 'LAST_BAL_UPDATED_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setLASTBALUPDATEDDATE(java.lang.Long value) {
      validate(fields()[3], value);
      this.LAST_BAL_UPDATED_DATE = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'LAST_BAL_UPDATED_DATE' field has been set.
      * @return True if the 'LAST_BAL_UPDATED_DATE' field has been set, false otherwise.
      */
    public boolean hasLASTBALUPDATEDDATE() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'LAST_BAL_UPDATED_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearLASTBALUPDATEDDATE() {
      LAST_BAL_UPDATED_DATE = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'SCHM_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSCHMCODE() {
      return SCHM_CODE;
    }

    /**
      * Sets the value of the 'SCHM_CODE' field.
      * @param value The value of 'SCHM_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSCHMCODE(java.nio.ByteBuffer value) {
      validate(fields()[4], value);
      this.SCHM_CODE = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'SCHM_CODE' field has been set.
      * @return True if the 'SCHM_CODE' field has been set, false otherwise.
      */
    public boolean hasSCHMCODE() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'SCHM_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSCHMCODE() {
      SCHM_CODE = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'CIF_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getCIFID() {
      return CIF_ID;
    }

    /**
      * Sets the value of the 'CIF_ID' field.
      * @param value The value of 'CIF_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setCIFID(java.nio.ByteBuffer value) {
      validate(fields()[5], value);
      this.CIF_ID = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'CIF_ID' field has been set.
      * @return True if the 'CIF_ID' field has been set, false otherwise.
      */
    public boolean hasCIFID() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'CIF_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearCIFID() {
      CIF_ID = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'ACCT_NAME' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getACCTNAME() {
      return ACCT_NAME;
    }

    /**
      * Sets the value of the 'ACCT_NAME' field.
      * @param value The value of 'ACCT_NAME'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setACCTNAME(java.nio.ByteBuffer value) {
      validate(fields()[6], value);
      this.ACCT_NAME = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'ACCT_NAME' field has been set.
      * @return True if the 'ACCT_NAME' field has been set, false otherwise.
      */
    public boolean hasACCTNAME() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'ACCT_NAME' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearACCTNAME() {
      ACCT_NAME = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'ACCT_SHORT_NAME' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getACCTSHORTNAME() {
      return ACCT_SHORT_NAME;
    }

    /**
      * Sets the value of the 'ACCT_SHORT_NAME' field.
      * @param value The value of 'ACCT_SHORT_NAME'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setACCTSHORTNAME(java.nio.ByteBuffer value) {
      validate(fields()[7], value);
      this.ACCT_SHORT_NAME = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'ACCT_SHORT_NAME' field has been set.
      * @return True if the 'ACCT_SHORT_NAME' field has been set, false otherwise.
      */
    public boolean hasACCTSHORTNAME() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'ACCT_SHORT_NAME' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearACCTSHORTNAME() {
      ACCT_SHORT_NAME = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'SCHM_SUB_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSCHMSUBTYPE() {
      return SCHM_SUB_TYPE;
    }

    /**
      * Sets the value of the 'SCHM_SUB_TYPE' field.
      * @param value The value of 'SCHM_SUB_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSCHMSUBTYPE(java.nio.ByteBuffer value) {
      validate(fields()[8], value);
      this.SCHM_SUB_TYPE = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'SCHM_SUB_TYPE' field has been set.
      * @return True if the 'SCHM_SUB_TYPE' field has been set, false otherwise.
      */
    public boolean hasSCHMSUBTYPE() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'SCHM_SUB_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSCHMSUBTYPE() {
      SCHM_SUB_TYPE = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'SCHM_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSCHMTYPE() {
      return SCHM_TYPE;
    }

    /**
      * Sets the value of the 'SCHM_TYPE' field.
      * @param value The value of 'SCHM_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSCHMTYPE(java.nio.ByteBuffer value) {
      validate(fields()[9], value);
      this.SCHM_TYPE = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'SCHM_TYPE' field has been set.
      * @return True if the 'SCHM_TYPE' field has been set, false otherwise.
      */
    public boolean hasSCHMTYPE() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'SCHM_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSCHMTYPE() {
      SCHM_TYPE = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getTRANDATE() {
      return TRAN_DATE;
    }

    /**
      * Sets the value of the 'TRAN_DATE' field.
      * @param value The value of 'TRAN_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANDATE(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.TRAN_DATE = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_DATE' field has been set.
      * @return True if the 'TRAN_DATE' field has been set, false otherwise.
      */
    public boolean hasTRANDATE() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'TRAN_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANDATE() {
      TRAN_DATE = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANID() {
      return TRAN_ID;
    }

    /**
      * Sets the value of the 'TRAN_ID' field.
      * @param value The value of 'TRAN_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANID(java.nio.ByteBuffer value) {
      validate(fields()[11], value);
      this.TRAN_ID = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_ID' field has been set.
      * @return True if the 'TRAN_ID' field has been set, false otherwise.
      */
    public boolean hasTRANID() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'TRAN_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANID() {
      TRAN_ID = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'PART_TRAN_SRL_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPARTTRANSRLNUM() {
      return PART_TRAN_SRL_NUM;
    }

    /**
      * Sets the value of the 'PART_TRAN_SRL_NUM' field.
      * @param value The value of 'PART_TRAN_SRL_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPARTTRANSRLNUM(java.nio.ByteBuffer value) {
      validate(fields()[12], value);
      this.PART_TRAN_SRL_NUM = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'PART_TRAN_SRL_NUM' field has been set.
      * @return True if the 'PART_TRAN_SRL_NUM' field has been set, false otherwise.
      */
    public boolean hasPARTTRANSRLNUM() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'PART_TRAN_SRL_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPARTTRANSRLNUM() {
      PART_TRAN_SRL_NUM = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'DEL_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getDELFLG() {
      return DEL_FLG;
    }

    /**
      * Sets the value of the 'DEL_FLG' field.
      * @param value The value of 'DEL_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setDELFLG(java.nio.ByteBuffer value) {
      validate(fields()[13], value);
      this.DEL_FLG = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'DEL_FLG' field has been set.
      * @return True if the 'DEL_FLG' field has been set, false otherwise.
      */
    public boolean hasDELFLG() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'DEL_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearDELFLG() {
      DEL_FLG = null;
      fieldSetFlags()[13] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANTYPE() {
      return TRAN_TYPE;
    }

    /**
      * Sets the value of the 'TRAN_TYPE' field.
      * @param value The value of 'TRAN_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANTYPE(java.nio.ByteBuffer value) {
      validate(fields()[14], value);
      this.TRAN_TYPE = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_TYPE' field has been set.
      * @return True if the 'TRAN_TYPE' field has been set, false otherwise.
      */
    public boolean hasTRANTYPE() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'TRAN_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANTYPE() {
      TRAN_TYPE = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_SUB_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANSUBTYPE() {
      return TRAN_SUB_TYPE;
    }

    /**
      * Sets the value of the 'TRAN_SUB_TYPE' field.
      * @param value The value of 'TRAN_SUB_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANSUBTYPE(java.nio.ByteBuffer value) {
      validate(fields()[15], value);
      this.TRAN_SUB_TYPE = value;
      fieldSetFlags()[15] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_SUB_TYPE' field has been set.
      * @return True if the 'TRAN_SUB_TYPE' field has been set, false otherwise.
      */
    public boolean hasTRANSUBTYPE() {
      return fieldSetFlags()[15];
    }


    /**
      * Clears the value of the 'TRAN_SUB_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANSUBTYPE() {
      TRAN_SUB_TYPE = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    /**
      * Gets the value of the 'PART_TRAN_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPARTTRANTYPE() {
      return PART_TRAN_TYPE;
    }

    /**
      * Sets the value of the 'PART_TRAN_TYPE' field.
      * @param value The value of 'PART_TRAN_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPARTTRANTYPE(java.nio.ByteBuffer value) {
      validate(fields()[16], value);
      this.PART_TRAN_TYPE = value;
      fieldSetFlags()[16] = true;
      return this;
    }

    /**
      * Checks whether the 'PART_TRAN_TYPE' field has been set.
      * @return True if the 'PART_TRAN_TYPE' field has been set, false otherwise.
      */
    public boolean hasPARTTRANTYPE() {
      return fieldSetFlags()[16];
    }


    /**
      * Clears the value of the 'PART_TRAN_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPARTTRANTYPE() {
      PART_TRAN_TYPE = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    /**
      * Gets the value of the 'GL_SUB_HEAD_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getGLSUBHEADCODE() {
      return GL_SUB_HEAD_CODE;
    }

    /**
      * Sets the value of the 'GL_SUB_HEAD_CODE' field.
      * @param value The value of 'GL_SUB_HEAD_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setGLSUBHEADCODE(java.nio.ByteBuffer value) {
      validate(fields()[17], value);
      this.GL_SUB_HEAD_CODE = value;
      fieldSetFlags()[17] = true;
      return this;
    }

    /**
      * Checks whether the 'GL_SUB_HEAD_CODE' field has been set.
      * @return True if the 'GL_SUB_HEAD_CODE' field has been set, false otherwise.
      */
    public boolean hasGLSUBHEADCODE() {
      return fieldSetFlags()[17];
    }


    /**
      * Clears the value of the 'GL_SUB_HEAD_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearGLSUBHEADCODE() {
      GL_SUB_HEAD_CODE = null;
      fieldSetFlags()[17] = false;
      return this;
    }

    /**
      * Gets the value of the 'ACID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getACID() {
      return ACID;
    }

    /**
      * Sets the value of the 'ACID' field.
      * @param value The value of 'ACID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setACID(java.nio.ByteBuffer value) {
      validate(fields()[18], value);
      this.ACID = value;
      fieldSetFlags()[18] = true;
      return this;
    }

    /**
      * Checks whether the 'ACID' field has been set.
      * @return True if the 'ACID' field has been set, false otherwise.
      */
    public boolean hasACID() {
      return fieldSetFlags()[18];
    }


    /**
      * Clears the value of the 'ACID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearACID() {
      ACID = null;
      fieldSetFlags()[18] = false;
      return this;
    }

    /**
      * Gets the value of the 'VALUE_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getVALUEDATE() {
      return VALUE_DATE;
    }

    /**
      * Sets the value of the 'VALUE_DATE' field.
      * @param value The value of 'VALUE_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setVALUEDATE(java.lang.CharSequence value) {
      validate(fields()[19], value);
      this.VALUE_DATE = value;
      fieldSetFlags()[19] = true;
      return this;
    }

    /**
      * Checks whether the 'VALUE_DATE' field has been set.
      * @return True if the 'VALUE_DATE' field has been set, false otherwise.
      */
    public boolean hasVALUEDATE() {
      return fieldSetFlags()[19];
    }


    /**
      * Clears the value of the 'VALUE_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearVALUEDATE() {
      VALUE_DATE = null;
      fieldSetFlags()[19] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_AMT' field.
      * @return The value.
      */
    public java.lang.Double getTRANAMT() {
      return TRAN_AMT;
    }

    /**
      * Sets the value of the 'TRAN_AMT' field.
      * @param value The value of 'TRAN_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANAMT(java.lang.Double value) {
      validate(fields()[20], value);
      this.TRAN_AMT = value;
      fieldSetFlags()[20] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_AMT' field has been set.
      * @return True if the 'TRAN_AMT' field has been set, false otherwise.
      */
    public boolean hasTRANAMT() {
      return fieldSetFlags()[20];
    }


    /**
      * Clears the value of the 'TRAN_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANAMT() {
      TRAN_AMT = null;
      fieldSetFlags()[20] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_PARTICULAR' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANPARTICULAR() {
      return TRAN_PARTICULAR;
    }

    /**
      * Sets the value of the 'TRAN_PARTICULAR' field.
      * @param value The value of 'TRAN_PARTICULAR'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANPARTICULAR(java.nio.ByteBuffer value) {
      validate(fields()[21], value);
      this.TRAN_PARTICULAR = value;
      fieldSetFlags()[21] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_PARTICULAR' field has been set.
      * @return True if the 'TRAN_PARTICULAR' field has been set, false otherwise.
      */
    public boolean hasTRANPARTICULAR() {
      return fieldSetFlags()[21];
    }


    /**
      * Clears the value of the 'TRAN_PARTICULAR' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANPARTICULAR() {
      TRAN_PARTICULAR = null;
      fieldSetFlags()[21] = false;
      return this;
    }

    /**
      * Gets the value of the 'ENTRY_USER_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getENTRYUSERID() {
      return ENTRY_USER_ID;
    }

    /**
      * Sets the value of the 'ENTRY_USER_ID' field.
      * @param value The value of 'ENTRY_USER_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setENTRYUSERID(java.nio.ByteBuffer value) {
      validate(fields()[22], value);
      this.ENTRY_USER_ID = value;
      fieldSetFlags()[22] = true;
      return this;
    }

    /**
      * Checks whether the 'ENTRY_USER_ID' field has been set.
      * @return True if the 'ENTRY_USER_ID' field has been set, false otherwise.
      */
    public boolean hasENTRYUSERID() {
      return fieldSetFlags()[22];
    }


    /**
      * Clears the value of the 'ENTRY_USER_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearENTRYUSERID() {
      ENTRY_USER_ID = null;
      fieldSetFlags()[22] = false;
      return this;
    }

    /**
      * Gets the value of the 'PSTD_USER_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPSTDUSERID() {
      return PSTD_USER_ID;
    }

    /**
      * Sets the value of the 'PSTD_USER_ID' field.
      * @param value The value of 'PSTD_USER_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPSTDUSERID(java.nio.ByteBuffer value) {
      validate(fields()[23], value);
      this.PSTD_USER_ID = value;
      fieldSetFlags()[23] = true;
      return this;
    }

    /**
      * Checks whether the 'PSTD_USER_ID' field has been set.
      * @return True if the 'PSTD_USER_ID' field has been set, false otherwise.
      */
    public boolean hasPSTDUSERID() {
      return fieldSetFlags()[23];
    }


    /**
      * Clears the value of the 'PSTD_USER_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPSTDUSERID() {
      PSTD_USER_ID = null;
      fieldSetFlags()[23] = false;
      return this;
    }

    /**
      * Gets the value of the 'VFD_USER_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getVFDUSERID() {
      return VFD_USER_ID;
    }

    /**
      * Sets the value of the 'VFD_USER_ID' field.
      * @param value The value of 'VFD_USER_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setVFDUSERID(java.nio.ByteBuffer value) {
      validate(fields()[24], value);
      this.VFD_USER_ID = value;
      fieldSetFlags()[24] = true;
      return this;
    }

    /**
      * Checks whether the 'VFD_USER_ID' field has been set.
      * @return True if the 'VFD_USER_ID' field has been set, false otherwise.
      */
    public boolean hasVFDUSERID() {
      return fieldSetFlags()[24];
    }


    /**
      * Clears the value of the 'VFD_USER_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearVFDUSERID() {
      VFD_USER_ID = null;
      fieldSetFlags()[24] = false;
      return this;
    }

    /**
      * Gets the value of the 'ENTRY_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getENTRYDATE() {
      return ENTRY_DATE;
    }

    /**
      * Sets the value of the 'ENTRY_DATE' field.
      * @param value The value of 'ENTRY_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setENTRYDATE(java.lang.CharSequence value) {
      validate(fields()[25], value);
      this.ENTRY_DATE = value;
      fieldSetFlags()[25] = true;
      return this;
    }

    /**
      * Checks whether the 'ENTRY_DATE' field has been set.
      * @return True if the 'ENTRY_DATE' field has been set, false otherwise.
      */
    public boolean hasENTRYDATE() {
      return fieldSetFlags()[25];
    }


    /**
      * Clears the value of the 'ENTRY_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearENTRYDATE() {
      ENTRY_DATE = null;
      fieldSetFlags()[25] = false;
      return this;
    }

    /**
      * Gets the value of the 'PSTD_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getPSTDDATE() {
      return PSTD_DATE;
    }

    /**
      * Sets the value of the 'PSTD_DATE' field.
      * @param value The value of 'PSTD_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPSTDDATE(java.lang.CharSequence value) {
      validate(fields()[26], value);
      this.PSTD_DATE = value;
      fieldSetFlags()[26] = true;
      return this;
    }

    /**
      * Checks whether the 'PSTD_DATE' field has been set.
      * @return True if the 'PSTD_DATE' field has been set, false otherwise.
      */
    public boolean hasPSTDDATE() {
      return fieldSetFlags()[26];
    }


    /**
      * Clears the value of the 'PSTD_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPSTDDATE() {
      PSTD_DATE = null;
      fieldSetFlags()[26] = false;
      return this;
    }

    /**
      * Gets the value of the 'VFD_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getVFDDATE() {
      return VFD_DATE;
    }

    /**
      * Sets the value of the 'VFD_DATE' field.
      * @param value The value of 'VFD_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setVFDDATE(java.lang.CharSequence value) {
      validate(fields()[27], value);
      this.VFD_DATE = value;
      fieldSetFlags()[27] = true;
      return this;
    }

    /**
      * Checks whether the 'VFD_DATE' field has been set.
      * @return True if the 'VFD_DATE' field has been set, false otherwise.
      */
    public boolean hasVFDDATE() {
      return fieldSetFlags()[27];
    }


    /**
      * Clears the value of the 'VFD_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearVFDDATE() {
      VFD_DATE = null;
      fieldSetFlags()[27] = false;
      return this;
    }

    /**
      * Gets the value of the 'RPT_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getRPTCODE() {
      return RPT_CODE;
    }

    /**
      * Sets the value of the 'RPT_CODE' field.
      * @param value The value of 'RPT_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRPTCODE(java.nio.ByteBuffer value) {
      validate(fields()[28], value);
      this.RPT_CODE = value;
      fieldSetFlags()[28] = true;
      return this;
    }

    /**
      * Checks whether the 'RPT_CODE' field has been set.
      * @return True if the 'RPT_CODE' field has been set, false otherwise.
      */
    public boolean hasRPTCODE() {
      return fieldSetFlags()[28];
    }


    /**
      * Clears the value of the 'RPT_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRPTCODE() {
      RPT_CODE = null;
      fieldSetFlags()[28] = false;
      return this;
    }

    /**
      * Gets the value of the 'REF_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getREFNUM() {
      return REF_NUM;
    }

    /**
      * Sets the value of the 'REF_NUM' field.
      * @param value The value of 'REF_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREFNUM(java.nio.ByteBuffer value) {
      validate(fields()[29], value);
      this.REF_NUM = value;
      fieldSetFlags()[29] = true;
      return this;
    }

    /**
      * Checks whether the 'REF_NUM' field has been set.
      * @return True if the 'REF_NUM' field has been set, false otherwise.
      */
    public boolean hasREFNUM() {
      return fieldSetFlags()[29];
    }


    /**
      * Clears the value of the 'REF_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREFNUM() {
      REF_NUM = null;
      fieldSetFlags()[29] = false;
      return this;
    }

    /**
      * Gets the value of the 'INSTRMNT_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getINSTRMNTTYPE() {
      return INSTRMNT_TYPE;
    }

    /**
      * Sets the value of the 'INSTRMNT_TYPE' field.
      * @param value The value of 'INSTRMNT_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setINSTRMNTTYPE(java.nio.ByteBuffer value) {
      validate(fields()[30], value);
      this.INSTRMNT_TYPE = value;
      fieldSetFlags()[30] = true;
      return this;
    }

    /**
      * Checks whether the 'INSTRMNT_TYPE' field has been set.
      * @return True if the 'INSTRMNT_TYPE' field has been set, false otherwise.
      */
    public boolean hasINSTRMNTTYPE() {
      return fieldSetFlags()[30];
    }


    /**
      * Clears the value of the 'INSTRMNT_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearINSTRMNTTYPE() {
      INSTRMNT_TYPE = null;
      fieldSetFlags()[30] = false;
      return this;
    }

    /**
      * Gets the value of the 'INSTRMNT_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getINSTRMNTDATE() {
      return INSTRMNT_DATE;
    }

    /**
      * Sets the value of the 'INSTRMNT_DATE' field.
      * @param value The value of 'INSTRMNT_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setINSTRMNTDATE(java.lang.CharSequence value) {
      validate(fields()[31], value);
      this.INSTRMNT_DATE = value;
      fieldSetFlags()[31] = true;
      return this;
    }

    /**
      * Checks whether the 'INSTRMNT_DATE' field has been set.
      * @return True if the 'INSTRMNT_DATE' field has been set, false otherwise.
      */
    public boolean hasINSTRMNTDATE() {
      return fieldSetFlags()[31];
    }


    /**
      * Clears the value of the 'INSTRMNT_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearINSTRMNTDATE() {
      INSTRMNT_DATE = null;
      fieldSetFlags()[31] = false;
      return this;
    }

    /**
      * Gets the value of the 'INSTRMNT_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getINSTRMNTNUM() {
      return INSTRMNT_NUM;
    }

    /**
      * Sets the value of the 'INSTRMNT_NUM' field.
      * @param value The value of 'INSTRMNT_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setINSTRMNTNUM(java.nio.ByteBuffer value) {
      validate(fields()[32], value);
      this.INSTRMNT_NUM = value;
      fieldSetFlags()[32] = true;
      return this;
    }

    /**
      * Checks whether the 'INSTRMNT_NUM' field has been set.
      * @return True if the 'INSTRMNT_NUM' field has been set, false otherwise.
      */
    public boolean hasINSTRMNTNUM() {
      return fieldSetFlags()[32];
    }


    /**
      * Clears the value of the 'INSTRMNT_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearINSTRMNTNUM() {
      INSTRMNT_NUM = null;
      fieldSetFlags()[32] = false;
      return this;
    }

    /**
      * Gets the value of the 'INSTRMNT_ALPHA' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getINSTRMNTALPHA() {
      return INSTRMNT_ALPHA;
    }

    /**
      * Sets the value of the 'INSTRMNT_ALPHA' field.
      * @param value The value of 'INSTRMNT_ALPHA'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setINSTRMNTALPHA(java.nio.ByteBuffer value) {
      validate(fields()[33], value);
      this.INSTRMNT_ALPHA = value;
      fieldSetFlags()[33] = true;
      return this;
    }

    /**
      * Checks whether the 'INSTRMNT_ALPHA' field has been set.
      * @return True if the 'INSTRMNT_ALPHA' field has been set, false otherwise.
      */
    public boolean hasINSTRMNTALPHA() {
      return fieldSetFlags()[33];
    }


    /**
      * Clears the value of the 'INSTRMNT_ALPHA' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearINSTRMNTALPHA() {
      INSTRMNT_ALPHA = null;
      fieldSetFlags()[33] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_RMKS' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANRMKS() {
      return TRAN_RMKS;
    }

    /**
      * Sets the value of the 'TRAN_RMKS' field.
      * @param value The value of 'TRAN_RMKS'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANRMKS(java.nio.ByteBuffer value) {
      validate(fields()[34], value);
      this.TRAN_RMKS = value;
      fieldSetFlags()[34] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_RMKS' field has been set.
      * @return True if the 'TRAN_RMKS' field has been set, false otherwise.
      */
    public boolean hasTRANRMKS() {
      return fieldSetFlags()[34];
    }


    /**
      * Clears the value of the 'TRAN_RMKS' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANRMKS() {
      TRAN_RMKS = null;
      fieldSetFlags()[34] = false;
      return this;
    }

    /**
      * Gets the value of the 'PSTD_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPSTDFLG() {
      return PSTD_FLG;
    }

    /**
      * Sets the value of the 'PSTD_FLG' field.
      * @param value The value of 'PSTD_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPSTDFLG(java.nio.ByteBuffer value) {
      validate(fields()[35], value);
      this.PSTD_FLG = value;
      fieldSetFlags()[35] = true;
      return this;
    }

    /**
      * Checks whether the 'PSTD_FLG' field has been set.
      * @return True if the 'PSTD_FLG' field has been set, false otherwise.
      */
    public boolean hasPSTDFLG() {
      return fieldSetFlags()[35];
    }


    /**
      * Clears the value of the 'PSTD_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPSTDFLG() {
      PSTD_FLG = null;
      fieldSetFlags()[35] = false;
      return this;
    }

    /**
      * Gets the value of the 'PRNT_ADVC_IND' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPRNTADVCIND() {
      return PRNT_ADVC_IND;
    }

    /**
      * Sets the value of the 'PRNT_ADVC_IND' field.
      * @param value The value of 'PRNT_ADVC_IND'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPRNTADVCIND(java.nio.ByteBuffer value) {
      validate(fields()[36], value);
      this.PRNT_ADVC_IND = value;
      fieldSetFlags()[36] = true;
      return this;
    }

    /**
      * Checks whether the 'PRNT_ADVC_IND' field has been set.
      * @return True if the 'PRNT_ADVC_IND' field has been set, false otherwise.
      */
    public boolean hasPRNTADVCIND() {
      return fieldSetFlags()[36];
    }


    /**
      * Clears the value of the 'PRNT_ADVC_IND' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPRNTADVCIND() {
      PRNT_ADVC_IND = null;
      fieldSetFlags()[36] = false;
      return this;
    }

    /**
      * Gets the value of the 'AMT_RESERVATION_IND' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getAMTRESERVATIONIND() {
      return AMT_RESERVATION_IND;
    }

    /**
      * Sets the value of the 'AMT_RESERVATION_IND' field.
      * @param value The value of 'AMT_RESERVATION_IND'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setAMTRESERVATIONIND(java.nio.ByteBuffer value) {
      validate(fields()[37], value);
      this.AMT_RESERVATION_IND = value;
      fieldSetFlags()[37] = true;
      return this;
    }

    /**
      * Checks whether the 'AMT_RESERVATION_IND' field has been set.
      * @return True if the 'AMT_RESERVATION_IND' field has been set, false otherwise.
      */
    public boolean hasAMTRESERVATIONIND() {
      return fieldSetFlags()[37];
    }


    /**
      * Clears the value of the 'AMT_RESERVATION_IND' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearAMTRESERVATIONIND() {
      AMT_RESERVATION_IND = null;
      fieldSetFlags()[37] = false;
      return this;
    }

    /**
      * Gets the value of the 'RESERVATION_AMT' field.
      * @return The value.
      */
    public java.lang.Double getRESERVATIONAMT() {
      return RESERVATION_AMT;
    }

    /**
      * Sets the value of the 'RESERVATION_AMT' field.
      * @param value The value of 'RESERVATION_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRESERVATIONAMT(java.lang.Double value) {
      validate(fields()[38], value);
      this.RESERVATION_AMT = value;
      fieldSetFlags()[38] = true;
      return this;
    }

    /**
      * Checks whether the 'RESERVATION_AMT' field has been set.
      * @return True if the 'RESERVATION_AMT' field has been set, false otherwise.
      */
    public boolean hasRESERVATIONAMT() {
      return fieldSetFlags()[38];
    }


    /**
      * Clears the value of the 'RESERVATION_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRESERVATIONAMT() {
      RESERVATION_AMT = null;
      fieldSetFlags()[38] = false;
      return this;
    }

    /**
      * Gets the value of the 'RESTRICT_MODIFY_IND' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getRESTRICTMODIFYIND() {
      return RESTRICT_MODIFY_IND;
    }

    /**
      * Sets the value of the 'RESTRICT_MODIFY_IND' field.
      * @param value The value of 'RESTRICT_MODIFY_IND'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRESTRICTMODIFYIND(java.nio.ByteBuffer value) {
      validate(fields()[39], value);
      this.RESTRICT_MODIFY_IND = value;
      fieldSetFlags()[39] = true;
      return this;
    }

    /**
      * Checks whether the 'RESTRICT_MODIFY_IND' field has been set.
      * @return True if the 'RESTRICT_MODIFY_IND' field has been set, false otherwise.
      */
    public boolean hasRESTRICTMODIFYIND() {
      return fieldSetFlags()[39];
    }


    /**
      * Clears the value of the 'RESTRICT_MODIFY_IND' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRESTRICTMODIFYIND() {
      RESTRICT_MODIFY_IND = null;
      fieldSetFlags()[39] = false;
      return this;
    }

    /**
      * Gets the value of the 'LCHG_USER_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getLCHGUSERID() {
      return LCHG_USER_ID;
    }

    /**
      * Sets the value of the 'LCHG_USER_ID' field.
      * @param value The value of 'LCHG_USER_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setLCHGUSERID(java.nio.ByteBuffer value) {
      validate(fields()[40], value);
      this.LCHG_USER_ID = value;
      fieldSetFlags()[40] = true;
      return this;
    }

    /**
      * Checks whether the 'LCHG_USER_ID' field has been set.
      * @return True if the 'LCHG_USER_ID' field has been set, false otherwise.
      */
    public boolean hasLCHGUSERID() {
      return fieldSetFlags()[40];
    }


    /**
      * Clears the value of the 'LCHG_USER_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearLCHGUSERID() {
      LCHG_USER_ID = null;
      fieldSetFlags()[40] = false;
      return this;
    }

    /**
      * Gets the value of the 'LCHG_TIME' field.
      * @return The value.
      */
    public java.lang.CharSequence getLCHGTIME() {
      return LCHG_TIME;
    }

    /**
      * Sets the value of the 'LCHG_TIME' field.
      * @param value The value of 'LCHG_TIME'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setLCHGTIME(java.lang.CharSequence value) {
      validate(fields()[41], value);
      this.LCHG_TIME = value;
      fieldSetFlags()[41] = true;
      return this;
    }

    /**
      * Checks whether the 'LCHG_TIME' field has been set.
      * @return True if the 'LCHG_TIME' field has been set, false otherwise.
      */
    public boolean hasLCHGTIME() {
      return fieldSetFlags()[41];
    }


    /**
      * Clears the value of the 'LCHG_TIME' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearLCHGTIME() {
      LCHG_TIME = null;
      fieldSetFlags()[41] = false;
      return this;
    }

    /**
      * Gets the value of the 'RCRE_USER_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getRCREUSERID() {
      return RCRE_USER_ID;
    }

    /**
      * Sets the value of the 'RCRE_USER_ID' field.
      * @param value The value of 'RCRE_USER_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRCREUSERID(java.nio.ByteBuffer value) {
      validate(fields()[42], value);
      this.RCRE_USER_ID = value;
      fieldSetFlags()[42] = true;
      return this;
    }

    /**
      * Checks whether the 'RCRE_USER_ID' field has been set.
      * @return True if the 'RCRE_USER_ID' field has been set, false otherwise.
      */
    public boolean hasRCREUSERID() {
      return fieldSetFlags()[42];
    }


    /**
      * Clears the value of the 'RCRE_USER_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRCREUSERID() {
      RCRE_USER_ID = null;
      fieldSetFlags()[42] = false;
      return this;
    }

    /**
      * Gets the value of the 'RCRE_TIME' field.
      * @return The value.
      */
    public java.lang.CharSequence getRCRETIME() {
      return RCRE_TIME;
    }

    /**
      * Sets the value of the 'RCRE_TIME' field.
      * @param value The value of 'RCRE_TIME'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRCRETIME(java.lang.CharSequence value) {
      validate(fields()[43], value);
      this.RCRE_TIME = value;
      fieldSetFlags()[43] = true;
      return this;
    }

    /**
      * Checks whether the 'RCRE_TIME' field has been set.
      * @return True if the 'RCRE_TIME' field has been set, false otherwise.
      */
    public boolean hasRCRETIME() {
      return fieldSetFlags()[43];
    }


    /**
      * Clears the value of the 'RCRE_TIME' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRCRETIME() {
      RCRE_TIME = null;
      fieldSetFlags()[43] = false;
      return this;
    }

    /**
      * Gets the value of the 'CUST_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getCUSTID() {
      return CUST_ID;
    }

    /**
      * Sets the value of the 'CUST_ID' field.
      * @param value The value of 'CUST_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setCUSTID(java.nio.ByteBuffer value) {
      validate(fields()[44], value);
      this.CUST_ID = value;
      fieldSetFlags()[44] = true;
      return this;
    }

    /**
      * Checks whether the 'CUST_ID' field has been set.
      * @return True if the 'CUST_ID' field has been set, false otherwise.
      */
    public boolean hasCUSTID() {
      return fieldSetFlags()[44];
    }


    /**
      * Clears the value of the 'CUST_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearCUSTID() {
      CUST_ID = null;
      fieldSetFlags()[44] = false;
      return this;
    }

    /**
      * Gets the value of the 'VOUCHER_PRINT_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getVOUCHERPRINTFLG() {
      return VOUCHER_PRINT_FLG;
    }

    /**
      * Sets the value of the 'VOUCHER_PRINT_FLG' field.
      * @param value The value of 'VOUCHER_PRINT_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setVOUCHERPRINTFLG(java.nio.ByteBuffer value) {
      validate(fields()[45], value);
      this.VOUCHER_PRINT_FLG = value;
      fieldSetFlags()[45] = true;
      return this;
    }

    /**
      * Checks whether the 'VOUCHER_PRINT_FLG' field has been set.
      * @return True if the 'VOUCHER_PRINT_FLG' field has been set, false otherwise.
      */
    public boolean hasVOUCHERPRINTFLG() {
      return fieldSetFlags()[45];
    }


    /**
      * Clears the value of the 'VOUCHER_PRINT_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearVOUCHERPRINTFLG() {
      VOUCHER_PRINT_FLG = null;
      fieldSetFlags()[45] = false;
      return this;
    }

    /**
      * Gets the value of the 'MODULE_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getMODULEID() {
      return MODULE_ID;
    }

    /**
      * Sets the value of the 'MODULE_ID' field.
      * @param value The value of 'MODULE_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setMODULEID(java.nio.ByteBuffer value) {
      validate(fields()[46], value);
      this.MODULE_ID = value;
      fieldSetFlags()[46] = true;
      return this;
    }

    /**
      * Checks whether the 'MODULE_ID' field has been set.
      * @return True if the 'MODULE_ID' field has been set, false otherwise.
      */
    public boolean hasMODULEID() {
      return fieldSetFlags()[46];
    }


    /**
      * Clears the value of the 'MODULE_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearMODULEID() {
      MODULE_ID = null;
      fieldSetFlags()[46] = false;
      return this;
    }

    /**
      * Gets the value of the 'BR_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBRCODE() {
      return BR_CODE;
    }

    /**
      * Sets the value of the 'BR_CODE' field.
      * @param value The value of 'BR_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setBRCODE(java.nio.ByteBuffer value) {
      validate(fields()[47], value);
      this.BR_CODE = value;
      fieldSetFlags()[47] = true;
      return this;
    }

    /**
      * Checks whether the 'BR_CODE' field has been set.
      * @return True if the 'BR_CODE' field has been set, false otherwise.
      */
    public boolean hasBRCODE() {
      return fieldSetFlags()[47];
    }


    /**
      * Clears the value of the 'BR_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearBRCODE() {
      BR_CODE = null;
      fieldSetFlags()[47] = false;
      return this;
    }

    /**
      * Gets the value of the 'FX_TRAN_AMT' field.
      * @return The value.
      */
    public java.lang.Double getFXTRANAMT() {
      return FX_TRAN_AMT;
    }

    /**
      * Sets the value of the 'FX_TRAN_AMT' field.
      * @param value The value of 'FX_TRAN_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setFXTRANAMT(java.lang.Double value) {
      validate(fields()[48], value);
      this.FX_TRAN_AMT = value;
      fieldSetFlags()[48] = true;
      return this;
    }

    /**
      * Checks whether the 'FX_TRAN_AMT' field has been set.
      * @return True if the 'FX_TRAN_AMT' field has been set, false otherwise.
      */
    public boolean hasFXTRANAMT() {
      return fieldSetFlags()[48];
    }


    /**
      * Clears the value of the 'FX_TRAN_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearFXTRANAMT() {
      FX_TRAN_AMT = null;
      fieldSetFlags()[48] = false;
      return this;
    }

    /**
      * Gets the value of the 'RATE_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getRATECODE() {
      return RATE_CODE;
    }

    /**
      * Sets the value of the 'RATE_CODE' field.
      * @param value The value of 'RATE_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRATECODE(java.nio.ByteBuffer value) {
      validate(fields()[49], value);
      this.RATE_CODE = value;
      fieldSetFlags()[49] = true;
      return this;
    }

    /**
      * Checks whether the 'RATE_CODE' field has been set.
      * @return True if the 'RATE_CODE' field has been set, false otherwise.
      */
    public boolean hasRATECODE() {
      return fieldSetFlags()[49];
    }


    /**
      * Clears the value of the 'RATE_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRATECODE() {
      RATE_CODE = null;
      fieldSetFlags()[49] = false;
      return this;
    }

    /**
      * Gets the value of the 'RATE' field.
      * @return The value.
      */
    public java.lang.Double getRATE() {
      return RATE;
    }

    /**
      * Sets the value of the 'RATE' field.
      * @param value The value of 'RATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setRATE(java.lang.Double value) {
      validate(fields()[50], value);
      this.RATE = value;
      fieldSetFlags()[50] = true;
      return this;
    }

    /**
      * Checks whether the 'RATE' field has been set.
      * @return True if the 'RATE' field has been set, false otherwise.
      */
    public boolean hasRATE() {
      return fieldSetFlags()[50];
    }


    /**
      * Clears the value of the 'RATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearRATE() {
      RATE = null;
      fieldSetFlags()[50] = false;
      return this;
    }

    /**
      * Gets the value of the 'CRNCY_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getCRNCYCODE() {
      return CRNCY_CODE;
    }

    /**
      * Sets the value of the 'CRNCY_CODE' field.
      * @param value The value of 'CRNCY_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setCRNCYCODE(java.nio.ByteBuffer value) {
      validate(fields()[51], value);
      this.CRNCY_CODE = value;
      fieldSetFlags()[51] = true;
      return this;
    }

    /**
      * Checks whether the 'CRNCY_CODE' field has been set.
      * @return True if the 'CRNCY_CODE' field has been set, false otherwise.
      */
    public boolean hasCRNCYCODE() {
      return fieldSetFlags()[51];
    }


    /**
      * Clears the value of the 'CRNCY_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearCRNCYCODE() {
      CRNCY_CODE = null;
      fieldSetFlags()[51] = false;
      return this;
    }

    /**
      * Gets the value of the 'NAVIGATION_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getNAVIGATIONFLG() {
      return NAVIGATION_FLG;
    }

    /**
      * Sets the value of the 'NAVIGATION_FLG' field.
      * @param value The value of 'NAVIGATION_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setNAVIGATIONFLG(java.nio.ByteBuffer value) {
      validate(fields()[52], value);
      this.NAVIGATION_FLG = value;
      fieldSetFlags()[52] = true;
      return this;
    }

    /**
      * Checks whether the 'NAVIGATION_FLG' field has been set.
      * @return True if the 'NAVIGATION_FLG' field has been set, false otherwise.
      */
    public boolean hasNAVIGATIONFLG() {
      return fieldSetFlags()[52];
    }


    /**
      * Clears the value of the 'NAVIGATION_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearNAVIGATIONFLG() {
      NAVIGATION_FLG = null;
      fieldSetFlags()[52] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_CRNCY_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANCRNCYCODE() {
      return TRAN_CRNCY_CODE;
    }

    /**
      * Sets the value of the 'TRAN_CRNCY_CODE' field.
      * @param value The value of 'TRAN_CRNCY_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANCRNCYCODE(java.nio.ByteBuffer value) {
      validate(fields()[53], value);
      this.TRAN_CRNCY_CODE = value;
      fieldSetFlags()[53] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_CRNCY_CODE' field has been set.
      * @return True if the 'TRAN_CRNCY_CODE' field has been set, false otherwise.
      */
    public boolean hasTRANCRNCYCODE() {
      return fieldSetFlags()[53];
    }


    /**
      * Clears the value of the 'TRAN_CRNCY_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANCRNCYCODE() {
      TRAN_CRNCY_CODE = null;
      fieldSetFlags()[53] = false;
      return this;
    }

    /**
      * Gets the value of the 'REF_CRNCY_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getREFCRNCYCODE() {
      return REF_CRNCY_CODE;
    }

    /**
      * Sets the value of the 'REF_CRNCY_CODE' field.
      * @param value The value of 'REF_CRNCY_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREFCRNCYCODE(java.nio.ByteBuffer value) {
      validate(fields()[54], value);
      this.REF_CRNCY_CODE = value;
      fieldSetFlags()[54] = true;
      return this;
    }

    /**
      * Checks whether the 'REF_CRNCY_CODE' field has been set.
      * @return True if the 'REF_CRNCY_CODE' field has been set, false otherwise.
      */
    public boolean hasREFCRNCYCODE() {
      return fieldSetFlags()[54];
    }


    /**
      * Clears the value of the 'REF_CRNCY_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREFCRNCYCODE() {
      REF_CRNCY_CODE = null;
      fieldSetFlags()[54] = false;
      return this;
    }

    /**
      * Gets the value of the 'REF_AMT' field.
      * @return The value.
      */
    public java.lang.Double getREFAMT() {
      return REF_AMT;
    }

    /**
      * Sets the value of the 'REF_AMT' field.
      * @param value The value of 'REF_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREFAMT(java.lang.Double value) {
      validate(fields()[55], value);
      this.REF_AMT = value;
      fieldSetFlags()[55] = true;
      return this;
    }

    /**
      * Checks whether the 'REF_AMT' field has been set.
      * @return True if the 'REF_AMT' field has been set, false otherwise.
      */
    public boolean hasREFAMT() {
      return fieldSetFlags()[55];
    }


    /**
      * Clears the value of the 'REF_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREFAMT() {
      REF_AMT = null;
      fieldSetFlags()[55] = false;
      return this;
    }

    /**
      * Gets the value of the 'SOL_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSOLID() {
      return SOL_ID;
    }

    /**
      * Sets the value of the 'SOL_ID' field.
      * @param value The value of 'SOL_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSOLID(java.nio.ByteBuffer value) {
      validate(fields()[56], value);
      this.SOL_ID = value;
      fieldSetFlags()[56] = true;
      return this;
    }

    /**
      * Checks whether the 'SOL_ID' field has been set.
      * @return True if the 'SOL_ID' field has been set, false otherwise.
      */
    public boolean hasSOLID() {
      return fieldSetFlags()[56];
    }


    /**
      * Clears the value of the 'SOL_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSOLID() {
      SOL_ID = null;
      fieldSetFlags()[56] = false;
      return this;
    }

    /**
      * Gets the value of the 'BANK_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBANKCODE() {
      return BANK_CODE;
    }

    /**
      * Sets the value of the 'BANK_CODE' field.
      * @param value The value of 'BANK_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setBANKCODE(java.nio.ByteBuffer value) {
      validate(fields()[57], value);
      this.BANK_CODE = value;
      fieldSetFlags()[57] = true;
      return this;
    }

    /**
      * Checks whether the 'BANK_CODE' field has been set.
      * @return True if the 'BANK_CODE' field has been set, false otherwise.
      */
    public boolean hasBANKCODE() {
      return fieldSetFlags()[57];
    }


    /**
      * Clears the value of the 'BANK_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearBANKCODE() {
      BANK_CODE = null;
      fieldSetFlags()[57] = false;
      return this;
    }

    /**
      * Gets the value of the 'TREA_REF_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTREAREFNUM() {
      return TREA_REF_NUM;
    }

    /**
      * Sets the value of the 'TREA_REF_NUM' field.
      * @param value The value of 'TREA_REF_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTREAREFNUM(java.nio.ByteBuffer value) {
      validate(fields()[58], value);
      this.TREA_REF_NUM = value;
      fieldSetFlags()[58] = true;
      return this;
    }

    /**
      * Checks whether the 'TREA_REF_NUM' field has been set.
      * @return True if the 'TREA_REF_NUM' field has been set, false otherwise.
      */
    public boolean hasTREAREFNUM() {
      return fieldSetFlags()[58];
    }


    /**
      * Clears the value of the 'TREA_REF_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTREAREFNUM() {
      TREA_REF_NUM = null;
      fieldSetFlags()[58] = false;
      return this;
    }

    /**
      * Gets the value of the 'TREA_RATE' field.
      * @return The value.
      */
    public java.lang.Double getTREARATE() {
      return TREA_RATE;
    }

    /**
      * Sets the value of the 'TREA_RATE' field.
      * @param value The value of 'TREA_RATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTREARATE(java.lang.Double value) {
      validate(fields()[59], value);
      this.TREA_RATE = value;
      fieldSetFlags()[59] = true;
      return this;
    }

    /**
      * Checks whether the 'TREA_RATE' field has been set.
      * @return True if the 'TREA_RATE' field has been set, false otherwise.
      */
    public boolean hasTREARATE() {
      return fieldSetFlags()[59];
    }


    /**
      * Clears the value of the 'TREA_RATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTREARATE() {
      TREA_RATE = null;
      fieldSetFlags()[59] = false;
      return this;
    }

    /**
      * Gets the value of the 'TS_CNT' field.
      * @return The value.
      */
    public java.lang.Long getTSCNT() {
      return TS_CNT;
    }

    /**
      * Sets the value of the 'TS_CNT' field.
      * @param value The value of 'TS_CNT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTSCNT(java.lang.Long value) {
      validate(fields()[60], value);
      this.TS_CNT = value;
      fieldSetFlags()[60] = true;
      return this;
    }

    /**
      * Checks whether the 'TS_CNT' field has been set.
      * @return True if the 'TS_CNT' field has been set, false otherwise.
      */
    public boolean hasTSCNT() {
      return fieldSetFlags()[60];
    }


    /**
      * Clears the value of the 'TS_CNT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTSCNT() {
      TS_CNT = null;
      fieldSetFlags()[60] = false;
      return this;
    }

    /**
      * Gets the value of the 'GST_UPD_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getGSTUPDFLG() {
      return GST_UPD_FLG;
    }

    /**
      * Sets the value of the 'GST_UPD_FLG' field.
      * @param value The value of 'GST_UPD_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setGSTUPDFLG(java.nio.ByteBuffer value) {
      validate(fields()[61], value);
      this.GST_UPD_FLG = value;
      fieldSetFlags()[61] = true;
      return this;
    }

    /**
      * Checks whether the 'GST_UPD_FLG' field has been set.
      * @return True if the 'GST_UPD_FLG' field has been set, false otherwise.
      */
    public boolean hasGSTUPDFLG() {
      return fieldSetFlags()[61];
    }


    /**
      * Clears the value of the 'GST_UPD_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearGSTUPDFLG() {
      GST_UPD_FLG = null;
      fieldSetFlags()[61] = false;
      return this;
    }

    /**
      * Gets the value of the 'ISO_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getISOFLG() {
      return ISO_FLG;
    }

    /**
      * Sets the value of the 'ISO_FLG' field.
      * @param value The value of 'ISO_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setISOFLG(java.nio.ByteBuffer value) {
      validate(fields()[62], value);
      this.ISO_FLG = value;
      fieldSetFlags()[62] = true;
      return this;
    }

    /**
      * Checks whether the 'ISO_FLG' field has been set.
      * @return True if the 'ISO_FLG' field has been set, false otherwise.
      */
    public boolean hasISOFLG() {
      return fieldSetFlags()[62];
    }


    /**
      * Clears the value of the 'ISO_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearISOFLG() {
      ISO_FLG = null;
      fieldSetFlags()[62] = false;
      return this;
    }

    /**
      * Gets the value of the 'EABFAB_UPD_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getEABFABUPDFLG() {
      return EABFAB_UPD_FLG;
    }

    /**
      * Sets the value of the 'EABFAB_UPD_FLG' field.
      * @param value The value of 'EABFAB_UPD_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setEABFABUPDFLG(java.nio.ByteBuffer value) {
      validate(fields()[63], value);
      this.EABFAB_UPD_FLG = value;
      fieldSetFlags()[63] = true;
      return this;
    }

    /**
      * Checks whether the 'EABFAB_UPD_FLG' field has been set.
      * @return True if the 'EABFAB_UPD_FLG' field has been set, false otherwise.
      */
    public boolean hasEABFABUPDFLG() {
      return fieldSetFlags()[63];
    }


    /**
      * Clears the value of the 'EABFAB_UPD_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearEABFABUPDFLG() {
      EABFAB_UPD_FLG = null;
      fieldSetFlags()[63] = false;
      return this;
    }

    /**
      * Gets the value of the 'LIFT_LIEN_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getLIFTLIENFLG() {
      return LIFT_LIEN_FLG;
    }

    /**
      * Sets the value of the 'LIFT_LIEN_FLG' field.
      * @param value The value of 'LIFT_LIEN_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setLIFTLIENFLG(java.nio.ByteBuffer value) {
      validate(fields()[64], value);
      this.LIFT_LIEN_FLG = value;
      fieldSetFlags()[64] = true;
      return this;
    }

    /**
      * Checks whether the 'LIFT_LIEN_FLG' field has been set.
      * @return True if the 'LIFT_LIEN_FLG' field has been set, false otherwise.
      */
    public boolean hasLIFTLIENFLG() {
      return fieldSetFlags()[64];
    }


    /**
      * Clears the value of the 'LIFT_LIEN_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearLIFTLIENFLG() {
      LIFT_LIEN_FLG = null;
      fieldSetFlags()[64] = false;
      return this;
    }

    /**
      * Gets the value of the 'PROXY_POST_IND' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPROXYPOSTIND() {
      return PROXY_POST_IND;
    }

    /**
      * Sets the value of the 'PROXY_POST_IND' field.
      * @param value The value of 'PROXY_POST_IND'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPROXYPOSTIND(java.nio.ByteBuffer value) {
      validate(fields()[65], value);
      this.PROXY_POST_IND = value;
      fieldSetFlags()[65] = true;
      return this;
    }

    /**
      * Checks whether the 'PROXY_POST_IND' field has been set.
      * @return True if the 'PROXY_POST_IND' field has been set, false otherwise.
      */
    public boolean hasPROXYPOSTIND() {
      return fieldSetFlags()[65];
    }


    /**
      * Clears the value of the 'PROXY_POST_IND' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPROXYPOSTIND() {
      PROXY_POST_IND = null;
      fieldSetFlags()[65] = false;
      return this;
    }

    /**
      * Gets the value of the 'SI_SRL_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSISRLNUM() {
      return SI_SRL_NUM;
    }

    /**
      * Sets the value of the 'SI_SRL_NUM' field.
      * @param value The value of 'SI_SRL_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSISRLNUM(java.nio.ByteBuffer value) {
      validate(fields()[66], value);
      this.SI_SRL_NUM = value;
      fieldSetFlags()[66] = true;
      return this;
    }

    /**
      * Checks whether the 'SI_SRL_NUM' field has been set.
      * @return True if the 'SI_SRL_NUM' field has been set, false otherwise.
      */
    public boolean hasSISRLNUM() {
      return fieldSetFlags()[66];
    }


    /**
      * Clears the value of the 'SI_SRL_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSISRLNUM() {
      SI_SRL_NUM = null;
      fieldSetFlags()[66] = false;
      return this;
    }

    /**
      * Gets the value of the 'SI_ORG_EXEC_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getSIORGEXECDATE() {
      return SI_ORG_EXEC_DATE;
    }

    /**
      * Sets the value of the 'SI_ORG_EXEC_DATE' field.
      * @param value The value of 'SI_ORG_EXEC_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSIORGEXECDATE(java.lang.CharSequence value) {
      validate(fields()[67], value);
      this.SI_ORG_EXEC_DATE = value;
      fieldSetFlags()[67] = true;
      return this;
    }

    /**
      * Checks whether the 'SI_ORG_EXEC_DATE' field has been set.
      * @return True if the 'SI_ORG_EXEC_DATE' field has been set, false otherwise.
      */
    public boolean hasSIORGEXECDATE() {
      return fieldSetFlags()[67];
    }


    /**
      * Clears the value of the 'SI_ORG_EXEC_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSIORGEXECDATE() {
      SI_ORG_EXEC_DATE = null;
      fieldSetFlags()[67] = false;
      return this;
    }

    /**
      * Gets the value of the 'PR_SRL_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPRSRLNUM() {
      return PR_SRL_NUM;
    }

    /**
      * Sets the value of the 'PR_SRL_NUM' field.
      * @param value The value of 'PR_SRL_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPRSRLNUM(java.nio.ByteBuffer value) {
      validate(fields()[68], value);
      this.PR_SRL_NUM = value;
      fieldSetFlags()[68] = true;
      return this;
    }

    /**
      * Checks whether the 'PR_SRL_NUM' field has been set.
      * @return True if the 'PR_SRL_NUM' field has been set, false otherwise.
      */
    public boolean hasPRSRLNUM() {
      return fieldSetFlags()[68];
    }


    /**
      * Clears the value of the 'PR_SRL_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPRSRLNUM() {
      PR_SRL_NUM = null;
      fieldSetFlags()[68] = false;
      return this;
    }

    /**
      * Gets the value of the 'SERIAL_NUM' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSERIALNUM() {
      return SERIAL_NUM;
    }

    /**
      * Sets the value of the 'SERIAL_NUM' field.
      * @param value The value of 'SERIAL_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSERIALNUM(java.nio.ByteBuffer value) {
      validate(fields()[69], value);
      this.SERIAL_NUM = value;
      fieldSetFlags()[69] = true;
      return this;
    }

    /**
      * Checks whether the 'SERIAL_NUM' field has been set.
      * @return True if the 'SERIAL_NUM' field has been set, false otherwise.
      */
    public boolean hasSERIALNUM() {
      return fieldSetFlags()[69];
    }


    /**
      * Clears the value of the 'SERIAL_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSERIALNUM() {
      SERIAL_NUM = null;
      fieldSetFlags()[69] = false;
      return this;
    }

    /**
      * Gets the value of the 'DEL_MEMO_PAD' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getDELMEMOPAD() {
      return DEL_MEMO_PAD;
    }

    /**
      * Sets the value of the 'DEL_MEMO_PAD' field.
      * @param value The value of 'DEL_MEMO_PAD'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setDELMEMOPAD(java.nio.ByteBuffer value) {
      validate(fields()[70], value);
      this.DEL_MEMO_PAD = value;
      fieldSetFlags()[70] = true;
      return this;
    }

    /**
      * Checks whether the 'DEL_MEMO_PAD' field has been set.
      * @return True if the 'DEL_MEMO_PAD' field has been set, false otherwise.
      */
    public boolean hasDELMEMOPAD() {
      return fieldSetFlags()[70];
    }


    /**
      * Clears the value of the 'DEL_MEMO_PAD' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearDELMEMOPAD() {
      DEL_MEMO_PAD = null;
      fieldSetFlags()[70] = false;
      return this;
    }

    /**
      * Gets the value of the 'UAD_MODULE_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getUADMODULEID() {
      return UAD_MODULE_ID;
    }

    /**
      * Sets the value of the 'UAD_MODULE_ID' field.
      * @param value The value of 'UAD_MODULE_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setUADMODULEID(java.nio.ByteBuffer value) {
      validate(fields()[71], value);
      this.UAD_MODULE_ID = value;
      fieldSetFlags()[71] = true;
      return this;
    }

    /**
      * Checks whether the 'UAD_MODULE_ID' field has been set.
      * @return True if the 'UAD_MODULE_ID' field has been set, false otherwise.
      */
    public boolean hasUADMODULEID() {
      return fieldSetFlags()[71];
    }


    /**
      * Clears the value of the 'UAD_MODULE_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearUADMODULEID() {
      UAD_MODULE_ID = null;
      fieldSetFlags()[71] = false;
      return this;
    }

    /**
      * Gets the value of the 'UAD_MODULE_KEY' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getUADMODULEKEY() {
      return UAD_MODULE_KEY;
    }

    /**
      * Sets the value of the 'UAD_MODULE_KEY' field.
      * @param value The value of 'UAD_MODULE_KEY'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setUADMODULEKEY(java.nio.ByteBuffer value) {
      validate(fields()[72], value);
      this.UAD_MODULE_KEY = value;
      fieldSetFlags()[72] = true;
      return this;
    }

    /**
      * Checks whether the 'UAD_MODULE_KEY' field has been set.
      * @return True if the 'UAD_MODULE_KEY' field has been set, false otherwise.
      */
    public boolean hasUADMODULEKEY() {
      return fieldSetFlags()[72];
    }


    /**
      * Clears the value of the 'UAD_MODULE_KEY' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearUADMODULEKEY() {
      UAD_MODULE_KEY = null;
      fieldSetFlags()[72] = false;
      return this;
    }

    /**
      * Gets the value of the 'REVERSAL_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getREVERSALDATE() {
      return REVERSAL_DATE;
    }

    /**
      * Sets the value of the 'REVERSAL_DATE' field.
      * @param value The value of 'REVERSAL_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREVERSALDATE(java.lang.CharSequence value) {
      validate(fields()[73], value);
      this.REVERSAL_DATE = value;
      fieldSetFlags()[73] = true;
      return this;
    }

    /**
      * Checks whether the 'REVERSAL_DATE' field has been set.
      * @return True if the 'REVERSAL_DATE' field has been set, false otherwise.
      */
    public boolean hasREVERSALDATE() {
      return fieldSetFlags()[73];
    }


    /**
      * Clears the value of the 'REVERSAL_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREVERSALDATE() {
      REVERSAL_DATE = null;
      fieldSetFlags()[73] = false;
      return this;
    }

    /**
      * Gets the value of the 'REVERSAL_VALUE_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getREVERSALVALUEDATE() {
      return REVERSAL_VALUE_DATE;
    }

    /**
      * Sets the value of the 'REVERSAL_VALUE_DATE' field.
      * @param value The value of 'REVERSAL_VALUE_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREVERSALVALUEDATE(java.lang.CharSequence value) {
      validate(fields()[74], value);
      this.REVERSAL_VALUE_DATE = value;
      fieldSetFlags()[74] = true;
      return this;
    }

    /**
      * Checks whether the 'REVERSAL_VALUE_DATE' field has been set.
      * @return True if the 'REVERSAL_VALUE_DATE' field has been set, false otherwise.
      */
    public boolean hasREVERSALVALUEDATE() {
      return fieldSetFlags()[74];
    }


    /**
      * Clears the value of the 'REVERSAL_VALUE_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREVERSALVALUEDATE() {
      REVERSAL_VALUE_DATE = null;
      fieldSetFlags()[74] = false;
      return this;
    }

    /**
      * Gets the value of the 'PTTM_EVENT_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPTTMEVENTTYPE() {
      return PTTM_EVENT_TYPE;
    }

    /**
      * Sets the value of the 'PTTM_EVENT_TYPE' field.
      * @param value The value of 'PTTM_EVENT_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPTTMEVENTTYPE(java.nio.ByteBuffer value) {
      validate(fields()[75], value);
      this.PTTM_EVENT_TYPE = value;
      fieldSetFlags()[75] = true;
      return this;
    }

    /**
      * Checks whether the 'PTTM_EVENT_TYPE' field has been set.
      * @return True if the 'PTTM_EVENT_TYPE' field has been set, false otherwise.
      */
    public boolean hasPTTMEVENTTYPE() {
      return fieldSetFlags()[75];
    }


    /**
      * Clears the value of the 'PTTM_EVENT_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPTTMEVENTTYPE() {
      PTTM_EVENT_TYPE = null;
      fieldSetFlags()[75] = false;
      return this;
    }

    /**
      * Gets the value of the 'PROXY_ACID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPROXYACID() {
      return PROXY_ACID;
    }

    /**
      * Sets the value of the 'PROXY_ACID' field.
      * @param value The value of 'PROXY_ACID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPROXYACID(java.nio.ByteBuffer value) {
      validate(fields()[76], value);
      this.PROXY_ACID = value;
      fieldSetFlags()[76] = true;
      return this;
    }

    /**
      * Checks whether the 'PROXY_ACID' field has been set.
      * @return True if the 'PROXY_ACID' field has been set, false otherwise.
      */
    public boolean hasPROXYACID() {
      return fieldSetFlags()[76];
    }


    /**
      * Clears the value of the 'PROXY_ACID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPROXYACID() {
      PROXY_ACID = null;
      fieldSetFlags()[76] = false;
      return this;
    }

    /**
      * Gets the value of the 'TOD_ENTITY_TYPE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTODENTITYTYPE() {
      return TOD_ENTITY_TYPE;
    }

    /**
      * Sets the value of the 'TOD_ENTITY_TYPE' field.
      * @param value The value of 'TOD_ENTITY_TYPE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTODENTITYTYPE(java.nio.ByteBuffer value) {
      validate(fields()[77], value);
      this.TOD_ENTITY_TYPE = value;
      fieldSetFlags()[77] = true;
      return this;
    }

    /**
      * Checks whether the 'TOD_ENTITY_TYPE' field has been set.
      * @return True if the 'TOD_ENTITY_TYPE' field has been set, false otherwise.
      */
    public boolean hasTODENTITYTYPE() {
      return fieldSetFlags()[77];
    }


    /**
      * Clears the value of the 'TOD_ENTITY_TYPE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTODENTITYTYPE() {
      TOD_ENTITY_TYPE = null;
      fieldSetFlags()[77] = false;
      return this;
    }

    /**
      * Gets the value of the 'TOD_ENTITY_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTODENTITYID() {
      return TOD_ENTITY_ID;
    }

    /**
      * Sets the value of the 'TOD_ENTITY_ID' field.
      * @param value The value of 'TOD_ENTITY_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTODENTITYID(java.nio.ByteBuffer value) {
      validate(fields()[78], value);
      this.TOD_ENTITY_ID = value;
      fieldSetFlags()[78] = true;
      return this;
    }

    /**
      * Checks whether the 'TOD_ENTITY_ID' field has been set.
      * @return True if the 'TOD_ENTITY_ID' field has been set, false otherwise.
      */
    public boolean hasTODENTITYID() {
      return fieldSetFlags()[78];
    }


    /**
      * Clears the value of the 'TOD_ENTITY_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTODENTITYID() {
      TOD_ENTITY_ID = null;
      fieldSetFlags()[78] = false;
      return this;
    }

    /**
      * Gets the value of the 'DTH_INIT_SOL_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getDTHINITSOLID() {
      return DTH_INIT_SOL_ID;
    }

    /**
      * Sets the value of the 'DTH_INIT_SOL_ID' field.
      * @param value The value of 'DTH_INIT_SOL_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setDTHINITSOLID(java.nio.ByteBuffer value) {
      validate(fields()[79], value);
      this.DTH_INIT_SOL_ID = value;
      fieldSetFlags()[79] = true;
      return this;
    }

    /**
      * Checks whether the 'DTH_INIT_SOL_ID' field has been set.
      * @return True if the 'DTH_INIT_SOL_ID' field has been set, false otherwise.
      */
    public boolean hasDTHINITSOLID() {
      return fieldSetFlags()[79];
    }


    /**
      * Clears the value of the 'DTH_INIT_SOL_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearDTHINITSOLID() {
      DTH_INIT_SOL_ID = null;
      fieldSetFlags()[79] = false;
      return this;
    }

    /**
      * Gets the value of the 'REGULARIZATION_AMT' field.
      * @return The value.
      */
    public java.lang.Double getREGULARIZATIONAMT() {
      return REGULARIZATION_AMT;
    }

    /**
      * Sets the value of the 'REGULARIZATION_AMT' field.
      * @param value The value of 'REGULARIZATION_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREGULARIZATIONAMT(java.lang.Double value) {
      validate(fields()[80], value);
      this.REGULARIZATION_AMT = value;
      fieldSetFlags()[80] = true;
      return this;
    }

    /**
      * Checks whether the 'REGULARIZATION_AMT' field has been set.
      * @return True if the 'REGULARIZATION_AMT' field has been set, false otherwise.
      */
    public boolean hasREGULARIZATIONAMT() {
      return fieldSetFlags()[80];
    }


    /**
      * Clears the value of the 'REGULARIZATION_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREGULARIZATIONAMT() {
      REGULARIZATION_AMT = null;
      fieldSetFlags()[80] = false;
      return this;
    }

    /**
      * Gets the value of the 'PRINCIPAL_PORTION_AMT' field.
      * @return The value.
      */
    public java.lang.Double getPRINCIPALPORTIONAMT() {
      return PRINCIPAL_PORTION_AMT;
    }

    /**
      * Sets the value of the 'PRINCIPAL_PORTION_AMT' field.
      * @param value The value of 'PRINCIPAL_PORTION_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPRINCIPALPORTIONAMT(java.lang.Double value) {
      validate(fields()[81], value);
      this.PRINCIPAL_PORTION_AMT = value;
      fieldSetFlags()[81] = true;
      return this;
    }

    /**
      * Checks whether the 'PRINCIPAL_PORTION_AMT' field has been set.
      * @return True if the 'PRINCIPAL_PORTION_AMT' field has been set, false otherwise.
      */
    public boolean hasPRINCIPALPORTIONAMT() {
      return fieldSetFlags()[81];
    }


    /**
      * Clears the value of the 'PRINCIPAL_PORTION_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPRINCIPALPORTIONAMT() {
      PRINCIPAL_PORTION_AMT = null;
      fieldSetFlags()[81] = false;
      return this;
    }

    /**
      * Gets the value of the 'TF_ENTITY_SOL_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTFENTITYSOLID() {
      return TF_ENTITY_SOL_ID;
    }

    /**
      * Sets the value of the 'TF_ENTITY_SOL_ID' field.
      * @param value The value of 'TF_ENTITY_SOL_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTFENTITYSOLID(java.nio.ByteBuffer value) {
      validate(fields()[82], value);
      this.TF_ENTITY_SOL_ID = value;
      fieldSetFlags()[82] = true;
      return this;
    }

    /**
      * Checks whether the 'TF_ENTITY_SOL_ID' field has been set.
      * @return True if the 'TF_ENTITY_SOL_ID' field has been set, false otherwise.
      */
    public boolean hasTFENTITYSOLID() {
      return fieldSetFlags()[82];
    }


    /**
      * Clears the value of the 'TF_ENTITY_SOL_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTFENTITYSOLID() {
      TF_ENTITY_SOL_ID = null;
      fieldSetFlags()[82] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_PARTICULAR_2' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANPARTICULAR2() {
      return TRAN_PARTICULAR_2;
    }

    /**
      * Sets the value of the 'TRAN_PARTICULAR_2' field.
      * @param value The value of 'TRAN_PARTICULAR_2'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANPARTICULAR2(java.nio.ByteBuffer value) {
      validate(fields()[83], value);
      this.TRAN_PARTICULAR_2 = value;
      fieldSetFlags()[83] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_PARTICULAR_2' field has been set.
      * @return True if the 'TRAN_PARTICULAR_2' field has been set, false otherwise.
      */
    public boolean hasTRANPARTICULAR2() {
      return fieldSetFlags()[83];
    }


    /**
      * Clears the value of the 'TRAN_PARTICULAR_2' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANPARTICULAR2() {
      TRAN_PARTICULAR_2 = null;
      fieldSetFlags()[83] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_PARTICULAR_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANPARTICULARCODE() {
      return TRAN_PARTICULAR_CODE;
    }

    /**
      * Sets the value of the 'TRAN_PARTICULAR_CODE' field.
      * @param value The value of 'TRAN_PARTICULAR_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANPARTICULARCODE(java.nio.ByteBuffer value) {
      validate(fields()[84], value);
      this.TRAN_PARTICULAR_CODE = value;
      fieldSetFlags()[84] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_PARTICULAR_CODE' field has been set.
      * @return True if the 'TRAN_PARTICULAR_CODE' field has been set, false otherwise.
      */
    public boolean hasTRANPARTICULARCODE() {
      return fieldSetFlags()[84];
    }


    /**
      * Clears the value of the 'TRAN_PARTICULAR_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANPARTICULARCODE() {
      TRAN_PARTICULAR_CODE = null;
      fieldSetFlags()[84] = false;
      return this;
    }

    /**
      * Gets the value of the 'TR_STATUS' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRSTATUS() {
      return TR_STATUS;
    }

    /**
      * Sets the value of the 'TR_STATUS' field.
      * @param value The value of 'TR_STATUS'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRSTATUS(java.nio.ByteBuffer value) {
      validate(fields()[85], value);
      this.TR_STATUS = value;
      fieldSetFlags()[85] = true;
      return this;
    }

    /**
      * Checks whether the 'TR_STATUS' field has been set.
      * @return True if the 'TR_STATUS' field has been set, false otherwise.
      */
    public boolean hasTRSTATUS() {
      return fieldSetFlags()[85];
    }


    /**
      * Clears the value of the 'TR_STATUS' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRSTATUS() {
      TR_STATUS = null;
      fieldSetFlags()[85] = false;
      return this;
    }

    /**
      * Gets the value of the 'SVS_TRAN_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSVSTRANID() {
      return SVS_TRAN_ID;
    }

    /**
      * Sets the value of the 'SVS_TRAN_ID' field.
      * @param value The value of 'SVS_TRAN_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSVSTRANID(java.nio.ByteBuffer value) {
      validate(fields()[86], value);
      this.SVS_TRAN_ID = value;
      fieldSetFlags()[86] = true;
      return this;
    }

    /**
      * Checks whether the 'SVS_TRAN_ID' field has been set.
      * @return True if the 'SVS_TRAN_ID' field has been set, false otherwise.
      */
    public boolean hasSVSTRANID() {
      return fieldSetFlags()[86];
    }


    /**
      * Clears the value of the 'SVS_TRAN_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSVSTRANID() {
      SVS_TRAN_ID = null;
      fieldSetFlags()[86] = false;
      return this;
    }

    /**
      * Gets the value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getCRNCYHOLCHKDONEFLG() {
      return CRNCY_HOL_CHK_DONE_FLG;
    }

    /**
      * Sets the value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
      * @param value The value of 'CRNCY_HOL_CHK_DONE_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setCRNCYHOLCHKDONEFLG(java.nio.ByteBuffer value) {
      validate(fields()[87], value);
      this.CRNCY_HOL_CHK_DONE_FLG = value;
      fieldSetFlags()[87] = true;
      return this;
    }

    /**
      * Checks whether the 'CRNCY_HOL_CHK_DONE_FLG' field has been set.
      * @return True if the 'CRNCY_HOL_CHK_DONE_FLG' field has been set, false otherwise.
      */
    public boolean hasCRNCYHOLCHKDONEFLG() {
      return fieldSetFlags()[87];
    }


    /**
      * Clears the value of the 'CRNCY_HOL_CHK_DONE_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearCRNCYHOLCHKDONEFLG() {
      CRNCY_HOL_CHK_DONE_FLG = null;
      fieldSetFlags()[87] = false;
      return this;
    }

    /**
      * Gets the value of the 'REFERRAL_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getREFERRALID() {
      return REFERRAL_ID;
    }

    /**
      * Sets the value of the 'REFERRAL_ID' field.
      * @param value The value of 'REFERRAL_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREFERRALID(java.nio.ByteBuffer value) {
      validate(fields()[88], value);
      this.REFERRAL_ID = value;
      fieldSetFlags()[88] = true;
      return this;
    }

    /**
      * Checks whether the 'REFERRAL_ID' field has been set.
      * @return True if the 'REFERRAL_ID' field has been set, false otherwise.
      */
    public boolean hasREFERRALID() {
      return fieldSetFlags()[88];
    }


    /**
      * Clears the value of the 'REFERRAL_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREFERRALID() {
      REFERRAL_ID = null;
      fieldSetFlags()[88] = false;
      return this;
    }

    /**
      * Gets the value of the 'PARTY_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPARTYCODE() {
      return PARTY_CODE;
    }

    /**
      * Sets the value of the 'PARTY_CODE' field.
      * @param value The value of 'PARTY_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPARTYCODE(java.nio.ByteBuffer value) {
      validate(fields()[89], value);
      this.PARTY_CODE = value;
      fieldSetFlags()[89] = true;
      return this;
    }

    /**
      * Checks whether the 'PARTY_CODE' field has been set.
      * @return True if the 'PARTY_CODE' field has been set, false otherwise.
      */
    public boolean hasPARTYCODE() {
      return fieldSetFlags()[89];
    }


    /**
      * Clears the value of the 'PARTY_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPARTYCODE() {
      PARTY_CODE = null;
      fieldSetFlags()[89] = false;
      return this;
    }

    /**
      * Gets the value of the 'GL_DATE' field.
      * @return The value.
      */
    public java.lang.CharSequence getGLDATE() {
      return GL_DATE;
    }

    /**
      * Sets the value of the 'GL_DATE' field.
      * @param value The value of 'GL_DATE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setGLDATE(java.lang.CharSequence value) {
      validate(fields()[90], value);
      this.GL_DATE = value;
      fieldSetFlags()[90] = true;
      return this;
    }

    /**
      * Checks whether the 'GL_DATE' field has been set.
      * @return True if the 'GL_DATE' field has been set, false otherwise.
      */
    public boolean hasGLDATE() {
      return fieldSetFlags()[90];
    }


    /**
      * Clears the value of the 'GL_DATE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearGLDATE() {
      GL_DATE = null;
      fieldSetFlags()[90] = false;
      return this;
    }

    /**
      * Gets the value of the 'BKDT_TRAN_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBKDTTRANFLG() {
      return BKDT_TRAN_FLG;
    }

    /**
      * Sets the value of the 'BKDT_TRAN_FLG' field.
      * @param value The value of 'BKDT_TRAN_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setBKDTTRANFLG(java.nio.ByteBuffer value) {
      validate(fields()[91], value);
      this.BKDT_TRAN_FLG = value;
      fieldSetFlags()[91] = true;
      return this;
    }

    /**
      * Checks whether the 'BKDT_TRAN_FLG' field has been set.
      * @return True if the 'BKDT_TRAN_FLG' field has been set, false otherwise.
      */
    public boolean hasBKDTTRANFLG() {
      return fieldSetFlags()[91];
    }


    /**
      * Clears the value of the 'BKDT_TRAN_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearBKDTTRANFLG() {
      BKDT_TRAN_FLG = null;
      fieldSetFlags()[91] = false;
      return this;
    }

    /**
      * Gets the value of the 'BANK_ID' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBANKID() {
      return BANK_ID;
    }

    /**
      * Sets the value of the 'BANK_ID' field.
      * @param value The value of 'BANK_ID'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setBANKID(java.nio.ByteBuffer value) {
      validate(fields()[92], value);
      this.BANK_ID = value;
      fieldSetFlags()[92] = true;
      return this;
    }

    /**
      * Checks whether the 'BANK_ID' field has been set.
      * @return True if the 'BANK_ID' field has been set, false otherwise.
      */
    public boolean hasBANKID() {
      return fieldSetFlags()[92];
    }


    /**
      * Clears the value of the 'BANK_ID' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearBANKID() {
      BANK_ID = null;
      fieldSetFlags()[92] = false;
      return this;
    }

    /**
      * Gets the value of the 'IMPL_CASH_PART_TRAN_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getIMPLCASHPARTTRANFLG() {
      return IMPL_CASH_PART_TRAN_FLG;
    }

    /**
      * Sets the value of the 'IMPL_CASH_PART_TRAN_FLG' field.
      * @param value The value of 'IMPL_CASH_PART_TRAN_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setIMPLCASHPARTTRANFLG(java.nio.ByteBuffer value) {
      validate(fields()[93], value);
      this.IMPL_CASH_PART_TRAN_FLG = value;
      fieldSetFlags()[93] = true;
      return this;
    }

    /**
      * Checks whether the 'IMPL_CASH_PART_TRAN_FLG' field has been set.
      * @return True if the 'IMPL_CASH_PART_TRAN_FLG' field has been set, false otherwise.
      */
    public boolean hasIMPLCASHPARTTRANFLG() {
      return fieldSetFlags()[93];
    }


    /**
      * Clears the value of the 'IMPL_CASH_PART_TRAN_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearIMPLCASHPARTTRANFLG() {
      IMPL_CASH_PART_TRAN_FLG = null;
      fieldSetFlags()[93] = false;
      return this;
    }

    /**
      * Gets the value of the 'PTRAN_CHRG_EXISTS_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getPTRANCHRGEXISTSFLG() {
      return PTRAN_CHRG_EXISTS_FLG;
    }

    /**
      * Sets the value of the 'PTRAN_CHRG_EXISTS_FLG' field.
      * @param value The value of 'PTRAN_CHRG_EXISTS_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPTRANCHRGEXISTSFLG(java.nio.ByteBuffer value) {
      validate(fields()[94], value);
      this.PTRAN_CHRG_EXISTS_FLG = value;
      fieldSetFlags()[94] = true;
      return this;
    }

    /**
      * Checks whether the 'PTRAN_CHRG_EXISTS_FLG' field has been set.
      * @return True if the 'PTRAN_CHRG_EXISTS_FLG' field has been set, false otherwise.
      */
    public boolean hasPTRANCHRGEXISTSFLG() {
      return fieldSetFlags()[94];
    }


    /**
      * Clears the value of the 'PTRAN_CHRG_EXISTS_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPTRANCHRGEXISTSFLG() {
      PTRAN_CHRG_EXISTS_FLG = null;
      fieldSetFlags()[94] = false;
      return this;
    }

    /**
      * Gets the value of the 'MUD_POOL_BAL_BUILD_FLG' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getMUDPOOLBALBUILDFLG() {
      return MUD_POOL_BAL_BUILD_FLG;
    }

    /**
      * Sets the value of the 'MUD_POOL_BAL_BUILD_FLG' field.
      * @param value The value of 'MUD_POOL_BAL_BUILD_FLG'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setMUDPOOLBALBUILDFLG(java.nio.ByteBuffer value) {
      validate(fields()[95], value);
      this.MUD_POOL_BAL_BUILD_FLG = value;
      fieldSetFlags()[95] = true;
      return this;
    }

    /**
      * Checks whether the 'MUD_POOL_BAL_BUILD_FLG' field has been set.
      * @return True if the 'MUD_POOL_BAL_BUILD_FLG' field has been set, false otherwise.
      */
    public boolean hasMUDPOOLBALBUILDFLG() {
      return fieldSetFlags()[95];
    }


    /**
      * Clears the value of the 'MUD_POOL_BAL_BUILD_FLG' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearMUDPOOLBALBUILDFLG() {
      MUD_POOL_BAL_BUILD_FLG = null;
      fieldSetFlags()[95] = false;
      return this;
    }

    /**
      * Gets the value of the 'GL_SEGMENT_STRING' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getGLSEGMENTSTRING() {
      return GL_SEGMENT_STRING;
    }

    /**
      * Sets the value of the 'GL_SEGMENT_STRING' field.
      * @param value The value of 'GL_SEGMENT_STRING'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setGLSEGMENTSTRING(java.nio.ByteBuffer value) {
      validate(fields()[96], value);
      this.GL_SEGMENT_STRING = value;
      fieldSetFlags()[96] = true;
      return this;
    }

    /**
      * Checks whether the 'GL_SEGMENT_STRING' field has been set.
      * @return True if the 'GL_SEGMENT_STRING' field has been set, false otherwise.
      */
    public boolean hasGLSEGMENTSTRING() {
      return fieldSetFlags()[96];
    }


    /**
      * Clears the value of the 'GL_SEGMENT_STRING' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearGLSEGMENTSTRING() {
      GL_SEGMENT_STRING = null;
      fieldSetFlags()[96] = false;
      return this;
    }

    /**
      * Gets the value of the 'SYS_PART_TRAN_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getSYSPARTTRANCODE() {
      return SYS_PART_TRAN_CODE;
    }

    /**
      * Sets the value of the 'SYS_PART_TRAN_CODE' field.
      * @param value The value of 'SYS_PART_TRAN_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setSYSPARTTRANCODE(java.nio.ByteBuffer value) {
      validate(fields()[97], value);
      this.SYS_PART_TRAN_CODE = value;
      fieldSetFlags()[97] = true;
      return this;
    }

    /**
      * Checks whether the 'SYS_PART_TRAN_CODE' field has been set.
      * @return True if the 'SYS_PART_TRAN_CODE' field has been set, false otherwise.
      */
    public boolean hasSYSPARTTRANCODE() {
      return fieldSetFlags()[97];
    }


    /**
      * Clears the value of the 'SYS_PART_TRAN_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearSYSPARTTRANCODE() {
      SYS_PART_TRAN_CODE = null;
      fieldSetFlags()[97] = false;
      return this;
    }

    /**
      * Gets the value of the 'USER_PART_TRAN_CODE' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getUSERPARTTRANCODE() {
      return USER_PART_TRAN_CODE;
    }

    /**
      * Sets the value of the 'USER_PART_TRAN_CODE' field.
      * @param value The value of 'USER_PART_TRAN_CODE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setUSERPARTTRANCODE(java.nio.ByteBuffer value) {
      validate(fields()[98], value);
      this.USER_PART_TRAN_CODE = value;
      fieldSetFlags()[98] = true;
      return this;
    }

    /**
      * Checks whether the 'USER_PART_TRAN_CODE' field has been set.
      * @return True if the 'USER_PART_TRAN_CODE' field has been set, false otherwise.
      */
    public boolean hasUSERPARTTRANCODE() {
      return fieldSetFlags()[98];
    }


    /**
      * Clears the value of the 'USER_PART_TRAN_CODE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearUSERPARTTRANCODE() {
      USER_PART_TRAN_CODE = null;
      fieldSetFlags()[98] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_FREE_CODE1' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANFREECODE1() {
      return TRAN_FREE_CODE1;
    }

    /**
      * Sets the value of the 'TRAN_FREE_CODE1' field.
      * @param value The value of 'TRAN_FREE_CODE1'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANFREECODE1(java.nio.ByteBuffer value) {
      validate(fields()[99], value);
      this.TRAN_FREE_CODE1 = value;
      fieldSetFlags()[99] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_FREE_CODE1' field has been set.
      * @return True if the 'TRAN_FREE_CODE1' field has been set, false otherwise.
      */
    public boolean hasTRANFREECODE1() {
      return fieldSetFlags()[99];
    }


    /**
      * Clears the value of the 'TRAN_FREE_CODE1' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANFREECODE1() {
      TRAN_FREE_CODE1 = null;
      fieldSetFlags()[99] = false;
      return this;
    }

    /**
      * Gets the value of the 'TRAN_FREE_CODE2' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getTRANFREECODE2() {
      return TRAN_FREE_CODE2;
    }

    /**
      * Sets the value of the 'TRAN_FREE_CODE2' field.
      * @param value The value of 'TRAN_FREE_CODE2'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setTRANFREECODE2(java.nio.ByteBuffer value) {
      validate(fields()[100], value);
      this.TRAN_FREE_CODE2 = value;
      fieldSetFlags()[100] = true;
      return this;
    }

    /**
      * Checks whether the 'TRAN_FREE_CODE2' field has been set.
      * @return True if the 'TRAN_FREE_CODE2' field has been set, false otherwise.
      */
    public boolean hasTRANFREECODE2() {
      return fieldSetFlags()[100];
    }


    /**
      * Clears the value of the 'TRAN_FREE_CODE2' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearTRANFREECODE2() {
      TRAN_FREE_CODE2 = null;
      fieldSetFlags()[100] = false;
      return this;
    }

    /**
      * Gets the value of the 'PSTD_SRL_NUM' field.
      * @return The value.
      */
    public java.lang.Long getPSTDSRLNUM() {
      return PSTD_SRL_NUM;
    }

    /**
      * Sets the value of the 'PSTD_SRL_NUM' field.
      * @param value The value of 'PSTD_SRL_NUM'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setPSTDSRLNUM(java.lang.Long value) {
      validate(fields()[101], value);
      this.PSTD_SRL_NUM = value;
      fieldSetFlags()[101] = true;
      return this;
    }

    /**
      * Checks whether the 'PSTD_SRL_NUM' field has been set.
      * @return True if the 'PSTD_SRL_NUM' field has been set, false otherwise.
      */
    public boolean hasPSTDSRLNUM() {
      return fieldSetFlags()[101];
    }


    /**
      * Clears the value of the 'PSTD_SRL_NUM' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearPSTDSRLNUM() {
      PSTD_SRL_NUM = null;
      fieldSetFlags()[101] = false;
      return this;
    }

    /**
      * Gets the value of the 'REVERSAL_STATUS' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getREVERSALSTATUS() {
      return REVERSAL_STATUS;
    }

    /**
      * Sets the value of the 'REVERSAL_STATUS' field.
      * @param value The value of 'REVERSAL_STATUS'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setREVERSALSTATUS(java.nio.ByteBuffer value) {
      validate(fields()[102], value);
      this.REVERSAL_STATUS = value;
      fieldSetFlags()[102] = true;
      return this;
    }

    /**
      * Checks whether the 'REVERSAL_STATUS' field has been set.
      * @return True if the 'REVERSAL_STATUS' field has been set, false otherwise.
      */
    public boolean hasREVERSALSTATUS() {
      return fieldSetFlags()[102];
    }


    /**
      * Clears the value of the 'REVERSAL_STATUS' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearREVERSALSTATUS() {
      REVERSAL_STATUS = null;
      fieldSetFlags()[102] = false;
      return this;
    }

    /**
      * Gets the value of the 'AVAILABLE_AMT' field.
      * @return The value.
      */
    public java.lang.Double getAVAILABLEAMT() {
      return AVAILABLE_AMT;
    }

    /**
      * Sets the value of the 'AVAILABLE_AMT' field.
      * @param value The value of 'AVAILABLE_AMT'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setAVAILABLEAMT(java.lang.Double value) {
      validate(fields()[103], value);
      this.AVAILABLE_AMT = value;
      fieldSetFlags()[103] = true;
      return this;
    }

    /**
      * Checks whether the 'AVAILABLE_AMT' field has been set.
      * @return True if the 'AVAILABLE_AMT' field has been set, false otherwise.
      */
    public boolean hasAVAILABLEAMT() {
      return fieldSetFlags()[103];
    }


    /**
      * Clears the value of the 'AVAILABLE_AMT' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearAVAILABLEAMT() {
      AVAILABLE_AMT = null;
      fieldSetFlags()[103] = false;
      return this;
    }

    /**
      * Gets the value of the 'ACCT_BALANCE' field.
      * @return The value.
      */
    public java.lang.Double getACCTBALANCE() {
      return ACCT_BALANCE;
    }

    /**
      * Sets the value of the 'ACCT_BALANCE' field.
      * @param value The value of 'ACCT_BALANCE'.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder setACCTBALANCE(java.lang.Double value) {
      validate(fields()[104], value);
      this.ACCT_BALANCE = value;
      fieldSetFlags()[104] = true;
      return this;
    }

    /**
      * Checks whether the 'ACCT_BALANCE' field has been set.
      * @return True if the 'ACCT_BALANCE' field has been set, false otherwise.
      */
    public boolean hasACCTBALANCE() {
      return fieldSetFlags()[104];
    }


    /**
      * Clears the value of the 'ACCT_BALANCE' field.
      * @return This builder.
      */
    public com.kotak.orchestrator.orchestrator.schema.BusinessEvent.Builder clearACCTBALANCE() {
      ACCT_BALANCE = null;
      fieldSetFlags()[104] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BusinessEvent build() {
      try {
        BusinessEvent record = new BusinessEvent();
        record.EFFECTIVE_BAL = fieldSetFlags()[0] ? this.EFFECTIVE_BAL : (java.lang.Double) defaultValue(fields()[0]);
        record.CLR_BAL = fieldSetFlags()[1] ? this.CLR_BAL : (java.lang.Double) defaultValue(fields()[1]);
        record.FORACID = fieldSetFlags()[2] ? this.FORACID : (java.nio.ByteBuffer) defaultValue(fields()[2]);
        record.LAST_BAL_UPDATED_DATE = fieldSetFlags()[3] ? this.LAST_BAL_UPDATED_DATE : (java.lang.Long) defaultValue(fields()[3]);
        record.SCHM_CODE = fieldSetFlags()[4] ? this.SCHM_CODE : (java.nio.ByteBuffer) defaultValue(fields()[4]);
        record.CIF_ID = fieldSetFlags()[5] ? this.CIF_ID : (java.nio.ByteBuffer) defaultValue(fields()[5]);
        record.ACCT_NAME = fieldSetFlags()[6] ? this.ACCT_NAME : (java.nio.ByteBuffer) defaultValue(fields()[6]);
        record.ACCT_SHORT_NAME = fieldSetFlags()[7] ? this.ACCT_SHORT_NAME : (java.nio.ByteBuffer) defaultValue(fields()[7]);
        record.SCHM_SUB_TYPE = fieldSetFlags()[8] ? this.SCHM_SUB_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[8]);
        record.SCHM_TYPE = fieldSetFlags()[9] ? this.SCHM_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[9]);
        record.TRAN_DATE = fieldSetFlags()[10] ? this.TRAN_DATE : (java.lang.CharSequence) defaultValue(fields()[10]);
        record.TRAN_ID = fieldSetFlags()[11] ? this.TRAN_ID : (java.nio.ByteBuffer) defaultValue(fields()[11]);
        record.PART_TRAN_SRL_NUM = fieldSetFlags()[12] ? this.PART_TRAN_SRL_NUM : (java.nio.ByteBuffer) defaultValue(fields()[12]);
        record.DEL_FLG = fieldSetFlags()[13] ? this.DEL_FLG : (java.nio.ByteBuffer) defaultValue(fields()[13]);
        record.TRAN_TYPE = fieldSetFlags()[14] ? this.TRAN_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[14]);
        record.TRAN_SUB_TYPE = fieldSetFlags()[15] ? this.TRAN_SUB_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[15]);
        record.PART_TRAN_TYPE = fieldSetFlags()[16] ? this.PART_TRAN_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[16]);
        record.GL_SUB_HEAD_CODE = fieldSetFlags()[17] ? this.GL_SUB_HEAD_CODE : (java.nio.ByteBuffer) defaultValue(fields()[17]);
        record.ACID = fieldSetFlags()[18] ? this.ACID : (java.nio.ByteBuffer) defaultValue(fields()[18]);
        record.VALUE_DATE = fieldSetFlags()[19] ? this.VALUE_DATE : (java.lang.CharSequence) defaultValue(fields()[19]);
        record.TRAN_AMT = fieldSetFlags()[20] ? this.TRAN_AMT : (java.lang.Double) defaultValue(fields()[20]);
        record.TRAN_PARTICULAR = fieldSetFlags()[21] ? this.TRAN_PARTICULAR : (java.nio.ByteBuffer) defaultValue(fields()[21]);
        record.ENTRY_USER_ID = fieldSetFlags()[22] ? this.ENTRY_USER_ID : (java.nio.ByteBuffer) defaultValue(fields()[22]);
        record.PSTD_USER_ID = fieldSetFlags()[23] ? this.PSTD_USER_ID : (java.nio.ByteBuffer) defaultValue(fields()[23]);
        record.VFD_USER_ID = fieldSetFlags()[24] ? this.VFD_USER_ID : (java.nio.ByteBuffer) defaultValue(fields()[24]);
        record.ENTRY_DATE = fieldSetFlags()[25] ? this.ENTRY_DATE : (java.lang.CharSequence) defaultValue(fields()[25]);
        record.PSTD_DATE = fieldSetFlags()[26] ? this.PSTD_DATE : (java.lang.CharSequence) defaultValue(fields()[26]);
        record.VFD_DATE = fieldSetFlags()[27] ? this.VFD_DATE : (java.lang.CharSequence) defaultValue(fields()[27]);
        record.RPT_CODE = fieldSetFlags()[28] ? this.RPT_CODE : (java.nio.ByteBuffer) defaultValue(fields()[28]);
        record.REF_NUM = fieldSetFlags()[29] ? this.REF_NUM : (java.nio.ByteBuffer) defaultValue(fields()[29]);
        record.INSTRMNT_TYPE = fieldSetFlags()[30] ? this.INSTRMNT_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[30]);
        record.INSTRMNT_DATE = fieldSetFlags()[31] ? this.INSTRMNT_DATE : (java.lang.CharSequence) defaultValue(fields()[31]);
        record.INSTRMNT_NUM = fieldSetFlags()[32] ? this.INSTRMNT_NUM : (java.nio.ByteBuffer) defaultValue(fields()[32]);
        record.INSTRMNT_ALPHA = fieldSetFlags()[33] ? this.INSTRMNT_ALPHA : (java.nio.ByteBuffer) defaultValue(fields()[33]);
        record.TRAN_RMKS = fieldSetFlags()[34] ? this.TRAN_RMKS : (java.nio.ByteBuffer) defaultValue(fields()[34]);
        record.PSTD_FLG = fieldSetFlags()[35] ? this.PSTD_FLG : (java.nio.ByteBuffer) defaultValue(fields()[35]);
        record.PRNT_ADVC_IND = fieldSetFlags()[36] ? this.PRNT_ADVC_IND : (java.nio.ByteBuffer) defaultValue(fields()[36]);
        record.AMT_RESERVATION_IND = fieldSetFlags()[37] ? this.AMT_RESERVATION_IND : (java.nio.ByteBuffer) defaultValue(fields()[37]);
        record.RESERVATION_AMT = fieldSetFlags()[38] ? this.RESERVATION_AMT : (java.lang.Double) defaultValue(fields()[38]);
        record.RESTRICT_MODIFY_IND = fieldSetFlags()[39] ? this.RESTRICT_MODIFY_IND : (java.nio.ByteBuffer) defaultValue(fields()[39]);
        record.LCHG_USER_ID = fieldSetFlags()[40] ? this.LCHG_USER_ID : (java.nio.ByteBuffer) defaultValue(fields()[40]);
        record.LCHG_TIME = fieldSetFlags()[41] ? this.LCHG_TIME : (java.lang.CharSequence) defaultValue(fields()[41]);
        record.RCRE_USER_ID = fieldSetFlags()[42] ? this.RCRE_USER_ID : (java.nio.ByteBuffer) defaultValue(fields()[42]);
        record.RCRE_TIME = fieldSetFlags()[43] ? this.RCRE_TIME : (java.lang.CharSequence) defaultValue(fields()[43]);
        record.CUST_ID = fieldSetFlags()[44] ? this.CUST_ID : (java.nio.ByteBuffer) defaultValue(fields()[44]);
        record.VOUCHER_PRINT_FLG = fieldSetFlags()[45] ? this.VOUCHER_PRINT_FLG : (java.nio.ByteBuffer) defaultValue(fields()[45]);
        record.MODULE_ID = fieldSetFlags()[46] ? this.MODULE_ID : (java.nio.ByteBuffer) defaultValue(fields()[46]);
        record.BR_CODE = fieldSetFlags()[47] ? this.BR_CODE : (java.nio.ByteBuffer) defaultValue(fields()[47]);
        record.FX_TRAN_AMT = fieldSetFlags()[48] ? this.FX_TRAN_AMT : (java.lang.Double) defaultValue(fields()[48]);
        record.RATE_CODE = fieldSetFlags()[49] ? this.RATE_CODE : (java.nio.ByteBuffer) defaultValue(fields()[49]);
        record.RATE = fieldSetFlags()[50] ? this.RATE : (java.lang.Double) defaultValue(fields()[50]);
        record.CRNCY_CODE = fieldSetFlags()[51] ? this.CRNCY_CODE : (java.nio.ByteBuffer) defaultValue(fields()[51]);
        record.NAVIGATION_FLG = fieldSetFlags()[52] ? this.NAVIGATION_FLG : (java.nio.ByteBuffer) defaultValue(fields()[52]);
        record.TRAN_CRNCY_CODE = fieldSetFlags()[53] ? this.TRAN_CRNCY_CODE : (java.nio.ByteBuffer) defaultValue(fields()[53]);
        record.REF_CRNCY_CODE = fieldSetFlags()[54] ? this.REF_CRNCY_CODE : (java.nio.ByteBuffer) defaultValue(fields()[54]);
        record.REF_AMT = fieldSetFlags()[55] ? this.REF_AMT : (java.lang.Double) defaultValue(fields()[55]);
        record.SOL_ID = fieldSetFlags()[56] ? this.SOL_ID : (java.nio.ByteBuffer) defaultValue(fields()[56]);
        record.BANK_CODE = fieldSetFlags()[57] ? this.BANK_CODE : (java.nio.ByteBuffer) defaultValue(fields()[57]);
        record.TREA_REF_NUM = fieldSetFlags()[58] ? this.TREA_REF_NUM : (java.nio.ByteBuffer) defaultValue(fields()[58]);
        record.TREA_RATE = fieldSetFlags()[59] ? this.TREA_RATE : (java.lang.Double) defaultValue(fields()[59]);
        record.TS_CNT = fieldSetFlags()[60] ? this.TS_CNT : (java.lang.Long) defaultValue(fields()[60]);
        record.GST_UPD_FLG = fieldSetFlags()[61] ? this.GST_UPD_FLG : (java.nio.ByteBuffer) defaultValue(fields()[61]);
        record.ISO_FLG = fieldSetFlags()[62] ? this.ISO_FLG : (java.nio.ByteBuffer) defaultValue(fields()[62]);
        record.EABFAB_UPD_FLG = fieldSetFlags()[63] ? this.EABFAB_UPD_FLG : (java.nio.ByteBuffer) defaultValue(fields()[63]);
        record.LIFT_LIEN_FLG = fieldSetFlags()[64] ? this.LIFT_LIEN_FLG : (java.nio.ByteBuffer) defaultValue(fields()[64]);
        record.PROXY_POST_IND = fieldSetFlags()[65] ? this.PROXY_POST_IND : (java.nio.ByteBuffer) defaultValue(fields()[65]);
        record.SI_SRL_NUM = fieldSetFlags()[66] ? this.SI_SRL_NUM : (java.nio.ByteBuffer) defaultValue(fields()[66]);
        record.SI_ORG_EXEC_DATE = fieldSetFlags()[67] ? this.SI_ORG_EXEC_DATE : (java.lang.CharSequence) defaultValue(fields()[67]);
        record.PR_SRL_NUM = fieldSetFlags()[68] ? this.PR_SRL_NUM : (java.nio.ByteBuffer) defaultValue(fields()[68]);
        record.SERIAL_NUM = fieldSetFlags()[69] ? this.SERIAL_NUM : (java.nio.ByteBuffer) defaultValue(fields()[69]);
        record.DEL_MEMO_PAD = fieldSetFlags()[70] ? this.DEL_MEMO_PAD : (java.nio.ByteBuffer) defaultValue(fields()[70]);
        record.UAD_MODULE_ID = fieldSetFlags()[71] ? this.UAD_MODULE_ID : (java.nio.ByteBuffer) defaultValue(fields()[71]);
        record.UAD_MODULE_KEY = fieldSetFlags()[72] ? this.UAD_MODULE_KEY : (java.nio.ByteBuffer) defaultValue(fields()[72]);
        record.REVERSAL_DATE = fieldSetFlags()[73] ? this.REVERSAL_DATE : (java.lang.CharSequence) defaultValue(fields()[73]);
        record.REVERSAL_VALUE_DATE = fieldSetFlags()[74] ? this.REVERSAL_VALUE_DATE : (java.lang.CharSequence) defaultValue(fields()[74]);
        record.PTTM_EVENT_TYPE = fieldSetFlags()[75] ? this.PTTM_EVENT_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[75]);
        record.PROXY_ACID = fieldSetFlags()[76] ? this.PROXY_ACID : (java.nio.ByteBuffer) defaultValue(fields()[76]);
        record.TOD_ENTITY_TYPE = fieldSetFlags()[77] ? this.TOD_ENTITY_TYPE : (java.nio.ByteBuffer) defaultValue(fields()[77]);
        record.TOD_ENTITY_ID = fieldSetFlags()[78] ? this.TOD_ENTITY_ID : (java.nio.ByteBuffer) defaultValue(fields()[78]);
        record.DTH_INIT_SOL_ID = fieldSetFlags()[79] ? this.DTH_INIT_SOL_ID : (java.nio.ByteBuffer) defaultValue(fields()[79]);
        record.REGULARIZATION_AMT = fieldSetFlags()[80] ? this.REGULARIZATION_AMT : (java.lang.Double) defaultValue(fields()[80]);
        record.PRINCIPAL_PORTION_AMT = fieldSetFlags()[81] ? this.PRINCIPAL_PORTION_AMT : (java.lang.Double) defaultValue(fields()[81]);
        record.TF_ENTITY_SOL_ID = fieldSetFlags()[82] ? this.TF_ENTITY_SOL_ID : (java.nio.ByteBuffer) defaultValue(fields()[82]);
        record.TRAN_PARTICULAR_2 = fieldSetFlags()[83] ? this.TRAN_PARTICULAR_2 : (java.nio.ByteBuffer) defaultValue(fields()[83]);
        record.TRAN_PARTICULAR_CODE = fieldSetFlags()[84] ? this.TRAN_PARTICULAR_CODE : (java.nio.ByteBuffer) defaultValue(fields()[84]);
        record.TR_STATUS = fieldSetFlags()[85] ? this.TR_STATUS : (java.nio.ByteBuffer) defaultValue(fields()[85]);
        record.SVS_TRAN_ID = fieldSetFlags()[86] ? this.SVS_TRAN_ID : (java.nio.ByteBuffer) defaultValue(fields()[86]);
        record.CRNCY_HOL_CHK_DONE_FLG = fieldSetFlags()[87] ? this.CRNCY_HOL_CHK_DONE_FLG : (java.nio.ByteBuffer) defaultValue(fields()[87]);
        record.REFERRAL_ID = fieldSetFlags()[88] ? this.REFERRAL_ID : (java.nio.ByteBuffer) defaultValue(fields()[88]);
        record.PARTY_CODE = fieldSetFlags()[89] ? this.PARTY_CODE : (java.nio.ByteBuffer) defaultValue(fields()[89]);
        record.GL_DATE = fieldSetFlags()[90] ? this.GL_DATE : (java.lang.CharSequence) defaultValue(fields()[90]);
        record.BKDT_TRAN_FLG = fieldSetFlags()[91] ? this.BKDT_TRAN_FLG : (java.nio.ByteBuffer) defaultValue(fields()[91]);
        record.BANK_ID = fieldSetFlags()[92] ? this.BANK_ID : (java.nio.ByteBuffer) defaultValue(fields()[92]);
        record.IMPL_CASH_PART_TRAN_FLG = fieldSetFlags()[93] ? this.IMPL_CASH_PART_TRAN_FLG : (java.nio.ByteBuffer) defaultValue(fields()[93]);
        record.PTRAN_CHRG_EXISTS_FLG = fieldSetFlags()[94] ? this.PTRAN_CHRG_EXISTS_FLG : (java.nio.ByteBuffer) defaultValue(fields()[94]);
        record.MUD_POOL_BAL_BUILD_FLG = fieldSetFlags()[95] ? this.MUD_POOL_BAL_BUILD_FLG : (java.nio.ByteBuffer) defaultValue(fields()[95]);
        record.GL_SEGMENT_STRING = fieldSetFlags()[96] ? this.GL_SEGMENT_STRING : (java.nio.ByteBuffer) defaultValue(fields()[96]);
        record.SYS_PART_TRAN_CODE = fieldSetFlags()[97] ? this.SYS_PART_TRAN_CODE : (java.nio.ByteBuffer) defaultValue(fields()[97]);
        record.USER_PART_TRAN_CODE = fieldSetFlags()[98] ? this.USER_PART_TRAN_CODE : (java.nio.ByteBuffer) defaultValue(fields()[98]);
        record.TRAN_FREE_CODE1 = fieldSetFlags()[99] ? this.TRAN_FREE_CODE1 : (java.nio.ByteBuffer) defaultValue(fields()[99]);
        record.TRAN_FREE_CODE2 = fieldSetFlags()[100] ? this.TRAN_FREE_CODE2 : (java.nio.ByteBuffer) defaultValue(fields()[100]);
        record.PSTD_SRL_NUM = fieldSetFlags()[101] ? this.PSTD_SRL_NUM : (java.lang.Long) defaultValue(fields()[101]);
        record.REVERSAL_STATUS = fieldSetFlags()[102] ? this.REVERSAL_STATUS : (java.nio.ByteBuffer) defaultValue(fields()[102]);
        record.AVAILABLE_AMT = fieldSetFlags()[103] ? this.AVAILABLE_AMT : (java.lang.Double) defaultValue(fields()[103]);
        record.ACCT_BALANCE = fieldSetFlags()[104] ? this.ACCT_BALANCE : (java.lang.Double) defaultValue(fields()[104]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<BusinessEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<BusinessEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<BusinessEvent>
    READER$ = (org.apache.avro.io.DatumReader<BusinessEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}

