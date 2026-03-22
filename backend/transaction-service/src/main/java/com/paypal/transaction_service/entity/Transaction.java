package com.paypal.transaction_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.Instant;

@Entity
@Table(name = "transactions") // ⚠️ better name (transaction is reserved keyword)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "receiver_id", nullable = false)
    private String receiverId;

    @Column(nullable = false)
    @Positive(message = "Amount must be positive")
    private Double amount;

    @Column(nullable = false)
    private Instant timeStamp;

    @Column(nullable = false)
    private String status;

    // ✅ Default constructor (REQUIRED for JPA)
    public Transaction() {
    }

    // ✅ Constructor
    public Transaction(Long id, String senderId, String receiverId,
                       Double amount, Instant timeStamp, String status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Auto set values before insert
    @PrePersist
    public void prePersist() {
        if (this.timeStamp == null) {
            this.timeStamp = Instant.now();
        }
        if (this.status == null) {
            this.status = "PENDING";
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timeStamp +
                ", status=" + status + '\'' +
                '}';

    }
}
