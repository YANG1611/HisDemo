package com.sit.service;

import com.sit.dao.Patient_baseRepository;
import com.sit.entity.Patient_base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Patient_baseService {
    @Autowired
    private Patient_baseRepository patient_baseRepository;

    public List<Patient_base> findPatient_baseInfo(String phoneNum) {//按电话号码查询病人基本信息
        List<Patient_base> list = new ArrayList<Patient_base>();
        list.add(patient_baseRepository.findById(phoneNum).get());
        return list;
    }

    public Patient_base findPatient_baseById(String id) {
        return patient_baseRepository.findById(id).get();
    }

    public void addPatient_base(Patient_base patient_base) {
        patient_baseRepository.save(patient_base);
    }
    public Patient_base findPatient_baseByIDNo(String IDNo)//按身份证查询病人信息
    {
      return patient_baseRepository.findByIdNo(IDNo);
    }

}
