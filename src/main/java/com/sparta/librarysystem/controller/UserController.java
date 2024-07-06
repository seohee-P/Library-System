package com.sparta.librarysystem.controller;

import com.sparta.librarysystem.dto.UserRequestDto;
import com.sparta.librarysystem.dto.UserResponseDto;
import com.sparta.librarysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.createUser(requestDto));
    }

    // 현재 패널티를 받고 있는 회원 조회
    @GetMapping("/user/penalty")
    public ResponseEntity<List<UserResponseDto>> getPenaltyUser(){
        return ResponseEntity.ok(userService.getPenaltyUser());
    }
}
