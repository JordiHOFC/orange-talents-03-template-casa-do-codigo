package br.com.zup.casadocodigo.Pais.Estado;

import br.com.zup.casadocodigo.Pais.Pais;
import br.com.zup.casadocodigo.validators.ExistsRegister;
import br.com.zup.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {
    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Estado.class)
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @ExistsRegister(domainClass = Pais.class)
    @JsonProperty("pais")
    private Long pais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public EstadoRequest() {
    }
    public Estado toModelo(){
        return new Estado(this.nome,new Pais(this.pais));
    }
}
