/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Exportar;

import Utils.Constantes;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class Exportar {
    
    public static void exporatTXT(List<String> datos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.FICHERO_TXT));
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
                
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void exportarCSV(List<String> datos){
        
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.FICHERO_CSV));
            for (String linea : datos) {
                bw.write(linea.replace(";", ":"));
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void exportarBINARIO(List<String> datos) throws IOException{
        try { 
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(Constantes.FICHERO_BIN));
            oos.writeObject(datos);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void exportarJSON(List<String> datos){
        
    }
    
}
