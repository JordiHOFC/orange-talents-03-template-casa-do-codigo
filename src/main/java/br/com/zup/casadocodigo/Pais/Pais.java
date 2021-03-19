package br.com.zup.casadocodigo.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "pais")
@Table(name = "pais")
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true,nullable = false)
    private String nome;

    public Pais(@NotBlank  String nome) {
        this.nome = nome;
    }

    public Pais() {
    }

    public Pais(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
