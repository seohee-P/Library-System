package com.sparta.librarysystem.service;

import com.sparta.librarysystem.dto.BookRequestDto;
import com.sparta.librarysystem.dto.BookResponseDto;
import com.sparta.librarysystem.entity.Book;
import com.sparta.librarysystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDto registerBook(BookRequestDto bookRequestDto) {
        return new BookResponseDto(bookRepository.save(bookRequestDto.toEntity()));
    }

    public List<BookResponseDto> findAllBooks() {
        return bookRepository.findAllByOrderByRegistrationDateAsc()
                .stream().map(BookResponseDto::new).toList();
    }


    public BookResponseDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        return new BookResponseDto(book);
    }



}
