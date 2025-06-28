package com.soft.demo.dto;

import java.util.List;

public record UserResponse(String email, List<String> roles) {
}
