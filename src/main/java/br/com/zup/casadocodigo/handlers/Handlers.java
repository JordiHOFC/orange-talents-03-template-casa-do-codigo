package br.com.zup.casadocodigo.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class Handlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  List<ApiError> MethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ApiError> dto=new ArrayList<>();
        List<FieldError> errors=e.getBindingResult().getFieldErrors();
         errors.forEach(erro->{
             ApiError error = new ApiError(erro.getField(), erro.getDefaultMessage());
             System.out.println(erro.toString());
             dto.add(error);
         });
        return dto;
    }
}
