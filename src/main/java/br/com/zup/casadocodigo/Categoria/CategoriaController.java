package br.com.zup.casadocodigo.Categoria;

import br.com.zup.casadocodigo.validators.CategoriaExistenteValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaExistenteValidator categoriaExistenteValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(categoriaExistenteValidator);
    }

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaExistenteValidator categoriaExistenteValidator) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaExistenteValidator = categoriaExistenteValidator;
    }
    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoria= categoriaForm.toModelo();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria.toString());
    }
}
