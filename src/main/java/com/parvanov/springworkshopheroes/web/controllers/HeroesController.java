package com.parvanov.springworkshopheroes.web.controllers;

import com.parvanov.springworkshopheroes.services.model.HeroServiceModel;
import com.parvanov.springworkshopheroes.services.services.HeroService;
import com.parvanov.springworkshopheroes.web.models.CreateHeroesModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/heroes")
public class HeroesController {
    private final ModelMapper mapper;
    private final HeroService heroService;

    public HeroesController(ModelMapper mapper, HeroService heroService) {
        this.mapper = mapper;
        this.heroService = heroService;
    }

    @GetMapping("/create")
    public String getHeroesCreateForm(){
        return "heroes/hero-create.html";
    }

    @GetMapping("/details/{name}")
    public String getHeroesDetails(@PathVariable String name){
        return "heroes/hero-details.html";
    }

    @PostMapping("/create")
    public String createHeroes(@ModelAttribute CreateHeroesModel heroesModel, HttpSession session){
        HeroServiceModel heroServiceModel = mapper.map(heroesModel,HeroServiceModel.class);
        heroService.create(heroServiceModel, session);
        return "redirect:/home";
    }
}
