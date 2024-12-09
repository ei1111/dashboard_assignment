package com.dashBoard.global.error.exception;

import com.dashBoard.global.error.errorCode.ErrorCode;

public class NotSuccessGetApiException extends BusinessException{
    public NotSuccessGetApiException(ErrorCode errorCode) {
        super(errorCode);
    }
}
