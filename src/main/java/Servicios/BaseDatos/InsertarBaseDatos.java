/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class InsertarBaseDatos {
    
    private static Connection con;
    
  public static void insertarActorBD (Object objecto, Scanner teclado){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            PreparedStatement pst = con.prepareStatement("Insert "+objecto+" values (?,?,?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
  public static void insertarPeliculaBD (Object objecto, Scanner teclado){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            PreparedStatement pst = con.prepareStatement("Insert "+objecto+" values (?,?,?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
  public static void insertarSerieBD (Object objecto, Scanner teclado){
      ServicioBase_de_Datos.inciarBase_De_Datos();
      
        try {
            PreparedStatement pst = con.prepareStatement("Insert "+objecto+" values (?,?,?,?,?,?)");
        } catch (SQLException ex) {
            System.out.println("Ah ocurrido un error de conexion");
            Logger.getLogger(InsertarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
      ServicioBase_de_Datos.cerrarBaseDatos();
  }
    
}
