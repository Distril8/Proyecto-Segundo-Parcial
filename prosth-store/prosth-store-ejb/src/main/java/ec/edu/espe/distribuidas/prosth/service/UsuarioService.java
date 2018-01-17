/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.service;


import ec.edu.espe.distribuidas.prosth.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.prosth.model.Usuario;
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
public class UsuarioService {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    public List<Usuario> obtenerTodos() {
        return this.usuarioFacade.findAll();
    }

    public Usuario obtenerPorCodigo(String codigo) {
        return this.usuarioFacade.find(codigo);
    }

    public void crear(Usuario usuario) {
        this.usuarioFacade.create(usuario);
    }

    public void modificar(Usuario usuario) {
        this.usuarioFacade.edit(usuario);
    }

}
