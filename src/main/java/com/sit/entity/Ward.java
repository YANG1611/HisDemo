package com.sit.entity;

import javax.persistence.*;

@Entity
@IdClass(WardGroupPK.class)
@Table(name = "ward_tb")
public class Ward {
    @Id
    @Column(length = 5)
    private String room_id;
    private Integer bed_num;
    @Id
    private Integer bed_id;
    @Column(length = 2)
    private String bed_status;

    public Ward() {
        super();
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Integer getBed_num() {
        return bed_num;
    }

    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public Integer getBed_id() {
        return bed_id;
    }

    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }

    public String getBed_status() {
        return bed_status;
    }

    public void setBed_status(String bed_status) {
        this.bed_status = bed_status;
    }
}
