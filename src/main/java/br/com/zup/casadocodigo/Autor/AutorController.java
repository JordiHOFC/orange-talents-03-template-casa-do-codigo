package br.com.zup.casadocodigo.Autor;

import br.com.zup.casadocodigo.validators.EmailJaExistenteValidator;
import br.com.zup.casadocodigo.validators.NaoPermitirValoresDuplicadosValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private final NaoPermitirValoresDuplicadosValidator naoPermitirValoresDuplicadosValidator;

    public AutorController(AutorRepository autorRepository, EmailJaExistenteValidator emailJaExistenteValidator, NaoPermitirValoresDuplicadosValidator naoPermitirValoresDuplicadosValidator) {
        this.autorRepository = autorRepository;
        this.naoPermitirValoresDuplicadosValidator = naoPermitirValoresDuplicadosValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(naoPermitirValoresDuplicadosValidator);
    }
    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {

        Autor autor= autorForm.converter();
        Autor autorSalvo=autorRepository.save(autor);
        return ResponseEntity.ok().body(autorSalvo.toString());

    }
}
