package com.sit.service;

import com.sit.dao.Patient_pwdRepository;
import com.sit.entity.Patient_pwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Patient_pwdService {
    @Autowired
    private Patient_pwdRepository patient_pwdRepository;

    public void addPatient_pwd(Patient_pwd p) {
        patient_pwdRepository.save(p);
    }

    public boolean verifyPatient_pwd(Patient_pwd patient_pwd) {
        if (patient_pwdRepository.findByPhoneNumAndPwd(patient_pwd.getPhoneNum(),patient_pwd.getPwd()).isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
    public List<Patient_pwd> getPatient_pwd(Patient_pwd p){
        return  patient_pwdRepository.findByPhoneNum(p.getPhoneNum());
    }
    public String registerPatient_pwd(Patient_pwd patient_pwd) {

        if (patient_pwdRepository.findByPhoneNum(patient_pwd.getPhoneNum()).isEmpty()) {
            patient_pwdRepository.save(patient_pwd);
            return "用户名  " + patient_pwd.getPhoneNum() + " 注册成功";

        } else {

            return "用户名 " + patient_pwd.getPhoneNum() + "已被占用！";
        }

    }
}
