package br.com.zup.casadocodigo.Autor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository repository;

    @Test
    public void testeCadastroDeAutor(){
        Autor autor = new Autor("Jordi","teste@teste.com","testando o repositorio");
        Assert.assertEquals(1L, (long) repository.save(autor).getId());
    }


}
