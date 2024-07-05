package com.sparta.librarysystem.service;

import com.sparta.librarysystem.dto.BorrowHistoryResponseDto;
import com.sparta.librarysystem.dto.BorrowsRequestDto;
import com.sparta.librarysystem.dto.BorrowsResponseDto;
import com.sparta.librarysystem.entity.Book;
import com.sparta.librarysystem.entity.Borrows;
import com.sparta.librarysystem.entity.User;
import com.sparta.librarysystem.repository.BookRepository;
import com.sparta.librarysystem.repository.BorrowsRepository;
import com.sparta.librarysystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowsService {
    private final BorrowsRepository borrowsRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public BorrowsResponseDto borrowBook(BorrowsRequestDto requestDto) {
        Book book = bookRepository.findById(requestDto.getBookId()).orElseThrow(()->
                new IllegalArgumentException("해당 책이 없습니다."));
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 없습니다."));
        // 책을 빌릴 수 없다면
        if (!book.getCanBorrow()) throw new IllegalArgumentException("다른 회원이 이용중이므로 해당 책은 빌릴 수 없습니다.");
        // 패널티를 받고 있는 중이라면 -> 아직 패널티 날짜를 지나지 않음.)
        if (!LocalDate.now().isAfter(user.getPenaltyDueTo())) throw new RuntimeException("패널티 기간에는 책을 대출할 수 없습니다.");
        // 7일이 넘었는데도 반납을 안한 책이 있다면
        List<Borrows> borrows = borrowsRepository.findAllByUserIdAndIsReturnedFalseOrderByBorrowDateAsc(requestDto.getUserId());
        for (Borrows borrow : borrows) {
            if (LocalDate.now().isAfter(borrow.getBorrowDate().plusDays(7)))
                throw new IllegalArgumentException("7일 이내에 반납하지 않은 책이 있어 책을 대출할 수 없습니다.");
        }

        book.update("borrowed");
        return new BorrowsResponseDto(borrowsRepository.save(requestDto.toEntity()));
    }

   public List<BorrowHistoryResponseDto> findByUserIdAllBorrows(Long userId) {
        List<Borrows> borrowsList= borrowsRepository.findAllByUserId(userId);
        List<BorrowHistoryResponseDto> result = new ArrayList<>();
       for (Borrows borrows : borrowsList) {
           Book book = bookRepository.findById(borrows.getBookId()).orElseThrow(()->
                   new IllegalArgumentException("해당 책이 없습니다."));
           User user = userRepository.findById(borrows.getUserId()).orElseThrow(()->
                   new IllegalArgumentException("해당 회원이 없습니다."));
           result.add(BorrowHistoryResponseDto.builder()
                   .bookName(book.getTitle())
                   .bookAuthor(book.getAuthor())
                   .userName(user.getName())
                   .userPhoneNumber(user.getPhoneNumber())
                   .build());
       }
       return result;
   }

    public List<BorrowHistoryResponseDto> findByUserIdBorrowsNotReturned(Long userId) {
        List<Borrows> borrowsList = borrowsRepository
                .findAllByUserIdAndIsReturnedFalseOrderByBorrowDateAsc(userId);
        List<BorrowHistoryResponseDto> result = new ArrayList<>();
        for (Borrows borrows : borrowsList) {
            Book book = bookRepository.findById(borrows.getBookId()).orElseThrow(()->
                    new IllegalArgumentException("해당 책이 없습니다."));
            User user = userRepository.findById(borrows.getUserId()).orElseThrow(()->
                    new IllegalArgumentException("해당 회원이 없습니다."));
            result.add(BorrowHistoryResponseDto.builder()
                    .bookName(book.getTitle())
                    .bookAuthor(book.getAuthor())
                    .userName(user.getName())
                    .userPhoneNumber(user.getPhoneNumber())
                    .build());
        }
        return result;
    }
    @Transactional
    public void returnBook(BorrowsRequestDto requestDto) {
        Book book = bookRepository.findById(requestDto.getBookId()).orElseThrow(()->
                new IllegalArgumentException("해당 책이 없습니다"));
        book.update("borrowed");
        Borrows borrow = borrowsRepository.findByBookIdAndIsReturnedFalse(requestDto.getBookId());
        borrow.update();
        // 책을 7일 이내에 반납 안했으면
        if (borrow.getReturnDate().isAfter(borrow.getBorrowDate().plusDays(7))) {
            User user = userRepository.findById(borrow.getUserId()).orElseThrow(()->
                    new IllegalArgumentException("해당 회원이 없습니다."));
            user.getPenalty(borrow.getReturnDate());
        }
    }
}
