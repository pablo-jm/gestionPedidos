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

@JsonTypeName("comida")

public class EstablecimientoComida extends EstablecimientoImpl{
    
    @JsonProperty("tipoComida")
    private String tipoComida;
    @JsonProperty("tipoProducto") 
    protected String tipoProducto = "comida";

    
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public EstablecimientoComida() {
        super();
        this.tipoComida = "";
        this.tipoProducto = "";
    }

    public EstablecimientoComida(String tipoComida, String nombre, String direccion, String tipoProducto) {
        super(nombre, direccion, tipoComida);
        this.tipoComida = tipoComida;
        this.tipoProducto = tipoProducto;
    }
    
   @Override
    public String toString() {
        return super.toString() + "EstablecimientoBelleza{" + super.toString() + "tipoProducto=" + tipoComida + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.tipoComida);
        return hash;
    }

    
    
    
    
}
