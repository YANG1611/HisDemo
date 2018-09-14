package com.sit.dao;

import com.sit.entity.Empl_dimission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Empl_dimissionRepository extends JpaRepository<Empl_dimission, String> {
    List<Empl_dimission> findByEmployeeId(String id);
}
