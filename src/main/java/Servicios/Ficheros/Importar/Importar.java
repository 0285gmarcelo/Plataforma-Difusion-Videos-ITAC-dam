/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Importar;


import Excepciones.YaImportadoException;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author isard
 */
public class Importar {
    /**
     * Importar los datos de un fichero TXT.
     * 
     * El nombre del fichero se obtiene automaticamente
     * usando el nombre de la clase del objeto recibido.
     * 
     * @param objeto el objeto del que se quiere importar el fichero
     * @return lista con las lineas leidas del fichero
     * @throws YaImportadoException  excepcion personalizada por si ya fue importada
     */
    public static List<String> importarTXT(Object objeto) throws YaImportadoException{
        List<String> datos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".txt"));
            String linea;
            
            while ((linea = br.readLine()) != null){
                datos.add(linea);
            }
            br.close();
            System.out.println(datos);
            System.out.println("Se ha importado con exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return datos;
    }
    /**
     * Importa los datos de un fichero CSV.
     * 
     * @param objeto el objeto de que se quiere importar el fichero
     * @return lista con las lineas leidas del fichero
     * @throws YaImportadoException excepcion personalizada por si ya fue importada
     */
    public static List<String> importarCSV(Object objeto) throws YaImportadoException{
        System.out.println(objeto.getClass().getSimpleName()+".csv");
        List<String> datos = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".csv"));
            String linea;
            while ((linea = br.readLine())!= null){
                datos.add(linea.replace(';', ':'));
            }
            br.close();
             System.out.println(datos);
             System.out.println("Se ha importado con exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    /**
     * Importa los datos desde un fichero binario.
     * 
     * @param objeto: objeto del que se quiere importar el fichero
     * @return lista con los datos recuperados
     * @throws YaImportadoException excepcion personalizada por si ya fue importada
     */
    public static List<String> importarBinario(Object objeto) throws YaImportadoException{
        // Lista donde se almacenarán los datos
        List<String> datos = new ArrayList<>();
        try {
            //Abre el fichero binario
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros\\"+objeto.getClass().getSimpleName()+".bin"));
            //Lee el objeto del fichero y lo convierte a List<String>
            datos = (List<String>) ois.readObject();
            //Cierre
            ois.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(datos);
        System.out.println("Se ha importado con exito");
        //Devolver los datos importados
        return datos;
    }
    /**
     * Importar los datos desde un fichero JSON.
     * 
     * @param objeto el objeto del que se quiere importar el fichero
     * @return lista con las lineas del JSON
     * @throws YaImportadoException excepcion personalizada por si ya fue importada
     */
     public static List<String> importarJSON(Object objeto) throws YaImportadoException{
        List<String> datos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Ficheros\\"+objeto.getClass().getSimpleName()+".json"));
            String linea;
            
            while ((linea = br.readLine()) != null){
                datos.add(linea);
            }
           
             System.out.println(datos);
              br.close();
             System.out.println("Se ha importado con exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return datos;
    }
    
   
    
}
