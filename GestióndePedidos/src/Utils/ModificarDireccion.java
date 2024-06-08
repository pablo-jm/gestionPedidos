/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.DireccionImpl;
import Models.Usuario;
import java.util.List;

/**
 *
 * @author pablo
 */
public class ModificarDireccion {
    public static void modificarDireccionUsuario(String nombreUsuario, List<Usuario> listaUsuarios, String direccion){
        try{
            CheckDireccion.checkFormatoDireccion(direccion);
        for(Usuario usuario: listaUsuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
            String[] direccionMod = direccion.split(", ");
            usuario.setDireccion(new DireccionImpl(direccionMod[0], direccionMod[1], direccionMod[2], direccionMod[3]));
            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}