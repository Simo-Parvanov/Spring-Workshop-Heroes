package com.parvanov.springworkshopheroes.services.services;

import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;

public interface ValidateAuthService {
    boolean isValidate(RegisterUserServiceModel model);
}
