package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.Pais.Estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais,Long> {
}
