/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Servicios.Ficheros.GenerarInformes;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de generar informes a partir de consultas SQL
 * sobre la base de datos de películas, series, actores y personajes.
 *
 * Cada método:
 * - Ejecuta una consulta SQL
 * - Muestra resultados por consola
 * - Genera un informe externo mediante GenerarInformes
 *
 * @author Carlos
 */
public class ConsultasBD {
    
    /**
     * Informe 1:
     * Muestra todas las películas junto con:
     * - Año de estreno
     * - Duración
     * - Actor participante
     * - Personaje interpretado
     * 
     * El informe se ordena por duración de película de forma descendente.
     * 
     * @param con conexión activa con la base de datos
     */
    public static void informePeliculasCS1(Connection con) {
        
        // Inicializa conexión 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta1";
        
        // Consulta SQL
        String sql = " select p.titulo,p.año_estreno,p.duracion, a.nombre as actor , pp.nombre as personaje from pelicula p\n"
                + "join personaje_pelicula  pp on pp.codigo_pelicula = p.codigo\n"
                + "join actor a on pp.codigo_actor_P = a.codigo\n"
                + "order by p.duracion desc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            
            // Recorre cada fila del resultado
            while (rs.next()) {
                System.out.println(rs.getString("titulo") + " - " + rs.getInt("año_estreno") + " - "
                        + rs.getInt("duracion") + " - " + rs.getString("actor") + " - " + rs.getString("personaje") + " - ");
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      /**
     * Informe 2:
     * Muestra todas las series junto con:
     * - Creador
     * - Número de temporadas
     * - Actor participante
     * - Personaje interpretado
     * 
     * El informe se ordena por número de temporadas.
     * 
     * @param con:La conexión activa con la base de datos
     */
    public static void informeSeriesCS2(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta2";
        
        // Consulta SQL
        String sql = "select s.titulo, s.creador, s.temporadas, a.nombre as actor , ps.nombre as personaje\n"
                + "from serie s\n"
                + "join personaje_serie ps on s.codigo = ps.codigo_serie\n"
                + "join actor a on a.codigo = ps.codigo_actor_S\n"
                + "order by s.temporadas desc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                
                // Se extraen los datos de cada serie con su actor y personaje
                System.out.println(rs.getString("titulo") + " - " + rs.getString("creador") + " - "
                        + rs.getInt("s.temporadas") + " - " + rs.getString("actor") + " - " + rs.getString("personaje") + " - ");
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Informe 3: Actores con sus series.
     *
     * Lógica:
     * - LEFT JOIN para incluir actores sin series
     * - Relaciona actores con personajes de serie
     * - Orden alfabético por nombre de actor
     *
     * @param con conexión activa a la base de datos
     */
    public static void informeSeriesCS3(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta3";
        
        // Consulta SQL
        String sql = "select a.nombre, a.fecha_nacimiento, a.lugar_residencia , s.titulo as serie , ps.episodios as episodios \n"
                + "from actor a\n"
                + "left join personaje_serie ps on a.codigo = ps.codigo_actor_S\n"
                + "left join serie s on ps.codigo_serie = s.codigo\n"
                + "order by a.nombre asc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                
                // Se muestran actores incluso si no tienen serie asociada
                System.out.println(rs.getString("nombre") + " - " + rs.getDate("fecha_nacimiento") + " - "
                        + rs.getString("lugar_residencia") + " - " + rs.getString("serie") + " - " + rs.getInt("episodios") + " - ");
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Informe 4: Actores con películas.
     *
     * Lógica:
     * - LEFT JOIN para incluir actores sin películas
     * - Relación con personaje de película
     * - Muestra tipo de papel interpretado
     *
     * @param con conexión activa a la base de datos
     */
    public static void informeSeriesCS4(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta4";
        
        // Consulta SQL
        String sql = "select a.nombre, a.fecha_nacimiento, a.lugar_residencia , p.titulo, pp.tipo\n"
                + "from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join pelicula p on pp.codigo_pelicula = p.codigo\n"
                + "order by a.nombre asc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                
                // Actor con posible participación en películas
                System.out.println(rs.getString("nombre") + " - " + rs.getDate("fecha_nacimiento") + " - "
                        + rs.getString("lugar_residencia") + " - " + rs.getString("p.titulo") + " - " + rs.getInt("pp.tipo") + " - ");
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     /**
     * Informe 5: Actores con películas y series.
     *
     * Lógica:
     * - Combina múltiples LEFT JOIN
     * - Permite ver participación total del actor
     * - Puede haber duplicados si un actor tiene varios roles
     *
     * @param con conexión activa a la base de datos
     */
    public static void informeSeriesCS5(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta5";
        
        // Consulta SQL
        String sql = "select a.nombre, a.nacionalidad, p.titulo as Pelicula , s.titulo as Serie from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join pelicula p on p.codigo = pp.codigo_pelicula\n"
                + "left join personaje_serie ps on ps.codigo_actor_S = a.codigo\n"
                + "left join serie s on s.codigo = ps.codigo_serie\n"
                + "order by a.nacionalidad asc";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                // Actor con participación combinada en cine y series
                System.out.println(rs.getString("nombre") + " - " + rs.getString("nacionalidad") + " - "
                + rs.getString("Pelicula") + " - " + rs.getString("Serie"));
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Informe 6: Número de actores por serie.
     *
     * Lógica:
     * - COUNT DISTINCT para evitar duplicados
     * - Agrupa por serie
     *
     * @param con conexión activa a la base de datos
     */
    public static void informeSeriesCS6(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta6";
        
        // Consulta SQL
        String sql = "select s.titulo , count(distinct ps.codigo_actor_S) as numActores \n"
                + "from serie s\n"
                + "left join personaje_serie ps on s.codigo = ps.codigo_serie\n"
                + "group by s.titulo;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                 // Número total de actores por cada serie
                System.out.println(rs.getString("s.titulo") + " - " + rs.getInt("numActores"));
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
    * Genera un informe de actores que han participado en más de 3 producciones
    * (películas + series).
    *
    * Lógica de la consulta:
    * - Se cuentan participaciones en películas y series
    * - Se agrupan por actor
    * - Se filtran aquellos con más de 3 apariciones totales
    *
    * @param con conexión activa a la base de datos
    */
    public static void informeSeriesCS7(Connection con) {
        
        // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta7";
        
        // Consulta SQL
        String sql = "select a.nombre \n"
                + "from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join personaje_serie ps on a.codigo = ps.codigo_actor_S\n"
                + "group by a.codigo, a.nombre\n"
                + "having count(pp.codigo_actor_P) + count(ps.codigo_actor_S) > 3;";
        try {
            //Prepara la consulta SQL para ejecución en la base de datos
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                
                // Muestra por consola el nombre del actor
                System.out.println(rs.getString("nombre"));
            }
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra la conexión a la base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
    * Lista actores que NO han participado ni en películas ni en series.
    *
    * Lógica:
    * - LEFT JOIN con ambas tablas de personajes
    * - Se filtran aquellos que no tienen coincidencias (NULL)
    *
    * @param con conexión activa a la base de datos
    */
    public static void informeSeriesCS8(Connection con) {
        
        // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta8";
        
        // Consulta SQL
        String sql = "select a.nombre, a.nacionalidad \n"
                + "from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join personaje_serie ps on a.codigo= ps.codigo_actor_S\n"
                + "where pp.codigo_actor_P is null and ps.codigo_actor_S is null;";
        try {
            // Prepara la sentencia SQL
            PreparedStatement pst = con.prepareStatement(sql);
            
            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            
            // Recorre cada fila del resultado
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getString("nacionalidad"));
            }
            
            // Genera informe externo con los resultados
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
           // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
            
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void informeSeriesCS9(Connection con) {
        
         // Inicializa base de datos 
        ServicioBase_de_Datos.inciarBase_De_Datos();
        
        // Nombre del informe que se generado
        String nombreArchivo = "Consulta9";
        
        // Consulta SQL
        String sql = "select * from pelicula\n"
                + "where año_estreno between 2010 and 2020\n"
                + "and titulo like '%Misterio%'\n"
                + "and duracion > 120;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            // Ejecuta consulta y obtiene resultados
            ResultSet rs = pst.executeQuery();
            // Recorre cada fila del resultado
            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + " - " + rs.getString("titulo") + " - "
                        + rs.getString("director") + " - " + rs.getString("año_estreno") + " - " + rs.getInt("duracion"));
            }
            
            // Genera el informe externo usando la consulta ejecutada
            GenerarInformes.GenerarInforme(con, sql, nombreArchivo);
            
            // Cierra el PreparedStatement
            pst.close();
            
            // Cierra conexión a base de datos
            con.close();
        } catch (SQLException ex) {
            // Captura errores SQL
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
