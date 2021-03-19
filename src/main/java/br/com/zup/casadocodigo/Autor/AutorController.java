package br.com.zup.casadocodigo.Autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {

        Autor autor= autorForm.toModelo();
        Autor autorSalvo=autorRepository.save(autor);
        return ResponseEntity.ok().body(autorSalvo.toString());

    }
}
