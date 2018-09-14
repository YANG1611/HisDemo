package com.sit.service;

import com.sit.dao.Empl_titleRepository;
import com.sit.entity.Empl_title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Empl_titleService {
    @Autowired
    Empl_titleRepository empl_titleRepository;

    public Empl_title findEmpl_title(String employeeID) {
        return empl_titleRepository.findById(employeeID).get();
    }

    public void addEmpl_title(Empl_title empl_title) {
        empl_titleRepository.save(empl_title);
    }
}
