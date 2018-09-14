package com.sit.entity;

import java.io.Serializable;

public class Empl_titleGroupPK implements Serializable {
    private String employee_id;
    private int title_id;

    public Empl_titleGroupPK() {
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }
}
