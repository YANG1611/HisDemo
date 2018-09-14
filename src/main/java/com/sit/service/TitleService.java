package com.sit.service;

import com.sit.dao.TitleRepository;
import com.sit.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {
    @Autowired
    TitleRepository titleRepository;
    public Title findTitle(Integer titleID)
    {
        return titleRepository.findById(titleID).get();
    }
}
