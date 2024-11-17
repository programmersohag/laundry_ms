package com.sohag.laundry_backend.dto;

import lombok.Data;

@Data
public class UsersDto {
    private String name;
    private String username;
    private String password;
    private String level;
}
