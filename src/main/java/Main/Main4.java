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

/**
 *
 * @author JOAHAN CARLO
 */
public class Main4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Connection conn = DatabaseConnection.getInstance()){
           Repositorio<Pelicula> repositorio = new PeliculaRepositorio();
          System.out.println("--------------Listando peliculas--------------");
           repositorio.findAll().forEach(System.out::println);
           
           
           System.out.println("--------------Pelicula eliminada--------------");
           repositorio.delete(6);
           
           
           System.out.println("--------------Listando peliculas--------------");
           repositorio.findAll().forEach(System.out::println);
       }
       catch(Exception e){
       System.out.println(e);
       System.out.println("Algo ha fallado ...............");
    }
    
}

}
