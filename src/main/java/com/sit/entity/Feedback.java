package com.sit.entity;

import javax.persistence.*;

@Entity
@Table(name = "Feedback_tb")
public class Feedback {
    @Id
    @GeneratedValue
    private  Integer feedbackId;
    @Column(length = 11)
    private String phoneNum;
    @Column(length = 100)
    private String message;
    @Column(length = 50)
    private String msgTime;

    public Feedback() {
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
