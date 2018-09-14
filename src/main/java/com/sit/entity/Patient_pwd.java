package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient_pwd {
    @Id
    @Column(length = 11)
    private String phoneNum;
    @Column(length = 20,nullable = false)
    private String pwd;
//    @Column(length = 20,nullable = true)
//    private String radio1;
//    @Column(length = 20,nullable = true)
//    private String radio2;
    public Patient_pwd() {
    }

//    public String getRadio1() {
//        return radio1;
//    }
//
//    public void setRadio1(String radio1) {
//        this.radio1 = radio1;
//    }
//
//    public String getRadio2() {
//        return radio2;
//    }
//
//    public void setRadio2(String radio2) {
//        this.radio2 = radio2;
//    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
