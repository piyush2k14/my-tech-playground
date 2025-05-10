package com.pj.quizservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pj.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
