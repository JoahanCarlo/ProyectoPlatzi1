/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Modelo.Pelicula;
import Util.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAHAN CARLO
 */
public class PeliculaRepositorio implements Repositorio<Pelicula>{
    
    private Connection getConnection() throws SQLException{
        return DatabaseConnection.getInstance();
    }
    
    @Override
    public List<Pelicula> findAll() throws SQLException {
        List<Pelicula> peliculas = new ArrayList<>();
        try(Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select \n" +
            "p.idpelicula,p.nombre_pel,p.año,d.nombre_director,c.nom_categoria, c.clasificacion\n" +
            "from pelicula p\n" +
            "inner join categoria c on c.idcategoria=p.idcategoria\n" +
            "inner join director d on d.iddirector = p.iddirector")){
            while (rs.next()) {                
                Pelicula p = createPelicula(rs);
                peliculas.add(p);
            }
        }
        return  peliculas;
    }
    
    private Pelicula createPelicula(ResultSet rs) throws SQLException{
         Pelicula p = new Pelicula();
                p.setIdpelicula(rs.getInt("p.idpelicula"));
                p.setNombre_pelicula(rs.getString("p.nombre_pel"));
                p.setAño_pelicula(rs.getInt("p.año"));
                p.setNombre_director(rs.getString("d.nombre_director"));
                p.setNom__categoria(rs.getString("c.nom_categoria"));
                p.setClasificacion_cat(rs.getString("c.clasificacion"));
                return p;
    }

    @Override
    public Pelicula getById(Integer id) throws SQLException {
       Pelicula pelicula = null;
       try(PreparedStatement pst = getConnection().prepareStatement("select \n" +
        "p.idpelicula,p.nombre_pel,p.año,d.nombre_director,c.nom_categoria, c.clasificacion\n" +
        "from pelicula p\n" +
        "inner join categoria c on c.idcategoria=p.idcategoria\n" +
        "inner join director d on d.iddirector = p.iddirector\n" +
        "where idpelicula=?")){
           pst.setInt(1,id);
           try(ResultSet rs = pst.executeQuery()){
               if(rs.next()){
                   pelicula = createPelicula(rs);
               }
           }
       }
       return pelicula;
    }

    @Override
    public void save(Pelicula pelicula) throws SQLException{
        String sql = "call registro_pelicula(?,?,?,?,?)";
        try(Connection conn = getConnection();
            CallableStatement cllst = getConnection().prepareCall(sql)){
                cllst.setString(1,pelicula.getNombre_pelicula());
                cllst.setInt(2,pelicula.getAño_pelicula());
                cllst.setInt(3,pelicula.getEstrella_pelicula());
                cllst.setString(4,pelicula.getNom__categoria());
                cllst.setString(5,pelicula.getNombre_director());
                cllst.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try(PreparedStatement pst = getConnection().prepareStatement("delete from pelicula where idpelicula = ?")){
            pst.setInt(1,id);
            pst.executeUpdate();
        }
        catch(Exception e){}
    }
    
}
