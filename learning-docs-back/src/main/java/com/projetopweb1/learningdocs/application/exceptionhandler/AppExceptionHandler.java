package com.projetopweb1.learningdocs.application.exceptionhandler;

import com.projetopweb1.learningdocs.domain.exceptions.BusinessException;
import com.projetopweb1.learningdocs.presentation.dto.appexception.AppExceptionDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    // handle @valid annotation
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("message", errors);

        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handlerBusinessException(BusinessException ex){
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        String statusCodeMessage = HttpStatus.BAD_REQUEST.getReasonPhrase();
        AppExceptionDTO appExceptionDTO = new AppExceptionDTO(statusCode.value(), statusCodeMessage, ex.getMessage());
        return new ResponseEntity<>(appExceptionDTO,statusCode);
    }

}
