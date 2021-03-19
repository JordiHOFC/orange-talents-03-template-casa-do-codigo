package br.com.zup.casadocodigo.Categoria;

import br.com.zup.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class,fieldName = "nome")
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
