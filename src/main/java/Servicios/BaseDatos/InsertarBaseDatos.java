/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import Modelos.*;
import java.sql.*;
import Servicios.BaseDatos.RegistroEnMemoria;

/**
 *
 * @author isard
 */
public class InsertarBaseDatos {

    public static void insertarActorBD(Object objecto, Connection con) {
        try {
            if (objecto instanceof Actor actor) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Actor VALUES (?,?,?,?,?)"
                );

                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                pst.setDate(3, java.sql.Date.valueOf(actor.getFecha_Nacimiento()));
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());

                pst.executeUpdate();
                pst.close();

                // ✅ LOG
                RegistroEnMemoria.addInsert(
                        "Actor",
                        "Codigo=" + actor.getCodigo()
                        + ", Nombre=" + actor.getNombre()
                        + ", Fecha_nacimiento=" + actor.getFecha_Nacimiento()
                        + ", Residencia=" + actor.getLugar_Residencia()
                        + ", Nacionalidad=" + actor.getNacionalidad());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void insertarPeliculaBD(Object objecto, Connection con) {
        try {
            if (objecto instanceof Pelicula pelicula) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Pelicula VALUES (?,?,?,?,?)"
                );

                pst.setInt(1, pelicula.getCodigo());
                pst.setString(2, pelicula.getTitulo());
                pst.setString(3, pelicula.getDirector());
                pst.setInt(4, pelicula.getAnyo_estreno());
                pst.setInt(5, pelicula.getDuracion());

                pst.executeUpdate();
                pst.close();

                // ✅ LOG
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

    public static void insertarSerieBD(Object objecto, Connection con) {
        try {
            if (objecto instanceof Serie serie) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Serie VALUES (?,?,?,?,?,?)"
                );

                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(6, serie.getEpisodios());

                pst.executeUpdate();
                pst.close();

                // ✅ LOG
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

    public static void insertarPersonajeSerieBD(Object objecto, Connection con) {
        try {
            if (objecto instanceof Personaje_Serie ps) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Personaje_Serie VALUES (?,?,?,?,?,?)"
                );

                pst.setInt(1, ps.getCodigo_Serie());
                pst.setInt(2, ps.getCodigo_Actor());
                pst.setString(3, ps.getNombre());
                pst.setString(4, ps.getTipo());
                pst.setInt(5, ps.getEpisodios());
                pst.setString(6, ps.getDuracion());

                pst.executeUpdate();
                pst.close();

                // ✅ LOG
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

    public static void insertarPersonajePeliculaBD(Object objecto, Connection con) {
        try {
            if (objecto instanceof Personaje_Pelicula pp) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO Personaje_Pelicula VALUES (?,?,?,?)"
                );

                pst.setInt(1, pp.getCodigo_Pelicula());
                pst.setInt(2, pp.getCodigo_Actor());
                pst.setString(3, pp.getNombre());
                pst.setString(4, pp.getTipo());

                pst.executeUpdate();
                pst.close();

                // ✅ LOG
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

    public static void insertarActorBDImport(Object objecto, Connection con) {
        try {
            if (objecto instanceof Actor actor) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Actor VALUES (?,?,?,?,?)"
                );

                pst.setInt(1, actor.getCodigo());
                pst.setString(2, actor.getNombre());
                pst.setDate(3, java.sql.Date.valueOf(actor.getFecha_Nacimiento()));
                pst.setString(4, actor.getLugar_Residencia());
                pst.setString(5, actor.getNacionalidad());

                pst.executeUpdate();
                pst.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void insertarPeliculaBDImport(Object objecto, Connection con) {
        try {
            if (objecto instanceof Pelicula pelicula) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Pelicula VALUES (?,?,?,?,?)"
                );

                pst.setInt(1, pelicula.getCodigo());
                pst.setString(2, pelicula.getTitulo());
                pst.setString(3, pelicula.getDirector());
                pst.setInt(4, pelicula.getAnyo_estreno());
                pst.setInt(5, pelicula.getDuracion());

                pst.executeUpdate();
                pst.close();
           
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void insertarSerieBDImport(Object objecto, Connection con) {
        try {
            if (objecto instanceof Serie serie) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Serie VALUES (?,?,?,?,?,?)"
                );

                pst.setInt(1, serie.getCodigo());
                pst.setString(2, serie.getTitulo());
                pst.setString(3, serie.getCreador());
                pst.setString(4, serie.getAnyos_Emision());
                pst.setInt(5, serie.getTemporadas());
                pst.setInt(6, serie.getEpisodios());

                pst.executeUpdate();
                pst.close();

               
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void insertarPersonajeSerieBDImport(Object objecto, Connection con) {
        try {
            if (objecto instanceof Personaje_Serie ps) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Personaje_Serie VALUES (?,?,?,?,?,?)"
                );

                pst.setInt(1, ps.getCodigo_Serie());
                pst.setInt(2, ps.getCodigo_Actor());
                pst.setString(3, ps.getNombre());
                pst.setString(4, ps.getTipo());
                pst.setInt(5, ps.getEpisodios());
                pst.setString(6, ps.getDuracion());

                pst.executeUpdate();
                pst.close();

             
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void insertarPersonajePeliculaBDImport(Object objecto, Connection con) {
        try {
            if (objecto instanceof Personaje_Pelicula pp) {

                PreparedStatement pst = con.prepareStatement(
                        "INSERT IGNORE INTO Personaje_Pelicula VALUES (?,?,?,?)"
                );

                pst.setInt(1, pp.getCodigo_Pelicula());
                pst.setInt(2, pp.getCodigo_Actor());
                pst.setString(3, pp.getNombre());
                pst.setString(4, pp.getTipo());

                pst.executeUpdate();
                pst.close();
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
