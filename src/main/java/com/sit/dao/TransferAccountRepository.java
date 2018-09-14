package com.sit.dao;

import com.sit.entity.TransferAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferAccountRepository extends JpaRepository<TransferAccount,Integer> {
}
