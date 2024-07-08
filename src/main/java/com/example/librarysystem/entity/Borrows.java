package com.example.librarysystem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Borrows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private Long userId;
    @Column(columnDefinition = "TINYINT(1)")
    @ColumnDefault("false")
    private Boolean isReturned;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private LocalDate borrowDate;
    private LocalDate returnDate;

    @Builder
    public Borrows(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public void update() {
        this.returnDate = LocalDate.now();
        this.isReturned = true;
    }
}
