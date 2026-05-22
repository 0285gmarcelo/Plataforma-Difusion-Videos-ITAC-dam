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
 * Clase encargada de exportar datos a diferentes formatos de fichero:
 * TXT, CSV, BINARIO y JSON.
 * 
 * También permite extraer datos desde una JTable
 * para convertirlos en una lista de Strings.
 * 
 * @author Andre
 */
public class Exportar {
    
    // ================= EXPORTAR A TXT =================

    /**
     * Exporta una lista de datos a un fichero .txt
     * 
     * Funcionamiento:
     * - Crea la carpeta "Ficheros" si no existe.
     * - Crea o sobrescribe el archivo TXT.
     * - Escribe cada línea de la lista en el fichero.
     *
     * @param datos:La lista de registros a exportar
     * @param nombreTabla:El nombre del fichero (tabla)
     */
    public static void exporatTXT(List<String> datos, String nombreTabla) {
        try {
            // Asegura que la carpeta existe
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();
            
            // Crea el fichero TXT (false = sobrescribe el archivo)
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".txt", false)
            );
            
            // Escribe cada línea en el fichero
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
            }
            
            // Se cierra el fichero
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // ================= EXPORTAR A CSV =================

    /**
     * Exporta los datos a un fichero CSV.
     * 
     * Funcionamiento:
     * - Sustituye ";" por ":" como separador.
     * - Guarda los datos en formato CSV.
     *
     * @param datos:La lista de registros
     * @param nombreTabla:El nombre del fichero
     */
    public static void exportarCSV(List<String> datos, String nombreTabla) {
        try {
            // Asegura que la carpeta existe
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();
            
            // Crea el fichero CSV (false = sobrescribe el archivo)
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".csv", false)
            );
            
            // Recorre los datos y cambia separador
            for (String linea : datos) {
                bw.write(linea.replace(";", ":"));
                bw.newLine();
            }
            // Se cierra el fichero
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // ================= EXPORTAR BINARIO =================

    /**
     * Exporta la lista de datos en formato binario (.bin)
     * usando ObjectOutputStream.
     *
     * @param datos:La lista de registros
     * @param nombreTabla:El nombre del fichero
     */
    public static void exportarBINARIO(List<String> datos, String nombreTabla) {
        try {
            // Asegura que la carpeta existe
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();
            
            // Crea el fichero BIN (false = sobrescribe el archivo)
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("Ficheros\\" + nombreTabla + ".bin", false)
            );
            
            // Escribe el objeto completo (lista)
            oos.writeObject(datos);
            // Se cierra el fichero 
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     // ================= EXPORTAR JSON =================

    /**
     * Exporta los datos a un fichero JSON.
     * 
     * Funcionamiento:
     * - Escribe los datos entre corchetes [].
     * - Cada línea representa un registro.
     *
     * @param datos:La lista de registros
     * @param nombreTabla:El nombre del fichero
     */
    public static void exportarJSON(List<String> datos, String nombreTabla) {
        try {
            // Asegura que la carpeta existe
            CrearCarpetaFicheros.crearCarpetaSiNoExiste();
            
            // Crea el fichero JSON (false = sobrescribe el archivo)
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Ficheros\\" + nombreTabla + ".json", false)
            );
            // Inicio JSON
            bw.write("[");
            bw.newLine();
            
            // Se escribe cada elemento
            for (int i = 0; i < datos.size(); i++) {
                bw.write(datos.get(i));
                bw.newLine();
            }
            
            // Fin JSON
            bw.write("]");
            // Salto de linea
            bw.newLine();
            
            // Se cierra el fichero 
            bw.close();


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
