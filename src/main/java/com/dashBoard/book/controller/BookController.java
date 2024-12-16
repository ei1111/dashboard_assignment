package com.dashBoard.book.controller;

import com.dashBoard.book.infrastructure.service.BookService;
import com.dashBoard.book.request.BookRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("v1/book")
    public void book(@RequestBody @Valid BookRequestDto bookRequestDto) {
        bookService.save(bookRequestDto);
    }
}
