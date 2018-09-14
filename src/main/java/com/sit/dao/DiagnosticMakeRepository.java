package com.sit.dao;

import com.sit.entity.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticMakeRepository extends JpaRepository<Diagnostic,Integer> {
}
