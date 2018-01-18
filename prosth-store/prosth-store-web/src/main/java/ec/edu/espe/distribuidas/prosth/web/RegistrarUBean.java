/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.web;

import ec.edu.espe.distribuidas.prosth.model.Ciudad;
import ec.edu.espe.distribuidas.prosth.model.Provincia;
import ec.edu.espe.distribuidas.prosth.model.Usuario;
import ec.edu.espe.distribuidas.prosth.model.UsuarioPK;
import ec.edu.espe.distribuidas.prosth.service.CiudadService;
import ec.edu.espe.distribuidas.prosth.service.ProvinciaService;
import ec.edu.espe.distribuidas.prosth.service.UsuarioService;
import ec.edu.espe.distribuidas.prosth.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Protesis Store Corp.
 */
@Named
@ViewScoped
public class RegistrarUBean extends BaseBean implements Serializable {

    private String filtro;
    private Integer provinciaBusqueda;
    private boolean enBusquedaPorTipo;
    private List<Provincia> provincias;
    private UsuarioPK usuarioPK;

    private String filtro2;
    private Integer ciudadBusqueda;
    private boolean enBusquedaPorTipo2;
    private List<Ciudad> ciudades;

    private List<Usuario> usuarios;

    private Usuario usuario;

    private Usuario usuarioSel;

    @Inject
    private ProvinciaService provinciaService;
    @Inject
    private CiudadService ciudadService;

    @Inject
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        this.ciudades = this.ciudadService.obtenerTodos();
        this.provincias = this.provinciaService.obtenerTodos();
        this.usuarios = this.usuarioService.obtenerTodos();
        this.usuario = new Usuario();
    }

    @Override
    public void agregar() {
        
        this.usuario = new Usuario();
        super.agregar();

    }

    @Override
    public void modificar() {
        super.modificar();
        this.usuario = new Usuario();
//        this.usuario.setUsuarioPK((this.usuarioSel.getUsuarioPK().getCodUsuario()));
        this.usuario.setNombre(this.usuarioSel.getNombre());
        this.usuario.setApellido(this.usuarioSel.getApellido());
        this.usuario.setPassword(this.usuarioSel.getPassword());
        this.usuario.setCi(this.usuarioSel.getCi());
        this.usuario.setEmail(this.usuarioSel.getEmail());
        this.usuario.setFechaNacimiento(this.usuarioSel.getFechaNacimiento());
        this.usuario.setCodPostal(this.usuarioSel.getCodPostal());
        this.usuario.setCallePrincipal(this.usuarioSel.getCallePrincipal());
        this.usuario.setCalleSecundaria(this.usuarioSel.getCalleSecundaria());
    }

    public void cancelar() {
        super.reset();
        this.usuario = new Usuario();
    }

    public void guardar() {
        try {
             if (this.enAgregar) {  
              this.usuarioPK.setCodTipoUsuario(1);
              this.usuarioPK.setCodUsuario("U003");
              this.usuario.setUsuarioPK(usuarioPK);
              this.usuarioService.crear(this.usuario);
               FacesUtil.addMessageInfo("Se agregó el Usuario: " + this.usuario.getNombre());
             }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.usuario = new Usuario();
        this.usuarios = this.usuarioService.obtenerTodos();
    }
    
     public void buscar() {
            this.ciudades = this.ciudadService.buscarPorTipo(this.provinciaBusqueda);
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getFiltro2() {
        return filtro2;
    }

    public void setFiltro2(String filtro2) {
        this.filtro2 = filtro2;
    }

    public boolean isEnBusquedaPorTipo() {
        return enBusquedaPorTipo;
    }

    public void setEnBusquedaPorTipo(boolean enBusquedaPorTipo) {
        this.enBusquedaPorTipo = enBusquedaPorTipo;
    }

    public boolean isEnBusquedaPorTipo2() {
        return enBusquedaPorTipo2;
    }

    public void setEnBusquedaPorTipo2(boolean enBusquedaPorTipo2) {
        this.enBusquedaPorTipo2 = enBusquedaPorTipo2;
    }
  

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Integer getProvinciaBusqueda() {
        return provinciaBusqueda;
    }

    public void setProvinciaBusqueda(Integer provinciaBusqueda) {
        this.provinciaBusqueda = provinciaBusqueda;
    }

    public Integer getCiudadBusqueda() {
        return ciudadBusqueda;
    }

    public void setCiudadBusqueda(Integer ciudadBusqueda) {
        this.ciudadBusqueda = ciudadBusqueda;
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

}
