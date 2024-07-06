package com.sparta.librarysystem.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BorrowHistoryResponseDto {
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private Long userId;
    private String userName;
    private String userPhoneNumber;
    private Boolean isReturned;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    @Builder

    public BorrowHistoryResponseDto(Long bookId, Long userId, LocalDate borrowDate, LocalDate returnDate, Boolean isReturned, String userName, String userPhoneNumber, String bookName, String bookAuthor) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
}
