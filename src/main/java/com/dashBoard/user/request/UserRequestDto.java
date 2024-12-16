package com.dashBoard.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long id;

    @Schema(description = "이름", example = "홍길동")
    @NotBlank(message = "이름은 필수입니다")
    private String name;

    @Schema(description = "나이", example = "20")
    private int age;

    public UserRequestDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
