package com.parvanov.springworkshopheroes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(){
        return "home/index.html";
    }
    @GetMapping("/home")
    public String getHome(HttpSession session){
        return "home/home.html";
    }
}
