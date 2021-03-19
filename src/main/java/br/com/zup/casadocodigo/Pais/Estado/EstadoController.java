package br.com.zup.casadocodigo.Pais.Estado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    private final EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        Estado estado=estadoRequest.toModelo();
        estadoRepository.save(estado);
        return ResponseEntity.ok(estado);
    }
}
