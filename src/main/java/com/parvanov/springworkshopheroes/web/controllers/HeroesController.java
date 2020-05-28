package com.parvanov.springworkshopheroes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    @GetMapping("/create")
    public String getHeroesCreateForm(){
        return "heroes/hero-create.html";
    }

    @GetMapping("/details/{name}")
    public String getHeroesDetails(@PathVariable String name){
        return "heroes/hero-details.html";
    }
}
