package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salary_tb")
public class Salary {
    @Id
    @Column(length = 20)
    private String titleID;
    private Double moneyMonth;

    public Salary() {
    }


    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public Double getMoney_month() {
        return moneyMonth;
    }

    public void setMoney_month(Double money_month) {
        this.moneyMonth = money_month;
    }
}
