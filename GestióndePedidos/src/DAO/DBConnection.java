/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author DAW TARDE
 */
public class DBConnection {
    
    
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String JDBC_USER = "sqluser";
    private static final String JDBC_PASSWORD = "sqluserpw";
    private static final String DATABASE = "gestionPedidosPJM";
    
    
    public static Connection getConnection() {
        Connection connections = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connections = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Conexión con base de datos realizada correctamente");

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC");
            e.printStackTrace();

        } catch (SQLException ex) {
            System.out.println("Error en la conexión de base de datos");
        }
        return connections;
    }
    
    public static void createDatabase() {
        Statement stat = null;
        try {
            stat = getConnection().createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + DATABASE;
            stat.executeUpdate(sql);
            System.out.println("Database creada.");
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    public static Statement connectDatabase() {
        Statement statement = null;
             Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL + DATABASE, JDBC_USER, JDBC_PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("USE " + DATABASE);
            System.out.println("Usando " + DATABASE);
        } catch (SQLException ex) {
            System.out.println("Error en la conexión de base de datos: " + DATABASE);
        }
        return statement;
    }
    
    public static void closeConnection() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            statement.getConnection().close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    
        
        
        
        
        
        
        
        
    }
 