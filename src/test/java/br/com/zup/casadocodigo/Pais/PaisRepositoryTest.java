package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Livro.Livro;
import br.com.zup.casadocodigo.Livro.LivroRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository repository;

    @Test
    public void testeCadastroDePais(){
        Pais pais=new Pais("Brasil");
        Assert.assertNotNull(repository.save(pais));
    }



}
