package com.sit.entity;

import javax.persistence.*;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Empl_title_tb")
public class Empl_title {
    @Id
    @Column(length = 10)
    private String employeeID;

    private Integer titleID;

    public Empl_title() {
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }
}
