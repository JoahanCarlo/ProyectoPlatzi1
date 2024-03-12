/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JOAHAN CARLO
 */
public class DatabaseConnection {
   private static String url = "jdbc:mysql://localhost:3306/bdnetflix";
   private static String usuario = "root";
   private static String contraseña = "";
   
   private static Connection conn;
   
   public static Connection getInstance() throws SQLException{
       if(conn==null){
           conn = DriverManager.getConnection(url,usuario,contraseña);
       }
       return conn;
   }
   
}
