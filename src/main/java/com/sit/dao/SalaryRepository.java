package com.sit.dao;

import com.sit.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SalaryRepository extends JpaRepository<Salary,String> {
}
