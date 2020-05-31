package com.parvanov.springworkshopheroes.services.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginServiceUserModel {
    private String username;
    private String heroName;

    public LoginServiceUserModel(String username, String heroName) {
        this.username = username;
        this.heroName = heroName;
    }
}
