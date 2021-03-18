package br.com.zup.casadocodigo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Size(max = 400)
    private String descricao;
    @NotBlank @Email
    private String email;

    public AutorForm(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Autor converter(){
        return new Autor(this.nome,this.email, this.descricao);
    }


}
