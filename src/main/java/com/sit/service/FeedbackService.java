package com.sit.service;

import com.sit.dao.FeedbackRepository;
import com.sit.entity.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public void addFeedback(Feedback feedback)
    {
        feedbackRepository.save(feedback);
    }


    public  Feedback findFeedback(String phoneNum)
    {
        Feedback feedback=feedbackRepository.findByMessage(phoneNum);
        return  feedback;
    }
    public List<Feedback> findAllFeedback()
    {
        return feedbackRepository.findAll();
    }
}
