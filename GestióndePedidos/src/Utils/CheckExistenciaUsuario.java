/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Exceptions.NoRegistradoException;
import Exceptions.UsuarioYaExistenteException;
import Models.Usuario;
import java.util.List;

/**
 *
 * @author pablo
 */
public class CheckExistenciaUsuario {
    
    public static void checkUsuarioNoExiste(String nombreUsuario, String contrasena, List<Usuario> listaUsuarios) throws NoRegistradoException, UsuarioYaExistenteException{
        for (Usuario infoUsuario: listaUsuarios) {
                if(!infoUsuario.getNombreUsuario().equals(nombreUsuario) 
                && !infoUsuario.getContrasena().equals(contrasena)){
                   throw new NoRegistradoException("Usuario no registrado.");
            }
        }
            
    }
    
    public static void checkUsuarioExiste(String nombreUsuario, String contrasena, List<Usuario> listaUsuarios) throws NoRegistradoException, UsuarioYaExistenteException{
        for (Usuario infoUsuario: listaUsuarios) {
                if(infoUsuario.getNombreUsuario().equals(nombreUsuario) 
                && infoUsuario.getContrasena().equals(contrasena)){
                   throw new UsuarioYaExistenteException("Usuario existente.");
            }
        }
            
    }
    
    
}
