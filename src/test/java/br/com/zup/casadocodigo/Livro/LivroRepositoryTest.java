package br.com.zup.casadocodigo.Livro;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Categoria.CategoriaRepository;
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
public class LivroRepositoryTest {

    @Autowired
    private LivroRepository repository;
    @PersistenceContext
    private EntityManager manager;

    @Test
    @Transactional
    public void testeCadastroDeLivro(){
       Categoria categoria =new Categoria("Testes automatizados em api rest");
        manager.persist(categoria);
        Autor autor=new Autor("Jordi","jordi@jordi.com","programador java");
        manager.persist(autor);
        Livro livro=new Livro("Testando Repositorios","1- Aprenda o que testar,2-Aprenda onde testar,3-aprenda a testar com junit","testando para caralho",new BigDecimal("25.3"),140,"2232.545.321f.2", LocalDate.now(),categoria,autor);
        Assert.assertNotNull(repository.save(livro));
    }



}
