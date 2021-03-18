package br.com.zup.casadocodigo.Autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
        Autor autor= autorForm.converter();
        Autor autorSalvo=autorRepository.save(autor);
        URI uri=uriBuilder.path("/autores/{id}").buildAndExpand(autorSalvo.getId()).toUri();
        return ResponseEntity.ok().location(uri).build();

    }
}
