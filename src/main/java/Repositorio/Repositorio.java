/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JOAHAN CARLO
 * @param <T>
 */
public interface Repositorio <T>{
    List<T> findAll() throws SQLException;
    
    T getById(Integer id) throws SQLException;
    
    void save(T t) throws SQLException;
    
    void delete(Integer id) throws SQLException;
}
