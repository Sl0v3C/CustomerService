package com.agroho.repository;

import com.agroho.model.Question;
import com.agroho.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by rezaul on 5/6/16.
 */

@Repository
public class QuestionRepositoryImpl implements CustomQuestionRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Question getQuestionByUserContact(String contact) {

        String sqlfForQuestionByContact = "SELECT `question_id`, `question_answered`, `question_details`, `question_subject`, `question_title`, `question_user_contact`, `question_user_name`, `admin_id` FROM `question` WHERE `question_user_contact` = ?";
        String test = "Select * from users";
        Query query = em.createNativeQuery(test);
        //query.setParameter(1,contact);
        //em.fin

        List<User> q = query.getResultList();
        int u = q.size();

        System.out.println(u);

        return null;
    }

 /*   @Autowired
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
    }*/


}
