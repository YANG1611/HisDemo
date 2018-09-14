package com.sit.service;

import com.sit.dao.Empl_dimissionRepository;
import com.sit.entity.Empl_dimission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Empl_dimissionService {
    @Autowired
    private Empl_dimissionRepository empl_dimissionRepository;

    public void addEmpl_dimission(Empl_dimission empl_dimission) {
       empl_dimissionRepository.save(empl_dimission);
    }
    public Boolean verifyaddEmpl_dimission(String id)
    {
       if( empl_dimissionRepository.findByEmployeeId(id).isEmpty())
           return true;
       else
           return false;
    }
    public List<Empl_dimission> findEmpl_dimissionInfoAll() {
       return empl_dimissionRepository.findAll();
    }
}
