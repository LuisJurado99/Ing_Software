/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author luisj
 */
public class conex {
    public static final String URL = "jdbc:mysql://remotemysql.com:3306/Nclx7geMqX";
    public static final String USERNAME = "Nclx7geMqX";
    public static final String PASSWORD = "GxO3BMW3Au";
    
    public static void coneccion(){
        try {
            Connection con = null;
            con=getConection();
            
            PreparedStatement ps;
            ResultSet res;
            
            ps = con.prepareStatement("SELECT * FROM recepcion");
            
            res = ps.executeQuery();
            
            if (res.next()) {
                JOptionPane.showMessageDialog(null,res.getInt("id_recp"+res.getString("nombre")));
            }else{
                JOptionPane.showMessageDialog(null, "No existen datos");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error:"+e);
        }
    }
    public static Connection getConection(){
        Connection con= null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection)DriverManager.getConnection(URL,USERNAME, PASSWORD);
            System.out.println("conecta chido");
        }catch(Exception e){
            System.out.println("Error:"+e);
                
        }
        return con;
    }
}
