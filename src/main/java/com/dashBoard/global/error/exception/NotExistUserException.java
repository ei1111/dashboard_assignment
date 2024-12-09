package com.dashBoard.global.error.exception;

import com.dashBoard.global.error.errorCode.ErrorCode;

public class NotExistUserException extends BusinessException{
    public NotExistUserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
