package com.sit.service;

import com.sit.dao.DepartmentRepository;
import com.sit.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public Department findDepartment(String departmentID)
    {
        return departmentRepository.findById(departmentID).get();
    }
}
