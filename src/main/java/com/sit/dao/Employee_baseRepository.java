package com.sit.dao;

import com.sit.entity.Employee_base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Employee_baseRepository extends JpaRepository<Employee_base,String> {

    public List<Employee_base> findByEmployeeIdAndPwd(String employeeId, String pwd);//按用户名和密码查询
    public List<Employee_base> findByEmployeeId(String employeeId);
}
