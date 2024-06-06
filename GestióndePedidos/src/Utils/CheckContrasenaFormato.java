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
public class CheckContrasenaFormato {
    public static void checkPassFormat(String contrasena) throws FormatoNoValidoException{
            String patternPass = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{8,16}$";
            if(!contrasena.matches(patternPass)){
               throw new FormatoNoValidoException("Formato de usuario o contraseña no válido"); 
            }
        }
}
