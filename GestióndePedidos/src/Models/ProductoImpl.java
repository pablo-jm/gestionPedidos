/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

/**
 *
 * @author pablo
 */
public class ProductoImpl implements Producto {
    
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("precio")
    private double precio;
    @JsonProperty("establecimiento")
    private String establecimiento;
    @JsonProperty("cantidad")
    private int cantidad;      
    private int idProducto;

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String getEstablecimiento() {
        return establecimiento;
    }

    @Override
    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoImpl(String nombre, double precio, String establecimiento, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.establecimiento = establecimiento;
        this.cantidad = cantidad;
    }
    
    public ProductoImpl() {
        this.nombre = "";
        this.precio = 0;
        this.establecimiento = "";
        this.cantidad = 0;
    }

    @Override
    public String toString() {
        return "ProductoImpl{" + "nombre=" + nombre + ", precio=" + precio + ", establecimiento=" + establecimiento + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.establecimiento);
        hash = 47 * hash + this.cantidad;
        return hash;
    }

    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Producto){
            Producto p = (Producto) o;
                r = this.nombre.equals(p.getNombre());
        }
        return r;
    }
    
    public int compareTo(Producto producto){
        int n;
        n = Double.compare(this.precio, producto.getPrecio());
        return n;
    }
    
            
    
    
            
}
