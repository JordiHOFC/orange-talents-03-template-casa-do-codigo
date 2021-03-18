package br.com.zup.casadocodigo.Autor;

import br.com.zup.casadocodigo.validators.EmailJaExistenteValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private final EmailJaExistenteValidator emailJaExistenteValidator;

    public AutorController(AutorRepository autorRepository, EmailJaExistenteValidator emailJaExistenteValidator) {
        this.autorRepository = autorRepository;
        this.emailJaExistenteValidator = emailJaExistenteValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailJaExistenteValidator);
    }
    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {

        Autor autor= autorForm.converter();
        Autor autorSalvo=autorRepository.save(autor);
        return ResponseEntity.ok().body(autorSalvo.toString());

    }
}
