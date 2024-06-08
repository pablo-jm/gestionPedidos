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
public class CheckFormatoUsuarioYPass {
    
    public static void checkUsuYPassFormat(String nombreUsuario, String contrasena) throws FormatoNoValidoException{
            String patternUsuario = "^[a-zA-Z0-9_]{5,20}$";
            String patternPass = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{8,16}$";
            if(!nombreUsuario.matches(patternUsuario) || !contrasena.matches(patternPass)){
               throw new FormatoNoValidoException("Formato de usuario o contraseña no válido"); 
            }
        }
}
