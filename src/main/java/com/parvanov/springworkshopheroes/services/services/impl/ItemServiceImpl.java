package com.parvanov.springworkshopheroes.services.services.impl;

import com.parvanov.springworkshopheroes.data.models.Hero;
import com.parvanov.springworkshopheroes.data.models.Item;
import com.parvanov.springworkshopheroes.data.repositories.ItemRepository;
import com.parvanov.springworkshopheroes.services.model.ItemServiceModel;
import com.parvanov.springworkshopheroes.services.model.LoginServiceUserModel;
import com.parvanov.springworkshopheroes.services.services.HeroService;
import com.parvanov.springworkshopheroes.services.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final HeroService heroService;



    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, HeroService heroService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @Override
    public void create(ItemServiceModel itemServiceModel, HttpSession session) {
        LoginServiceUserModel user = (LoginServiceUserModel) session.getAttribute("user");
        Item item = modelMapper.map(itemServiceModel, Item.class);
        Hero hero = heroService.getHeroByName(user.getHeroName());
        item.setHeroes(hero);
        itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemServiceModel> getItemForSale(HttpSession session) {
        LoginServiceUserModel user = (LoginServiceUserModel) session.getAttribute("user");
        Hero hero = heroService.getHeroByName(user.getHeroName());
        List<Item> m = itemRepository.findByHeroes(hero);
        return m.stream()
                .map(e -> modelMapper.map(e, ItemServiceModel.class))
                .collect(Collectors.toList());
    }
}
