package com.sit.dao;

import com.sit.entity.DoctorShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorShowRepository extends JpaRepository<DoctorShow,Integer> {
    public DoctorShow findByEmployeeId(String employeeId);
}
