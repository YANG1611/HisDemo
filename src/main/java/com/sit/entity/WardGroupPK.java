package com.sit.entity;

import java.io.Serializable;

public class WardGroupPK implements Serializable {

    private String room_id;
    private Integer bed_id;

    public WardGroupPK() {
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
