/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Producto;
import java.sql.*;
import java.util.List;

/**
 *
 * @author DAW TARDE
 */
public class ProductoDAO extends BaseDAO{

    public ProductoDAO(String tabla, Connection connection, Statement statement) {
        super(tabla, connection, statement);
    }
        
    //PREGUNTAR INSERTS AHORA, IDESTABLECIMIENTO
        public void crearTabla() {
        String columns = "CREATE TABLE IF NOT EXISTS productos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255), "
                    + "precio DOUBLE, "
                    + "idEstablecimiento INT, "
                    + "FOREIGN KEY (idEstablecimiento) REFERENCES establecimientos(id))";
        
        super.crearTabla(columns);
    }
    
     public int insertaProductos(List<Producto> productos) {
        Integer idEstablecimiento = null;
        String insertSQL = "INSERT IGNORE INTO " + this.tabla + "(nombre, precio, establecimiento, cantidad) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.getPreparedStatement(insertSQL);
            for (Producto producto: productos) {
                preparedStatement.setString(1, producto.getNombre());
                preparedStatement.setDouble(2, producto.getPrecio());
                preparedStatement.setString(2, producto.getEstablecimiento());
                preparedStatement.setInt(2, producto.getCantidad());
                int affectedRows = preparedStatement.executeUpdate();
           
        // Check if the insert was successful
                if (affectedRows > 0) {
                // Retrieve the auto-increment ID
                ResultSet rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        idEstablecimiento = rs.getInt(1);
                        System.out.println("Last inserted ID: " + idEstablecimiento);
                    }
            }   
            }   
            System.out.println("Establecimientos Belleza almacenados con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error al almacenar los estbalecimientos: " + ex.getMessage());
        }
        return idEstablecimiento;
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    }
    
    
    
    
    
    
    
    
    
    
  