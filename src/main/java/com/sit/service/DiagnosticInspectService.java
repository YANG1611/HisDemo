package com.sit.service;

import com.sit.dao.DiagnosticInspectRepository;
import com.sit.entity.Diagnostic;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticInspectService {
    @Autowired
    DiagnosticInspectRepository diagnosticInspectRepository;
    public List<Diagnostic> finaDiagnostic()
    {
        return diagnosticInspectRepository.findAll();
    }
}
