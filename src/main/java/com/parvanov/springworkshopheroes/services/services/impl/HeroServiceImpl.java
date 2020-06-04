package com.parvanov.springworkshopheroes.services.services.impl;

import com.parvanov.springworkshopheroes.data.models.Hero;
import com.parvanov.springworkshopheroes.data.models.Item;
import com.parvanov.springworkshopheroes.data.repositories.HeroRepository;
import com.parvanov.springworkshopheroes.services.model.HeroServiceModel;
import com.parvanov.springworkshopheroes.services.model.LoginServiceUserModel;
import com.parvanov.springworkshopheroes.services.services.AuthService;
import com.parvanov.springworkshopheroes.services.services.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper mapper;
    private final AuthService authService;


    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper mapper, AuthService authService) {
        this.heroRepository = heroRepository;
        this.mapper = mapper;

        this.authService = authService;
    }

    @Override
    public void create(HeroServiceModel heroServiceModel, HttpSession session) {
        heroServiceModel.setGender(heroServiceModel.getGender().toUpperCase());
        LoginServiceUserModel user = (LoginServiceUserModel) session.getAttribute("user");
        heroServiceModel.setUserId(authService.userId(user.getUsername()));
        user.setHeroName(heroServiceModel.getName());
        session.setAttribute("user",user);
        Hero hero = mapper.map(heroServiceModel, Hero.class);
        heroRepository.saveAndFlush(hero);
    }

    @Override
    public Hero getHeroByName(String name) {
        return heroRepository.findHeroByName(name);
    }

}
