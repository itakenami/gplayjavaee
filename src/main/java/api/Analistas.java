/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import jee.api.GenericRest;
import jee.dao.GenericModel;
import models.AnalistaDao;
import models.dto.Analista;
import models.dto.Cargo;

/**
 *
 * @author itakenami
 */
@Path("/analistas")
@Produces(MediaType.APPLICATION_JSON)
public class Analistas extends GenericRest<Analista> {
    
    @EJB
    AnalistaDao dao;

    @Override
    public GenericModel getModel() {
        return dao;
    }

    @Override
    public Analista getDtoToSave(MultivaluedMap<String, String> form) {
        
        Analista a = new Analista();
        
        a.setNome(form.getFirst("analista.nome"));
        a.setEspecialidade(form.getFirst("analista.especialidade"));
        
        Cargo c = new Cargo();
        c.setId(new Long(form.getFirst("analista.cargo.id")));
        
        a.setCargo(c);
        
        return a;
    }

    @Override
    public void setDtoToSave(Analista dto, MultivaluedMap<String, String> form) {
        
        dto.setNome(form.getFirst("analista.nome"));
        dto.setEspecialidade(form.getFirst("analista.especialidade"));
        
        Cargo c = new Cargo();
        c.setId(new Long(form.getFirst("analista.cargo.id")));
        
        dto.setCargo(c);
    }
    
}
