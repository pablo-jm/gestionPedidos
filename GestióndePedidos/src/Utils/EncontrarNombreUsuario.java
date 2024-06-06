/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Usuario;
import Models.UsuarioImpl;
import java.util.List;

/**
 *
 * @author pablo
 */
public class EncontrarNombreUsuario {
    public static String encontrarNombreUsuario(List<Usuario> listaUsuario, String nombreUsuario){
        String usuarioEncontrado = "";
        for (Usuario usuario: listaUsuario) {
             if(usuario.getNombreUsuario().equals(nombreUsuario)){
                usuarioEncontrado = nombreUsuario;
             }
        }
        return usuarioEncontrado;
    }
}
