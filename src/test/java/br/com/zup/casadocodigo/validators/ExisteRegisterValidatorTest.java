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
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;

@SpringBootTest
@ActiveProfiles("Dev")
@RunWith(SpringRunner.class)
public class ExisteRegisterValidatorTest {
    private final static Class<?> DOMAIN_CLASS= Autor.class;
    private AutorRequest autor;

    ConstraintValidatorContext ctx;
    ExisteRegisterTestCase testCase;
    ExistsRegisterValidator validator;

    @PersistenceContext
    private EntityManager entityManager;

     @Before
     public void config(){
        ctx= Mockito.mock(ConstraintValidatorContext.class);
        testCase=new ExisteRegisterTestCase();
        validator=new ExistsRegisterValidator(entityManager);
     }

     @Test
     @Transactional
     public void deveExistirORegistro(){
         Long idAutor=1L;
         autor=new AutorRequest("joao",",moreno alto bonito e sensual","jordi@gmail.com");
         entityManager.persist(autor.toModelo());
         validator.initialize(testCase);
         boolean existe=validator.isValid(1L,ctx);
         Assert.assertTrue(existe);
     }

     private static class ExisteRegisterTestCase implements ExistsRegister{

         @Override
         public String message() {
             return "Já Existe este registro";
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
         public Class<?> domainClass() {
             return DOMAIN_CLASS;
         }

         @Override
         public Class<? extends Annotation> annotationType() {
             return ExistsRegister.class;
         }
     }
}
