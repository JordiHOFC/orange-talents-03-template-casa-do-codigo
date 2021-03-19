package br.com.zup.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsRegisterValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsRegister {
    String message() default "Não existe registro relacionado a este identificador unico";
    Class<?> [] groups() default  { };
    Class<? extends Payload>[] payload() default {};
    Class<?> domainClass();
}
