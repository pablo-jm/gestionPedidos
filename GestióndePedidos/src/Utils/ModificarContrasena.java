/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Usuario;
import java.util.List;

/**
 *
 * @author pablo
 */
public class ModificarContrasena {
    public static void modificarContrasenaUsuario(String nombreUsuario, List<Usuario> listaUsuarios, String contrasena){
        try{
            for(Usuario usuario: listaUsuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
            usuario.setContrasena(contrasena);
            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
