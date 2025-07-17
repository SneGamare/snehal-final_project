<!-- Create schema if not exists -->
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">

    <include file="db/changelog/changelog-v1.xml"/>

<changeSet id="000-create-schema" author="snehal">
    <preConditions onFail="MARK_RAN">
        <not>
            <schemaExists schemaName="plutus_ecollection"/>
        </not>
    </preConditions>
    <createSchema schemaName="plutus_ecollection"/>
</changeSet>

        <!-- Create table -->
<changeSet id="001-create-plutus-finacle-transaction-details" author="snehal">
<preConditions onFail="MARK_RAN">
    <not>
        <tableExists tableName="plutus_finacle_transaction_details" schemaName="plutus_ecollection"/>
    </not>
</preConditions>
<createTable tableName="plutus_finacle_transaction_details" schemaName="plutus_ecollection">
    <column name="id" type="SERIAL">
        <constraints primaryKey="true" nullable="false"/>
    </column>
    <column name="tran_date" type="DATE"/>
    <column name="tran_id" type="VARCHAR(50)"/>
    <column name="part_tran_srl_num" type="INTEGER"/>
    <column name="del_flg" type="BOOLEAN"/>
    <column name="tran_type" type="VARCHAR(20)"/>
    <column name="tran_sub_type" type="VARCHAR(20)"/>
    <column name="part_tran_type" type="VARCHAR(20)"/>
    <column name="gl_sub_head_code" type="VARCHAR(20)"/>
    <column name="acid" type="VARCHAR(50)"/>
    <column name="value_date" type="DATE"/>
    <column name="tran_amt" type="NUMERIC(18,2)"/>
    <column name="tran_particular" type="TEXT"/>
    <column name="entry_date" type="TIMESTAMP"/>
    <column name="pstd_date" type="TIMESTAMP"/>
    <column name="ref_num" type="VARCHAR(50)"/>
    <column name="instrmnt_type" type="VARCHAR(20)"/>
    <column name="instrmnt_date" type="DATE"/>
    <column name="instrmnt_num" type="VARCHAR(50)"/>
    <column name="tran_rmks" type="TEXT"/>
    <column name="cust_id" type="VARCHAR(50)"/>
    <column name="br_code" type="VARCHAR(20)"/>
    <column name="crncy_code" type="VARCHAR(10)"/>
    <column name="tran_crncy_code" type="VARCHAR(10)"/>
    <column name="ref_amt" type="NUMERIC(18,2)"/>
    <column name="sol_id" type="VARCHAR(20)"/>
    <column name="bank_code" type="VARCHAR(20)"/>
    <column name="trea_ref_num" type="VARCHAR(50)"/>
    <column name="reversal_date" type="DATE"/>
    <column name="reversal_value_date" type="DATE"/>
    <column name="tran_particular_2" type="TEXT"/>
    <column name="tran_particular_code" type="VARCHAR(20)"/>
    <column name="tr_status" type="VARCHAR(20)"/>
    <column name="party_code" type="VARCHAR(50)"/>
    <column name="gl_date" type="DATE"/>
    <column name="bank_id" type="VARCHAR(20)"/>
    <column name="tran_free_code1" type="VARCHAR(50)"/>
    <column name="tran_free_code2" type="VARCHAR(50)"/>
    <column name="reversal_status" type="VARCHAR(20)"/>
    <column name="available_amt" type="NUMERIC(18,2)"/>
    <column name="acct_balance" type="NUMERIC(18,2)"/>
    <column name="foracid" type="VARCHAR(50)"/>
    <column name="acct_name" type="VARCHAR(100)"/>
    <column name="acct_short_name" type="VARCHAR(50)"/>
    <column name="last_tran_date_cr" type="DATE"/>
    <column name="raw_json" type="JSONB"/>
    <column name="received_at" type="TIMESTAMP"/>
</createTable>
</changeSet>
</databaseChangeLog>
