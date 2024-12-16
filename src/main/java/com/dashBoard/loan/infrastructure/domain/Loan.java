package com.dashBoard.loan.infrastructure.domain;

import com.dashBoard.book.infrastructure.domain.Book;
import com.dashBoard.user.infrastructure.domain.User;
import jakarta.persistence.*;

@Entity
public class Loan {
    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean loanYn;


    public Loan() {

    }

    public static Loan makeLoan(User user, Book book) {
        Loan loan = new Loan();
        loan.user = user;
        loan.book = book;
        loan.loanYn = true;

        return loan;
    }

    public void returnBook() {
        this.loanYn = false;
    }
}
