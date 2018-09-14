package com.sit.dao;

import com.sit.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    public List<OrderDetail> findByPatientId(String idNo);
}
