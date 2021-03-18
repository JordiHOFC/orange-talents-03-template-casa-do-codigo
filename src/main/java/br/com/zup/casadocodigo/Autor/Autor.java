package br.com.zup.casadocodigo.Autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 400)
    private String descricao;

    private LocalDateTime criadoEm;

    public Autor(){}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm=LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
}
