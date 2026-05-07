/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Modelos.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author isard
 */
public class InsertarBaseDatos {
    
    private static Connection con;
    
  public static void insertarActorBD (Object objecto){
      ServicioBase_de_Datos.inciarBase_De_Datos();
        try {
            
            if (objecto.getClass()== Actor.class){
                
                Actor actor = (Actor) objecto;
                PreparedStatement pst = con.prepareStatement("Insert actor values (?,?,?,?,?)");
               
                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                pst.setDate(3, new java.sql.Date(actor.getFecha_Nacimiento().getTime()));
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());
                
                pst.executeUpdate();
                
            }
           
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
  public static void insertarPeliculaBD (Object objecto){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if (objecto.getClass()== Película.class){
                
                Película pelicula = (Película) objecto;
                
                PreparedStatement pst = con.prepareStatement("Insert Pelicula values (?,?,?,?,?)");
                
                pst.setInt(1, pelicula.getCodigo());
                pst.setString(2, pelicula.getTitulo());
                pst.setString(3, pelicula.getDirector());
                pst.setInt(4, pelicula.getAnyo_estreno());
                pst.setInt(5, pelicula.getDuracion());
                
                pst.executeUpdate();
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
  public static void insertarSerieBD (Object objecto){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if(objecto.getClass()== Serie.class){
                
                Serie serie = (Serie) objecto;
                
                
                PreparedStatement pst = con.prepareStatement("Insert Serie values (?,?,?,?,?,?)");
                
                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(0, serie.getEpisodios());
                
                pst.executeUpdate();
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
   public static void insertarPersonajes_SerieBD (Object objecto){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if(objecto.getClass()== Personaje_Serie.class){
                
                Serie serie = (Serie) objecto;
                
                
                PreparedStatement pst = con.prepareStatement("Insert Serie values (?,?,?,?,?,?)");
                
                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(0, serie.getEpisodios());
                
                pst.executeUpdate();
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
   }
   public static void insertarPersonajes_PeliculaBD (Object objecto){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if(objecto.getClass()== Serie.class){
                
                Serie serie = (Serie) objecto;
                
                
                PreparedStatement pst = con.prepareStatement("Insert Serie values (?,?,?,?,?,?)");
                
                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(0, serie.getEpisodios());
                
                pst.executeUpdate();
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
   }
    
}
