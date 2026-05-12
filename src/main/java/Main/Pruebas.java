/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelos.Actor;
import Servicios.Ficheros.Exportar.Exportar;
import Servicios.Ficheros.Importar.Importar;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Actor actor1 = new Actor(12, "Carlos", LocalDate.now(), "Madird", "España");
        List<String> datos = new ArrayList<>();
        datos.add(actor1.datosActor());
        File fichero = new File("Ficheros\\"+actor1.getNombre()+".csv");
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Exportar.exportarCSV(datos, actor1);
        Importar.importarCSV(actor1);
    }
    
}
