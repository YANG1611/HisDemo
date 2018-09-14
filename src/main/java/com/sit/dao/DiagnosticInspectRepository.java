package com.sit.dao;

import com.sit.entity.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticInspectRepository extends JpaRepository<Diagnostic,Integer> {
}
