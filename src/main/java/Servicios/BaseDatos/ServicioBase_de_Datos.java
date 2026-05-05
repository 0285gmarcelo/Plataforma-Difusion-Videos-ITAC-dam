/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class ServicioBase_de_Datos {
    
public static void inciarBase_De_Datos(){
    String url = "jdbc:mysql://localhost:3306/Plataforma_difusion_video";
    String user = "root";
    String password = "root";
    try{
    Connection con = DriverManager.getConnection(url, user, password);
    PreparedStatement pst = con.prepareStatement("");
    }catch(SQLException ex){
    System.out.println("Ah ocurrido un error en la conexion");
    Logger.getLogger(ServicioBase_de_Datos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
