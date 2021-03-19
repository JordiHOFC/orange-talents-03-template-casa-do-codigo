package br.com.zup.casadocodigo.Livro;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;

import java.math.BigDecimal;

public class DetalharLivroDTO {
    private String titulo;
    private String sumario;
    private String resumo;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private Categoria categoria;
    private Autor autor;

    public DetalharLivroDTO(Livro livro) {
        this.titulo= livro.getTitulo();
        this.sumario= livro.getSumario();
        this.resumo= livro.getResumo();
        this.preco=livro.getPreco();
        this.numeroPaginas= livro.getNumeroPaginas();
        this.isbn= livro.getIsbn();
        this.categoria= livro.getCategoria();
        this.autor=livro.getAutor();
    }

    public DetalharLivroDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "DetalharLivroDTO{" +
                "titulo='" + titulo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", resumo='" + resumo + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
