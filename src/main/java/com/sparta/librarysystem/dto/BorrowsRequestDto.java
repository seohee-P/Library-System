package com.sparta.librarysystem.dto;

import com.sparta.librarysystem.entity.Borrows;
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
