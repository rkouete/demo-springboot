package com.soft.demo.service;


import com.soft.demo.dto.UserRequest;
import com.soft.demo.dto.UserResponse;

public interface UserService {
    UserResponse signUp(UserRequest userRequest);
    boolean existsByEmail(String email);
}
