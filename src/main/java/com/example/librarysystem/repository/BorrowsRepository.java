package com.example.librarysystem.repository;

import com.example.librarysystem.entity.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowsRepository extends JpaRepository<Borrows,Long> {
    List<Borrows> findAllByUserIdAndIsReturnedFalseOrderByBorrowDateAsc(Long userId);
    List<Borrows> findAllByUserId(Long userId);
    Borrows findByBookIdAndIsReturnedFalse(Long bookId);
}
