package com.sparta.librarysystem.dto;

import com.sparta.librarysystem.entity.User;
import com.sparta.librarysystem.enums.Gender;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Gender gender;
    private String phoneNumber;
    private String address;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }
}
