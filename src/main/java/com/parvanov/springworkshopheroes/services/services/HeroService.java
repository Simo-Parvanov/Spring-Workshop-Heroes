package com.parvanov.springworkshopheroes.services.services;

import com.parvanov.springworkshopheroes.data.models.Hero;
import com.parvanov.springworkshopheroes.data.models.Item;
import com.parvanov.springworkshopheroes.services.model.HeroServiceModel;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface HeroService {
    void create(HeroServiceModel heroServiceModel, HttpSession httpSession);
    Hero getHeroByName(String name);

}
