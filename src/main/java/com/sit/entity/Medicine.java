package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Medicine_tb")
public class Medicine {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer medId;
    @Column(length = 15)
    private String medName;
    @Column(length = 15)
    private String medSpeci;
    private Integer medNum;
    private Double medPrice;
    @Column(length = 15)
    private String EmplId;
    @Column(length = 15)
    private String medTime;

    public String getMedTime() {
        return medTime;
    }

    public void setMedTime(String medTime) {
        this.medTime = medTime;
    }

    public Medicine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmplId() {
        return EmplId;
    }

    public void setEmplId(String emplId) {
        EmplId = emplId;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedSpeci() {
        return medSpeci;
    }

    public void setMedSpeci(String medSpeci) {
        this.medSpeci = medSpeci;
    }

    public Integer getMedNum() {
        return medNum;
    }

    public void setMedNum(Integer medNum) {
        this.medNum = medNum;
    }

    public Double getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(Double medPrice) {
        this.medPrice = medPrice;
    }
}
