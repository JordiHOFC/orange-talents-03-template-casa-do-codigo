package br.com.zup.casadocodigo.Pais.Estado;

import br.com.zup.casadocodigo.Pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "estado")
@Table(name = "estado")
public class Estado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true,nullable = false)
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "pais_id_fk"))
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {
    }

    public Estado(Long estado) {
        this.id=estado;
    }

    public Long getId() {
        return id;
    }
    

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais.toString() +
                '}';
    }
}
