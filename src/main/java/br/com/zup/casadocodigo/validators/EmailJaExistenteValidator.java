package br.com.zup.casadocodigo.validators;


import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Autor.AutorForm;
import br.com.zup.casadocodigo.Autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
public class EmailJaExistenteValidator implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        AutorForm request= (AutorForm) o;
        Optional<Autor> possivelAutor=repository.findByEmail(request.getEmail());
        if(possivelAutor.isPresent()){
            errors.rejectValue("email",null,"Ja existe um(a) autor(a) cadastrado com este email");
        }
    }
}
