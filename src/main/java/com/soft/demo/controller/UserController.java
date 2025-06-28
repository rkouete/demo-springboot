package com.soft.demo.controller;

import com.soft.demo.dto.UserRequest;
import com.soft.demo.dto.UserResponse;
import com.soft.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest userRequest) {
        //  validate input data
        // check unicity of email
        // encore password (use BCrypt. You can configure a password encoder)
        try {
            UserResponse response = userService.signUp(userRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }//
    // implements login endpoint.


}
