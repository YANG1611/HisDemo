package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "TransferAccount_tb")
public class TransferAccount {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String fromUserId;
    @Column(length = 20)
    private String toUserId;
    private Double amount;
    @Column(length = 50)
    private String operateTime;

    public TransferAccount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}
