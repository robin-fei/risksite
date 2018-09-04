package com.wpt.risk.exception;

import com.wpt.risk.base.exception.RecordUsedException;
import com.wpt.risk.base.exception.RiskException;
import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.util.ApiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object processValidationError(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(), ex);
        String result = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));

        return ApiUtils.getResponseBody(ErrorCode.PARAMETERS_ERROR, result);
    }

    @ExceptionHandler(RecordUsedException.class)
    public Object handleException(RecordUsedException e) {
        logger.error("failed@ExceptionHandlerController.handleException", e);
        return ApiUtils.getResponseBody(ErrorCode.USED_EXCEPTION_ERROR);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Object handleException(DuplicateKeyException e) {
        logger.error("failed@ExceptionHandlerController.handleException", e);
        return ApiUtils.getResponseBody(ErrorCode.DUPLICATION_EXCEPTION_ERROR);
    }

    @ExceptionHandler(RiskException.class)
    public Object handleRiskException(Exception e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);
        return ApiUtils.getResponseBody(ErrorCode.RISK_EXCEPTION_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);
        return ApiUtils.getResponseBody(ErrorCode.SYS_ERROR);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleException(HttpMessageNotReadableException e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);

        return ApiUtils.getResponseBody(ErrorCode.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object handleException(NoHandlerFoundException e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);

        return ApiUtils.getResponseBody(ErrorCode.API_NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleException(HttpRequestMethodNotSupportedException e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);

        return ApiUtils.getResponseBody(ErrorCode.API_NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleException(HttpMediaTypeNotSupportedException e) {
        logger.error("failed@ExceptionHandlerController.handleRiskException", e);

        return ApiUtils.getResponseBody(ErrorCode.BAD_CONTENT_TYPE);
    }
}