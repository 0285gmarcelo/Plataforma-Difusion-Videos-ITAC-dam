/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros;

import java.io.File;

/**
 * Clase encargada de crear la carpeta "Ficheros"
 * en caso de que no exista.
 * 
 * Esta carpeta se utilizará para almacenar
 * los archivos exportados del proyecto
 * (.txt, .csv, .bin y .json).
 * 
 * @author Andre
 */
public class CrearCarpetaFicheros {

    public static void crearCarpetaSiNoExiste() {
        // Se crea un objeto File asociado a la carpeta "Ficheros"
        File carpeta = new File("Ficheros");
        
        // Se comprueba si la carpeta no existe
        if (!carpeta.exists()) {
            //Se crea la carpeta
            carpeta.mkdirs();
        }
    }
}
