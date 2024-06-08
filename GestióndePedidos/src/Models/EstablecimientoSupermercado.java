/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Objects;

/**
 *
 * @author pablo
 */

@JsonTypeName("supermercado")

public class EstablecimientoSupermercado extends EstablecimientoImpl{
    
    @JsonProperty("tipoSupermercado")
    private String tipoSupermercado;
    @JsonProperty("tipoProducto") 
    protected String tipoProducto = "supermercado";

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    public String getTipoSupermercado() {
        return tipoSupermercado;
    }

    public void setTipoSupermercado(String tipoSupermercado) {
        this.tipoSupermercado = tipoSupermercado;
    }

    public EstablecimientoSupermercado(String tipoSupermercado, String nombre, String direccion) {
        super(nombre, direccion, tipoSupermercado);
        this.tipoSupermercado = tipoSupermercado;
    }

    public EstablecimientoSupermercado() {
        super();
        this.tipoSupermercado = "";
    }
    
    @Override
    public String toString() {
        return "Establecimiento: " + super.getNombre() + "acbsdhugfusv"
                + " tipoProducto: " + this.getTipoProducto()
                + " tipoSupermercado: " + this.getTipoSupermercado()
                + " direccion: " + super.getDireccion();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.tipoSupermercado);
        return hash;
    }

    
    
    
    
}
