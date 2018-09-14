package com.sit.service;

import com.sit.dao.Empl_depaRepository;
import com.sit.entity.Empl_depa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Empl_depaService {
    @Autowired
    Empl_depaRepository empl_depaRepository;

    public Empl_depa findEmpl_depa(String employeeID) {
        return empl_depaRepository.findById(employeeID).get();
    }

//    public Empl_depa findEmpl_depaByEmployeeID(String employeeID) {
//        return empl_depaRepository.findByEmployeeID(employeeID);
//    }
    public void addEmpl_depa(Empl_depa empl_depa)
    {
        empl_depaRepository.save(empl_depa);
    }
}
