package com.sparta.librarysystem.dto;

import com.sparta.librarysystem.entity.Book;
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
