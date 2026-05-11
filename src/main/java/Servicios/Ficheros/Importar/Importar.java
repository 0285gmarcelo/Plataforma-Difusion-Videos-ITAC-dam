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
    
    public static List<String> importarTXT(){
        List<String> datos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constantes.FICHERO_TXT));
            String linea;
            
            while ((linea = br.readLine()) != null){
                datos.add(linea);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return datos;
    }
    
    public static List<String> importarCSV(){
        List<String> datos = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constantes.FICHERO_CSV));
            String linea;
            while ((linea = br.readLine())!= null){
                datos.add(linea.replace(';', ':'));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public static List<String> importarBinario(){
        List<String> datos = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constantes.FICHERO_BIN));
            datos = (List<String>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    
}
