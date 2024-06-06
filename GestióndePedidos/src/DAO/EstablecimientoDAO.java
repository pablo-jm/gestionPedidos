/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Establecimiento;
import Models.EstablecimientoBelleza;
import Models.EstablecimientoComida;
import java.sql.*;
import java.util.List;

/**
 *
 * @author DAW TARDE
 */
public class EstablecimientoDAO extends BaseDAO {

    
    public EstablecimientoDAO(String tabla, Connection connection, Statement statement) {
        super(tabla, connection, statement);
    }

    public void crearTabla() {
        String columns = "CREATE TABLE IF NOT EXISTS establecimientos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL UNIQUE, "
                    + "direccion VARCHAR(255), "
                    + "tipo VARCHAR(255)";
        super.crearTabla(columns);
    }
    

    public boolean isEstablecimientoFound(String establecimiento) {
        try {
            String sql = "SELECT * FROM " + this.tabla + "WHERE nombre= '" + establecimiento + "'";
            ResultSet rs = this.statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error al buscar el establecimiento");
            return false;
        }
    }

    public int insertaEstablecimientos(List<Establecimiento> establecimientos) {
        Integer idEstablecimiento = null;
        String insertSQL = "INSERT IGNORE INTO " + this.tabla + "(nombre, direccion) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = this.getPreparedStatement(insertSQL);
            for (Establecimiento establecimiento: establecimientos) {
                preparedStatement.setString(1, establecimiento.getNombre());
                preparedStatement.setString(2, establecimiento.getDireccion());
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
    
   
