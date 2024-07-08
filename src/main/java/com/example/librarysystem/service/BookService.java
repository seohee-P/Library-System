package com.example.librarysystem.service;

import com.example.librarysystem.dto.BookRequestDto;
import com.example.librarysystem.dto.BookResponseDto;
import com.example.librarysystem.entity.Book;
import com.example.librarysystem.repository.BookRepository;
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
