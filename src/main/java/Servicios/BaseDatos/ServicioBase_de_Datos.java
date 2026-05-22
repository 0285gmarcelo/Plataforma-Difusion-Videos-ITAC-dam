/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Utils.Constantes;
import java.sql.*;
import java.util.logging.*;

/**
 *Clase encargada de gestionar la conexion a la base de datos
 * 
 * @author Carlos
 */
public class ServicioBase_de_Datos {

    /**
     * Metodo estatico que inicia y devuelve una conexion a la base de datos
     * 
     * @return 
     */
    public static Connection inciarBase_De_Datos() {
        
        // Objeto Connection que almacenará la conexión (inicialmente null)
        Connection con = null;
        try {
            
            // Se intenta establecer la conexión usando los datos definidos en Constantes
           con = DriverManager.getConnection(Constantes.URL_BASE_DATOS, Constantes.USER, Constantes.PASSWORD);
        } catch (SQLException ex) {
            
            // Si ocurre un error en la conexión, se muestra un mensaje por consola
            System.out.println("Ha ocurrido un error en la conexion");
            
            // Se registra el error con el logger para depuración
            Logger.getLogger(ServicioBase_de_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Devuelve la conexión (puede ser null si falló la conexión)
        return con;
    }
    
   
}
