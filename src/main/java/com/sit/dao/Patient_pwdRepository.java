package com.sit.dao;

import com.sit.entity.Patient_pwd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Patient_pwdRepository extends JpaRepository<Patient_pwd,String> {
    public List<Patient_pwd> findByPhoneNum(String phoneNum);
    public List<Patient_pwd> findByPhoneNumAndPwd(String phoneNum,String pwd);
}
