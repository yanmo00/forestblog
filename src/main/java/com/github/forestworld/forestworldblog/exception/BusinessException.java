package com.github.forestworld.forestworldblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public  class BusinessException extends RuntimeException{
    /**
     * Error errorData.
     */
    private Object errorData;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Http status code
     *
     * @return {@link HttpStatus}
     */

    @Nullable
    public Object getErrorData() {
        return errorData;
    }

    /**
     * Sets error errorData.
     *
     * @param errorData error data
     * @return current exception.
     */
    @NonNull
    public BusinessException setErrorData(@Nullable Object errorData) {
        this.errorData = errorData;
        return this;
    }
}
