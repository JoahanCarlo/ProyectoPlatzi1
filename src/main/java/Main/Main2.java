/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelo.Pelicula;
import Repositorio.PeliculaRepositorio;
import Repositorio.Repositorio;
import Util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JOAHAN CARLO
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        try(Connection conn = DatabaseConnection.getInstance()){
           Repositorio<Pelicula> repositorio = new PeliculaRepositorio();
           
           repositorio.findAll().forEach(System.out::println);
       }
       catch(Exception e){
       System.out.println(e);
       System.out.println("Algo ha fallado ...............");
       }
    }
    
}
