package com.agroho.repository;

import com.agroho.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by rezaul on 5/6/16.
 */

@Repository
public class AskingQuestionRepositoryImpl {

    @Autowired
    AskingQuestionRepositoriy askingQuestionRepositoriy;

    public String saveQuestion(Question question){

       Question question1 =  askingQuestionRepositoriy.saveAndFlush(question);

        if (question1.getQuestionId() != null){
            return question1.getQuestionId().toString();
        } else {
            return "Failed";
        }

    }
}
