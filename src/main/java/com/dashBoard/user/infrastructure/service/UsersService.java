package com.dashBoard.user.infrastructure.service;

import com.dashBoard.global.error.errorCode.ErrorCode;
import com.dashBoard.global.error.exception.NotExistUserException;
import com.dashBoard.global.utils.Aes256;
import com.dashBoard.user.infrastructure.repository.UsersRepository;
import com.dashBoard.user.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final Aes256 aes256;

    @Transactional
    public void save(UserRequestDto userRequestDto) {
        if (usersRepository.existsByUserId(userRequestDto.getUserId())) {
            throw new NotExistUserException(ErrorCode.ALREADY_REGISTERED_MEMBER);
        }

        usersRepository.save(aes256.userEncryptAes256(userRequestDto));
    }
}
