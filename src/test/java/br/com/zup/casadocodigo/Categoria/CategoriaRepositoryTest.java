package br.com.zup.casadocodigo.Categoria;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Autor.AutorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository repository;

    @Test
    public void testeCadastroDeCategoria(){
       Categoria categoria=new Categoria("Programação Orientada a Objetos");
        Assert.assertNotNull(repository.save(categoria));
    }
    @Test
    public void deveRetornarCategoriaPeloNome(){
        Categoria categoria=new Categoria("Programação Orientada a Objetos");
        repository.save(categoria);
        Assert.assertEquals(repository.findByNome("Programação Orientada a Objetos").get().getNome(),"Programação Orientada a Objetos");
    }
    @Test
    public void naoDeveRetornarCategoriaPeloNome(){
        Assert.assertFalse(repository.findByNome("Programação Orientada a Objetos").isPresent());
    }


}
