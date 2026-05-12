/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelos.Actor;
import Servicios.Ficheros.Importar.Importar;
import java.time.LocalDate;

/**
 *
 * @author isard
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Importar.importarCSV(new Actor(12, "Carlos", LocalDate.now(), "Madird", "España"));
    }
    
}
