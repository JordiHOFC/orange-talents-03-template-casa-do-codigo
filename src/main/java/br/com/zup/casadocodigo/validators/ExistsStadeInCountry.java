package br.com.zup.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsStadeInCountryValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsStadeInCountry {
    String message() default " Este pais requer um estado";
    Class<?> [] groups() default  { };
    Class<? extends Payload>[] payload() default {};
    Class<?> countryClass();
    Class<?> stadeClass();


}
