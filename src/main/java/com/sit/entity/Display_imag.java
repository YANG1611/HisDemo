package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Display_imag_tb")
public class Display_imag {
    @Id
    @Column(length = 20)
private String widget_id;
    @Column(length = 50)
    private String imag_address;

    public Display_imag() {
    }

    public String getWidget_id() {
        return widget_id;
    }

    public void setWidget_id(String widget_id) {
        this.widget_id = widget_id;
    }

    public String getImag_address() {
        return imag_address;
    }

    public void setImag_address(String imag_address) {
        this.imag_address = imag_address;
    }
}
