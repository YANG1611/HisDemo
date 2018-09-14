package com.sit.controller;

import com.sit.entity.Employee_base;
import com.sit.service.Employee_baseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 @RestController
public class EmployeeController {
    @Autowired
    private Employee_baseService employee_baseService;

    @RequestMapping("/findEmployee_baseInfo")
    public List<Employee_base> findEmployee_baseInfo( ) {
        Employee_base employee_base=new Employee_base();
        employee_base.setEmployeeId("1");
        return employee_baseService.findEmployee_baseInfo(employee_base.getEmployeeId());
    }
}
