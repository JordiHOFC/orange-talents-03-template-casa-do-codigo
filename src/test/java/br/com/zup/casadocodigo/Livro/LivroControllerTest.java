package br.com.zup.casadocodigo.Livro;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Categoria.CategoriaRepository;
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
public class LivroControllerTest {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private  MockMvc mockMvc;
    @PersistenceContext
    private EntityManager manager;

    @Test
    @Transactional
    public void deveRetorna200CasoCadastroComSucesso() throws Exception {
        Categoria categoria =new Categoria("Testes automatizados em api rest");
        manager.persist(categoria);
        Autor autor=new Autor("Jordi","jordi@jordi.com","programador java");
        manager.persist(autor);
        String json="{\n" +
                "    \"titulo\":\"Cadastrwandso um Livro\",\n" +
                "    \"sumario\":\"asdsdasfsafasfsa\",\n" +
                "    \"resumo\": \"ddnshdsioahdoksji\",\n" +
                "    \"preco\":20.3,\n" +
                "    \"numeroPaginas\":110,\n" +
                "    \"isbn\" :\"2312.3123.41222\",\n" +
                "    \"dataLancamento\": \"2021-03-21\",\n" +
                "    \"categoria\":1,\n" +
                "    \"autor\":1    \n" +
                "}";
        URI uri=new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    public void deveRetorna400() throws Exception {
        String json="{\n" +
                "    \"titulo\":\"Cadastrwandso um Livro\",\n" +
                "    \"sumario\":\"asdsdasfsafasfsa\",\n" +
                "    \"resumo\": \"ddnshdsioahdoksji\",\n" +
                "    \"preco\":20.3,\n" +
                "    \"numeroPaginas\":110,\n" +
                "    \"isbn\" :\"2312.3123.41222\",\n" +
                "    \"dataLancamento\": \"2021-03-21\",\n" +
                "    \"categoria\":1,\n" +
                "    \"autor\":1    \n" +
                "}";
        URI uri=new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(400));

    }
}
