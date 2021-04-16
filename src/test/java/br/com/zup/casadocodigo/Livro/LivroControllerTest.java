package br.com.zup.casadocodigo.Livro;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Categoria.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LivroControllerTest {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private MockMvc mockMvc;
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @Transactional
    public void deveRetorna200CasoCadastroComSucesso() throws Exception {
        Categoria categoria = new Categoria("Testes automatizados em api rest");
        manager.persist(categoria);
        Autor autor = new Autor("Jordi", "jordi@jordi.com", "programador java");
        manager.persist(autor);
        LivroRequest request = new LivroRequest("cadastrando um livro", "sjasjioajs", "resumao da massa", new BigDecimal("22.3"), 110, "2312.3123.41222", LocalDate.parse("2021-04-21", DateTimeFormatter.ISO_LOCAL_DATE), categoria.getId(), autor.getId());
        String requestJson = mapper.writeValueAsString(request);
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(requestJson).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    public void deveRetorna400() throws Exception {
        LivroRequest request = new LivroRequest("cadastrando um livro", "sjasjioajs", "resumao da massa", new BigDecimal("22.3"), 110, "2312.3123.41222", LocalDate.parse("2021-04-21", DateTimeFormatter.ISO_LOCAL_DATE), 1L, 1L);
        String requestJson = mapper.writeValueAsString(request);
        URI uri = new URI("/livros");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(requestJson).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(400));

    }

    @Test
    @Transactional
    public void deveRetornaroLivroDetalhado() throws Exception {
        Categoria categoria = new Categoria("Testes automatizados em api rest");
        manager.persist(categoria);
        Autor autor = new Autor("Jordi", "jordi@jordi.com", "programador java");
        manager.persist(autor);
        LivroRequest request = new LivroRequest("cadastrando um livro", "sjasjioajs", "resumao da massa", new BigDecimal("22.3"), 110, "2312.3123.41222", LocalDate.parse("2021-04-21", DateTimeFormatter.ISO_LOCAL_DATE), categoria.getId(), autor.getId());
        Livro novoLivro= request.toModel();
        manager.persist(novoLivro);
        //crio um livro dto
        DetalharLivroDTO response = new DetalharLivroDTO(novoLivro);
        //crio um json do livro dto
        String responseJson= mapper.writeValueAsString(response);
        //crio o enderdo do endpoint
        URI uri = UriComponentsBuilder.fromUriString("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();

        mockMvc.perform(MockMvcRequestBuilders.get(uri)).
                andExpect(MockMvcResultMatchers.status().is(200)).
                andExpect(MockMvcResultMatchers.content().json(responseJson));

    }
}
