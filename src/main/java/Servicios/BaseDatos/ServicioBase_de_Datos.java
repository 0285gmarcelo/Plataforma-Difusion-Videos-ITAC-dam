/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Utils.Constantes;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author isard
 */
public class ServicioBase_de_Datos {


    public static Connection inciarBase_De_Datos() {
        Connection con = null;
        try {
           con = DriverManager.getConnection(Constantes.URL_BASE_DATOS, Constantes.USER, Constantes.PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error en la conexion");
            Logger.getLogger(ServicioBase_de_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
   
}
