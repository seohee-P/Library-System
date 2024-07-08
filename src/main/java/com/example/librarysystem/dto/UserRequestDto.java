package com.example.librarysystem.dto;

import com.example.librarysystem.entity.User;
import com.example.librarysystem.enums.Gender;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name;
    private Gender gender;
    private String socialSecurityNumber;
    private String phoneNumber;
    private String address;

    public User toEntity() {
        return User.builder()
                .name(name)
                .gender(gender)
                .socialSecurityNumber(socialSecurityNumber)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();
    }
}
