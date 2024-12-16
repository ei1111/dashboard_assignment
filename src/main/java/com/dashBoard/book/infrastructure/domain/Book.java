package com.dashBoard.book.infrastructure.domain;

import com.dashBoard.book.request.BookRequestDto;
import com.dashBoard.loan.infrastructure.domain.Loan;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "book")
    private Loan loan;

    public Book() {
    }

    private Book(String name) {
        this.name = name;

    }

    public static Book of(BookRequestDto bookRequestDto) {
        return new Book(bookRequestDto.getName());
    }

}
