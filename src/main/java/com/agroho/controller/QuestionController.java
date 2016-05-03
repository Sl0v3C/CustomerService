package com.agroho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rezaul on 5/1/16.
 */
@Controller
public class QuestionController {


    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String askQuestion(){
        return "question";
    }

}
