/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;

/**
 *
 * @author pablo
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoProducto")
@JsonSubTypes({
    @JsonSubTypes.Type(value = EstablecimientoBelleza.class, name = "belleza"),
    @JsonSubTypes.Type(value = EstablecimientoComida.class, name = "comida"),
    @JsonSubTypes.Type(value = EstablecimientoSupermercado.class, name = "supermercado")
})

public class EstablecimientoImpl implements Establecimiento {
    
    @JsonProperty("establecimiento")
    protected String nombre;
    @JsonProperty("direccion") 
    protected String direccion;
    protected int id;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstablecimientoImpl(String nombre, String direccion, String tipoProducto) {
        this.id = 0;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public EstablecimientoImpl() {
        this.nombre = "";
        this.direccion = "";
        this.id = 0;
    }
    
    @Override
    public String toString() {
        return "EstablecimientoImpl{" + "nombre=" + nombre + ", direccion=" + direccion;
    }
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Establecimiento){
            Establecimiento e = (Establecimiento) o;
                r = this.direccion.equals(e.getDireccion());
        }
        return r;
    }
    
    public int compareTo(Establecimiento e){
        int n;
        n = this.direccion.compareTo(e.getDireccion());
        return n;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.direccion);
        return hash;
    }
    
    
    
    
}
