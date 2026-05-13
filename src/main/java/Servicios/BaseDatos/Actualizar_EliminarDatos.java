/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Modelos.Película;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class Actualizar_EliminarDatos {
    public static void actualizar(String tabla,int codigo,String FilaModificar, String nuevoContenido,Connection con){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
            
            try {
                PreparedStatement ps = con.prepareStatement("UPDATE "+tabla+" set "+FilaModificar+" = ? WHERE codigo = ?");
                ps.setString(1, nuevoContenido);
                ps.setInt(2, codigo);
                ps.executeUpdate();
                ps.close();
                con.close();
                System.out.println("Datos actualizados correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        
    }
    public static void actualizarPeliculas_personaje(int codgioPelicula, int codigoActor, String filaModificar, String nuevoCString, Connection con){
         ServicioBase_de_Datos.inciarBase_De_Datos();
         
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE personaje_pelicula SET "+filaModificar+" = ? " +
                    " WHERE codigo_pelicula = ? AMD codigo_actor = ?");
            
            ps.setString(1, nuevoCString);
            ps.setInt(2, codgioPelicula); 
            ps.setInt(3, codigoActor);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("Datos actualizados correctamente");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void actualizarSeries_personaje(int codgioSerie, int codigoActor, String filaModificar, String nuevoCString, Connection con){
         ServicioBase_de_Datos.inciarBase_De_Datos();
         
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE personaje_pelicula SET "+filaModificar+" = ? " +
                    " WHERE codigo_pelicula = ? AMD codigo_actor = ?");
            
            ps.setString(1, nuevoCString);
            ps.setInt(2, codgioSerie); 
            ps.setInt(3, codigoActor);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("Datos actualizados correctamente");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void eliminar(String tabla,int codigo, Connection con){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM "+tabla+" WHERE codigo = ?");
            
            
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
            System.out.println("Datos eliminados correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void eliminarPersonaje_Pelicula(String tabla, int codigoActor, int codigoPelicula, Connection con){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM personaje_pelicula WHERE codigo_pelicula = ? AND codigo_actor = ?");
            
            ps.setInt(1, codigoPelicula);
            ps.setInt(2, codigoActor);
            
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public static void eliminarPersonaje_Serie( int codigoActor, int codigoSerie, Connection con){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM personaje_serie WHERE codigo_pelicula = ? AND codigo_actor = ?");
            
            ps.setInt(1, codigoSerie);
            ps.setInt(2, codigoActor);
            
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
