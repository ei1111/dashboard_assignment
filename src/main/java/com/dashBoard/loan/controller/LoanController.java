package com.dashBoard.loan.controller;

import com.dashBoard.loan.infrastructure.domain.Loan;
import com.dashBoard.loan.infrastructure.service.LoanService;
import com.dashBoard.loan.request.LoanRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping("v1/book/loan")
    public void loan(@RequestBody LoanRequestDto loanRequestDto) {
        loanService.save(loanRequestDto);
    }

    @PutMapping("v1/book/return")
    public void returnBook(@RequestBody LoanRequestDto loanRequestDto) {
        loanService.returnBook(loanRequestDto);
    }
}
