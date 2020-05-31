package com.parvanov.springworkshopheroes.services.services.impl;

import com.parvanov.springworkshopheroes.data.repositories.UserRepository;
import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;
import com.parvanov.springworkshopheroes.services.services.ValidateAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthValidateServiceImpl implements ValidateAuthService {
    private final UserRepository userRepository;

    public AuthValidateServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValidate(RegisterUserServiceModel user) {
        return isEmailValid(user.getEmail()) &&
                arePasswordValid(user.getPassword(), user.getConfirmPassword()) &&
                isUsernameFree(user.getUsername());
    }

    private boolean isUsernameFree(String username) {
        return !userRepository.existsByUsername(username);
    }

    private boolean arePasswordValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    private boolean isEmailValid(String email) {
        return true;
    }
}
