package com.sparta.librarysystem.repository;

import com.sparta.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByRegistrationDateAsc();
}
