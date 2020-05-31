package com.parvanov.springworkshopheroes.services.services;

import com.parvanov.springworkshopheroes.services.model.LoginServiceUserModel;
import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;

public interface AuthService {
    void register(RegisterUserServiceModel model);

    LoginServiceUserModel login(RegisterUserServiceModel userModel) throws Exception;
}
