package com.sit.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Diagnostic_tb")
public class Diagnostic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer DiagnosticId;//诊断ID
    @Column(length = 18)
    private String patientId;//病人ID
    @Column(length = 18)
    private String doctorId;//医生ID
    @Column(length = 100)
    private String illnessStatus;//病情说明
    private String medTime;//治疗时间
    @Column(length = 200)
    private String medSet;//药方（medSet,varchar(200）(以json形式存储药品名称、规格、数量)

    public Diagnostic() {
    }

    public Integer getDiagnosticId() {
        return DiagnosticId;
    }

    public void setDiagnosticId(Integer diagnosticId) {
        DiagnosticId = diagnosticId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getIllnessStatus() {
        return illnessStatus;
    }

    public void setIllnessStatus(String illnessStatus) {
        this.illnessStatus = illnessStatus;
    }

    public String getMedTime() {
        return medTime;
    }

    public void setMedTime(String medTime) {
        this.medTime = medTime;
    }

    public String getMedSet() {
        return medSet;
    }

    public void setMedSet(String medSet) {
        this.medSet = medSet;
    }
}
