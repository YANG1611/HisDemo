package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Title_tb")
public class Title {
    @Id
    private Integer titleID;
    @Column(length = 20,nullable = false)
    private String titleName;

    public Title() {
    }

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
