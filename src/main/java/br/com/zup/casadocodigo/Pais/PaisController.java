package br.com.zup.casadocodigo.Pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?>cadastrarPais(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais=paisRequest.toModelo();
        paisRepository.save(pais);
        return ResponseEntity.ok(pais.toString());
    }
}
