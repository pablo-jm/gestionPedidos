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

    
    public String getTipoSupermercado() {
        return tipoSupermercado;
    }

    public void setTipoSupermercado(String tipoSupermercado) {
        this.tipoSupermercado = tipoSupermercado;
    }

    public EstablecimientoSupermercado(String tipoSupermercado, String nombre, String direccion) {
        super(nombre, direccion);
        this.tipoSupermercado = tipoSupermercado;
    }

    public EstablecimientoSupermercado() {
        super();
        this.tipoSupermercado = "";
    }
    
    @Override
    public String toString() {
        return "EstablecimientoSupermercado{" + super.toString() + "tipoSupermercado=" + tipoSupermercado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.tipoSupermercado);
        return hash;
    }

    
    
    
    
}
