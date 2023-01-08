package com.powerplantsystem.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * ApiResponse is class which can be used to return common response format
 * for battery inventory related CRUD operations' functions
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */

@Data
@Builder
public class ApiResponse<T> {
    private final HttpStatus status;
    private final String message;
    private final String code;
    private T data;
}
