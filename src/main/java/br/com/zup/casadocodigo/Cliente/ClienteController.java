package br.com.zup.casadocodigo.Cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteRequest request){
        Cliente cliente= request.toModelo();
        repository.save(cliente);
        return ResponseEntity.ok(cliente.getId().toString());

    }
}
