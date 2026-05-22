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
 * Clase encargada de realizar operaciones de actualización y eliminación
 * sobre la base de datos.
 *
 * Incluye:
 * - UPDATE genérico
 * - UPDATE en tablas relacionales (películas/series/personajes)
 * - DELETE genérico
 * - DELETE en tablas relacionales
 * - UPDATE con validación previa de datos
 *
 * @author Carlos
 */
public class Actualizar_EliminarDatos {

    /**
     * Actualiza un campo concreto de cualquier tabla.
     *
     * FLUJO:
     * 1. Construye consulta UPDATE dinámica
     * 2. Asigna valores con PreparedStatement
     * 3. Ejecuta actualización
     * 4. Muestra resultado por consola
     * 5. Cierra recursos
     *
     * @param tabla tabla donde se hará la actualización
     * @param codigo identificador del registro (PK)
     * @param columna columna que se actualizará
     * @param nuevoContenido nuevo valor del campo
     * @param con conexión activa a la base de datos
     */
    public static void actualizar(String tabla, int codigo, String columna, String nuevoContenido, Connection con) {

        try {
            
            // Construcción dinámica del UPDATE (tabla y columna variables)
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + tabla + " SET " + columna + " = ? WHERE codigo = ?"
            );

            // Asigna el nuevo valor al campo
            ps.setString(1, nuevoContenido);
            
            // Asigna el identificador del registro
            ps.setInt(2, codigo);

            // Ejecuta la actualización y obtiene cuántas filas fueron afectadas
            int filas = ps.executeUpdate();

            // Mensajes de control
            System.out.println("Actualización OK");
            System.out.println("Tabla: " + tabla + " | Filas: " + filas);

            // Cierra statement
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en actualizar()");
            ex.printStackTrace();
            // Relanza excepción como Runtime para control global
            throw new RuntimeException(ex);
        }
    }
    /**
     * Actualiza un campo específico de la tabla personaje_pelicula.
     *
     * FLUJO:
     * 1. Construye UPDATE con clave compuesta (película + actor)
     * 2. Asigna parámetros
     * 3. Ejecuta actualización
     * 4. Muestra confirmación
     * 5. Cierra recursos
     *
     * @param codigoPelicula ID de la película
     * @param codigoActor ID del actor
     * @param columna campo a modificar
     * @param nuevoValor nuevo valor
     * @param con conexión activa
     */
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

    /**
     * Actualiza un campo específico en personaje_serie.
     *
     * FLUJO:
     * - Igual que películas pero usando PK compuesta de serie + actor
     *
     * @param codigoSerie ID de la serie
     * @param codigoActor ID del actor
     * @param columna campo a modificar
     * @param nuevoValor nuevo valor
     * @param con conexión activa
     */
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
    /**
     * Elimina un registro de cualquier tabla usando su código.
     *
     * FLUJO:
     * 1. Construye DELETE dinámico
     * 2. Asigna ID
     * 3. Ejecuta eliminación
     * 4. Muestra resultado
     * 5. Cierra recursos
     *
     * @param tabla tabla donde se eliminará el registro
     * @param codigo ID del registro a eliminar
     * @param con conexión activa
     */
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
    
     /**
     * Elimina una relación actor-película en la tabla intermedia.
     *
     * FLUJO:
     * - Usa clave compuesta (película + actor)
     * - Ejecuta DELETE seguro con parámetros
     *
     * @param codigoActor ID del actor
     * @param codigoPelicula ID de la película
     * @param con conexión activa
     */
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
    /**
     * Elimina una relación actor-serie en la tabla intermedia.
     *
     * FLUJO:
     * - DELETE con clave compuesta (serie + actor)
     *
     * @param codigoActor ID del actor
     * @param codigoSerie ID de la serie
     * @param con conexión activa
     */
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
     /**
     * Actualiza un campo SOLO si pasa validación previa.
     *
     * FLUJO:
     * 1. Comprueba si el valor es nulo o vacío
     * 2. Según la tabla, aplica validaciones específicas
     * 3. Si todo es correcto, ejecuta UPDATE real
     *
     * @param tabla tabla a actualizar
     * @param id identificador del registro
     * @param columna campo a modificar
     * @param valor nuevo valor
     * @param con conexión activa
     */
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
