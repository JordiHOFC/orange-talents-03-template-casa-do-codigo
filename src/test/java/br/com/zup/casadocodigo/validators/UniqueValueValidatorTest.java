package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Autor.AutorRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;
import javax.validation.*;

import java.lang.annotation.Annotation;



@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UniqueValueValidatorTest {
    @PersistenceContext
    private EntityManager manager;
    private static final Class<?> DOMAIN_CLASS=Autor.class;
    private static final String DOMAIN_ATRIBUTE="email";

     UniqueValueTestCase testCase;
     ConstraintValidatorContext ctx;
     UniqueValueValidator validator;
     AutorRequest autor;

    @Before
    public void setUp(){
        testCase= new UniqueValueTestCase();
        ctx=Mockito.mock(ConstraintValidatorContext.class);
        validator= new UniqueValueValidator(manager);
    }

    @Test
    @Transactional
    public void deveRetornarUmErro(){
        autor=new AutorRequest("joao",",moreno alto bonito e sensual","jordi@gmail.com");
        manager.persist(autor.toModelo());
        String request="jordi@gmail.com";
        validator.initialize(testCase);
        boolean  exist=validator.isValid(request,ctx);
        Assert.assertFalse(exist);
    }




private static class UniqueValueTestCase implements UniqueValue{


    @Override
    public String message() {
        return "Valor já registrado em banco de dados";
    }

    @Override
    public Class<?>[] groups() {
        return new Class[]{};
    }

    @Override
    public Class<? extends Payload>[] payload() {
        return new Class[]{};
    }

    @Override
    public String fieldName() {
        return DOMAIN_ATRIBUTE;
    }

    @Override
    public Class<?> domainClass() {
        return DOMAIN_CLASS;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return UniqueValue.class;
    }
    }
}