package com.sit.dao;

import com.sit.entity.Empl_salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Empl_salaryRepository extends JpaRepository<Empl_salary,String> {
    public Empl_salary findByEmployeeID(String Employee);
}
