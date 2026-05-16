/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class GenerarInformes {
    
    public static void generarInforme(Connection con, String sql, String nombreArchivo){
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+nombreArchivo+".txt"));
            
            ResultSetMetaData meta = rs.getMetaData();
            
            int columnas = meta.getColumnCount();
            
            while(rs.next()){
                for(int i = 1; i <= columnas; i++){
                    
                    bw.write(rs.getString(i));
                    
                    if(i < columnas) {
                        
                        bw.write(" - ");
                        
                    }
                    
                }
                bw.newLine();
            }
            
            bw.close();
            pst.close();
            
            System.out.println("Informe generado correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(GenerarInformes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarInformes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
