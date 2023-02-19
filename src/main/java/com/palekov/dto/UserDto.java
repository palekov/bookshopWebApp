package com.palekov.dto;

import com.palekov.model.enums.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private Set<Role> role = new HashSet<>();
    private String email;
    private String phone;
    private String address;
    private String password;
}
