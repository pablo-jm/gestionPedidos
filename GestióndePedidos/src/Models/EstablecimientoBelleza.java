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

@JsonTypeName("belleza")

public class EstablecimientoBelleza extends EstablecimientoImpl{
    
    @JsonProperty("tipoCentroBelleza")
    private String tipoBelleza;
    @JsonProperty("tipoProducto") 
    protected String tipoProducto = "belleza";

    
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
    public String getTipoBelleza() {
        return tipoBelleza;
    }

    public void setTipoBelleza(String tipoBelleza) {
        this.tipoBelleza = tipoBelleza;
    }

    public EstablecimientoBelleza() {
        super();
        this.tipoBelleza = "";
    }

    public EstablecimientoBelleza(String tipoBelleza, String nombre, String direccion, String tipoProducto) {
        super(nombre, direccion, tipoProducto);
        this.tipoBelleza = tipoBelleza;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.tipoBelleza);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString() + "EstablecimientoBelleza{" + super.toString() + "tipoProducto=" + tipoBelleza + '}';
    }

  
    
    
    
}
