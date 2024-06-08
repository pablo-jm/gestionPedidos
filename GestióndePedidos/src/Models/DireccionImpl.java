/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author pablo
 */
public class DireccionImpl implements Direccion {
    
    private int idDireccion;
    private String calle;
    private String numero;
    private String ciudad;
    private String numPostal;
    

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
    @Override
    public String getCalle() {
        return calle;
    }

    @Override
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumPostal() {
        return numPostal;
    }

    public void setNumPostal(String numPostal) {
        this.numPostal = numPostal;
    }  
    
    public DireccionImpl(String lineaFichero) {
        String[] atributos = lineaFichero.split(";")[1].split(",");
        this.calle = atributos[0];
        this.numero = atributos[1];
        this.ciudad = atributos[2];
        this.numPostal = atributos[3];
    } 

    public DireccionImpl() {
        this.calle = "";
        this.numero = "";
        this.ciudad = "";
        this.numPostal = "";  
    }

    public DireccionImpl(String calle, String numero, String ciudad, String numPostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.numPostal = numPostal;
    }
   
    public int compareTo(Direccion d){
        int n;
        n = this.calle.compareTo(d.getCalle());
        if(n == 0){
           n = this.numero.compareTo(d.getNumero());
        }
        return n;
    }

    @Override
    public String toString() {
        return "DireccionImpl{" + "calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", numPostal=" + numPostal + '}';
    }
    
    
    
    
}
