/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author pablo
 */
public interface Pedido {

    EstadoPedido getEstadoPedido();

    int getIdPedido();
    
    String getNombreUsuario();
    
    void setNombreUsuario(String nombreUsuario);

    List<Producto> getListaProductos();

    void setEstadoPedido(EstadoPedido estadoPedido);

    void setIdPedido(int idPedido);

    void setListaProductos(List<Producto> listaProductos);
    
}
