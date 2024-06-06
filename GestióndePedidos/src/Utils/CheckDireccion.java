/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Exceptions.FormatoNoValidoException;

/**
 *
 * @author pablo
 */
public class CheckDireccion {
    
    public static void checkFormatoDireccion(String direccion) throws FormatoNoValidoException{
        String formatoDireccion = "^[A-Za-z\\s]+,\\s\\d+,\\s[A-Za-z\\s]+,\\s\\d{5}$";
        if(direccion.matches(formatoDireccion)){
           throw new FormatoNoValidoException("La dirección no sigue el formato. (Calle, número, ciudad, codigo postal"); 
        }
    }
}
