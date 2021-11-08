/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class MYSQL {
     public boolean registrar(USUARIOS usr){
        PreparedStatement ps = null;
        Connection con = getConexion();
        //cadena de mysqul
        String sql = "INSERT INTO usuarios (id_depa,id_regis,nombre,apellido,correo, fechanacimiento,fecharegistro) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getid_depa());
            ps.setString(2, usr.getid_regis());//orden de columnas
            ps.setString(3, usr.getnombre());
            ps.setString(4, usr.getapellido());
            ps.setString(5, usr.getcorreo());
            ps.setString(6, usr.getfechanaciemiento());
            ps.setString(7, usr.getfecharegistro());
            ps.setInt(8, usr.getId_tipo());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
            try {
                //Cerramos la conexión!
                con.close();
            } catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
    }
    
    public int existeUsuario(String usuario){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";//se selecciona la tabla de usuarios para poder egistrar
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1,usuario);
            
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
            return 1;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return 1;
        } finally {
            try {
                //Cerramos la conexión!
                con.close();
            } catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
    }
    
    
  
    
    
    public boolean login(Usuario usr){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT id_depa,id_regis,nombre,apellido,correo, fechanacimiento,fecharegistro, FROM usuarios WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1,usr.getUsuario());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(3))) {
                    
                    String sqlUpdateDate = "UPDATE usuarios SET usuarios = ? WHERE id =?";
                    
                    ps = con.prepareStatement(sqlUpdateDate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    
                    ps.execute();
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(5);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
            try {
                //Cerramos la conexión!
                con.close();
            } catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }
}

