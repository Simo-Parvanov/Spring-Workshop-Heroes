package com.parvanov.springworkshopheroes.web.controllers;

import com.parvanov.springworkshopheroes.services.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersController{
    private final AuthService authService;

    public UsersController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/profile")
    public ModelAndView getUserProfile(ModelAndView modelAndView, HttpSession session){
        Object name = session.getAttribute("username");
        modelAndView.addObject("email",authService.getUserEmail(name.toString()));
        modelAndView.setViewName("users/profile");
        return modelAndView;
    }

}
