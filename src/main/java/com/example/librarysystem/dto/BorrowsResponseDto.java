package com.example.librarysystem.dto;

import com.example.librarysystem.entity.Borrows;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BorrowsResponseDto {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Boolean isReturned;

    public BorrowsResponseDto(Borrows borrows) {
        this.id = borrows.getId();
        this.userId = borrows.getUserId();
        this.bookId = borrows.getBookId();
        this.borrowDate = borrows.getBorrowDate();
        this.returnDate = borrows.getReturnDate();
        this.isReturned = borrows.getIsReturned();
    }
}
