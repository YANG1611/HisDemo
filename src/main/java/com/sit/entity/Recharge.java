package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Recharge_tb")
public class Recharge {
    @Id
    @GeneratedValue
    private Integer rechargeId;
    @Column(length = 50)
    private String cardId;
    @Column(length = 20)
    private String phoneNum;
    private Double amount;
    @Column(length = 50)
    private String operateTime;
    @Column(length = 10)
    private String operateStatus;

    public Recharge() {
    }

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }
}
