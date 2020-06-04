package com.parvanov.springworkshopheroes.web.models;

import com.parvanov.springworkshopheroes.data.models.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateItemModel {
    private String name;
    private String slot;
    private int level;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
}
