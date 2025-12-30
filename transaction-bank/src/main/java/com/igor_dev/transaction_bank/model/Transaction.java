package com.igor_dev.transaction_bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private Long payer;

    @Column(name = "status", unique = true)
    private String status;

    @Column(name = "message", unique = true)
    private String message;

    private Long value;

    public Transaction() {
    }

    public Transaction(Long id, Long payer, String status, String message, Long value) {
        this.id = id;
        this.payer = payer;
        this.status = status;
        this.message = message;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Long getPayer() {
        return payer;
    }

    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
