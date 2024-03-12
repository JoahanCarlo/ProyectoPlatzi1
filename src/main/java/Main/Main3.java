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
public class Main3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Connection conn = DatabaseConnection.getInstance()){
           Repositorio<Pelicula> repositorio = new PeliculaRepositorio();
           
           System.out.println("--------------Listando peliculas--------------");
           repositorio.findAll().forEach(System.out::println);
           
           System.out.println("--------------Insertando un empleado--------------");
           Pelicula pelicula = new Pelicula();
           pelicula.setNombre_pelicula("INDIDIOUS LA PUERTA FINAL");
           pelicula.setAño_pelicula(Integer.valueOf("2023"));
           pelicula.setEstrella_pelicula(Integer.valueOf("2"));
           pelicula.setClasificacion_cat("TERROR");
           pelicula.setNombre_director("OREN PELI");
           repositorio.save(pelicula);
           
           System.out.println("--------------Pelicula Registrada--------------");
           repositorio.findAll().forEach(System.out::println);
       }
       catch(Exception e){
       System.out.println(e);
       System.out.println("Algo ha fallado ...............");
       }
    }
    
}
