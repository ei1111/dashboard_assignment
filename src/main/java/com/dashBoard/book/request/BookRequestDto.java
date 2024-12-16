package com.dashBoard.book.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class BookRequestDto {
    @NotEmpty(message = "책 이름은 필수 입니다")
    @Column(nullable = false)
    private String name;
}
