package com.parvanov.springworkshopheroes.web.controllers;

import com.parvanov.springworkshopheroes.services.model.ItemServiceModel;
import com.parvanov.springworkshopheroes.services.services.HeroService;
import com.parvanov.springworkshopheroes.services.services.ItemService;
import com.parvanov.springworkshopheroes.web.models.CreateItemModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/items")
public class ItemController{
    private final ModelMapper mapper;
    private final ItemService itemService;
    private final HeroService heroService;

    public ItemController(ModelMapper mapper, ItemService itemService, HeroService heroService) {
        this.mapper = mapper;
        this.itemService = itemService;
        this.heroService = heroService;
    }

    @GetMapping("/create")
    public String getCreateItemForm(){
        return "items/create-item.html";
    }

    @GetMapping("/merchant")
    public ModelAndView getMerchant(ModelAndView modelAndView, HttpSession session){
        List<CreateItemModel> items = itemService.getItemForSale(session)
                .stream()
                .map(e -> mapper.map(e, CreateItemModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("items", items);
        modelAndView.setViewName("items/merchant.html");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreateItemForm(@ModelAttribute CreateItemModel createItemModel,
                                          ModelAndView modelAndView,
            HttpSession session) {
        ItemServiceModel itemServiceModel = mapper.map(createItemModel, ItemServiceModel.class);
        itemService.create(itemServiceModel,session);
        modelAndView.setViewName("redirect:/items/merchant");

        return modelAndView;
    }
}
