/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Exportar;

import Servicios.Ficheros.CrearCarpetaFicheros;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.util.ArrayList;

/**
 *
 * @author isard
 */
public class Exportar {

    public static void exporatTXT(List<String> datos, String nombreTabla) {
        try {
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".txt", false)
            );

            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportarCSV(List<String> datos, String nombreTabla) {
        try {
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".csv", false)
            );

            for (String linea : datos) {
                bw.write(linea.replace(";", ":"));
                bw.newLine();
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportarBINARIO(List<String> datos, String nombreTabla) {
        try {
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("Ficheros\\" + nombreTabla + ".bin", false)
            );

            oos.writeObject(datos);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportarJSON(List<String> datos, String nombreTabla) {
        try {
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".json", false)
            );

            bw.write("[");
            bw.newLine();

            for (int i = 0; i < datos.size(); i++) {
                bw.write(datos.get(i));
                bw.newLine();
            }

            bw.write("]");
            bw.newLine();

            bw.close();

            System.out.println("JSON exportado correctamente");

        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> obtenerDatosTabla(JTable tabla) {

        List<String> datos = new ArrayList<>();

        for (int i = 0; i < tabla.getRowCount(); i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < tabla.getColumnCount(); j++) {

                Object valor = tabla.getValueAt(i, j);
                sb.append(valor != null ? valor.toString() : "");

                if (j < tabla.getColumnCount() - 1) {
                    sb.append(";");
                }
            }

            datos.add(sb.toString());
        }

        return datos;
    }
}
