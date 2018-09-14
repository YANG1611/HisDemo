package com.sit.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;


public class DoctorHelper {

    private String EmployeeID;
    private String Name;
    private String Sex;
    private String Age;
    private String ID;
    private String PhoneNumber;
    private String LiveAddress;
    private String Birthplace;
    private String Nation;
    private String DepartmentName;
    private String imgAddress;

    public DoctorHelper() {
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getLiveAddress() {
        return LiveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        LiveAddress = liveAddress;
    }

    public String getBirthplace() {
        return Birthplace;
    }

    public void setBirthplace(String birthplace) {
        Birthplace = birthplace;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    private String TitleName;
    private String Salary;

}
