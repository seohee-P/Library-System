package com.sparta.librarysystem.repository;

import com.sparta.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPenaltyDueToIsGreaterThanEqual(LocalDate now);
}
