package com.soft.demo.service.impl;

import com.soft.demo.dto.UserRequest;
import com.soft.demo.dto.UserResponse;
import com.soft.demo.entities.User;
import com.soft.demo.repository.UserRepository;
import com.soft.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse signUp(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password()); //

        userRepository.save(user);
        return new UserResponse(user.getEmail(), user.getRoles());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
