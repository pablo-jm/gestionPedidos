/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models;

/**
 *
 * @author pablo
 */
public interface Producto {

    int getCantidad();

    String getEstablecimiento();

    String getNombre();

    double getPrecio();
    
    public int getIdProducto();

    void setCantidad(int cantidad);

    void setEstablecimiento(String establecimiento);

    void setNombre(String nombre);

    void setPrecio(double precio);

    
    
}
