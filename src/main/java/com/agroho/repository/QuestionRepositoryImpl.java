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

/*

    @Override
    public Question getQuestionByUserContact(String contact) {

        Long LongContact = Long.parseLong(contact);

        Question q = em.find(Question.class,LongContact);

        System.out.println("Data from nahid:"+q.getQuestionSubject());


        return q;
    }
*/


    @Override
    public Question getQuestionByUserContact(String contact) {

        String sqlfForQuestionByContact = "SELECT `question_id`, `question_answered`, `question_details`, `question_subject`, `question_title`, `question_user_contact`, `question_user_name`, `admin_id` FROM `question` WHERE `question_id` = ?";
        String test = "Select * from users";

        Long LongContact = Long.parseLong(contact);

        Query query = em.createNativeQuery(sqlfForQuestionByContact, Question.class);
        query.setParameter(1,LongContact);
        Question q = (Question) query.getSingleResult();

        System.out.println("Data from nahid:"+q.getQuestionSubject());


        return q;
    }

 /*
    String sqlfForQuestionByContact = "SELECT `question_id`, `question_answered`, `question_details`, `question_subject`, `question_title`, `question_user_contact`, `question_user_name`, `admin_id` FROM `question` WHERE `question_id` = ?";
        String test = "Select * from users";

        Query query = em.createNativeQuery(sqlfForQuestionByContact);
        query.setParameter(1,LongContact);*//*




    //  Question question = (Question) query.getSingleResult();
    // Question q = (Question) query.getSingleResult();


    //em.fin

        //List<User> q = query.getResultList();
       // int u = q.size();

        //System.out.println(u);

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
    }*/


}
