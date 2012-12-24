/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import jee.api.GenericRest;
import jee.dao.GenericModel;
import models.ProjetoDao;
import models.dto.Analista;
import models.dto.Projeto;

/**
 *
 * @author itakenami
 */
@Path("/projetos")
@Produces(MediaType.APPLICATION_JSON)
public class Projetos extends GenericRest<Projeto> {

    @EJB
    ProjetoDao dao;

    @Override
    public GenericModel getModel() {
        return dao;
    }

    @Override
    public Projeto getDtoToSave(MultivaluedMap<String, String> form) {
        
        Projeto p = new Projeto();
        p.setNome(form.getFirst("projeto.nome"));
        p.setDescricao(form.getFirst("projeto.descricao"));
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        
        
        try {
            p.setData_inicio(sdf.parse(form.getFirst("projeto.data_inicio")));
            p.setData_fim(sdf.parse(form.getFirst("projeto.data_fim")));
        } catch (ParseException ex) {
            
        }
        
        Set<Analista> analistas = new LinkedHashSet<Analista>();
        Set<String> lista = form.keySet();
        for (String param : lista) {
            if(param.indexOf("[")>-1){
                String val_id = form.getFirst(param);
                Analista a = new Analista();
                a.setId(new Long(val_id));
                analistas.add(a);
            }
        }
        
        p.setAnalistas(analistas);
        
        return p;
        
        
    }

    @Override
    public void setDtoToSave(Projeto dto, MultivaluedMap<String, String> form) {
        
        dto.setNome(form.getFirst("projeto.nome"));
        dto.setDescricao(form.getFirst("projeto.descricao"));
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        
        
        try {
            dto.setData_inicio(sdf.parse(form.getFirst("projeto.data_inicio")));
            dto.setData_fim(sdf.parse(form.getFirst("projeto.data_fim")));
        } catch (ParseException ex) {
            
        }
        
        Set<Analista> analistas = new LinkedHashSet<Analista>();
        Set<String> lista = form.keySet();
        
        for (String param : lista) {
            if(param.indexOf("[")>-1){
                String val_id = form.getFirst(param);
                Analista a = new Analista();
                a.setId(new Long(val_id));
                analistas.add(a);
            }
        }
        
        dto.setAnalistas(analistas);
    }
    
}
