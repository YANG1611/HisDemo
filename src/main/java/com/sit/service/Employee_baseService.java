package com.sit.service;

import com.sit.dao.Employee_baseRepository;
import com.sit.dao.OrderDetailRepository;
import com.sit.entity.Employee_base;
import com.sit.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service
public class Employee_baseService {
    @Autowired
    private Employee_baseRepository employee_baseRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<Employee_base> findEmployee_baseInfo(String employeeId) {//按工号查询职工基本信息
        List<Employee_base> list = new ArrayList<Employee_base>();
        list.add(employee_baseRepository.findById(employeeId).get());
        return list;
    }

    public Boolean verifyEmployee_base(Employee_base employee_base)//按用户名和密码验证是否存在
    {
        if (employee_baseRepository.findByEmployeeIdAndPwd(employee_base.getEmployeeId(), employee_base.getPwd()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


    public List<OrderDetail> findOrder()//查询所有挂号信息
    {

        return orderDetailRepository.findAll();

    }

    public void addOrderDetail(OrderDetail orderDetail)//添加挂号信息
    {
        orderDetailRepository.save(orderDetail);
    }
    /*
    添加职工基本信息
     */
    public void addEmployee_baseInfo(Employee_base employee_base)
    {
        employee_baseRepository.save(employee_base);
    }
    public Boolean verifyAddEmployee_baseInfo(String id)
    {
      if(  employee_baseRepository.findByEmployeeId(id).isEmpty()==true)
          return true;
      else
          return false;
    }
    public Employee_base findEmployee_base(String EmployeeID)
    {
        return employee_baseRepository.findById(EmployeeID).get();
    }

}
