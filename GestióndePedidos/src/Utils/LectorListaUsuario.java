/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Usuario;
import Models.UsuarioImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pablo
 */
public class LectorListaUsuario {
    
    public static List<Usuario> getListaUsuarios(String filePath){
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        String usuarios = LecturaFicheros.leerFicheros("src/sources/usuarios.txt");
        Arrays.asList(usuarios.split("\n")).stream().forEach(linea ->listaUsuarios.add(new UsuarioImpl(linea)));
        return listaUsuarios;
}
    
    
}
