package com.agroho.controller;

import com.agroho.model.Question;
import com.agroho.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by rezaul on 5/26/16.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String viewQuestion(){

        List<Question> questionList = adminService.getQuestionList();

        for (int i = 0; i < questionList.size(); i++) {
            String Subject = questionList.get(i).getQuestionSubject();
            System.out.println(Subject);
        }

        return "admin-question";
    }
/*

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String SubmitAnswer(){

        return null;
    }


    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public String viewSingleQuestion(Model model){

        model.addAttribute("question", new Question());

        return "admin-answer-question";
    }

    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    public String viewAnswered(){

        return "admin-answer";
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public String viewSingleAnswered(){

        return null;
    }
*/

}
