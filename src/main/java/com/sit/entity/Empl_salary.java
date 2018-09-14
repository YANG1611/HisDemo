package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name="empl_salary_tb")
public class Empl_salary {
    @Id
    @Column(length = 20)
    private String employeeID;
    @Column(length = 20)
    private String titleID;


    public Empl_salary() {
    }

    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
