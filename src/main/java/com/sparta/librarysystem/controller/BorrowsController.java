package com.sparta.librarysystem.controller;

import com.sparta.librarysystem.dto.BorrowHistoryResponseDto;
import com.sparta.librarysystem.dto.BorrowsResponseDto;
import com.sparta.librarysystem.dto.BorrowsRequestDto;
import com.sparta.librarysystem.service.BorrowsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowsController {
    private final BorrowsService borrowsService;

    @PostMapping("/borrow")
    public ResponseEntity<BorrowsResponseDto> borrowBook(@RequestBody BorrowsRequestDto requestDto){
        return ResponseEntity.ok().body(borrowsService.borrowBook(requestDto));
    }

    // 한 회원의 전체 대출 내역 조회
    @GetMapping("/borrows/all/{userId}")
    public ResponseEntity<List<BorrowHistoryResponseDto>> getALlBorrowsHistory(@PathVariable Long userId){
        return ResponseEntity.ok().body(borrowsService.findByUserIdAllBorrows(userId));
    }

    // 한 회원의 전체 대출 내역 조회 (반납이 안 된 것만 조회하기)
    @GetMapping("/borrows/notReturned/{userId}")
    public ResponseEntity<List<BorrowHistoryResponseDto>> getBorrowsHistoryNotReturned(@PathVariable Long userId){
        return ResponseEntity.ok().body(borrowsService.findByUserIdBorrowsNotReturned(userId));
    }

    @PatchMapping("/return")
    public void returnBook(@RequestBody BorrowsRequestDto requestDto){
        borrowsService.returnBook(requestDto);
    }

}
