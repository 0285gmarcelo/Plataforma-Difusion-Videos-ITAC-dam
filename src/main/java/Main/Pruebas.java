/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelos.Actor;
import Servicios.Ficheros.Exportar.*;
import Servicios.Ficheros.Importar.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
       /** Actor actor1 = new Actor(12, "Carlos", LocalDate.now(), "Madird", "España");
        List<String> datos = new ArrayList<>();
        datos.add(actor1.datosActor());
        List<String> datos1 = new ArrayList<>();
        datos1.add(actor1.diseñoJSON());
        //Exportar
        Exportar.exportarBINARIO(datos, actor1);
        Exportar.exportarJSON(datos1, actor1);
        Exportar.exporatTXT(datos, actor1);
        Exportar.exportarCSV(datos, actor1);
        //Importar
        Importar.importarTXT(actor1);
        Importar.importarJSON(actor1);
        Importar.importarBinario(actor1);
        Importar.importarCSV(actor1);
        **/
      Connection con = Servicios.BaseDatos.ServicioBase_de_Datos.inciarBase_De_Datos();
      Servicios.BaseDatos.ConsultasBD.informeSeriesCS6(con);
              
        
    }
    
}
