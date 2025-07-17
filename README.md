Element schemaExists is not allowed here
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">

    <!-- Schema creation -->
    <changeSet id="000-create-schema" author="snehal">
        <preConditions onFail="MARK_RAN">
            <not>
                <schemaExists schemaName="plutus_ecollection"/>
            </not>
        </preConditions>
        <createSchema schemaName="plutus_ecollection"/>
    </changeSet>

    <!-- Table creation -->
    <changeSet id="001-create-plutus-finacle-transaction-details" author="snehal">
        <preConditions onFail="MARK_RAN">
            <not>
                <tableExists tableName="plutus_finacle_transaction_details" schemaName="plutus_ecollection"/>
            </not>
        </preConditions>

        <createTable tableName="plutus_finacle_transaction_details" schemaName="plutus_ecollection">
            <!-- your columns here (as you've written above) -->
            <!-- I’ll omit repeating them again to keep it short -->
        </createTable>
    </changeSet>

</databaseChangeLog>
