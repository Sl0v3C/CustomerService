package com.agroho.controller;

import com.agroho.model.Question;
import com.agroho.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String viewQuestion(Model model){

        List<Question> questionList = adminService.getQuestionList();

        for (int i = 0; i < questionList.size(); i++) {
            String Subject = questionList.get(i).getQuestionSubject();
            System.out.println(Subject);
        }

        model.addAttribute("questions", questionList);

        return "admin-question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String SubmitAnswer(@ModelAttribute("question") Question question){

        System.out.println("THIS IS POST CALL");
        System.out.println("Get Data "+question.getQuestionId()+" and "+question.getQuestionAnswer());
        Long idlong = Long.parseLong(String.valueOf(question.getQuestionId()));

        Question questionOld = adminService.getQuestionById(idlong);

        questionOld.setQuestionAnswer(question.getQuestionAnswer());
        questionOld.setQuestionAnswered(1);
        Question question1 = adminService.submitAnswer(questionOld);


        System.out.println("Answer Old: "+question1.getQuestionAnswer());


        return "redirect:question";

    }




    /*    @RequestMapping(value = "/question/{contact}", method = RequestMethod.GET)
        public String SearchByContact(@PathVariable(value = "contact") String contact){

            System.out.println("Path Variable: "+contact);


            Question question = questionService.getQuestionByUserContact(contact);

            System.out.println("Question Title: "+question.getQuestionSubject());

            return "home";
        }*/

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public String viewSingleQuestion(@PathVariable(value = "id") String id , Model model){

      //  model.addAttribute("question", new Question());

        Long idlong = Long.parseLong(id);

        Question question = adminService.getQuestionById(idlong);

        model.addAttribute("question", question);

        return "admin-answer-question";
    }


    @RequestMapping(value = "/answered", method = RequestMethod.GET)
    public String AnsweredQuestion(Model model){
        List<Question> questionList = adminService.getAnsweredQuestionList();

        for (int i = 0; i < questionList.size(); i++) {
            String Subject = questionList.get(i).getQuestionSubject();
            System.out.println(Subject);
        }

        model.addAttribute("questions", questionList);

        return "admin-answered";
    }


    @RequestMapping(value = "/answered/{id}", method = RequestMethod.GET)
    public String viewSingleAnswered(@PathVariable(value = "id") String id , Model model){

        Long idlong = Long.parseLong(id);

        Question question = adminService.getQuestionById(idlong);

        model.addAttribute("question", question);

        return "admin-answered-question";
    }

}
