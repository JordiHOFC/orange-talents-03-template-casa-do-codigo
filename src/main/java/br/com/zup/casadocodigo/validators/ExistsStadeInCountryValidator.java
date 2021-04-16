package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.Pais.Estado.Estado;
import br.com.zup.casadocodigo.Pais.Estado.EstadoRepository;
import br.com.zup.casadocodigo.Pais.PaiseEstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;


public class ExistsStadeInCountryValidator implements ConstraintValidator<ExistsStadeInCountry, PaiseEstadoRequest> {
    private Class<?> stade;
    private Class<?> country;
    private Long countryId;
    private Long stadeId;


    private final EntityManager manager;
    private  final EstadoRepository repository;

    public ExistsStadeInCountryValidator(EntityManager manager, EstadoRepository repository) {
        this.manager = manager;
        this.repository = repository;
    }


    @Override
    public void initialize(ExistsStadeInCountry params) {

        this.country=params.countryClass();
        this.stade=params.stadeClass();


    }

    @Override
    public boolean isValid(PaiseEstadoRequest o, ConstraintValidatorContext constraintValidatorContext) {
       this.countryId =o.getId();
       this.stadeId =o.getEstado();

       if (stadeId==null){
           String sql="select e from "+stade.getName()+" e where e.pais.id=:id";
           Query query= manager.createQuery(sql);
           query.setParameter("id",countryId);
           List<?> result=query.getResultList();
            if (result.isEmpty()){
                return true;
            }
            else {
                return false;
            }

       }
        return repository.findEstadoNoPais(countryId,stadeId).isPresent();



    }

}
