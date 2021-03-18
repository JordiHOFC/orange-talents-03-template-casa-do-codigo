package br.com.zup.casadocodigo.Autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Length(max = 400)
    private String descricao;
    @NotBlank @Email
    private String email;

    public Autor converter(){
        return new Autor(this.nome,this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }
}
