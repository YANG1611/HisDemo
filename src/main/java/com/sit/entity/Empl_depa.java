package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Empl_depa_tb")
public class Empl_depa {
    @Id
    @Column(length = 10)
    private String employeeID;

    @Column(length = 2)
    private String departmentID;

    public Empl_depa() {
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
}
