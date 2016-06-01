package com.agroho.repository;

import com.agroho.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    @Query(value = "SELECT * FROM question where `question_answered` =  0", nativeQuery = true)
    List<Question> getQuestionList();

    @Query(value = "SELECT * FROM question where `question_answered` =  1", nativeQuery = true)
    List<Question> getAnsweredQuestionList();

}
