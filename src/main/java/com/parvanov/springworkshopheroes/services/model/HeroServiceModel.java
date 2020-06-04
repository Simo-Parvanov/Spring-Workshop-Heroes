package com.parvanov.springworkshopheroes.services.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroServiceModel {
    private String name;
    private String gender;
    private int level;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
    private Long userId;
}
