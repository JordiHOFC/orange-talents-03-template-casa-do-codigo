package br.com.zup.casadocodigo.Categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria= categoriaRepository.save(categoriaRequest.toModelo());
        return ResponseEntity.ok().body(new CategoriaResponse(categoria));
    }
}
