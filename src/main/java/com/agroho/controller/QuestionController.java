package com.agroho.controller;

import com.agroho.model.Admin;
import com.agroho.model.Question;
import com.agroho.service.AskingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rezaul on 5/1/16.
 */
@Controller
public class QuestionController {

    @Autowired
    AskingQuestionService askingQuestionService;


    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String askQuestion(){

        Question question = new Question();

        question.setQuestionTitle("What is Islam");
        question.setQuestionSubject("Islam");
        question.setQuestionUserName("Prithu");

        Admin admin = new Admin();

        admin.setAdminName("Amin");
        admin.setAdminEmail("arez@gmail.com");
        admin.setAdminPassword("pass");
        admin.setAdminRole("Head");

        question.setAdmin(admin);

        String response = askingQuestionService.saveQuestion(question);

        System.out.println(response);

        return "question";
    }


    @RequestMapping(value = "/question/all", method = RequestMethod.GET)
    public String viewQuestion(){

        return "view_question";
    }

}
