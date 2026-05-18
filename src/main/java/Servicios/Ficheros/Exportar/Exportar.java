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
    /**
     * Exportar una lista de datos a un fichero TXT.
     * 
     * @param datos lista con los datos a exportar
     * @param objeto el objeto usado para obtener el nombre del fichero
     */
    public static void exporatTXT(List<String> datos, Object objeto) {
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+objeto.getClass().getSimpleName()+".txt", true));
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
                
            }
            bw.close();
            System.out.println("TXT Exportado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Exporta una lista de datos a un fichero CSV.
     * 
     * @param datos lista con los datos
     * @param objeto  el objeto usado para el nombre del fichero
     */
    public static void exportarCSV(List<String> datos, Object objeto){
        
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+objeto.getClass().getSimpleName()+".csv", true));
            for (String linea : datos) {
                bw.write(linea.replace(";", ":"));
                bw.newLine();
            }
            bw.close();
            System.out.println("CSV exportado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * Exportar un lista de datos  a un fichero binario.
     * 
     * @param datos lista de datos
     * @param objeto el objeto usado para el nombre del fichero
     */
    public static void exportarBINARIO(List<String> datos, Object objeto){
        try { 
            //Crear el fichero binario
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("Ficheros\\"+objeto.getClass().getSimpleName()+".bin", true));
            //Guarda la lista completa
            oos.writeObject(datos);
            //Cierra el flujo
            oos.close();
            System.out.println("BIN exportado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /**
     * Exportar una lista de datos a un fichero JSON
     * 
     * @param datos lista de datos
     * @param objeto el objeto usado para el nombre
     */
    public static void exportarJSON(List<String> datos, Object objeto){
        try {
            
            //Crear el fichero JSON
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\"+objeto.getClass().getSimpleName()+".json", true));
            //Iniciao del array JSON
            bw.write("[");
            bw.newLine();
            //Recorre la lista
            for (int i = 0 ; i < datos.size(); i++) {
                bw.write(datos.get(i));
                bw.newLine();
                
                
            }
            //Fin del array JSON
            bw.write("[");
            bw.newLine();
            bw.close();
            System.out.println("JSON exportado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
