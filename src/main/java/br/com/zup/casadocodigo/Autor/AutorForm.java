package br.com.zup.casadocodigo.Autor;

import br.com.zup.casadocodigo.Categoria.CategoriaForm;
import br.com.zup.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Size(max = 400)
    private String descricao;
    @NotBlank @Email
    @UniqueValue(domainClass = Autor.class,fieldName = "email")
    private String email;

    public AutorForm(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Autor toModelo(){
        return new Autor(this.nome,this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}
