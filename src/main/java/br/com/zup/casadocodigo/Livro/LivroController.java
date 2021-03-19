package br.com.zup.casadocodigo.Livro;

import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<?> listarLivros(){
        List<Livro> livros=livroRepository.findAll();
        return ResponseEntity.ok(livros.stream().map(LivroResponse::new).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalharLivroDTO> detalharLivro(@PathVariable Long id){
        Optional<Livro> livro=livroRepository.findById(id);
        if(livro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        DetalharLivroDTO detalhado= new DetalharLivroDTO(livro.get());
        return ResponseEntity.ok(detalhado);
    }
}
