package com.learn.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}