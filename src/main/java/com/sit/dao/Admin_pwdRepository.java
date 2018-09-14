package com.sit.dao;

import com.sit.entity.Admin_pwd;
import com.sit.entity.Patient_pwd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Admin_pwdRepository extends JpaRepository<Admin_pwd,String> {
    public List<Admin_pwd> findByAdminiId(String adminiId);
    public List<Admin_pwd> findByAdminiIdAndPwd(String adminiId,String pwd);
}
