package com.relsola.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalException
 *
 * @author relsola
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable e) {
        // 这里可以记录日志
        log.error("全局异常捕获", e);
        // 返回一个友好的提示
        return "系统异常，请稍后再试！";
    }
}
