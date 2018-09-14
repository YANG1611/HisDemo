package com.sit.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "empl_dimission_tb")
public class Empl_dimission {
    @Id
    @Column(length = 10)
    private String employeeId;
    @Column(length = 20)
    private String requestTime;
    @Column(length = 200)
    private String requestReason;

    public Empl_dimission() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }
}
