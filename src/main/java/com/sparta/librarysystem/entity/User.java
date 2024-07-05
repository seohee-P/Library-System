package com.sparta.librarysystem.entity;

import com.sparta.librarysystem.enums.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@DynamicInsert
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Gender gender;

    @Column(unique = true)
    private String socialSecurityNumber;

    @Column(unique = true)
    private String phoneNumber;

    @Column
    private String address;


    @Column(name="penalty_due_to")
    private LocalDate penaltyDueTo = LocalDate.now().minusDays(1);

    @Builder
    public User(String name, Gender gender, String socialSecurityNumber, String phoneNumber, String address) {
        this.name = name;
        this.gender = gender;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void getPenalty(LocalDate returnDate) {
        this.penaltyDueTo = returnDate.plusWeeks(2);

    }
}
