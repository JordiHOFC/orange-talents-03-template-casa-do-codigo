package br.com.zup.casadocodigo.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsRegisterValidator implements ConstraintValidator<ExistsRegister,Object> {
    private Class<?> klazz;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(ExistsRegister params) {
        this.klazz=params.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext){
        Query query= em.createQuery("select e from "+klazz.getName()+" e where e.id =:element");
        query.setParameter("element",o);
        List<?> register= query.getResultList();
         if(register.isEmpty()){
             return false;
         }

        return register.size()==1;
    }
}
