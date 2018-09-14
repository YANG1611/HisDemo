package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device_stock_tb")
public class Device_stock {
    @Id
    private Integer device_id;
    @Column(length = 15)
    private String device_name;
    private Integer device_num;

    public Device_stock() {
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public Integer getDevice_num() {
        return device_num;
    }

    public void setDevice_num(Integer device_num) {
        this.device_num = device_num;
    }
}
