package com.sit.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "order_tb")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(nullable = true, length = 18)
    private String patientId;

    @Column(nullable = true, length = 4)
    private String departmentId;
    @Column(nullable = true, length = 20)
    private String orderTime;
    @Column(precision = 10, scale = 2)
    private Double orderCost;
    @Column(nullable = true, length = 20)
    private String orderStatus;
    @Column(nullable = true, length = 20)
    private String orderHandleTime;
    @Column(nullable = true, length = 20)
    private String receptionistId;

    public OrderDetail() {
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderHandleTime() {
        return orderHandleTime;
    }

    public void setOrderHandleTime(String orderHandleTime) {
        this.orderHandleTime = orderHandleTime;
    }
}
