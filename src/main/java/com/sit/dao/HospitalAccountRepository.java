package com.sit.dao;

import com.sit.entity.HospitalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalAccountRepository extends JpaRepository<HospitalAccount,String> {
}
