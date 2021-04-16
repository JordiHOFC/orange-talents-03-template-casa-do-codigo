package br.com.zup.casadocodigo.Livro;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.validators.ExistsRegister;
import br.com.zup.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank
    @JsonProperty
    @UniqueValue(fieldName = "titulo",domainClass = Livro.class)
    private String titulo;

    @NotBlank
    @JsonProperty
    private String sumario;

    @NotBlank
    @JsonProperty
    @Size(max = 500)
    private String resumo;

    @Min(value = 20)
    @NotNull
    @JsonProperty
    private BigDecimal preco;

    @Min(value = 100)
    @NotNull
    @JsonProperty
    private Integer numeroPaginas;

    @NotBlank
    @JsonProperty
    @UniqueValue(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;

    @NotNull
    @Future
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    @JsonProperty
    @ExistsRegister(domainClass = Categoria.class)
    private Long categoria;

    @ExistsRegister(domainClass = Autor.class)
    @JsonProperty
    private Long autor;

    public LivroRequest(@NotBlank String titulo, @NotBlank String sumario, @NotBlank @Size(max = 500) String resumo, @Min(value = 20) @NotNull BigDecimal preco, @Min(value = 100) @NotNull Integer numeroPaginas, @NotBlank String isbn,@Future LocalDate dataLancamento, @Valid Long categoria, @Valid Long autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }
    public Livro toModel(){
        return new Livro(titulo,sumario,resumo,preco,numeroPaginas,isbn,dataLancamento,new Categoria(categoria),new Autor(autor) );
    }
}
