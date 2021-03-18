package br.com.zup.casadocodigo.handlers;

public class ApiError {
    private String campo;
    private String erro;

    public ApiError(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
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
