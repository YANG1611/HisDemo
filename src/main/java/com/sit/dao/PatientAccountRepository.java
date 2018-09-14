package com.sit.dao;

import com.sit.entity.PatientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientAccountRepository extends JpaRepository<PatientAccount,String> {
}
