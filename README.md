spring.liquibase.enabled=true
spring.liquibase.change-log=classpath*:
added in application.properties 


This is my changelog-master
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">

    <include file="db/changelog/changelog-v1.xml"/>
</databaseChangeLog>

changelog-v1.xml

<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">
</databaseChangeLog>

package com.kotak.orchestrator.orchestrator.repository;

import com.kotak.orchestrator.orchestrator.entity.PlutusFinacleDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PlutusFinacleDataRepository extends JpaRepository<PlutusFinacleDataEntity, String> {
    void deleteByReceivedAtBefore(LocalDateTime dateTime);

} 

package com.kotak.orchestrator.orchestrator.repository;

import com.kotak.orchestrator.orchestrator.entity.PlutusClientConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to fetch active client configurations from the database.
 */
@Repository
public interface PlutusClientConfigurationRepository extends JpaRepository<PlutusClientConfiguration, Integer> {

    /**
     * Fetch all active configurations (with activeFlag = true).
     */
    @Query("SELECT c FROM PlutusClientConfiguration c WHERE c.activeFlag = true")
    List<PlutusClientConfiguration> findAllActive();
}

package com.kotak.orchestrator.orchestrator.entity;


import com.kotak.plutus.common.utils.JsonConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plutus_finacle_transaction_details", schema = "plutus_ecollection")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlutusFinacleDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tran_date")
    private LocalDate tranDate;

    @Column(name = "tran_id")
    private String tranId;

    @Column(name = "part_tran_srl_num")
    private String partTranSrlNum;

    @Column(name = "del_flg")
    private String delFlg;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "tran_sub_type")
    private String tranSubType;

    @Column(name = "part_tran_type")
    private String partTranType;

    @Column(name = "gl_sub_head_code")
    private String glSubHeadCode;

    @Column(name = "acid")
    private String acid;

    @Column(name = "value_date")
    private LocalDate valueDate;

    @Column(name = "tran_amt")
    private BigDecimal tranAmt;

    @Column(name = "tran_particular")
    private String tranParticular;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "pstd_date")
    private LocalDateTime pstdDate;

    @Column(name = "ref_num")
    private String refNum;

    @Column(name = "instrmnt_type")
    private String instrmntType;

    @Column(name = "instrmnt_date")
    private LocalDate instrmntDate;

    @Column(name = "instrmnt_num")
    private String instrmntNum;

    @Column(name = "tran_rmks")
    private String tranRmks;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "br_code")
    private String brCode;

    @Column(name = "crncy_code")
    private String crncyCode;

    @Column(name = "tran_crncy_code")
    private String tranCrncyCode;

    @Column(name = "ref_amt")
    private BigDecimal refAmt;

    @Column(name = "sol_id")
    private String solId;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "trea_ref_num")
    private String treaRefNum;

    @Column(name = "reversal_date")
    private LocalDate reversalDate;

    @Column(name = "reversal_value_date")
    private LocalDate reversalValueDate;

    @Column(name = "tran_particular_2")
    private String tranParticular2;

    @Column(name = "tran_particular_code")
    private String tranParticularCode;

    @Column(name = "tr_status")
    private String trStatus;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "gl_date")
    private LocalDate glDate;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "tran_free_code1")
    private String tranFreeCode1;

    @Column(name = "tran_free_code2")
    private String tranFreeCode2;

    @Column(name = "reversal_status")
    private String reversalStatus;

    @Column(name = "available_amt")
    private BigDecimal availableAmt;

    @Column(name = "acct_balance")
    private BigDecimal acctBalance;

    @Column(name = "foracid")
    private String foracid;

    @Column(name = "acct_name")
    private String acctName;

    @Column(name = "acct_short_name")
    private String acctShortName;

    @Column(name = "last_tran_date_cr")
    private LocalDate lastTranDateCr;

    @Convert(converter = JsonConverter.class)
    @Column(name = "raw_json", columnDefinition = "jsonb")
    private String rawJson;


    @Column(name = "received_at")
    private LocalDateTime receivedAt;
} and this is my entyty 
