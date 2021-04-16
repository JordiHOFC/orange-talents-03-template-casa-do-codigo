package br.com.zup.casadocodigo.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {
    String domainAtribute;
    Class<?> klass;

    private final EntityManager em;

    public UniqueValueValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(UniqueValue params) {
        this.domainAtribute= params.fieldName();
        this.klass=params.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query=em.createQuery("select r from "+klass.getName()+" r where "+domainAtribute+" = :value");
        query.setParameter("value",o);
        List<?> results= query.getResultList();
       Assert.state(results.size()<=1,"foi encontrado mais de um "+klass+"com este atributo "+domainAtribute+"igual a "+o);
        return results.isEmpty();
    }
}
