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
    
    
    //CONSTRUCTOR JSON URL

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.tipoBelleza);
        return hash;
    }

    @Override
    public String toString() {
        return "EstablecimientoBelleza{" + super.toString() + "tipoBelleza=" + tipoBelleza + '}';
    }

    
    
    
    
    
}
