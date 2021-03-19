package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @JsonProperty("nome")
    @UniqueValue(fieldName = "nome",domainClass = Pais.class)
    private String nome;

    public PaisRequest(@NotBlank  String nome) {
        this.nome = nome;
    }

    public PaisRequest() {
    }
    public Pais toModelo(){
        return new Pais(this.nome);
    }
}
