package com.sit.service;

import com.sit.dao.DiagnosticMakeRepository;
import com.sit.entity.Diagnostic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticMakeService {
    @Autowired
    DiagnosticMakeRepository diagnosticMakeRepository;
    public void saveDiagnosticMake(Diagnostic diagnostic)
    {
        diagnosticMakeRepository.save(diagnostic);
    }
}
