/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros;

import java.io.File;

/**
 *
 * @author isard
 */
public class CrearCarpetaFicheros {

    public static void crearCarpetaSiNoExiste() {
        File carpeta = new File("Ficheros");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}
