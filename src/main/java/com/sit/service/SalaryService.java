package com.sit.service;

import com.sit.dao.SalaryRepository;
import com.sit.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    SalaryRepository salaryRepository;
    public Salary findSalary(String titleID)
    {
        return salaryRepository.findById(titleID).get();
    }
}
