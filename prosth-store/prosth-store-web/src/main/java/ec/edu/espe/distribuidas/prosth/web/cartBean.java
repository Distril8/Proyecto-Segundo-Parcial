/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.web;

import ec.edu.espe.distribuidas.prosth.model.Item;
import ec.edu.espe.distribuidas.prosth.model.Producto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author Juan José Ponce
 */
@Named(value = "sp")
@ViewScoped
public class cartBean implements Serializable {

    private List<Item> cart = new ArrayList<Item>();
    private float total;
private Item selectedItem = new Item();

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }


    public cartBean() {

    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        total = 0;
        for (Item item : cart) {
            total += item.getValorTotal();
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> addtoCart(Producto p, Integer cantidad) {
       // HttpSession session = HibernateUtil.getSession();
      

        for (Item item : cart) {
            if (item.getProducto().getCodProducto().equals(p.getCodProducto())) {
                item.setCantidad(cantidad + item.getCantidad());
                item.setId(p.getCodProducto());
                return cart;
            }
        }
        Item item1 = new Item();
        item1.setCantidad(cantidad);
        item1.setProducto(p);
       // BigDecimal.valueOf(cantidad).movePointLeft(2);
        item1.setValorTotal(0);
        item1.setId(p.getCodProducto());
        cart.add(item1);
       // session.setAttribute("carrito", this.cart);
        return cart;
    }

     public void remove(){
        String msg;
        // HttpSession session = HibernateUtil.getSession();
        // List<Item> lista = (List<Item>); //session.getAttribute("carrito");
          //  lista = (List<Item>) ;

//        for (Item item : lista) {
//            if(item.getId().equals(selectedItem.getId()))
//            {
//                lista.remove(selectedItem);
//                
//                msg = "Se elimino correctamente el registro";
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            }
//        }
         //session.setAttribute("carrito", lista);

    }
     
     public String payment()
     {
         return "pago";
     }

}
