package br.com.zup.casadocodigo.Autor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutorControllerTest {

    @Autowired
    private  AutorRepository repository;
    @Autowired
    private  MockMvc mockMvc;

    @Test
    public void deveRetorna200CasoCadastroComSucesso() throws Exception {
        String json="{\"nome\": \"Autor\", \"descricao\": \"Autor anonimo\", \"email\" :\"email@email.com\"}";
        URI uri=new URI("/autores");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    public void deveRetorna400() throws Exception {
        String json="{\"nome\": \"\", \"descricao\": \"Autor anonimo\", \"email\" :\"emailemail.com\"}";
        URI uri=new URI("/autores");
        mockMvc.perform(MockMvcRequestBuilders.post(uri).
                content(json).
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(400));

    }
}
