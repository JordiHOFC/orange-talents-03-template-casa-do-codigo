package br.com.zup.casadocodigo.Autor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutorResponse {
    @JsonProperty
    private String nome;
    @JsonProperty
    private String descricao;

    public AutorResponse(Autor autor){
        this.nome=autor.getNome();
        this.descricao=autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
