package com.sparta.librarysystem.repository;

import com.sparta.librarysystem.entity.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowsRepository extends JpaRepository<Borrows,Long> {
    List<Borrows> findAllByUserIdAndIsReturnedFalseOrderByBorrowDateAsc(Long userId);
    List<Borrows> findAllByUserId(Long userId);
    Borrows findByBookIdAndIsReturnedFalse(Long bookId);
}
