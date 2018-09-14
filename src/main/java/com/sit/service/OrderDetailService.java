package com.sit.service;

import com.sit.dao.OrderDetailRepository;
import com.sit.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> findOrder()//查询所有挂号信息
    {

        return orderDetailRepository.findAll();

    }

    @Transactional
    public void addOrderDetail(OrderDetail orderDetail)//添加挂号信息
    {
        orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> findOrderByIdNo(String idNo)//查询挂号信息
    {
        return orderDetailRepository.findByPatientId(idNo);
    }

}
