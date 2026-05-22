/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Modelos.*;
import java.sql.*;
import Servicios.BaseDatos.RegistroEnMemoria;

/**
 * Clase encargada de insertar datos en la base de datos.
 * Cada método recibe un objeto (Actor, Pelicula, Serie, etc.)
 * y lo convierte en una sentencia INSERT SQL.
 * 
 * Además, algunos métodos registran la operación en memoria (log).
 * 
 * @author Carlos
 */
public class InsertarBaseDatos {
    
    /**
     * Inserta un objeto Actor en la base de datos.
     *
     * @param objecto:El objeto que debe ser de tipo Actor (se valida con instanceof)
     * @param con:La conexión activa a la base de datos
     */
    public static void insertarActorBD(Object objecto, Connection con) {
        try {
            // Comprobación de tipo seguro (pattern matching Java)
            // Solo continúa si el objeto es un Actor es válido
            if (objecto instanceof Actor actor) {
                
                
                // Sentencia SQL para insertar un actor
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Actor VALUES (?,?,?,?,?)"
                );
                
                // Asignamos los valores del objeto Actor a la consulta SQL
                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                
                // Convertimos fecha LocalDate a formato SQL Date
                pst.setDate(3, java.sql.Date.valueOf(actor.getFecha_Nacimiento()));
                
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());
                
                // Ejecutamos la inserción en la base de datos
                pst.executeUpdate();
                
                // Cerramos el statement para liberar recursos
                pst.close();

                // Un log de memoria
                RegistroEnMemoria.addInsert(
                        "Actor",
                        "Codigo=" + actor.getCodigo()
                        + ", Nombre=" + actor.getNombre()
                        + ", Fecha_nacimiento=" + actor.getFecha_Nacimiento()
                        + ", Residencia=" + actor.getLugar_Residencia()
                        + ", Nacionalidad=" + actor.getNacionalidad());
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Lanza excepción en tiempo de ejecución para detener flujo si es necesario
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Inserta una película en la base de datos.
     *
     * @param objecto:El Objeto de tipo Pelicula
     * @param con:La Conexión activa a la base de datos
     */
    public static void insertarPeliculaBD(Object objecto, Connection con) {
        try {
            // Comprobación de tipo seguro (pattern matching Java)
            // Solo continúa si el objeto es un Pelicula es válida
            if (objecto instanceof Pelicula pelicula) {
                
                // Sentencia SQL para insertar una pelicula
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Pelicula VALUES (?,?,?,?,?)"
                );
                // Asignamos los valores del objeto Pelicula a la consulta SQL
                pst.setInt(1, pelicula.getCodigo());
                pst.setString(2, pelicula.getTitulo());
                pst.setString(3, pelicula.getDirector());
                pst.setInt(4, pelicula.getAnyo_estreno());
                pst.setInt(5, pelicula.getDuracion());
                
                // Ejecutamos la inserción en la base de datos
                pst.executeUpdate();
                
                // Cerramos el statement para liberar recursos
                pst.close();

                // Log de insercion
                RegistroEnMemoria.addInsert(
                        "pelicula",
                        "Codigo=" + pelicula.getCodigo()
                        + ", Titulo=" + pelicula.getTitulo()
                        + ", Director=" + pelicula.getDirector()
                        + ", Año=" + pelicula.getAnyo_estreno()
                        + ", Duracion=" + pelicula.getDuracion()
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    /**
     * Inserta una serie en la base de datos.
     *
     * @param objecto:El objeto de tipo Serie
     * @param con:La conexión activa a la base de datos
     */
    public static void insertarSerieBD(Object objecto, Connection con) {
        try {
            // Comprobación de tipo seguro (pattern matching Java)
            // Solo continúa si el objeto es un Serie es válida
            if (objecto instanceof Serie serie) {
                
                // Sentencia SQL para insertar una serie
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Serie VALUES (?,?,?,?,?,?)"
                );
                // Asignamos los valores del objeto Serie a la consulta SQL
                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(6, serie.getEpisodios());

                // Ejecutamos la inserción en la base de datos
                pst.executeUpdate();
                
                // Cerramos el statement para liberar recursos
                pst.close();

                // Log de insercion
                RegistroEnMemoria.addInsert(
                        "Serie",
                        "Codigo=" + serie.getCodigo()
                        + ", Titulo=" + serie.getTitulo()
                        + ", Creador=" + serie.getCreador()
                        + ", Años_emision=" + serie.getAnyos_Emision()
                        + ", Temporadas=" + serie.getTemporadas()
                        + ", Episodios=" + serie.getEpisodios()
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    /**
     * Inserta un personaje de serie en la base de datos.
     *
     * @param objecto:El objeto de tipo Personaje_Serie
     * @param con:La conexión activa a la base de datos
     */
    public static void insertarPersonajeSerieBD(Object objecto, Connection con) {
        try {
            // Comprobación de tipo seguro (pattern matching Java)
            // Solo continúa si el objeto es un Personaje Serie es válida
            if (objecto instanceof Personaje_Serie ps) {
                
                // Sentencia SQL para insertar un personaje serie
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Personaje_Serie VALUES (?,?,?,?,?,?)"
                );
                // Asignamos los valores del objeto personaje serie a la consulta SQL
                pst.setInt(1, ps.getCodigo_Serie());
                pst.setInt(2, ps.getCodigo_Actor());
                pst.setString(3, ps.getNombre());
                pst.setString(4, ps.getTipo());
                pst.setInt(5, ps.getEpisodios());
                pst.setString(6, ps.getDuracion());
                
                // Ejecutamos la inserción en la base de datos
                pst.executeUpdate();
                
                // Cerramos el statement para liberar recursos
                pst.close();

                 // Log de insercion
                RegistroEnMemoria.addInsert(
                        "Personaje_serie",
                        "Codigo_serie=" + ps.getCodigo_Serie()
                        + ", Codigo_actor=" + ps.getCodigo_Actor()
                        + ", Nombre=" + ps.getNombre()
                        + ", Tipo=" + ps.getTipo()
                        + ", Episodios=" + ps.getEpisodios()
                        + ", Duracion=" + ps.getDuracion()
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Inserta un personaje de película en la base de datos.
     *
     * @param objecto:El objeto de tipo Personaje_Pelicula
     * @param con:La conexión activa a la base de datos
     */
    public static void insertarPersonajePeliculaBD(Object objecto, Connection con) {
        try {
            // Comprobación de tipo seguro (pattern matching Java)
            // Solo continúa si el objeto es un Personaje Pelicula es válida
            if (objecto instanceof Personaje_Pelicula pp) {
                
                // Sentencia SQL para insertar un personaje pelicula
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Personaje_Pelicula VALUES (?,?,?,?)"
                );
                // Asignamos los valores del objeto personaje pelicula a la consulta SQL
                pst.setInt(1, pp.getCodigo_Pelicula());
                pst.setInt(2, pp.getCodigo_Actor());
                pst.setString(3, pp.getNombre());
                pst.setString(4, pp.getTipo());
                
                // Ejecutamos la inserción en la base de datos
                pst.executeUpdate();
                
                // Cerramos el statement para liberar recursos
                pst.close();

                // Log de insercion
                RegistroEnMemoria.addInsert(
                        "Personaje Película",
                        "Codigo_pelicula=" + pp.getCodigo_Pelicula()
                        + ", Codigo_actor=" + pp.getCodigo_Actor()
                        + ", Nombre=" + pp.getNombre()
                        + ", Tipo=" + pp.getTipo()
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    // MÉTODOS DE IMPORTACIÓN A BASE DE DATOS
    // -----------------------------------------------------------------------------
    // Estos métodos insertan datos en la base de datos usando INSERT IGNORE.
    // Esto significa que si el registro ya existe (duplicado por clave primaria
    // o índice único), MySQL lo ignorará sin lanzar error.
    //
    // IMPORTANTE:
    // - No generan logs en memoria (no usan RegistroEnMemoria)
    // - Se utilizan normalmente para procesos de importación masiva
    // - Evitan interrupciones por duplicados

    /**
 * Inserta un Actor en la base de datos ignorando duplicados.
 *
 * @param objecto Objeto que debe ser de tipo Actor (se valida con instanceof)
 * @param con Conexión activa con la base de datos
 */
    public static void insertarActorBDImport(Object objecto, Connection con) {
        try {
            
            // Verifica que el objeto recibido sea realmente un Actor
            if (objecto instanceof Actor actor) {
                
                // Sentencia SQL con IGNORE para evitar errores por duplicados
                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Actor VALUES (?,?,?,?,?)"
                );
                
                // Asignación de valores del objeto Actor a la consulta SQL
                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                
                // Conversión de LocalDate a java.sql.Date para la base de datos
                pst.setDate(3, java.sql.Date.valueOf(actor.getFecha_Nacimiento()));
                
                
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());
                
                // Ejecuta la inserción (si no es duplicado)
                pst.executeUpdate();
                
                // Cierra el PreparedStatement para liberar recursos
                pst.close();
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Convierte la excepción en RuntimeException para no obligar a manejarla
            throw new RuntimeException(ex);
        }
    }
    /**
    * Inserta una Película en la base de datos ignorando duplicados.
    *
    * @param objecto Objeto de tipo Pelicula
    * @param con Conexión activa a la base de datos
    */
    public static void insertarPeliculaBDImport(Object objecto, Connection con) {
        try {
            
            // Verifica que el objeto recibido sea realmente una Pelicula
            if (objecto instanceof Pelicula pelicula) {
                
                // Sentencia SQL con IGNORE para evitar errores por duplicados
                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Pelicula VALUES (?,?,?,?,?)"
                );
                
                // Asignación de valores del objeto pelicula a la consulta SQL
                pst.setInt(1, pelicula.getCodigo());
                pst.setString(2, pelicula.getTitulo());
                pst.setString(3, pelicula.getDirector());
                pst.setInt(4, pelicula.getAnyo_estreno());
                pst.setInt(5, pelicula.getDuracion());
                
                // Ejecuta la inserción (si no es duplicado)
                pst.executeUpdate();
                
                // Cierra el PreparedStatement para liberar recursos
                pst.close();
           
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Convierte la excepción en RuntimeException para no obligar a manejarla
            throw new RuntimeException(ex);
        }
    }
    /**
    * Inserta una Serie en la base de datos ignorando duplicados.
    *
    * @param objecto:El objeto de tipo Serie
    * @param con:La Conexión activa a la base de datos
    */
    public static void insertarSerieBDImport(Object objecto, Connection con) {
        try {
            // Verifica que el objeto recibido sea realmente una Serie
            if (objecto instanceof Serie serie) {
                
                // Sentencia SQL con IGNORE para evitar errores por duplicados
                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Serie VALUES (?,?,?,?,?,?)"
                );
                
                // Asignación de valores del objeto Serie a la consulta SQL
                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(6, serie.getEpisodios());
                
                // Ejecuta la inserción (si no es duplicado)
                pst.executeUpdate();
                
                // Cierra el PreparedStatement para liberar recursos
                pst.close();
               
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Convierte la excepción en RuntimeException para no obligar a manejarla
            throw new RuntimeException(ex);
        }
    }
    /**
    * Inserta un Personaje de Serie ignorando duplicados.
    *
    * @param objecto:El objeto de tipo Personaje_Serie
    * @param con:La conexión activa a la base de datos
    */
    public static void insertarPersonajeSerieBDImport(Object objecto, Connection con) {
        try {
            // Verifica que el objeto recibido sea realmente un personaje serie
            if (objecto instanceof Personaje_Serie ps) {
                
                // Sentencia SQL con IGNORE para evitar errores por duplicados
                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Personaje_Serie VALUES (?,?,?,?,?,?)"
                );
                
                // Asignación de valores del objeto personaje serie a la consulta SQL
                pst.setInt(1, ps.getCodigo_Serie());
                pst.setInt(2, ps.getCodigo_Actor());
                pst.setString(3, ps.getNombre());
                pst.setString(4, ps.getTipo());
                pst.setInt(5, ps.getEpisodios());
                pst.setString(6, ps.getDuracion());
                
                // Ejecuta la inserción (si no es duplicado)
                pst.executeUpdate();
                
                // Cierra el PreparedStatement para liberar recursos
                pst.close();

             
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Convierte la excepción en RuntimeException para no obligar a manejarla
            throw new RuntimeException(ex);
        }
    }
    /**
    * Inserta un Personaje de Película ignorando duplicados.
    *
    * @param objecto:El objeto de tipo Personaje_Pelicula
    * @param con:La Conexión activa a la base de datos
    */
    public static void insertarPersonajePeliculaBDImport(Object objecto, Connection con) {
        try {
            // Verifica que el objeto recibido sea realmente un personaje pelicula
            if (objecto instanceof Personaje_Pelicula pp) {
                
                // Asignación de valores del objeto personaje serie a la consulta SQL
                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Personaje_Pelicula VALUES (?,?,?,?)"
                );
                
                // Asignación de valores del objeto personaje pelicula a la consulta SQL
                pst.setInt(1, pp.getCodigo_Pelicula());
                pst.setInt(2, pp.getCodigo_Actor());
                pst.setString(3, pp.getNombre());
                pst.setString(4, pp.getTipo());
                
                // Ejecuta la inserción (si no es duplicado)
                pst.executeUpdate();
                
                // Cierra el PreparedStatement para liberar recursos
                pst.close();
                
            }

        } catch (SQLException ex) {
            
            // Imprime el error en consola para depuración
            ex.printStackTrace();
            
            // Convierte la excepción en RuntimeException para no obligar a manejarla
            throw new RuntimeException(ex);
        }
    }
}
