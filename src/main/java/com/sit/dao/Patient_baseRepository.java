package com.sit.dao;

import com.sit.entity.Patient_base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patient_baseRepository extends JpaRepository<Patient_base,String> {
    public Patient_base findByIdNo(String idNo);

}
