package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name="DoctorShow_tb")
public class DoctorShow {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String employeeId;
    @Column(length = 20)
    private String employeeName;
    @Column(length = 20)
    private String titleName;

    public DoctorShow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
