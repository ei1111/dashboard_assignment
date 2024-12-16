package com.dashBoard.loan.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRequestDto {
    @NotEmpty(message = "책 이름은 필수 입니다.")
    private String bookName;

    @NotEmpty(message = "사용자 이름은 필수 입니다.")
    private String userName;
}
