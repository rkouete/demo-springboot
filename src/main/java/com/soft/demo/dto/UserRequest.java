package com.soft.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UserRequest(@Email(message = "The email address is invalid.",
        flags = {Pattern.Flag.CASE_INSENSITIVE}) String email, String password) {

}
