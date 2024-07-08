package com.example.librarysystem.controller;

import com.example.librarysystem.dto.BookRequestDto;
import com.example.librarysystem.dto.BookResponseDto;
import com.example.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto requestDto){
        BookResponseDto responseDto = bookService.registerBook(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.findBookById(id));
    }

    @GetMapping("/bookList")
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){
        List<BookResponseDto> responseDtoList = bookService.findAllBooks();
        return ResponseEntity.ok().body(responseDtoList);
    }

}
