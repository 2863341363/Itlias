package com.yangzhong.itlias.util;

import com.yangzhong.itlias.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class Exception extends Throwable {
    @ExceptionHandler
    public Result handleException(java.lang.Exception e) {
        log.error("程序出现异常", e);
        String message = e.getMessage();
        if (message == null || message.trim().isEmpty()) {
            message = "程序出现异常，请联系管理员";
        }
        return Result.error(message);
    }
}
