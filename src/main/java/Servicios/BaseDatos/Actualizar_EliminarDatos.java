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
    public static void eliminar(String tabla,int codigo,String FilaEliminar, String eliminarContenido, Connection con){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM "+tabla+" WHERE "+FilaEliminar+" = ?");
            
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
