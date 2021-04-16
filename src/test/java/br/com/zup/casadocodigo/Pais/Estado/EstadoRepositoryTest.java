package br.com.zup.casadocodigo.Pais.Estado;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Livro.Livro;
import br.com.zup.casadocodigo.Livro.LivroRepository;
import br.com.zup.casadocodigo.Pais.Pais;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class EstadoRepositoryTest {

    @Autowired
    private EstadoRepository repository;
    @PersistenceContext
    private EntityManager manager;

    @Test
    @Transactional
    public void testeCadastroDeLivro(){
        Pais pais= new Pais("Brasil");
        manager.persist(pais);
        Estado estado= new Estado("Minas Gerais",pais);
        Assert.assertNotNull(repository.save(estado));
    }

    @Test
    @Transactional
    public void deveRetornarSeOEstadoPertenceAoPais(){
        Pais pais= new Pais("Brasil");
        manager.persist(pais);
        Estado estado= new Estado("Minas Gerais",pais);
        manager.persist(estado);
        Optional<Estado> optionalEstado=repository.findEstadoNoPais(pais.getId(), estado.getId());
        Assert.assertTrue(optionalEstado.isPresent());
        Assert.assertEquals(optionalEstado.get(),estado);
        Assert.assertEquals(optionalEstado.get().getPais(),pais);
    }

}
