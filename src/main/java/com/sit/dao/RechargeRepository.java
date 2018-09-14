package com.sit.dao;

import com.sit.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge,Integer> {
    public List<Recharge> findByPhoneNum(String phoneNum);
}
