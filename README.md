Steps:
Data Extraction:
Extract Finacle data from ROS using the DTD + GAM topic.
Data Filtering:
Apply the following filter using the Plutus_Client_Configuration table:
If ROS.FORACID matches Plutus_Client_Configuration.Master_Account_Number, pass the record for further processing.
Otherwise, ignore the record.
Data Storage:
Save the filtered Finacle DTD + GAM data in the Plutus_Finacle_Transaction_details table.



CREATE TABLE PLUTUS_ECOLLECTION.PLUTUS_CLIENT_CONFIGURATION (
    ID INT PRIMARY KEY,
    MASTER_ACCOUNT VARCHAR(255),
    UPI_SOURCE VARCHAR(255),
    IMPS_SOURCE_SYSTEM VARCHAR(255),
    NEFT_SOURCE VARCHAR(255),
    RTGS_SOURCE_SYSTEM VARCHAR(255),
    IFT_SOURCE_SYSTEM VARCHAR(255),
    PG_SOURCE_SYSTEM VARCHAR(255),
    API_TYPE VARCHAR(255),
    CLIENTNAME VARCHAR(255),
    CRN VARCHAR(255),
    ACTIVE_FLAG BOOLEAN,
    CREATED_BY VARCHAR(255),
    MODIFIED_BY VARCHAR(255),
    CREATED_DATE TIMESTAMP,
    MODIFIED_DATE TIMESTAMP
);

