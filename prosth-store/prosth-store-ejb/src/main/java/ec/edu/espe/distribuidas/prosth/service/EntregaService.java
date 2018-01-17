/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.service;


import ec.edu.espe.distribuidas.prosth.dao.EntregaFacade;
import ec.edu.espe.distribuidas.prosth.model.Entrega;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@Stateless
@LocalBean
public class EntregaService {
    
    @EJB
    private EntregaFacade entregaFacade;

    public List<Entrega> buscarPorTipo(Integer conductorBusqueda) {
        return this.entregaFacade.findByTipo(conductorBusqueda);
    }
    
    public List<Entrega> buscarPorFechas(Date fechaInicioBusqueda, Date fechaFinBusqueda) {
        return this.entregaFacade.findByFechas(fechaInicioBusqueda, fechaFinBusqueda);
    }
    
}
