/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isard
 */
public class ConsultasBD {

    public static void informePeliculasCS1(Connection con) {
        ServicioBase_de_Datos.inciarBase_De_Datos();
        String sql = " select p.titulo,p.año_estreno,p.duracion, a.nombre , pp.nombre from pelicula p\n"
                + "join personaje_pelicula  pp on pp.codigo_pelicula = p.codigo\n"
                + "join actor a on pp.codigo_actor_P = a.codigo\n"
                + "order by p.duracion desc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("titulo") + " - " + rs.getInt("año_estreno") + " - "
                        + rs.getInt("duracion") + " - " + rs.getString("a.nombre") + " - " + rs.getString("pp.nombre") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void informeSeriesCS2(Connection con) {
        ServicioBase_de_Datos.inciarBase_De_Datos();
        String sql = "select s.titulo, s.creador, s.temporadas, a.nombre , ps.nombre\n"
                + "from serie s\n"
                + "join personaje_serie ps on s.codigo = ps.codigo_serie\n"
                + "join actor a on a.codigo = ps.codigo_actor_S\n"
                + "order by s.temporadas desc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("titulo") + " - " + rs.getString("creador") + " - "
                        + rs.getInt("s.temporadas") + " - " + rs.getString("a.nombre") + " - " + rs.getString("ps.nombre") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void informeSeriesCS3(Connection con) {
        ServicioBase_de_Datos.inciarBase_De_Datos();
        String sql = "select a.nombre, a.fecha_nacimiento, a.lugar_residencia , s.titulo , ps.episodios \n"
                + "from actor a\n"
                + "left join personaje_serie ps on a.codigo = ps.codigo_actor_S\n"
                + "left join serie s on ps.codigo_serie = s.codigo\n"
                + "order by a.nombre asc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getDate("fecha_nacimiento") + " - "
                        + rs.getString("lugar_residencia") + " - " + rs.getString("s.titulo") + " - " + rs.getInt("ps.episodios") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void informeSeriesCS4(Connection con) {
        ServicioBase_de_Datos.inciarBase_De_Datos();
        String sql = "select a.nombre, a.fecha_nacimiento, a.lugar_residencia , p.titulo, pp.tipo\n"
                + "from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join pelicula p on pp.codigo_pelicula = p.codigo\n"
                + "order by a.nombre asc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getDate("fecha_nacimiento") + " - "
                        + rs.getString("lugar_residencia") + " - " + rs.getString("p.titulo") + " - " + rs.getInt("pp.tipo") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void informeSeriesCS5(Connection con) {
        ServicioBase_de_Datos.inciarBase_De_Datos();
        String sql = "select a.nombre, a.nacionalidad from actor a\n"
                + "left join personaje_pelicula pp on a.codigo = pp.codigo_actor_P\n"
                + "left join pelicula p on p.codigo = pp.codigo_pelicula\n"
                + "left join personaje_serie ps on ps.codigo_actor_S = a.codigo\n"
                + "left join serie s on s.codigo = ps.codigo_serie\n"
                + "order by a.nacionalidad asc;";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getString("nacionalidad") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
