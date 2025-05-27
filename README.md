SELECT * 
FROM information_schema.tables 
WHERE table_schema = 'plutus_ecollection' 
  AND table_name = 'plutus_finacle_transaction_details';




ALTER TABLE public.plutus_finacle_transaction_details
SET SCHEMA plutus_ecollection;

