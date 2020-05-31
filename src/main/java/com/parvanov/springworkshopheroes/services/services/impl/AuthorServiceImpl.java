package com.parvanov.springworkshopheroes.services.services.impl;

import com.parvanov.springworkshopheroes.data.models.User;
import com.parvanov.springworkshopheroes.data.repositories.UserRepository;
import com.parvanov.springworkshopheroes.services.model.LoginServiceUserModel;
import com.parvanov.springworkshopheroes.services.model.RegisterUserServiceModel;
import com.parvanov.springworkshopheroes.services.services.AuthService;
import com.parvanov.springworkshopheroes.services.services.HashingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthService {
    private final AuthValidateServiceImpl validateService;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final HashingService hashingService;

    public AuthorServiceImpl(AuthValidateServiceImpl validateService, UserRepository userRepository, ModelMapper mapper, HashingService hashingService) {
        this.validateService = validateService;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterUserServiceModel model) {
        if (!validateService.isValidate(model)) {
            return;
        }
        User user = mapper.map(model, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public LoginServiceUserModel login(RegisterUserServiceModel userModel) throws Exception {
        String hashPass = hashingService.hash(userModel.getPassword());
        Optional<User> userOptional = this.userRepository.findByUsernameAndPassword(userModel.getUsername(),hashPass);
        if (userOptional.isEmpty()) {
        throw new Exception("Invalid User!");
        }
        User user = userOptional.get();
        String heroName = user.getHero() == null ? null : user.getHero().getName();
        return new LoginServiceUserModel(userModel.getUsername(), heroName);
    }
}
