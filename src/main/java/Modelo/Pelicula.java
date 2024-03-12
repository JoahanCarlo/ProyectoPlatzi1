/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JOAHAN CARLO
 */
public class Pelicula {
    private Integer idpelicula;
    private Integer iddirector;
    private Integer idcategoria;
    private String nombre_pelicula;
    private Integer año_pelicula;
    private Integer estrella_pelicula;
    private String nom__categoria;
    private String clasificacion_cat;
    private String nombre_director;
    private Integer cantidad_oscar;

    public Pelicula() {
    }

    public Pelicula(Integer idpelicula, Integer iddirector, Integer idcategoria, String nombre_pelicula, Integer año_pelicula, Integer estrella_pelicula, String nom__categoria, String clasificacion_cat, String nombre_director, Integer cantidad_oscar) {
        this.idpelicula = idpelicula;
        this.iddirector = iddirector;
        this.idcategoria = idcategoria;
        this.nombre_pelicula = nombre_pelicula;
        this.año_pelicula = año_pelicula;
        this.estrella_pelicula = estrella_pelicula;
        this.nom__categoria = nom__categoria;
        this.clasificacion_cat = clasificacion_cat;
        this.nombre_director = nombre_director;
        this.cantidad_oscar = cantidad_oscar;
    }

    public Integer getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Integer getIddirector() {
        return iddirector;
    }

    public void setIddirector(Integer iddirector) {
        this.iddirector = iddirector;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public Integer getAño_pelicula() {
        return año_pelicula;
    }

    public void setAño_pelicula(Integer año_pelicula) {
        this.año_pelicula = año_pelicula;
    }

    public Integer getEstrella_pelicula() {
        return estrella_pelicula;
    }

    public void setEstrella_pelicula(Integer estrella_pelicula) {
        this.estrella_pelicula = estrella_pelicula;
    }

    public String getNom__categoria() {
        return nom__categoria;
    }

    public void setNom__categoria(String nom__categoria) {
        this.nom__categoria = nom__categoria;
    }

    public String getClasificacion_cat() {
        return clasificacion_cat;
    }

    public void setClasificacion_cat(String clasificacion_cat) {
        this.clasificacion_cat = clasificacion_cat;
    }

    public String getNombre_director() {
        return nombre_director;
    }

    public void setNombre_director(String nombre_director) {
        this.nombre_director = nombre_director;
    }

    public Integer getCantidad_oscar() {
        return cantidad_oscar;
    }

    public void setCantidad_oscar(Integer cantidad_oscar) {
        this.cantidad_oscar = cantidad_oscar;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idpelicula=" + idpelicula + ", iddirector=" + iddirector + ", idcategoria=" + idcategoria + ", nombre_pelicula=" + nombre_pelicula + ", año_pelicula=" + año_pelicula + ", estrella_pelicula=" + estrella_pelicula + ", nom__categoria=" + nom__categoria + ", clasificacion_cat=" + clasificacion_cat + ", nombre_director=" + nombre_director + ", cantidad_oscar=" + cantidad_oscar + '}';
    }

   
    
}
