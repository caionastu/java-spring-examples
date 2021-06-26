package com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionsHandler {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleValidationErrors(MethodArgumentNotValidException exception, Locale locale) {
        ErrorMessage errorMessage = new ErrorMessage(messageSource.getMessage("validation.exception.title", null, locale));
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                String message = messageSource.getMessage(fieldError.getCode(), fieldError.getArguments(), fieldError.getDefaultMessage(), locale);
                errorMessage.addDetail(String.format("%s: %s", fieldError.getField(), message));
            } else {
                errorMessage.addDetail(messageSource.getMessage(error.getCode(), error.getArguments(), locale));
            }
        }
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorMessage handleBusinessExceptions(BusinessException exception, Locale locale) {
        return handleExceptionMessage("business.exception.title", exception, locale);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleNotFoundExceptions(NotFoundException exception, Locale locale) {
        return handleExceptionMessage("notFound.exception.title", exception, locale);
    }

    private ErrorMessage handleExceptionMessage(String keyMessage, BusinessException exception, Locale locale) {
        ErrorMessage errorMessage = new ErrorMessage(messageSource.getMessage(keyMessage, null, locale));
        errorMessage.addDetail(messageSource.getMessage(exception.getKeyMessage(), exception.getArguments(), locale));
        return errorMessage;
    }
}
