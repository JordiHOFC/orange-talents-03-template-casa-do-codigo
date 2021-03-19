package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Livro.LivroRepository;
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
public class PaisControllerTest {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private  MockMvc mockMvc;

    @Test
    public void deveRetorna200CasoCadastroComSucesso() throws Exception {
        String json="{\"nome\": \"Brasil\" }";
        URI uri=new URI("/paises");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    public void deveRetorna400() throws Exception {
        String json="{\"nome\": \"\" }";
        URI uri=new URI("/paises");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(400));

    }
}
