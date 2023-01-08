package com.powerplantsystem.exceptionhandler;

import com.powerplantsystem.dtos.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * WebExceptionHandler is a class which handles all exceptions while making any REST API call
 * and provides proper error message
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class WebExceptionHandler {

    /**
     * Handles all exceptions
     *@param e
     *@return ApiError
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleException(final Exception e) {
        log.error(e.getMessage(), e);
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getLocalizedMessage());
    }
}