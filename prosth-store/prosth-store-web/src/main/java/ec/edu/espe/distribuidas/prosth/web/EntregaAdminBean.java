/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.web;


import ec.edu.espe.distribuidas.prosth.model.Conductor;
import ec.edu.espe.distribuidas.prosth.model.Entrega;
import ec.edu.espe.distribuidas.prosth.service.ConductorService;
import ec.edu.espe.distribuidas.prosth.service.EntregaService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class EntregaAdminBean  extends BaseBean implements Serializable{
    
    private String filtro;
    private Integer tipoEntregaBusqueda;
    private boolean enBusquedaPorTipo;
    private List<Conductor> conductores;
    private Date fechaInicioBusqueda;
    private Date fechaFinBusqueda;

    
    private List<Entrega> entregas;
    private Entrega entrega;
    private Entrega entregaSel;
    
    @Inject
    private ConductorService conductorService;
    @Inject
    private EntregaService entregaService;
    
    @PostConstruct
    public void init() {
        this.filtro = "FEC";
        this.enBusquedaPorTipo = true;
        this.conductores = this.conductorService.obtenerTodos();
    }
    
    public void cambiarFiltro() {
        this.enBusquedaPorTipo = !this.enBusquedaPorTipo;
        System.out.println("Valor para enbusqueda: "+this.enBusquedaPorTipo);
    }
    
    public void buscar() {
        if (this.enBusquedaPorTipo) {
            this.entregas = this.entregaService.buscarPorTipo(this.tipoEntregaBusqueda);
        } else {
            this.entregas = this.entregaService.buscarPorFechas(this.fechaInicioBusqueda, this.fechaFinBusqueda);
        }
        
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

   
   

    public void setFechaInicioBusqueda(Date fechaInicioBusqueda) {
        this.fechaInicioBusqueda = fechaInicioBusqueda;
    }

    public void setFechaFinBusqueda(Date fechaFinBusqueda) {
        this.fechaFinBusqueda = fechaFinBusqueda;
    }

 
    public Date getFechaInicioBusqueda() {
        return fechaInicioBusqueda;
    }

    public Date getFechaFinBusqueda() {
        return fechaFinBusqueda;
    }

    public Integer getTipoEntregaBusqueda() {
        return tipoEntregaBusqueda;
    }

    public void setTipoEntregaBusqueda(Integer tipoEntregaBusqueda) {
        this.tipoEntregaBusqueda = tipoEntregaBusqueda;
    }

    

    public boolean isEnBusquedaPorTipo() {
        return enBusquedaPorTipo;
    }

    public void setEnBusquedaPorTipo(boolean enBusquedaPorTipo) {
        this.enBusquedaPorTipo = enBusquedaPorTipo;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Entrega getEntregaSel() {
        return entregaSel;
    }

    public void setEntregaSel(Entrega entregaSel) {
        this.entregaSel = entregaSel;
    }

   
    
    
}
