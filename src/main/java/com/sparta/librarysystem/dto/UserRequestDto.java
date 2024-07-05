package com.sparta.librarysystem.dto;

import com.sparta.librarysystem.entity.User;
import com.sparta.librarysystem.enums.Gender;
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
