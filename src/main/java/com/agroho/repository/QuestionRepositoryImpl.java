package com.agroho.repository;

import com.agroho.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */

@Repository
public class QuestionRepositoryImpl {

    @Autowired
    QuestionRepositoriy questionRepositoriy;

    public String saveQuestion(Question question){

       Question question1 =  questionRepositoriy.saveAndFlush(question);

        if (question1.getQuestionId() != null){
            return question1.getQuestionId().toString();
        } else {
            return "Failed";
        }
    }

    public List<Question> getQuestionList(){

        List<Question> questionList  = questionRepositoriy.findAll();

        return questionList;
    }


}
