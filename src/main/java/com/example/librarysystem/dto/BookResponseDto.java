package com.example.librarysystem.dto;

import com.example.librarysystem.entity.Book;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookResponseDto {

    private Long id;
    private String title;
    private String author;
    private String language;
    private String publisher;
    private LocalDateTime registrationDate;
    private Boolean canBorrow;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.registrationDate = book.getRegistrationDate();
        this.canBorrow = book.getCanBorrow();
    }
}
