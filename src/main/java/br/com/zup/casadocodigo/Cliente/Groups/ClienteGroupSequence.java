package br.com.zup.casadocodigo.Cliente.Groups;

import br.com.zup.casadocodigo.Cliente.Cliente;
import br.com.zup.casadocodigo.Cliente.ClienteRequest;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequence implements DefaultGroupSequenceProvider<ClienteRequest> {
    @Override
    public List<Class<?>> getValidationGroups(ClienteRequest cliente) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClienteRequest.class);
        if(cliente!=null){
            Integer pf=14;
            Integer pj=18;
            if(pf.equals(cliente.getDocumento().length())){
                groups.add(PessoaFisica.class);
            }
            else if(pj.equals(cliente.getDocumento().length())){
                groups.add(PessoaJuridica.class);
            }
        }
        return groups;
    }
}
