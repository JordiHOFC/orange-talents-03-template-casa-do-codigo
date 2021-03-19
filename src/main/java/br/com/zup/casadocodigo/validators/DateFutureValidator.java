package br.com.zup.casadocodigo.validators;

import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateFutureValidator implements ConstraintValidator<DateFuture, LocalDate> {
    @Override
    public void initialize(DateFuture constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate today=LocalDate.now();
       if(localDate.isBefore(today))
           return  false;
        return today.isBefore(localDate);
    }
}
