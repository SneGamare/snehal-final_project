SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;



GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO your_user;


CREATE ROLE app_user WITH LOGIN PASSWORD 'your_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO app_user;




-- Create the user if not already present
CREATE ROLE plutus_app_user WITH LOGIN PASSWORD 'your_password';

-- Grant access to the schema and tables
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user;

-- Run as admin or schema owner
GRANT USAGE ON SCHEMA plutus_ecollection TO plutus_app_user_dev;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA plutus_ecollection TO plutus_app_user_dev;
