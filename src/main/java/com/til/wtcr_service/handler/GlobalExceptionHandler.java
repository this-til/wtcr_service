package com.til.wtcr_service.handler;

import com.til.wtcr_service.pojo.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public Result<Void> handler(Exception e) {
        logger.error("An exception occurred: ", e);
        return Result.error(e.getClass().getName() + ":" + e.getMessage());
    }

}
