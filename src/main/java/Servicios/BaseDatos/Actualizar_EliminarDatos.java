/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Servicios.Validaciones.Validaciones;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author isard
 */
public class Actualizar_EliminarDatos {

    public static void actualizar(String tabla, int codigo, String columna, String nuevoContenido, Connection con) {

        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + tabla + " SET " + columna + " = ? WHERE codigo = ?"
            );

            ps.setString(1, nuevoContenido);
            ps.setInt(2, codigo);

            int filas = ps.executeUpdate();

            System.out.println("Actualización OK");
            System.out.println("Tabla: " + tabla + " | Filas: " + filas);

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en actualizar()");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void actualizarPeliculas_personaje(
            int codigoPelicula,
            int codigoActor,
            String columna,
            String nuevoValor,
            Connection con) {

        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE personaje_pelicula SET " + columna
                    + " = ? WHERE codigo_pelicula = ? AND codigo_actor_P = ?"
            );

            ps.setString(1, nuevoValor);
            ps.setInt(2, codigoPelicula);
            ps.setInt(3, codigoActor);

            ps.executeUpdate();

            System.out.println("✔ Personaje película actualizado");

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en actualizar()");
            ex.printStackTrace();
            throw new RuntimeException(ex); // 👈 IMPORTANTE
        }
    }

    public static void actualizarSeries_personaje(
            int codigoSerie,
            int codigoActor,
            String columna,
            String nuevoValor,
            Connection con) {

        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE personaje_serie SET " + columna
                    + " = ? WHERE codigo_serie = ? AND codigo_actor_S = ?"
            );

            ps.setString(1, nuevoValor);
            ps.setInt(2, codigoSerie);
            ps.setInt(3, codigoActor);

            ps.executeUpdate();

            System.out.println("✔ Personaje serie actualizado");

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en actualizar()");
            ex.printStackTrace();
            throw new RuntimeException(ex); // 👈 IMPORTANTE
        }
    }

    public static void eliminar(String tabla, int codigo, Connection con) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + tabla + " WHERE codigo = ?"
            );

            ps.setInt(1, codigo);

            int filas = ps.executeUpdate();

            System.out.println("Eliminación OK");
            System.out.println("Tabla: " + tabla + " | Filas eliminadas: " + filas);

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminar()");
            ex.printStackTrace();
            throw ex; // 🔴 ESTO es lo único importante
        }
    }

    public static void eliminarPersonaje_Pelicula(
            int codigoActor,
            int codigoPelicula,
            Connection con) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM personaje_pelicula WHERE codigo_pelicula = ? AND codigo_actor_P = ?"
            );

            ps.setInt(1, codigoPelicula);
            ps.setInt(2, codigoActor);

            ps.executeUpdate();

            System.out.println("Eliminación OK en personaje_pelicula");

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminarPersonaje_Pelicula()");
            ex.printStackTrace();
            throw ex;
        }
    }

    public static void eliminarPersonaje_Serie(
            int codigoActor,
            int codigoSerie,
            Connection con) throws SQLException {

        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM personaje_serie WHERE codigo_serie = ? AND codigo_actor_S = ?"
            );

            ps.setInt(1, codigoSerie);
            ps.setInt(2, codigoActor);

            ps.executeUpdate();

            System.out.println("Eliminación OK en personaje_serie");

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminarPersonaje_Serie()");
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public static void actualizarCampoValidado(
        String tabla,
        int id,
        String columna,
        String valor,
        Connection con
) throws Exception {

    if (valor == null || valor.isBlank()) {
        return; // NO actualiza campos vacíos
    }

    switch (tabla) {

        case "pelicula" -> {
            switch (columna) {
                case "titulo" -> Validaciones.validarTitulo(valor);
                case "director" -> Validaciones.validarDirector(valor);
                case "año_estreno" -> Validaciones.validarAnyo(Integer.parseInt(valor));
                case "duracion" -> Validaciones.validarDuracion(Integer.parseInt(valor));
            }
        }

        case "serie" -> {
            switch (columna) {
                case "titulo" -> Validaciones.validarTitulo(valor);
                case "creador" -> Validaciones.validarCreador(valor);
            }
        }

        case "actor" -> {
            switch (columna) {
                case "nombre" -> Validaciones.validarNombreActor(valor);
                case "fecha_nacimiento" -> Validaciones.validarFechaNacimiento(LocalDate.parse(valor));
                case "lugar_residencia" -> Validaciones.validarResidencia(valor);
                case "nacionalidad" -> Validaciones.validarNacionalidad(valor);
            }
        }

        case "personaje_pelicula", "personaje_serie" -> {
            if (columna.equals("tipo")) {
                Validaciones.validarTipoPersonaje(valor);
            }
        }
    }

    // si pasa validación → actualiza
    Actualizar_EliminarDatos.actualizar(tabla, id, columna, valor, con);
}
}
