package com.dashBoard.user.controller;

import com.dashBoard.user.infrastructure.domain.User;
import com.dashBoard.user.infrastructure.service.UsersService;
import com.dashBoard.user.request.UserRequestDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "01.사용자 저장", description = "사용자 저장")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsersService usersService;

    @Tag(name = "01.사용자 저장")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원가입완료"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생"),
            @ApiResponse(responseCode = "U-001", description = "해당 회원은 존재하지 않습니다.")
    })
    @PostMapping("/v1/user")
    public void save(@RequestBody @Valid UserRequestDto userRequestDto) {
        usersService.save(userRequestDto);
    }

    @Tag(name = "02.사용자 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 조회 완료"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생"),
    })
    @GetMapping("/v1/user")
    public List<User> users() {
        return usersService.findAll();
    }

    @Tag(name = "03.사용자 수정")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 수정 완료"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생"),
    })
    @PutMapping("/v1/user")
    public void update(@RequestBody @Valid UserRequestDto userRequestDto) {
        usersService.update(userRequestDto);
    }

    @Tag(name = "03.사용자 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 삭제 완료"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생"),
    })
    @DeleteMapping("/v1/user")
    public void delete(@RequestParam("name") String name) {
        usersService.remove(name);
    }
}
