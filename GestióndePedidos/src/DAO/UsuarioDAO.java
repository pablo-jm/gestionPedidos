/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Usuario;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW TARDE
 */
public class UsuarioDAO extends BaseDAO {

    public UsuarioDAO(String tabla, Connection connection, Statement statement) {
        super(tabla, connection, statement);
    }

    public void crearTabla() {
        String columns = "nombreUsuario VARCHAR(255) PRIMARY KEY, "
                + "contrasena VARCHAR(255) NOT NULL, "
                + "idDireccion INT, "
                + "FOREIGN KEY (idDireccion) REFERENCES direcciones(id)";
        super.crearTabla(columns);
    }

    public void insertUsuarios(List<Usuario> usuarios) {
        String insertSQL = "INSERT IGNORE INTO " + this.tabla + " (nombreUsuario, contrasena, idDireccion) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.getPreparedStatement(insertSQL);
            Integer idDireccion = null;
            for (Usuario usuario : usuarios) {
                DireccionDAO direccionDAO = new DireccionDAO("direcciones", this.connection, this.statement);
                boolean foundDireccion = direccionDAO.isDireccionFound(usuario.getDireccion());
                if (!foundDireccion) {
                    idDireccion = direccionDAO.insertaDireccion(usuario.getDireccion());
                }
                preparedStatement.setString(1, usuario.getNombreUsuario());
                preparedStatement.setString(2, usuario.getContrasena());
                preparedStatement.setInt(3, idDireccion);

                preparedStatement.executeUpdate();
            }
            System.out.println("Usuarios almacenados con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al almacenar los usuarios: " + e.getMessage());
        }
    }

}
