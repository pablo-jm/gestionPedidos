/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Models;

import DAO.DBConnection;
import DAO.DireccionDAO;
import DAO.EstablecimientoDAO;
import DAO.UsuarioDAO;
import static Utils.GetListaDirecciones.getListaDeDirecciones;
import Utils.LectorListaUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.sql.*;
/**
 *
 * @author pablo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ObjectMapper JSON_MAPPER = new ObjectMapper();

            List<Usuario> listaUsuarios = LectorListaUsuario.getListaUsuarios("src/sources/usuarios.txt");
            List<Establecimiento> establecimientos = Arrays.asList(JSON_MAPPER.readValue(new URL("http://demo4746359.mockable.io/establecimientos"), EstablecimientoImpl[].class));
            List<Producto> establecimientosComida = Arrays.asList(JSON_MAPPER.readValue(new URL("http://demo4746359.mockable.io/productos/comida"), ProductoImpl[].class));
            List<Producto> establecimientosBelleza = Arrays.asList(JSON_MAPPER.readValue(new URL("http://demo4746359.mockable.io/productos/belleza"), ProductoImpl[].class));
            List<Producto> establecimientosSupermercado = Arrays.asList(JSON_MAPPER.readValue(new URL("http://demo4746359.mockable.io/productos/supermercado"), ProductoImpl[].class));
            List<Direccion> direcciones = getListaDeDirecciones(listaUsuarios);

            
            DBConnection.createDatabase();
            Statement statement = DBConnection.connectDatabase();
            //  BaseDAO.crearTablas();
            Connection connection = statement.getConnection();
            
            DireccionDAO direccionDAO = new DireccionDAO("direcciones", connection, statement);
            direccionDAO.crearTabla();
            
            UsuarioDAO usuarioDAO = new UsuarioDAO("usuarios", connection, statement);
            usuarioDAO.crearTabla();
            usuarioDAO.insertUsuarios(listaUsuarios);
            
           
            
            
            

            /*
            MenuPrincipal menu = new MenuPrincipal("Principal", listaUsuarios, 
                            establecimientosComida, establecimientosBelleza, 
                            establecimientosSupermercado);
            */ 
            DBConnection.closeConnection();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
