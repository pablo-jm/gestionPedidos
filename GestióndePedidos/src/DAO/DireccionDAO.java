/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Direccion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class DireccionDAO extends BaseDAO {

    public DireccionDAO(String tabla, Connection connection,  Statement statement) {
        super(tabla, connection, statement);
    }

    public void crearTabla() {

        String columns = "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "calle VARCHAR(255), "
                + "numero VARCHAR(10), "
                + "ciudad VARCHAR(255), "
                + "codigoPostal VARCHAR(10)";
        super.crearTabla(columns);
    }

    public boolean isDireccionFound(Direccion direccion) {
        try {
            String sql = "SELECT * FROM " + this.tabla + "WHERE calle= '" + direccion.getCalle() + "' , numero= "
                    + direccion.getNumero() + ", ciudad='" + direccion.getCiudad() + "' , numPostal= '" + direccion.getNumPostal() + "'";
            ResultSet rs = this.statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error al buscar la direccion");
            return false;
        }
    }

    public int insertaDireccion(Direccion direccion) {
        Integer direccionId = null;
        String insertSQL = "INSERT IGNORE INTO " + this.tabla + "(calle, numero, ciudad, codigoPostal) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.getPreparedStatement(insertSQL);
        try {
            preparedStatement.setString(1, direccion.getCalle());
            preparedStatement.setString(2, direccion.getNumero());
            preparedStatement.setString(3, direccion.getCiudad());
            preparedStatement.setString(4, direccion.getNumPostal());
            int affectedRows = preparedStatement.executeUpdate();

            // Check if the insert was successful
            if (affectedRows > 0) {
                // Retrieve the auto-increment ID
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    direccionId = rs.getInt(1);
                    System.out.println("Last inserted ID: " + direccionId);
                }
            }
            System.out.println("Direccion almacenada con éxito.");
        } catch (SQLException ex) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al almacenar las direcciones: " + ex.getMessage());
        }
        return direccionId;
    }

}
