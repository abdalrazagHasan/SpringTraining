package com.junior.controller;

import com.junior.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute User user, Errors errors){
        if (errors.hasErrors()){
            return "login";
        }
        return "home";
    }

    

}
