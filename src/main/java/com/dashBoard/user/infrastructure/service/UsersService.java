package com.dashBoard.user.infrastructure.service;

import com.dashBoard.global.error.errorCode.ErrorCode;
import com.dashBoard.global.error.exception.NotExistUserException;
import com.dashBoard.user.infrastructure.domain.User;
import com.dashBoard.user.infrastructure.repository.UserRepository;
import com.dashBoard.user.request.UserRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.dashBoard.global.error.errorCode.ErrorCode.*;
import static com.dashBoard.user.infrastructure.domain.User.of;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsersService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserRequestDto userRequestDto) {
        if (userRepository.existsByName(userRequestDto.getName())) {
            throw new NotExistUserException(ALREADY_REGISTERED_MEMBER);
        }

        userRepository.save(of(userRequestDto));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId()).get();
        user.update(userRequestDto);
    }

    @Transactional
    public void remove(String name) {
        User user = userRepository.findUserByName(name).get();
        userRepository.delete(user);
    }
}
