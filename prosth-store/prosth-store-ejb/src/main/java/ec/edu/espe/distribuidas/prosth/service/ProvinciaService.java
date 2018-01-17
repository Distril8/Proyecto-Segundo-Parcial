/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.service;


import ec.edu.espe.distribuidas.prosth.dao.ProvinciaFacade;
import ec.edu.espe.distribuidas.prosth.model.Provincia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Protesis Store Corp.
 */
@Stateless
@LocalBean
public class ProvinciaService {
    
    @EJB
    private ProvinciaFacade provinciaFacade;

    public List<Provincia> obtenerTodos() {
        return this.provinciaFacade.findAll();
    }

    public Provincia obtenerPorCodigo(Integer codigo) {
        return this.provinciaFacade.find(codigo);
    }
    
    
}
