package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Like_tb")
public class Like {
    @Id
    @Column(length = 18)
    private String id;
    private Integer like_num;

    public Like() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLike_num() {
        return like_num;
    }

    public void setLike_num(Integer like_num) {
        this.like_num = like_num;
    }
}
