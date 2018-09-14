package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "nurse_task_tb")
public class Nurse_task {
   @Id
   @Column(length = 10)
    private String employee_id;
   @Column(length = 5,nullable = false)
    private String room_id;
   @Column(nullable = false)
    private Integer bed_id;

    public Nurse_task() {
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Integer getBed_id() {
        return bed_id;
    }

    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }
}
