package br.com.zup.casadocodigo.Cliente;


import br.com.zup.casadocodigo.Pais.Estado.Estado;
import br.com.zup.casadocodigo.Pais.Pais;
import javax.persistence.*;


@Entity(name = "cliente")
@Table(name = "cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobreNome;


    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String documento;

    @Column
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    private Pais pais;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Estado estado;

    @Column(nullable = false)
    private String cep;

    public Cliente(String nome, String sobreNome, String email, String documento, String telefone, String endereco, String complemento, String cidade, Pais pais, Estado estado, String cep) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
    }

    public Cliente(String nome, String sobreNome, String email, String documento, String telefone, String endereco, String complemento, String cidade, Pais pais, String cep) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", cep='" + cep + '\'' +
                '}';
    }
}
