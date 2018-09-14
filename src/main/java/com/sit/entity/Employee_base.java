package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_base_tb")
public class Employee_base {
    @Id
    @Column(name = "employeeId",length = 10)
    private String employeeId;
    @Column(name = "employeeName",nullable = true, length = 20)
    private String employeeName;
    @Column(name = "employeeSex",nullable = true, length = 5)
    private String employeeSex;
    @Column(name = "employeeAge",nullable = true)
    private Integer employeeAge;
    @Column(name = "id",nullable = true, length = 20)
    private String id;
    @Column(name = "phoneNum",nullable = true, length = 11)
    private String phoneNum;
    @Column(name = "employeeLiveAddress",nullable = true, length = 100)
    private String employeeLiveAddress;
    @Column(name = "employeeBirthplace",nullable = true, length = 100)
    private String employeeBirthplace;
    @Column(name = "employeeNation",nullable = true, length = 20)
    private String employeeNation;
    @Column(name = "employeeType",nullable = true, length = 20)
    private String employeeType;
    @Column(name = "pwd",nullable = false, length = 20)
    private String pwd;
    @Column(name = "imgAddress",nullable = true, length = 500)
    private String imgAddress;
    public Employee_base() {
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
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

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmployeeLiveAddress() {
        return employeeLiveAddress;
    }

    public void setEmployeeLiveAddress(String employeeLiveAddress) {
        this.employeeLiveAddress = employeeLiveAddress;
    }

    public String getEmployeeBirthplace() {
        return employeeBirthplace;
    }

    public void setEmployeeBirthplace(String employeeBirthplace) {
        this.employeeBirthplace = employeeBirthplace;
    }

    public String getEmployeeNation() {
        return employeeNation;
    }

    public void setEmployeeNation(String employeeNation) {
        this.employeeNation = employeeNation;
    }
}
