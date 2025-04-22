package com.kotak.distributionmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class CMSGenericInboundResponse {
    private Header header;
    private CMSGenericInboundRes cmsGenericInboundRes;

    @Data
    public static class Header {
        private String srcappcd;
        private String requestID;
    }

    @Data
    public static class CMSGenericInboundRes {
        private CollectionDetails collectionDetails;
    }

    @Data
    public static class CollectionDetails {
        private List<CollectionDetail> collectionDetail;
    }

    @Data
    public static class CollectionDetail {
        private String master_Acc_No;
        private String remit_Info;
        private String remit_Name;
        private String remit_Ifsc;
        private String ref1;
        private String ref2;
        private String ref3;
        private Double amount;
        private String txn_Ref_No;
        private String utr_No;
        private String pay_Mode;
        private String e_Coll_Acc_No;
        private String remit_Ac_Nmbr;
        private String creditdateandtime;
        private String txn_Date;
        private String bene_Cust_Acname;
    }
}
