/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.web;


import ec.edu.espe.distribuidas.prosth.dao.DetalleVentaFacade;
import ec.edu.espe.distribuidas.prosth.dao.VentaFacade;
import ec.edu.espe.distribuidas.prosth.model.Producto;
import ec.edu.espe.distribuidas.prosth.service.ProductoService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author dansan
 */
@Named(value = "carritoController")
@SessionScoped
public class CarritoBean implements Serializable {

    @EJB
    private VentaFacade lineapedidoFacade;
    @EJB
    private DetalleVentaFacade pedidoFacade;
    /**
     * Atributos utiles para el controlador Carrito
     */
    @Inject
    private ProductoAdminBean productoController;
    
    private ArrayList<Producto> carrito = new ArrayList<Producto>();
    private Producto productoSelecionado;
    private int idProductoSeleccionado;
    private double totalCompra = 0.0;
        @Inject
    private ProductoService productoService;

    public CarritoBean() {
    }

    //metodos
    public String agregarAlCarrito(int idProducto) {
        setIdProductoSeleccionado(idProducto);
        Producto p = buscarProductoCarrito(idProductoSeleccionado);
        if (p != null && p.getStock() > 0) {
            int n = carrito.indexOf(p);
            //carrito.get(n).setCantidad(carrito.get(n).getCantidad() + 1);
            totalCompra+=p.getPrecio().doubleValue();
        }        
        return "compraU";
    }

    private Producto buscarProductoCarrito(int idProducto) {
        Producto p = null;
        for (Producto prod : carrito) {
            if (prod.getCodigo() == idProducto) {
                p = prod;
                break;
            }
        }
        return p;
    }

   
//
//    public String confirmarPedido() {
//        Date date = new Date();
//        ArrayList<Lineapedido> pedidos = new ArrayList<Lineapedido>();
//        if (usuarioController.getIdcliente() > 0) {
//            Pedido pedido = new Pedido(date, usuarioController.getIdcliente(), 'a');
//            for (Producto p : carrito) {
//                Number n = p.getCantidad();
//                BigDecimal cant = new BigDecimal(n.toString());
//                BigDecimal monto = p.getPrecio().multiply(cant);
//                BigDecimal descuento = new BigDecimal(0.0);
//                if (p.getCantidad() >= 10) {
//                    descuento = monto.multiply(new BigDecimal(0.1));
//                }
//                Lineapedido linea = new Lineapedido(pedido, p.getIdproducto(), descuento, p.getCantidad(), monto);
//                pedidos.add(linea);
//            }
//            pedido.setPedidos(pedidos);
//            pedidoFacade.create(pedido);            
//            carrito.clear();
//            totalCompra = 0.0;
//            return "confirmacion";
//        } else {
//            FacesContext faces = FacesContext.getCurrentInstance();
//            faces.addMessage("mensajeError", new FacesMessage("Para poder comprar debes registrate o ingresar al sistema"));
//            return "carrito";
//        }
//    }

    public String doIrCarrito() {
        productoService.obtenerTodos();
        return "carrito";
    }

    public String doIrCarritoActual() {
        return "carritoactual";
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    public Producto getProductoSelecionado() {
        return productoSelecionado;
    }

    public void setProductoSelecionado(Producto productoSelecionado) {
        this.productoSelecionado = productoSelecionado;
    }

    public int getIdProductoSeleccionado() {
        return idProductoSeleccionado;
    }

    public void setIdProductoSeleccionado(int idProductoSeleccionado) {
        this.idProductoSeleccionado = idProductoSeleccionado;
    }

   
    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

  
}