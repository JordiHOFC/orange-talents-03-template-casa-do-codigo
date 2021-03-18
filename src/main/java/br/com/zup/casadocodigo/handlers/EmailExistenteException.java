package br.com.zup.casadocodigo.handlers;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmailExistenteException extends Exception{
    public EmailExistenteException(String mensagem){
        super(mensagem);
    }
}
