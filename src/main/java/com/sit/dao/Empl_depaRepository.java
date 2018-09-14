package com.sit.dao;

import com.sit.entity.Empl_depa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Empl_depaRepository extends JpaRepository<Empl_depa,String> {
    public Empl_depa findByEmployeeID(String employeeID);
}
