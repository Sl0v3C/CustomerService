package com.agroho.controller;

import com.agroho.model.Question;
import com.agroho.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rezaul on 5/1/16.
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String askQuestion( Model model){

        model.addAttribute("question",new Question());

        return "question";
    }



    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String askQuestion(@ModelAttribute("question") Question question, Model model){


        System.out.println("THIS IS POST CALL");
        System.out.println("Get Data"+question.getQuestionDetails());

        String response = questionService.saveQuestion(question);

        model.addAttribute("res", response);

        System.out.println(response);

        return "response";
    }




}


 /*    @RequestMapping(value = "/question/{contact}", method = RequestMethod.GET)
        public String SearchByContact(@PathVariable(value = "contact") String contact){

            System.out.println("Path Variable: "+contact);


            Question question = questionService.getQuestionByUserContact(contact);

            System.out.println("Question Title: "+question.getQuestionSubject());

            return "home";
        }*/