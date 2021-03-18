package br.com.zup.casadocodigo.Autor;

import br.com.zup.casadocodigo.handlers.EmailExistenteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) throws EmailExistenteException {

        Optional<Autor> emailExiste= autorRepository.findByEmail(autorForm.getEmail());
        if(emailExiste.isPresent()){
            throw new EmailExistenteException("Email já existente");
        }
        Autor autor= autorForm.converter();
        Autor autorSalvo=autorRepository.save(autor);
        return ResponseEntity.ok().body(autorSalvo.toString());

    }
}
