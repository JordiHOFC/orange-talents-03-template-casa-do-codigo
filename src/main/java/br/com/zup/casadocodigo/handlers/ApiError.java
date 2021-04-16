package br.com.zup.casadocodigo.handlers;

import org.springframework.validation.FieldError;

public class ApiError {
    private String campo;
    private String erro;

    public ApiError(FieldError fieldError){
        this.campo= fieldError.getField();
        this.erro= fieldError.getDefaultMessage();
    }

    public ApiError() {
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "campo='" + campo + '\'' +
                ", erro='" + erro + '\'' +
                '}';
    }
}
