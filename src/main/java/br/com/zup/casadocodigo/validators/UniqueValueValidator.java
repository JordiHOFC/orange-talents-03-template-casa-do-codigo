package br.com.zup.casadocodigo.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {
    private String domainAtribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(UniqueValue params) {
        this.domainAtribute= params.fieldName();
        this.klass=params.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query=em.createQuery("select 1 from "+klass.getName()+" where "+domainAtribute+" = :value");
        query.setParameter("value",o);
        List<?> results= query.getResultList();
        Assert.state(results.size()<=1,"foi encontrado mais de um "+klass+"com este atributo "+domainAtribute+"igual a "+o);
        return results.isEmpty();
    }
}
