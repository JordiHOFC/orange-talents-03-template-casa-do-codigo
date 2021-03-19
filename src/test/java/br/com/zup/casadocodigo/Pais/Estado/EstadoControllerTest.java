package br.com.zup.casadocodigo.Pais.Estado;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Livro.LivroRepository;
import br.com.zup.casadocodigo.Pais.Pais;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EstadoControllerTest {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private  MockMvc mockMvc;
    @PersistenceContext
    private EntityManager manager;

    @Test
    @Transactional
    public void deveRetorna200CasoCadastroComSucesso() throws Exception {
        Pais pais= new Pais("Brasil");
        manager.persist(pais);
        Estado estado= new Estado("Minas Gerais",pais);
        String json="{\"nome\":\"Minas Gerais\",\"pais\":1}";
        URI uri=new URI("/estados");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    public void deveRetorna400() throws Exception {
        Pais pais= new Pais(1L);
        Estado estado= new Estado("Minas Gerais",pais);
        String json="{\"nome\":\"Minas Gerais\",\"pais\":1}";
        URI uri=new URI("/estados");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(400));

    }
}
