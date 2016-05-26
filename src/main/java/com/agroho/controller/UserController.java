package com.agroho.controller;

import com.agroho.model.Question;
import com.agroho.model.User;
import com.agroho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rezau on 2016-05-12.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(){

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String adminRegister(@ModelAttribute("user") User user){

        user.setEnabled(1);
        User user1 = userService.saveAdmin(user);
        System.out.println(user1);

        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model){

        model.addAttribute("user",new User());

        return "register";
    }

}
