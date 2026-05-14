/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Importar;

import Utils.Constantes;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author isard
 */
public class Importar {
    
    public static List<String> importarTXT(Object objeto){
        List<String> datos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".txt"));
            String linea;
            
            while ((linea = br.readLine()) != null){
                datos.add(linea);
            }
            System.out.println(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return datos;
    }
    
    public static List<String> importarCSV(Object objeto){
        System.out.println(objeto.getClass().getSimpleName()+".csv");
        List<String> datos = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".csv"));
            String linea;
            while ((linea = br.readLine())!= null){
                datos.add(linea.replace(';', ':'));
            }
             System.out.println(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public static List<String> importarBinario(Object objeto){
        List<String> datos = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros\\"+objeto.getClass().getSimpleName()+".bin"));
            datos = (List<String>) ois.readObject();
            ois.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(datos);
        return datos;
    }
    
     public static List<String> importarJSON(Object objeto){
        List<String> datos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".json"));
            String linea;
            
            while ((linea = br.readLine()) != null){
                datos.add(linea);
            }
             System.out.println(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return datos;
    }
    
   
    
}
