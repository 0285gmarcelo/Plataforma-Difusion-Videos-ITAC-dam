/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros;

import Servicios.BaseDatos.ServicioBase_de_Datos;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author isard
 */
public class generarInformes {
    
    public static void generarInforme(Connection con, String sql){
        
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
        
            BufferedWriter bw = new BufferedWriter( new FileWriter("Informe.txt"));
            
            ResultSetMetaData meta = rs.getMetaData();
            
            int columnas = meta.getColumnCount();
            
            while(rs.next()){
                
                for (int i = 1 ; i <= columnas ; i++){
                    
                    bw.write(rs.getString(i));
                    
                    if (i < columnas){
                        bw.write(" - ");
                    }
                    
                }
                bw.newLine();
            }
            bw.close();
            
            pst.close();
            
            System.err.println("Informe generado correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(generarInformes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(generarInformes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
