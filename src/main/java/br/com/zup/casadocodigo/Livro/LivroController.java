package br.com.zup.casadocodigo.Livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro= livroRequest.toModel();
        livroRepository.save(livro);
        return ResponseEntity.ok(livro.toString());
    }
}
