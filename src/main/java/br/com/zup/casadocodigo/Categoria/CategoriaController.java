package br.com.zup.casadocodigo.Categoria;

import br.com.zup.casadocodigo.validators.CategoriaExistenteValidator;
import br.com.zup.casadocodigo.validators.NaoPermitirValoresDuplicadosValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final NaoPermitirValoresDuplicadosValidator naoPermitirValoresDuplicadosValidator;

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaExistenteValidator categoriaExistenteValidator, NaoPermitirValoresDuplicadosValidator naoPermitirValoresDuplicadosValidator) {
        this.categoriaRepository = categoriaRepository;
        this.naoPermitirValoresDuplicadosValidator = naoPermitirValoresDuplicadosValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(naoPermitirValoresDuplicadosValidator);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoria= categoriaForm.toModelo();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria.toString());
    }
}
