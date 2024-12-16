package com.dashBoard.login;

import com.dashBoard.global.error.errorCode.ErrorCode;
import com.dashBoard.global.error.exception.NotExistUserException;
import com.dashBoard.user.infrastructure.domain.User;
import com.dashBoard.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userRepository.findUserByName(name).orElseThrow(() -> new NotExistUserException(ErrorCode.MEMBER_NOT_EXIST));
        return Objects.nonNull(user) ? new CustomUserDetails(user) : null;
    }
}
