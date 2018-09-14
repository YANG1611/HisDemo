package com.sit.dao;

import com.sit.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
}
