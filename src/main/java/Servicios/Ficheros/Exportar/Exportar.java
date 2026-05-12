/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Exportar;


import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class Exportar {
    
    public static void exporatTXT(List<String> datos, Object objeto) {
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+objeto.getClass().getSimpleName()+".txt", true));
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
                
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void exportarCSV(List<String> datos, Object objeto){
        
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+objeto.getClass().getSimpleName()+".csv", true));
            for (String linea : datos) {
                bw.write(linea.replace(";", ":"));
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void exportarBINARIO(List<String> datos, Object objeto) throws IOException{
        try { 
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("Ficheros\\"+objeto.getClass().getSimpleName()+".bin", true));
            oos.writeObject(datos);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void exportarJSON(List<String> datos){
        
    }
    
}
