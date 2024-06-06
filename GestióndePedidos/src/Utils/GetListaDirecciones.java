/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Direccion;
import Models.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class GetListaDirecciones {
    
    public static List<Direccion> getListaDeDirecciones(List<Usuario> usuarios){

        List<Direccion> direcciones = new ArrayList();

        for(Usuario u : usuarios){
            direcciones.add(u.getDireccion());
        }

        return direcciones;
    }
}
