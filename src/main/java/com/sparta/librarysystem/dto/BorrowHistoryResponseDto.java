package com.sparta.librarysystem.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BorrowHistoryResponseDto {
    private String userName;
    private String userPhoneNumber;
    private String bookName;
    private String bookAuthor;

    @Builder
    public BorrowHistoryResponseDto(String userName, String userPhoneNumber, String bookName, String bookAuthor) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
}
