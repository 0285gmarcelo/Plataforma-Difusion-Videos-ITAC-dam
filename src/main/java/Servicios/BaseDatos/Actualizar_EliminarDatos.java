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
 * sobre las tablas de la base de datos.
 *
 * Esta clase permite:
 * - Actualizar registros
 * - Eliminar registros
 * - Gestionar tablas intermedias (personaje_pelicula y personaje_serie)
 * - Validar datos antes de modificar la base de datos
 *
 * Todas las operaciones utilizan PreparedStatement
 * para evitar errores SQL y mejorar la seguridad.
 *
 * @author Carlos
 */
public class Actualizar_EliminarDatos {

    /**
     * Actualiza un campo concreto de cualquier tabla.
     *
     * Funcionamiento:
     * 1. Construye dinámicamente una consulta UPDATE
     * 2. Sustituye los parámetros usando PreparedStatement
     * 3. Ejecuta la actualización
     * 4. Muestra información por consola
     *
     * @param tabla:La tabla donde se realizará la actualización
     * @param codigo:El identificador del registro
     * @param columna:La columna que se modificará
     * @param nuevoContenido:El nuevo valor del campo
     * @param con:La conexión activa a la base de datos
     */
    public static void actualizar(String tabla, int codigo, String columna, String nuevoContenido, Connection con) {

        try {
            
            // Construcción dinámica del UPDATE
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + tabla + " SET " + columna + " = ? WHERE codigo = ?"
            );

            // Nuevo valor
            ps.setString(1, nuevoContenido);
            
            // Código del registro
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
            // UPDATE con la clave compuesta
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE personaje_pelicula SET " + columna
                    + " = ? WHERE codigo_pelicula = ? AND codigo_actor_P = ?"
            );
            
            // Nuevo valor
            ps.setString(1, nuevoValor);
            
            // Código película
            ps.setInt(2, codigoPelicula);
            
             // Código actor
            ps.setInt(3, codigoActor);
            
            // Ejecuta la actualización
            ps.executeUpdate();

            System.out.println("Personaje película actualizado");
            
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
     * Actualiza un registro de la tabla personaje_serie.
     *
     * Utiliza clave compuesta:
     * - codigo_serie
     * - codigo_actor_S
     *
     * @param codigoSerie código de la serie
     * @param codigoActor código del actor
     * @param columna columna a modificar
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
            // Consulta UPDATE
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE personaje_serie SET " + columna
                    + " = ? WHERE codigo_serie = ? AND codigo_actor_S = ?"
            );
            
            // Nuevo valor
            ps.setString(1, nuevoValor);
            
            // Código serie
            ps.setInt(2, codigoSerie);
            
            // Código actor
            ps.setInt(3, codigoActor);

            // Ejecuta actualización
            ps.executeUpdate();

            System.out.println("Personaje serie actualizado");

            // Cierra recursos
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
     * Funcionamiento:
     * 1. Construye consulta DELETE
     * 2. Asigna el código del registro
     * 3. Ejecuta eliminación
     * 4. Muestra información por consola
     *
     * @param tabla tabla donde se eliminará el registro
     * @param codigo identificador del registro
     * @param con conexión activa
     * @throws SQLException si ocurre un error SQL
     */
    public static void eliminar(String tabla, int codigo, Connection con) throws SQLException {
        try {
            
            // Consulta DELETE
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + tabla + " WHERE codigo = ?"
            );

            // Código del registro
            ps.setInt(1, codigo);

            // Ejecuta eliminación
            int filas = ps.executeUpdate();

            // Mensajes informativos
            System.out.println("Eliminación OK");
            System.out.println("Tabla: " + tabla + " | Filas eliminadas: " + filas);

            // Cierra recursos
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminar()");
            ex.printStackTrace();
            throw ex; // 🔴 ESTO es lo único importante
        }
    }
    
     /**
     * Elimina un personaje de película usando clave compuesta.
     *
     * @param codigoActor código del actor
     * @param codigoPelicula código de la película
     * @param con conexión activa
     * @throws SQLException si ocurre un error SQL
     */
    public static void eliminarPersonaje_Pelicula(
            int codigoActor,
            int codigoPelicula,
            Connection con) throws SQLException {
        try {
            // Consulta DELETE
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM personaje_pelicula WHERE codigo_pelicula = ? AND codigo_actor_P = ?"
            );

            // Código película
            ps.setInt(1, codigoPelicula);
            
            // Código actor
            ps.setInt(2, codigoActor);

            // Ejecuta eliminación
            ps.executeUpdate();

            System.out.println("Eliminación OK en personaje_pelicula");

            // Cierra recursos
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminarPersonaje_Pelicula()");
            ex.printStackTrace();
            throw ex;
        }
    }
    /**
     * Elimina un personaje de serie usando clave compuesta.
     *
     * @param codigoActor código del actor
     * @param codigoSerie código de la serie
     * @param con conexión activa
     * @throws SQLException si ocurre un error SQL
     */
    public static void eliminarPersonaje_Serie(
            int codigoActor,
            int codigoSerie,
            Connection con) throws SQLException {

        try {
            
             // Consulta DELETE
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM personaje_serie WHERE codigo_serie = ? AND codigo_actor_S = ?"
            );

            // Código serie
            ps.setInt(1, codigoSerie);
            
            // Código actor
            ps.setInt(2, codigoActor);

            // Ejecuta eliminación
            ps.executeUpdate();

            System.out.println("Eliminación OK en personaje_serie");

            // Cierra recursos
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en eliminarPersonaje_Serie()");
            ex.printStackTrace();
            throw ex;
        }
    }
     /**
     * Actualiza un campo solamente si pasa las validaciones.
     *
     * Funcionamiento:
     * 1. Comprueba si el valor está vacío
     * 2. Según la tabla y columna:
     *    - ejecuta validaciones específicas
     * 3. Si todo es correcto:
     *    - llama al método actualizar()
     *
     * @param tabla tabla a modificar
     * @param id código del registro
     * @param columna columna a actualizar
     * @param valor nuevo valor
     * @param con conexión activa
     * @throws Exception si falla alguna validación
     */
    public static void actualizarCampoValidado(
        String tabla,
        int id,
        String columna,
        String valor,
        Connection con
) throws Exception {
        // Evita actualizar valores vacíos
    if (valor == null || valor.isBlank()) {
        return; // NO actualiza campos vacíos
    }
    
    // Validaciones según tabla
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
            
            // Validación del tipo de personaje
            if (columna.equals("tipo")) {
                Validaciones.validarTipoPersonaje(valor);
            }
        }
    }

    // si pasa validación → actualiza
    Actualizar_EliminarDatos.actualizar(tabla, id, columna, valor, con);
}
}
