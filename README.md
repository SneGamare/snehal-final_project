package com.kotak.orchestrator.orchestrator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reconciled_transaction")
public class ReconciledTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finacle_tran_id", referencedColumnName = "tranId")
    private PlutusFinacleDataEntity plutusFinacleDataEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "txnRefNo", referencedColumnName = "txnRefNo")
    private PaymentProcessorEntity paymentProcessorEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlutusFinacleDataEntity getPlutusFinacleDataEntity() {
        return plutusFinacleDataEntity;
    }

    public void setPlutusFinacleDataEntity(PlutusFinacleDataEntity plutusFinacleDataEntity) {
        this.plutusFinacleDataEntity = plutusFinacleDataEntity;
    }

    public PaymentProcessorEntity getVirtualApacEntity() {
        return paymentProcessorEntity;
    }

    public void setVirtualApacEntity(PaymentProcessorEntity virtualApacEntity) {
        this.paymentProcessorEntity = virtualApacEntity;
    }



    // Getters and Setters
}
