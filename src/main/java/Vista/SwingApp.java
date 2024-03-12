/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Pelicula;
import Repositorio.PeliculaRepositorio;
import Repositorio.Repositorio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOAHAN CARLO
 */
public class SwingApp extends JFrame{
     
     private final Repositorio<Pelicula> pelicula_repositorio;
     private final JTable employeeTable;
     public SwingApp(){
        setTitle("Gestión de peliculas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,230);
        
         //       Crear una tabla para mostrar los empleados
        employeeTable=new JTable();
        JScrollPane scrollPane=new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);
        
          //Crear los Botones
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");
        
       //Configurar el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        add(buttonPanel,BorderLayout.SOUTH);
        
          //Establecer estilos de botones
        agregarButton.setBackground(new Color(46,204,113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        actualizarButton.setBackground(new Color(52,152,219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);

        eliminarButton.setBackground(new Color(231,76,60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);
        
           //Crear el objeto repositorio de la base de datos
        pelicula_repositorio =new PeliculaRepositorio();
        
        //Vista peliculas
        refreshPelicula();
        
        //Agregar ActionListener
        agregarButton.addActionListener(e -> {
            agregarPelicula();
        });

        actualizarButton.addActionListener(e -> actualizarPelicula());

        eliminarButton.addActionListener(e -> eliminarPelicula());
                
     }
         private void refreshPelicula(){
            try{
                 try{
            List<Pelicula> peliculas= pelicula_repositorio.findAll();

            //Crear un modelo de tabla y establecer los datos de los empleados
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre Pelicula");
            model.addColumn("Año");
            model.addColumn("Nombre Director");
            model.addColumn("Categoria");
            model.addColumn("Clasificación");

            for(Pelicula pelicula:peliculas){
                Object[] rowData={
                    pelicula.getIdpelicula(),
                    pelicula.getNombre_pelicula(),
                    pelicula.getAño_pelicula(),
                    pelicula.getNombre_director(),
                    pelicula.getNom__categoria(),
                    pelicula.getClasificacion_cat()
                    };
                model.addRow(rowData);
            }
            //establecer el modelo de tabla actualizado
            employeeTable.setModel(model);
            }catch(SQLException e){
          JOptionPane.showMessageDialog(this,"Error al obtener los datos de la bd");
       }
            }
            catch(HeadlessException e){
            JOptionPane.showMessageDialog(this, e);
            }
        }
        
         private void agregarPelicula(){}
         private void actualizarPelicula(){}
         private void eliminarPelicula(){}
}
