package com.dashBoard.global.error.exception;


import com.dashBoard.global.error.errorCode.ErrorCode;

public class AuthenticationException extends BusinessException{

    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
