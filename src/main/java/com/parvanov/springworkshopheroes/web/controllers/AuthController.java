package com.parvanov.springworkshopheroes.web.controllers;

import com.parvanov.springworkshopheroes.services.model.LoginServiceUserModel;
import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;
import com.parvanov.springworkshopheroes.services.services.AuthService;
import com.parvanov.springworkshopheroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {
    private final AuthService authServices;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authServices, ModelMapper modelMapper) {
        this.authServices = authServices;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String getRegisterForm() {
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String userRegister(@ModelAttribute RegisterUserModel model) {
        RegisterUserServiceModel userModel = modelMapper.map(model, RegisterUserServiceModel.class);
        authServices.register(userModel);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @PostMapping("/login")
    public String userLogin(@ModelAttribute RegisterUserModel model, HttpSession session) {
        RegisterUserServiceModel userModel = modelMapper.map(model, RegisterUserServiceModel.class);
        try {
          LoginServiceUserModel loginModel = authServices.login(userModel);
            session.setAttribute("user", loginModel);
            session.setAttribute("username", userModel.getUsername());
            return "redirect:/home";
        }catch (Exception ex){
            return "redirect:/users/login";
        }
    }

}

