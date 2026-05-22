/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Importar;

import Servicios.BaseDatos.ServicioBase_de_Datos;
import Servicios.BaseDatos.InsertarBaseDatos;
import Servicios.Validaciones.Validaciones;
import Modelos.*;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
/**
 * Clase encargada de importar datos desde ficheros
 * y añadirlos a la base de datos.
 * 
 * Esta clase permite importar información desde:
 * - Ficheros TXT
 * - Ficheros CSV
 * - Ficheros BINARIOS
 * - Ficheros JSON
 * 
 * Cada línea del fichero se convierte en un objeo
 * y posteriormente se inserta en la base de datos.
 * 
 * @author Carlos
 */
public class Importar {

    // ================= IMPORTACIÓN GENERAL =================
    
     /**
     * Método general para importar datos desde un fichero
     * de texto , CSV o JSON.
     * 
     * Funcionamiento:
     * 1. Abre conexión con la base de datos.
     * 2. Abre el fichero indicado.
     * 3. Lee línea por línea.
     * 4. Procesa cada línea según la tabla.
     * 5. Inserta los datos en la base de datos.
     * 
     * @param tabla:El nombre de la tabla
     * @param extension:La extensión del fichero (.txt o .csv)
     * @param separador:El carácter separador de campos
     * @throws Exception error general durante la importación
     */
    public static void importar(String tabla, String extension, String separador) throws Exception {
        
        // Inicia conexión con la base de datos
        Connection con = ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Abre el fichero a importar
        BufferedReader br = new BufferedReader(
                new FileReader("Ficheros\\" + tabla + extension)
        );

        String linea;
        
        // Guarda el número de línea actual
        int numLinea = 0;
        
        // Lee el fichero línea por línea
        while ((linea = br.readLine()) != null) {
            numLinea++;

            try {
                // Procesa la línea actual
                procesarLinea(tabla, linea, separador, numLinea, con);

            } catch (Exception e) {
                
                // Muestra mensaje de error indicando la línea
                JOptionPane.showMessageDialog(
                        null,
                        "Error en línea " + numLinea + ": " + e.getMessage(),
                        "Error de importación",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        // Se cierra el fichero
        br.close();
        // Se cierra el fichero
        con.close();
    }

    // ================= PROCESAR UNA LÍNEA =================
    
    /**
     * Método encargado de convertir una línea del fichero
     * en un objeto Java y validarlo antes de insertarlo.
     * 
     * Dependiendo de la tabla recibida:
     * - Crea el objeto correspondiente
     * - Valida los datos
     * - Inserta el objeto en la base de datos
     *
     * @param tabla:El nombre de la tabla
     * @param linea:La línea del fichero
     * @param separador:El separador de campos
     * @param numLinea:El número de línea
     * @param con:La conexión a la base de datos
     * @throws Exception error durante el procesamiento
     */
    private static void procesarLinea(String tabla, String linea, String separador, int numLinea, Connection con) throws Exception {
        
        // Divide la línea usando el separador indicado
        String[] d = linea.split(separador);
        
        // Comprueba qué tabla se está importando
        switch (tabla) {

            case "pelicula" -> {
                
                 // Se crea objeto Pelicula
                Pelicula p = new Pelicula(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3]),
                        Integer.parseInt(d[4])
                );
                // Se valida los datos
                Validaciones.validarPelicula(p);
                // Se inserta en la base de datos
                InsertarBaseDatos.insertarPeliculaBDImport(p, con);
            }

            case "serie" -> {
                
                //Se crea objeto Serie
                Serie s = new Serie(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5])
                );
                
                 // Se valida los datos
                Validaciones.validarSerie(s);
                 // Se inserta en la base de datos
                InsertarBaseDatos.insertarSerieBDImport(s, con);
            }

            case "actor" -> {
                
                // Se crea objeto Actor
                Actor a = new Actor(
                        Integer.parseInt(d[0]),
                        d[1],
                        LocalDate.parse(d[2]),
                        d[3],
                        d[4]
                );
                
                // Se valida los datos
                Validaciones.validarActor(a);
                
                // Se inserta en la base de datos
                InsertarBaseDatos.insertarActorBDImport(a, con);
            }

            case "personaje_pelicula" -> {
                
                // Crea objeto Personaje_Pelicula
                Personaje_Pelicula pp = new Personaje_Pelicula(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2],
                        d[3]
                );
                
                // Valida los datos
                Validaciones.validarPersonajePelicula(pp);
                
                // Inserta en la base de datos
                InsertarBaseDatos.insertarPersonajePeliculaBDImport(pp, con);
            }

            case "personaje_serie" -> {
                
                // Crea objeto Personaje_Pelicula
                Personaje_Serie ps = new Personaje_Serie(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        d[5]
                );
                
                // Valida los datos
                Validaciones.validarPersonajeSerie(ps);
                // Inserta en la base de datos
                InsertarBaseDatos.insertarPersonajeSerieBDImport(ps, con);
            }
        }
    }

    // ================= BINARIO =================
    
     /**
     * Método encargado de importar datos desde
     * un fichero binario (.bin).
     * 
     * Funcionamiento:
     * 1. Lee el objeto almacenado en el fichero binario.
     * 2. Recupera la lista de líneas.
     * 3. Procesa cada línea.
     * 4. Inserta los datos en la base de datos.
     *
     * @param tabla nombre de la tabla
     * @throws Exception error durante la importación
     */
    public static void importarBIN(String tabla) throws Exception {
        
        // Inicia conexión con la base de datos
        Connection con = ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Abre el fichero binario
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Ficheros\\" + tabla + ".bin")
        );
        
        // Recupera la lista de datos guardada
        List<String> datos = (List<String>) ois.readObject();

        int numLinea = 0;
        
        // Recorre todas las líneas recuperadas
        for (String linea : datos) {
            numLinea++;

            try {
                // Procesa cada línea
                procesarLinea(tabla, linea, ";", numLinea, con);

            } catch (Exception e) {
                
                // Muestra error indicando la línea
                JOptionPane.showMessageDialog(
                        null,
                        "Error en línea " + numLinea + ": " + e.getMessage(),
                        "Error BIN",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        // Se cierra el flujo binario
        ois.close();
        // Se cierra conexión con la base de datos
        con.close();
    }
}
