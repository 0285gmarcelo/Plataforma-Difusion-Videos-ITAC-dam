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

public class Importar {

    // ================= IMPORTACIÓN GENERAL =================
    public static void importar(String tabla, String extension, String separador) throws Exception {

        Connection con = ServicioBase_de_Datos.inciarBase_De_Datos();

        BufferedReader br = new BufferedReader(
                new FileReader("Ficheros\\" + tabla + extension)
        );

        String linea;
        int numLinea = 0;

        while ((linea = br.readLine()) != null) {
            numLinea++;

            try {
                procesarLinea(tabla, linea, separador, numLinea, con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error en línea " + numLinea + ": " + e.getMessage(),
                        "Error de importación",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        br.close();
        con.close();
    }

    // ================= PROCESAR UNA LÍNEA =================
    private static void procesarLinea(String tabla, String linea, String separador, int numLinea, Connection con) throws Exception {

        String[] d = linea.split(separador);

        switch (tabla) {

            case "pelicula" -> {

                Pelicula p = new Pelicula(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3]),
                        Integer.parseInt(d[4])
                );

                Validaciones.validarPelicula(p);
                InsertarBaseDatos.insertarPeliculaBDImport(p, con);
            }

            case "serie" -> {

                Serie s = new Serie(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5])
                );

                Validaciones.validarSerie(s);
                InsertarBaseDatos.insertarSerieBDImport(s, con);
            }

            case "actor" -> {

                Actor a = new Actor(
                        Integer.parseInt(d[0]),
                        d[1],
                        LocalDate.parse(d[2]),
                        d[3],
                        d[4]
                );

                Validaciones.validarActor(a);
                InsertarBaseDatos.insertarActorBDImport(a, con);
            }

            case "personaje_pelicula" -> {

                Personaje_Pelicula pp = new Personaje_Pelicula(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2],
                        d[3]
                );

                Validaciones.validarPersonajePelicula(pp);
                InsertarBaseDatos.insertarPersonajePeliculaBDImport(pp, con);
            }

            case "personaje_serie" -> {

                Personaje_Serie ps = new Personaje_Serie(
                        Integer.parseInt(d[0]),
                        Integer.parseInt(d[1]),
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        d[5]
                );

                Validaciones.validarPersonajeSerie(ps);
                InsertarBaseDatos.insertarPersonajeSerieBDImport(ps, con);
            }
        }
    }

    // ================= BINARIO =================
    public static void importarBIN(String tabla) throws Exception {

        Connection con = ServicioBase_de_Datos.inciarBase_De_Datos();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Ficheros\\" + tabla + ".bin")
        );

        List<String> datos = (List<String>) ois.readObject();

        int numLinea = 0;

        for (String linea : datos) {
            numLinea++;

            try {
                procesarLinea(tabla, linea, ";", numLinea, con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error en línea " + numLinea + ": " + e.getMessage(),
                        "Error BIN",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        ois.close();
        con.close();
    }
}
