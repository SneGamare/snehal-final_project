{
  "CMSGenericInboundResponse": {
    "Header": {
      "Srcappcd": "ECOLLECTION",
      "RequestID": "1234567890"
    },
    "CMSGenericInboundRes": {
      "CollectionDetails": {
        "CollectionDetail": [
          {
            "Master_Acc_No": 3014370947,
            "Remitt_Info": "NEFT Txn",
            "Remit_Name": "Test Shankar M",
            "Remit_Ifsc": "PYTM0123456",
            "REF3": "",
            "Amount": 10,
            "Txn_Ref_No": 9300000000082,
            "Utr_No": 9300000000082,
            "Pay_Mode": "NEFT",
            "E_Coll_Acc_No": "AZYPAYMER7807001",
            "Remit_Ac_Nmbr": 919092798622,
            "Creditdateandtime": "2020-07-13 00:00:00",
            "REF1": "",
            "REF2": "",
            "Txn_Date": "2020-09-09 00:00:00",
            "Bene_Cust_Acname": "AZYPAY"
          },
          {
            "Master_Acc_No": 3014370947,
            "Remitt_Info": "CUST CUST",
            "Remit_Name": "Lakshmi Priya K",
            "Remit_Ifsc": "HDFC0000486",
            "REF3": "",
            "Amount": 15,
            "Txn_Ref_No": 9300000000056,
            "Utr_No": 9300000000056,
            "Pay_Mode": "NEFT",
            "E_Coll_Acc_No": "AZYPAYMER7807002",
            "Remit_Ac_Nmbr": 50100012817190,
            "Creditdateandtime": "2020-08-31 00:00:00",
            "REF1": "",
            "REF2": "",
            "Txn_Date": "2020-09-09 00:00:00",
            "Bene_Cust_Acname": "AZYPAY"
          }
        ]
      }
    }
  }
}
 

Ecollection API Request-
{
   "Header": {
      "SrcAppCd": "ECOLLECTION",
      "RequestID": "1234567890"
   },
   "CMSGenericInboundReq": {
      "MerchantName": "TEMPTEST1",
      "MerchantSecret": ""
   }
}
 

Ecollection-Refund API Request-
{
   "Header": {
      "SrcAppCd": "ECOLLECTION",
      "RequestID": "1234567890"
   },
   "CMSGenericInboundReq": {
      "MerchantName": "TEMPTEST1",
      "MerchantSecret": "",
     "RefNo": "123456"
   }
}
 
