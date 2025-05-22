package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dtd_business_event")
@Getter
@Setter
public class DtdBusinessEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double effective_bal;
    private Double clr_bal;
    private byte[] foracid;
    private Long last_bal_updated_date;
    private byte[] schm_code;
    private byte[] cif_id;
    private byte[] acct_name;
    private Double tran_amt;
    private String tran_date;
    private byte[] tran_id;
    private byte[] tran_particular;
    private byte[] acid;
    private String value_date;
    private String reversal_date;
    private byte[] tran_type;
    private byte[] tran_sub_type;
    private byte[] part_tran_type;
    private byte[] gl_sub_head_code;
    private byte[] ref_num;
    private Double ref_amt;
    private byte[] cust_id;
    private byte[] br_code;
    private byte[] crncy_code;
    private byte[] tran_crncy_code;
    private byte[] sol_id;
    private byte[] bank_code;
    private byte[] trea_ref_num;
    private byte[] tran_rmks;
    private byte[] tran_particular_2;
    private Double acct_balance;
    private Double available_amt;

    // Add additional fields as needed from the schema
}
