package com.sparta.librarysystem.entity;

import com.sparta.librarysystem.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String language;
    @Column
    private String publisher;

    @CreatedDate
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @ColumnDefault("true")
    @Column(name = "can_borrow",columnDefinition = "TINYINT(1)")
    private Boolean canBorrow;

    @Builder
    public Book(String title, String author, String language, String publisher) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
    }

    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
    }

    public void update(String state){
        if (state.equals("borrowed")) this.canBorrow = false;
        else if (state.equals("returned")) this.canBorrow = true;
    }


}
