package br.com.zup.casadocodigo.Categoria;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

    @NotBlank
    private String nome;

    public CategoriaForm(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaForm() {
    }

    public Categoria toModelo(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }

}
