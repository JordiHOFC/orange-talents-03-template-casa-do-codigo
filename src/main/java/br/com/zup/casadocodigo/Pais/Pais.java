package br.com.zup.casadocodigo.Pais;

import br.com.zup.casadocodigo.Pais.Estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pais")
@Table(name = "pais")

public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true,nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados=new ArrayList<>();

    public Pais(@NotBlank  String nome) {
        this.nome = nome;
    }

    public Pais() {
    }

    public Pais(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
