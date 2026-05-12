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
    
    
  public static void insertarActorBD (Object objecto,Connection con){
    ServicioBase_de_Datos.inciarBase_De_Datos();
        try {
            
            if (objecto.getClass()== Actor.class){
                
                Actor actor = (Actor) objecto;
                PreparedStatement pst = con.prepareStatement("Insert actor values (?,?,?,?,?)");
               
                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                pst.setDate(3, java.sql.Date.valueOf(actor.getFecha_Nacimiento()));
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());
                
                pst.executeUpdate();
                pst.close();
                con.close();
            }
           
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
     
  }
  public static void insertarPeliculaBD (Object objecto, Connection con){
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
                pst.close();
                con.close();
            }
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }
  public static void insertarSerieBD (Object objecto, Connection con){
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
                pst.setInt(6, serie.getEpisodios());
                
                pst.executeUpdate();
                pst.close();
                con.close();
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
   public static void insertarPersonajes_SerieBD (Object objecto, Connection con){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if(objecto.getClass()== Personaje_Serie.class){
                
                
                Personaje_Serie ps = (Personaje_Serie) objecto;
                
                
                PreparedStatement pst = con.prepareStatement("Insert Serie values (?,?,?,?,?,?)");
                
                pst.setInt(1, ps.getCodigo_Serie());
                pst.setInt(2, ps.getCodigo_Actor());
                pst.setString(3, ps.getNombre());
                pst.setString(4, ps.getTipo());
                pst.setInt(5, ps.getEpisodios() );
                pst.setString(6, ps.getDuracion());
                
                pst.executeUpdate();
                pst.close();
                con.close();
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   }
   public static void insertarPersonajes_PeliculaBD (Object objecto, Connection con){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            
            if(objecto.getClass()== Personaje_Película.class){
                
                Personaje_Película pp = (Personaje_Película) objecto;
                
                
                PreparedStatement pst = con.prepareStatement("Insert Serie values (?,?,?,?)");
                
                pst.setInt(1, pp.getCodigo_Pelicula());
                pst.setInt(2, pp.getCodigo_Actor());
                pst.setString(3, pp.getNombre());
                pst.setString(4, pp.getTipo());
                
                pst.executeUpdate();
                pst.close();
                con.close();
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
