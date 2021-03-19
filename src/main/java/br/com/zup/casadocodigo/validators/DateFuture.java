package br.com.zup.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {DateFutureValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFuture {
    String message() default "Data informada deve ser maior que a data atual";
    Class<?> [] groups() default  { };
    Class<? extends Payload>[] payload() default {};

}
