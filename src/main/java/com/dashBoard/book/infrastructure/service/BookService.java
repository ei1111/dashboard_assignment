package com.dashBoard.book.infrastructure.service;

import com.dashBoard.book.infrastructure.domain.Book;
import com.dashBoard.book.infrastructure.repository.BookRepository;
import com.dashBoard.book.request.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void save(BookRequestDto requestDto) {
        bookRepository.save(Book.of(requestDto));
    }
}
