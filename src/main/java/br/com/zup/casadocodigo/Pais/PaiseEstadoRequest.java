package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.Pais.Estado.Estado;
import br.com.zup.casadocodigo.validators.ExistsRegister;
import br.com.zup.casadocodigo.validators.ExistsStadeInCountry;

import javax.validation.constraints.NotNull;

public class PaiseEstadoRequest {
    @NotNull
    @ExistsRegister(domainClass = Pais.class)
    private Long id;

    private Long estado;

    public PaiseEstadoRequest(@NotNull Long id, Long estado) {
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
}
