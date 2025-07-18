Pre-enrich incoming transaction data using VAM cache in Orchestrator layer


As a developer,
I want to enrich ROS transaction data in the Data Collection - Orchestrator layer using a VAM cache,
So that the data is enriched upfront before being stored in Plutus and distributed to downstream systems.



The orchestrator layer should maintain a cache (Map<MasterAccountNo, List<VirtualAccounts>).

On receiving a transaction from ROS, the orchestrator should:

Extract the Master Account Number.

Lookup in the VAM cache.

Enrich the transaction with the corresponding list of Virtual Accounts.

The enriched record should be forwarded for:

Storage in Plutus.

Distribution to downstream systems.

Proper logging should be done for:

Cache hit/miss

Enrichment status per record

The enrichment logic should be unit-testable.

If VAM cache is not initialized, the orchestrator should log and skip or flag enrichment (based on config).
