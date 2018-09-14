package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Patient_base_tb")
public class Patient_base {

    @Id
    private String phoneNum;//电话号码
    @Column(nullable = true, length = 20)
    private String patientName;//姓名
    @Column(nullable = true, length = 20)
    private String patientSex;//性别

    private int patientAge;//年龄
    @Column(nullable = true, length = 100)
    private String patientPmdlh;//既往病史
    @Column(nullable = true, length = 18)
    private String idNo;//身份证号
    @Column(name = "imgAddress",nullable = true, length = 500)
    private String imgAddress;

    public Patient_base() {
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPmdlh() {
        return patientPmdlh;
    }

    public void setPatientPmdlh(String patientPmdlh) {
        this.patientPmdlh = patientPmdlh;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
