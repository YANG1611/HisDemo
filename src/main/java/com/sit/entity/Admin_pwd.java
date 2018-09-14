package com.sit.entity;

import javax.persistence.*;


@Entity
@Table(name = "admin_pwd_tb")
public class Admin_pwd {
    @Id
    @Column(length = 10)
    private String adminiId;
    @Column(length = 20,nullable = false)
    private String pwd;
    public Admin_pwd() {
    }
    public String getAdminiId() {
        return adminiId;
    }

    public void setAdminiId(String adminiId) {
        this.adminiId = adminiId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
