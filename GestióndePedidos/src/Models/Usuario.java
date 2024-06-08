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
public interface Usuario {

    String getContrasena();

    Direccion getDireccion();

    List<Pedido> getListaPedido();

    String getNombreUsuario();

    void setContrasena(String contrasena);

    void setDireccion(Direccion direccion);

    void setListaPedido(List<Pedido> listaPedido);

    void setNombreUsuario(String nombreUsuario);

    int compareTo(Usuario usuario);

    
}
