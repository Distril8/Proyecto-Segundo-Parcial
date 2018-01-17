/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.service;


import ec.edu.espe.distribuidas.prosth.dao.CiudadFacade;
import ec.edu.espe.distribuidas.prosth.dao.ProductoFacade;
import ec.edu.espe.distribuidas.prosth.dao.ProveedorFacade;
import ec.edu.espe.distribuidas.prosth.model.Ciudad;
import ec.edu.espe.distribuidas.prosth.model.Producto;
import ec.edu.espe.distribuidas.prosth.model.Proveedor;
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
public class CiudadService {
    
    @EJB
    private CiudadFacade ciudadFacade;

    public List<Ciudad> obtenerTodos() {
        return this.ciudadFacade.findAll();
    }

    public Ciudad obtenerPorCodigo(Integer codigo) {
        return this.ciudadFacade.find(codigo);
    }

    
     public List<Ciudad> buscarPorTipo(Integer tipoCiudadBusqueda) {
        return this.ciudadFacade.findByTipo(tipoCiudadBusqueda);
    }
    
}
