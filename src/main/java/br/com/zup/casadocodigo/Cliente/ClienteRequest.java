package br.com.zup.casadocodigo.Cliente;

import br.com.zup.casadocodigo.Cliente.Groups.ClienteGroupSequence;
import br.com.zup.casadocodigo.Cliente.Groups.PessoaFisica;
import br.com.zup.casadocodigo.Cliente.Groups.PessoaJuridica;
import br.com.zup.casadocodigo.Pais.Estado.Estado;
import br.com.zup.casadocodigo.Pais.Pais;
import br.com.zup.casadocodigo.Pais.PaiseEstadoRequest;
import br.com.zup.casadocodigo.validators.ExistsStadeInCountry;
import br.com.zup.casadocodigo.validators.UniqueValue;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@GroupSequenceProvider(value = ClienteGroupSequence.class)
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;

    @Email
    @UniqueValue(fieldName = "email",domainClass = Cliente.class)
    private String email;

    @UniqueValue(fieldName = "documento",domainClass = Cliente.class)
    @CPF(groups = PessoaFisica.class)
    @CNPJ(groups = PessoaJuridica.class)
    private String documento;

    @NotNull
    private String telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String cep;

    @NotNull
    @Valid
    @ExistsStadeInCountry(countryClass = Pais.class, stadeClass = Estado.class)
    private PaiseEstadoRequest pais;

    public ClienteRequest(@NotBlank String nome, @NotBlank String sobreNome, @Email String email, @CPF(groups = PessoaFisica.class) @CNPJ(groups = PessoaJuridica.class) String documento, @NotNull String telefone, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String cep, @NotNull @Valid PaiseEstadoRequest pais) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
    }

    public ClienteRequest() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setPais(PaiseEstadoRequest pais) {
        this.pais = pais;
    }

    public String getDocumento() {
        return documento;
    }

    public PaiseEstadoRequest getPais() {
        return pais;
    }

    public Cliente toModelo(){
        if(this.pais.getEstado()==null){
            return new Cliente(nome,sobreNome,email,documento,telefone,endereco,complemento,cidade,new Pais(pais.getId()),cep);

        }
        return new Cliente(nome,sobreNome,email,documento,telefone,endereco,complemento,cidade,new Pais(pais.getId()),new Estado(pais.getEstado()),cep);
    }
}
