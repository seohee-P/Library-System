package com.sparta.librarysystem.service;

import com.sparta.librarysystem.dto.UserRequestDto;
import com.sparta.librarysystem.dto.UserResponseDto;
import com.sparta.librarysystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        return new UserResponseDto(userRepository.save(requestDto.toEntity()));
    }

    public UserResponseDto findUserById(Long id) {
        return new UserResponseDto(userRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("User with id " + id + " not found")));
    }

}
