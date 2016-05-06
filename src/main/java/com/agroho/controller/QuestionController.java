package com.agroho.controller;

import com.agroho.model.Admin;
import com.agroho.model.Question;
import com.agroho.service.AskingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String askQuestion( Model model){

        model.addAttribute("question",new Question());


        return "question";
    }


    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String askQuestion(@ModelAttribute("question") Question question){


        System.out.println("THIS IS POST CALL");
        System.out.println("Get Data"+question.getQuestionDetails());

        String response = askingQuestionService.saveQuestion(question);

        System.out.println(response);

        return "redirect:/question/all";
    }


    @RequestMapping(value = "/question/all", method = RequestMethod.GET)
    public String viewQuestion(){

        return "view_question";
    }

}
