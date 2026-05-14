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
            while (rs.next()){
                System.out.println(rs.getString("titulo") + " - " + rs.getInt("año_estreno") + " - " +
                rs.getInt("duracion") + " - " + rs.getString("a.nombre") + " - " + rs.getString("pp.nombre") + " - ");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
