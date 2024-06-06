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

public class UsuarioImpl implements Usuario {
    
    // IMPORTANTE AÑADIR A TODOS private int id;
    private String nombreUsuario;
    private Direccion direccion;
    private String contrasena;
    private List<Pedido> listaPedido;
   
    
    public UsuarioImpl() {
        this.nombreUsuario = "";
        this.direccion = new DireccionImpl();
        this.contrasena = "";
        this.listaPedido = new ArrayList<>();
    }

    public UsuarioImpl(String nombreUsuario, Direccion direccion, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }
    
    public UsuarioImpl(String nombreUsuario, String direccion, String contrasena) {
        String[] direccionSplit = direccion.split(", ");
        this.nombreUsuario = nombreUsuario;
        this.direccion = new DireccionImpl(direccionSplit[0], direccionSplit[1], direccionSplit[2], direccionSplit[3]);
        this.contrasena = contrasena;
    }
    
    public UsuarioImpl(String lineaFichero) {
        String[] atributos = lineaFichero.split(";");
        this.nombreUsuario = atributos[0];
        this.direccion = new DireccionImpl(lineaFichero);
        this.contrasena = atributos[2];
        this.listaPedido = new ArrayList<>();
    }
   
    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public Direccion getDireccion() {
        return direccion;
    }

    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public List<Pedido> getListaPedido() {
        return listaPedido;
    }

    @Override
    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", direccion=" + direccion + ", contrasena=" + contrasena + ", listaPedido=" + listaPedido + '}';
    } 
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Usuario){
            Usuario p = (Usuario) o;
                r = this.nombreUsuario.equals(p.getNombreUsuario()) && this.contrasena.equals(p.getContrasena());
        }
        return r;
    }
    
    public int compareTo(Usuario usuario){
        int n;
        n = this.nombreUsuario.compareTo(usuario.getNombreUsuario());
        return n;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 41 * hash + Objects.hashCode(this.direccion);
        hash = 41 * hash + Objects.hashCode(this.contrasena);
        hash = 41 * hash + Objects.hashCode(this.listaPedido);
        return hash;
    }
    
    

    
    
}
