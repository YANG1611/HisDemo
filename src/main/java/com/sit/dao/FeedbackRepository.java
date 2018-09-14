package com.sit.dao;

import com.sit.entity.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    //

    public  Feedback findByMessage(String m) ;
}
