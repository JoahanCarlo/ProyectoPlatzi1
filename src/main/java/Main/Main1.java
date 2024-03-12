/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Util.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author JOAHAN CARLO
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try(Connection conn = DatabaseConnection.getInstance();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select *from pelicula")){
           while (rs.next()) {               
               System.out.println(rs.getString("idcategoria"));
           }
       }
       catch(Exception e){
       e.fillInStackTrace();
       System.out.println("Algo ha fallado ...............");
       }
    }
    
}
