package com.sparta.librarysystem.controller;

import com.sparta.librarysystem.dto.UserRequestDto;
import com.sparta.librarysystem.dto.UserResponseDto;
import com.sparta.librarysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.createUser(requestDto));
    }
}
