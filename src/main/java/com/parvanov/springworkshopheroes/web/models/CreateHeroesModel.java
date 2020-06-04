package com.parvanov.springworkshopheroes.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateHeroesModel {
    private String name;
    private String gender;
    private Long userId;
}
