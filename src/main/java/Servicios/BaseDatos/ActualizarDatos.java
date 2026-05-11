/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Modelos.Película;
import java.sql.*;

/**
 *
 * @author isard
 */
public class ActualizarDatos {
    private static Connection con;
    public static void actualizarPelicula(int codigo, Object objeto, String tabla){
        ServicioBase_de_Datos.inciarBase_De_Datos();
        if(objeto.getClass() == Película.class){
            
            Película pelicula = (Película) objeto;
            
            PreparedStatement pst = con.prepareStatement("UPDATE pelicula set "+tabla+" = ? ")
                    
        }
    }
}
