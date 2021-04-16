package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.Pais.Estado.Estado;
import br.com.zup.casadocodigo.Pais.Estado.EstadoRepository;
import br.com.zup.casadocodigo.Pais.Pais;
import br.com.zup.casadocodigo.Pais.PaiseEstadoRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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
@ActiveProfiles("Test")
@RunWith(SpringRunner.class)
public class ExistStadeInCountryValidatorTest {
    private static final Class<?> STADE = Estado.class;
    private static final Class<?> COUNTRY = Pais.class;

    @Autowired
    private EstadoRepository repository;
    @PersistenceContext
    private EntityManager manager;

    ConstraintValidatorContext ctx;
    ExistsStadeInCountryValidator validator;
    ExistStadeInCountryTestCase testCase;


    @Before
    public void config(){
        validator=new ExistsStadeInCountryValidator(manager,repository);
        ctx= Mockito.mock(ConstraintValidatorContext.class);
        testCase=new ExistStadeInCountryTestCase();
    }

    @Transactional
    @Test
    public void deveExisterUmEstadoNestePais(){
        Pais pais = new Pais("Brazuca");
        manager.persist(pais);
        Estado estado= new Estado("Minas Gerais",pais);
        manager.persist(estado);
        PaiseEstadoRequest request= new PaiseEstadoRequest(pais.getId(), estado.getId());
        validator.initialize(testCase);
        boolean existe=validator.isValid(request,ctx);
        Assert.assertTrue(existe);

    }
    @Transactional
    @Test
    public void naoDeveExisterUmEstadoNestePais(){
        Pais pais = new Pais("Brazuca");
        Pais pais2 = new Pais("Brazucao");
        manager.persist(pais);
        manager.persist(pais2);
        Estado estado= new Estado("Minas Gerais",pais2);
        manager.persist(estado);
        PaiseEstadoRequest request= new PaiseEstadoRequest(pais.getId(), estado.getId());
        validator.initialize(testCase);
        boolean existe=validator.isValid(request,ctx);
        Assert.assertFalse(existe);

    }
    private static class ExistStadeInCountryTestCase implements ExistsStadeInCountry{

        @Override
        public String message() {
            return "Existe estado no pais";
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
        public Class<?> countryClass() {
            return COUNTRY;
        }

        @Override
        public Class<?> stadeClass() {
            return STADE;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return ExistsStadeInCountry.class;
        }
    }
}
