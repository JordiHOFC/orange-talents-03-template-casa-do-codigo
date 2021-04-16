package br.com.zup.casadocodigo.handlers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Handlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public  List<ApiError> MethodArgumentNotValid(MethodArgumentNotValidException e){
        return e.getBindingResult().getFieldErrors().stream().map(ApiError::new).collect(Collectors.toList());

    }
}
