package com.dashBoard.book.infrastructure.repository;

import com.dashBoard.book.infrastructure.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByName(String bookName);
    Optional<Book> findByName(String bookName);
}
