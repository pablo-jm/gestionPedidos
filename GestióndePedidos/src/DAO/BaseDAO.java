/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class BaseDAO {

    protected Connection connection;
    protected Statement statement;
    protected String tabla;

    public BaseDAO(String tabla, Connection connection, Statement statement) {
            this.connection = connection;
            this.statement = statement;
            this.tabla = tabla;
     
    }

    public PreparedStatement getPreparedStatement(String sqlQuery) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(sqlQuery,  Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Error creando prepared statement");
        }
        return ps;
    }

    public void crearTabla(String columns) {

        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + this.tabla + "("
                  + columns + ")";
            this.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public static void crearTablas() {
        try {
            Statement stat = DBConnection.getConnection().createStatement();

            String crearTablaPedido = "CREATE TABLE IF NOT EXISTS pedidos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "precio DOUBLE, "
                    + "estado VARCHAR(50), "
                    + "nombreUsuario VARCHAR(255), "
                    + "FOREIGN KEY (nombreUsuario) REFERENCES usuarios(nombreUsuario))";

            String crearTablaPedidoProducto = "CREATE TABLE IF NOT EXISTS pedidoProducto ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "id_producto INT, "
                    + "id_pedido INT, "
                    + "cantidad INT, "
                    + "FOREIGN KEY (id_producto) REFERENCES productos(id), "
                    + "FOREIGN KEY (id_pedido) REFERENCES pedidos(id))";

            stat.executeUpdate(crearTablaPedido);
            stat.executeUpdate(crearTablaPedidoProducto);

            System.out.println("Tablas creadas con éxito.");
        } catch (SQLException e) {
            System.out.println("Error en crearTablas: " + e.getMessage());
        }
    }
*/
    public void updateTabla(String setQuery, String whereQuery) {
        try {
            String sql = "UPDATE " + this.tabla + " SET " + setQuery + " WHERE " + whereQuery;
            System.out.println(sql);
            this.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
