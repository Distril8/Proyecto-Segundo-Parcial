/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.service;


import ec.edu.espe.distribuidas.prosth.dao.CamionFacade;
import ec.edu.espe.distribuidas.prosth.model.Camion;
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
public class CamionService {
    
    @EJB
    private CamionFacade camionFacade;

    public List<Camion> obtenerTodos() {
        return this.camionFacade.findAll();
    }

    public Camion obtenerPorCodigo(Integer codigo) {
        return this.camionFacade.find(codigo);
    }

    public void crear(Camion camion) {
        this.camionFacade.create(camion);
    }

    public void modificar(Camion camion) {
        this.camionFacade.edit(camion);
    }

    public void eliminar(Integer codigo) {
        Camion camion = this.camionFacade.find(codigo);
        this.camionFacade.remove(camion);
    }
    
     public List<Camion> buscarPorTipo(Integer tipoProductoBusqueda) {
        return this.camionFacade.findByTipo(tipoProductoBusqueda);
    }
    
}
