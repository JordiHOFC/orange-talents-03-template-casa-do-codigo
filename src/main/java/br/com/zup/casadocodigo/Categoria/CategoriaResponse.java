package br.com.zup.casadocodigo.Categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaResponse {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String nome;

    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
