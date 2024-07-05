package com.sparta.librarysystem.repository;

import com.sparta.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
