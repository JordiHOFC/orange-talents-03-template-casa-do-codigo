package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Categoria.CategoriaForm;
import br.com.zup.casadocodigo.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaExistenteValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;
    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CategoriaForm request= (CategoriaForm) o;

        if (errors.hasErrors()){
            return;
        }
        Optional<Categoria> possivelCategoria=repository.findByNome(request.getNome());
        if (possivelCategoria.isPresent()){
            errors.rejectValue("nome", null,"Já existe uma categoria cadastrada com este nome.");
        }

    }
}
