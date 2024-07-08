package com.example.librarysystem.dto;

import com.example.librarysystem.entity.Book;
import lombok.Getter;

@Getter
public class BookRequestDto {
    private String title;
    private String author;
    private String language;
    private String publisher;


    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .language(language)
                .publisher(publisher).build();
    }
}
