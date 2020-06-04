package com.parvanov.springworkshopheroes.services.services;

import com.parvanov.springworkshopheroes.services.model.ItemServiceModel;
import com.parvanov.springworkshopheroes.web.models.CreateItemModel;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ItemService {
    void create(ItemServiceModel itemServiceModel, HttpSession session);
    List<ItemServiceModel> getItemForSale(HttpSession session);
}
