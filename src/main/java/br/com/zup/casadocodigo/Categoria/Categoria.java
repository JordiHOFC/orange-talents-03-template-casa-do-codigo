package br.com.zup.casadocodigo.Categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "categoria")
@Table(name = "categoria")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
