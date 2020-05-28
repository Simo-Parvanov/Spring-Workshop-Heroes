package com.parvanov.springworkshopheroes.web.controllers;

import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;
import com.parvanov.springworkshopheroes.services.services.AuthServices;
import com.parvanov.springworkshopheroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AuthController {
    private final AuthServices authServices;
    private final ModelMapper modelMapper;

    public AuthController(AuthServices authServices, ModelMapper modelMapper) {
        this.authServices = authServices;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute RegisterUserModel model) {
        RegisterUserServiceModel userModel = modelMapper.map(model, RegisterUserServiceModel.class);
        authServices.register(userModel);
        return "/";
    }
}

