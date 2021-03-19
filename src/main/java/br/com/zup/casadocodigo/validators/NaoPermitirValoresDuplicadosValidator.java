package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.Autor.Autor;
import br.com.zup.casadocodigo.Autor.AutorForm;
import br.com.zup.casadocodigo.Autor.AutorRepository;
import br.com.zup.casadocodigo.Categoria.Categoria;
import br.com.zup.casadocodigo.Categoria.CategoriaForm;
import br.com.zup.casadocodigo.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NaoPermitirValoresDuplicadosValidator implements Validator {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Object.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        String objectName= errors.getObjectName();
        System.out.println(objectName);
        switch (objectName){
            case "categoriaForm":
                CategoriaForm requestCategoria=(CategoriaForm) o;
                Optional<Categoria> possivelCategoria=categoriaRepository.findByNome(requestCategoria.getNome());
                if (possivelCategoria.isPresent()){
                    errors.rejectValue("nome",null,"Já existe uma categoria cadastrada com este nome.");
                }
                break;
            case "autorForm":
                AutorForm requestAutor=(AutorForm) o;
                Optional<Autor> possivelAutor=autorRepository.findByEmail(requestAutor.getEmail());
                if (possivelAutor.isPresent()) {
                    errors.rejectValue("email",null,"Já existe um autor(a) cadastrado(a) com este email.");
                }


            }
        }

}
