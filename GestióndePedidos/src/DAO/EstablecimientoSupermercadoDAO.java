/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.EstablecimientoSupermercado;
import java.util.List;
import java.sql.*;

/**
 *
 * @author pablo
 */
public class EstablecimientoSupermercadoDAO extends BaseDAO{
    
    public EstablecimientoSupermercadoDAO(String tabla, Connection connection, Statement statement) {
        super(tabla, connection, statement);
    }

    public void crearTabla() {
        String columns = "id INT AUTO_INCREMENT PRIMARY KEY, " + "tipo VARCHAR(255)";
        super.crearTabla(columns);
    }
    
    public int insertaEstablecimientos(List<EstablecimientoSupermercado> establecimientos) {
        Integer idEstablecimiento = null;
        String insertSQL = "INSERT IGNORE INTO " + this.tabla + "(nombre, direccion, tipo) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.getPreparedStatement(insertSQL);
            for (EstablecimientoSupermercado establecimiento: establecimientos) {
                preparedStatement.setString(1, establecimiento.getTipoSupermercado());
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
            System.out.println("Establecimientos almacenados con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error al almacenar los establecimientos: " + ex.getMessage());
        }
        return idEstablecimiento;
    }
}

