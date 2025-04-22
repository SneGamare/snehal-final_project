package com.kotak.distributionmanager.dao;

import com.kotak.distributionmanager.dto.CollectionDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class CollectionDetailDao {

    private final JdbcTemplate jdbcTemplate;

    public List<CollectionDetail> getDetails(String requestId, String refNo) {
        String sql = "SELECT * FROM collection_detail WHERE request_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(requestId);

        if (refNo != null && !refNo.isEmpty()) {
            sql += " AND ref_no = ?";
            params.add(refNo);
        }

        return jdbcTemplate.query(sql, params.toArray(), this::mapRowToDetail);
    }

    private CollectionDetail mapRowToDetail(ResultSet rs, int rowNum) throws SQLException {
        CollectionDetail d = new CollectionDetail();
        d.setMaster_Acc_No(rs.getString("master_acc_no"));
        d.setRemitt_Info(rs.getString("remitt_info"));
        d.setRemit_Name(rs.getString("remit_name"));
        d.setRemit_Ifsc(rs.getString("remit_ifsc"));
        d.setREF1(rs.getString("ref1"));
        d.setREF2(rs.getString("ref2"));
        d.setREF3(rs.getString("ref3"));
        d.setAmount(rs.getDouble("amount"));
        d.setTxn_Ref_No(rs.getString("txn_ref_no"));
        d.setUtr_No(rs.getString("utr_no"));
        d.setPay_Mode(rs.getString("pay_mode"));
        d.setE_Coll_Acc_No(rs.getString("e_coll_acc_no"));
        d.setRemit_Ac_Nmbr(rs.getString("remit_ac_nmbr"));
        d.setCreditdateandtime(rs.getString("creditdateandtime"));
        d.setTxn_Date(rs.getString("txn_date"));
        d.setBene_Cust_Acname(rs.getString("bene_cust_acname"));
        return d;
    }
}




sne
