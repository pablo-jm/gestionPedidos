/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.*;

/**
 *
 * @author pablo
 */
public class PedidoImpl implements Pedido {
    
    private int idPedido;
    private EstadoPedido estadoPedido;
    private List<Producto> listaProductos;
    private String nombreUsuario;

    
    public PedidoImpl(EstadoPedido estadoPedido, List<Producto> listaProductos, String nombreUsuario) {
        this.idPedido = 0;
        this.estadoPedido = estadoPedido;
        this.listaProductos = listaProductos;
        this.nombreUsuario = nombreUsuario;
    }

    public PedidoImpl() {
        this.idPedido = 0;
        this.estadoPedido = null;
        this.listaProductos = new ArrayList<>();
        this.nombreUsuario = "";
    }

    @Override
    public int getIdPedido() {
        return idPedido;
    }

    @Override
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    @Override
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }


    @Override
    public List<Producto> getListaProductos() {
        return listaProductos;
    }


    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "PedidoImpl{" + "idPedido=" + idPedido + ", estadoPedido=" + estadoPedido + ", listaProductos=" + listaProductos + ", nombreUsuario=" + nombreUsuario + '}';
    }
    
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Pedido){
            Pedido p = (Pedido) o;
                r = this.idPedido == p.getIdPedido();
        }
        return r;
    }
    
    public int compareTo(Pedido pedido){
        int n;
        n = this.nombreUsuario.compareTo(pedido.getNombreUsuario());
        return n;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idPedido;
        hash = 67 * hash + Objects.hashCode(this.estadoPedido);
        hash = 67 * hash + Objects.hashCode(this.listaProductos);
        hash = 67 * hash + Objects.hashCode(this.nombreUsuario);
        return hash;
    }
    
    
    
    
    
    
    
    
}
