package com.sit.service;

import com.sit.dao.Empl_salaryRepository;
import com.sit.entity.Empl_salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Empl_salaryService {
    @Autowired
    Empl_salaryRepository empl_salaryRepository;
    public Empl_salary findEmpl_salary(String EmployeeID)
    {
       return empl_salaryRepository.findByEmployeeID(EmployeeID);
    }
    public void addEmpl_salary(Empl_salary empl_salary)
    {
        empl_salaryRepository.save(empl_salary);
    }
}
