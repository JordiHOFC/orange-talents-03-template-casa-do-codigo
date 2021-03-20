package br.com.zup.casadocodigo.Cliente;

import br.com.zup.casadocodigo.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
