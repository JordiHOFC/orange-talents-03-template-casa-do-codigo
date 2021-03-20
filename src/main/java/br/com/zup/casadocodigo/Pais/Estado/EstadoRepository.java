package br.com.zup.casadocodigo.Pais.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado,Long> {
    @Query(value = "SELECT e.* FROM pais  as p inner join estado as e "+
    "on e.pais_id=p.id where p.id= ?1 and e.id= ?2 ",nativeQuery = true)
    Optional<Estado> findEstadoNoPais(Long idPais,Long idEstado);
}
