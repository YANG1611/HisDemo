package com.sit.entity;

import java.io.Serializable;

public class Empl_depaGroupPK implements Serializable {
    private String employee_id;
    private String department_id;

    public Empl_depaGroupPK() {
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }
}
