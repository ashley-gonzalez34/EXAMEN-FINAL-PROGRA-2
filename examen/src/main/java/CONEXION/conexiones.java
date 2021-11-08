/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class conexiones {
     private final String base = "final examen";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "123456";
    private final String host = "localhost";
    private final String port = "3306";
    private final String url = "jdbc:mysql://"+host+":"+port+"/"+base;
    private Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return con;
    }
    
    public Connection getConexion(String dbNombre){
        String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbNombre;
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return con;
    }
    
}

