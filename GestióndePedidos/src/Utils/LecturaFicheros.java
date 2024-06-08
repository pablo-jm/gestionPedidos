/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author pablo
 */
public class LecturaFicheros {
    
    public static String leerFicheros(String filePath){
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        String contenido = "";
        
        try{
            archivo = new File(filePath);
            reader = new FileReader (archivo);
            buffer = new BufferedReader (reader);
            String linea;
            
            while((linea = buffer.readLine()) != null && linea.length() != 0){
                  contenido = contenido + "\n" + linea;
            }
            return contenido.trim();
            
        }catch(Exception e) {
            System.out.println(e);
        }
        return ""; 
    }
}
