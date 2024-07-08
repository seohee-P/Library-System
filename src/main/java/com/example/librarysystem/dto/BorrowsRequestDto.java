package com.example.librarysystem.dto;

import com.example.librarysystem.entity.Borrows;
import lombok.Getter;

@Getter
public class BorrowsRequestDto {
    private Long bookId;
    private Long userId;

    public Borrows toEntity() {
        return Borrows.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }
}
