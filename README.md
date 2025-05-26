Steps:
Data Extraction:
Extract Finacle data from ROS using the DTD + GAM topic.
Data Filtering:
Apply the following filter using the Plutus_Client_Configuration table:
If ROS.FORACID matches Plutus_Client_Configuration.Master_Account_Number, pass the record for further processing.
Otherwise, ignore the record.
Data Storage:
Save the filtered Finacle DTD + GAM data in the Plutus_Finacle_Transaction_details table.
