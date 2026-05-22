/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros;

import java.io.*;
import java.sql.*;

/**
 *Clase encagrada de generar informes a partir  de las consultas SQL
 * 
 * El informe generado se guarda en ficheros TXT
 * con los datos obtenidos desde la base de datos
 * 
 * @author Carlos y Andre
 */
public class GenerarInformes {
    /**
     * Metodo que genera un informe a partir de una consulta SQL
     *
     * 
     * Funcionamineto:
     * 1. Recibe la conexion a la base de datos
     * 2. Ejecuta ña consulta SQL recibida.
     * 3. Lee todos los rresultados obtenidos.
     * 4. Guarda cada fila del resultado en un fichero de texto.
     * 5. Cada columna separada con " - ".
     * 
     * @param con:La conexión a la base de datos
     * @param sql:La consulta SQL que desea ejecutar
     * @param nombreArchivo:El  nombre del fichero donde se guarda el informe
     */
    public static void GenerarInforme(Connection con, String sql, String nombreArchivo) {

        try {
            // Preparar la consulta SQL
            PreparedStatement pst = con.prepareStatement(sql);
            
            // Ejecuta la consulta y guarda el resultado
            ResultSet rs = pst.executeQuery();
            
            // Crea el fichero donde se alamacenara el informe
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            
            // Obtiene informacion sobre las columnas del ResultSet
            ResultSetMetaData meta = rs.getMetaData();
            
            // Guarda el numero total de columnas
            int columnas = meta.getColumnCount();
            
            // Recorre todas las filas obtenidas de la consulta
            while (rs.next()) {
                
                // Recorre todas las columnas de la fila actual
                for (int i = 1; i <= columnas; i++) {
                    
                    // Escribe el contenido de la columna
                    bw.write(rs.getString(i));
                    
                    // Añade separador entre columnas
                    if (i < columnas) {
                        bw.write(" - ");
                    }
                }
                
                // Salto de linea para la siguiente fila
                bw.newLine();
            }
            
            // Se cierra el fichero
            bw.close();
            
            // Se cierra eñ PreparedStatement
            pst.close();
            
             // Mensaje de confirmación
            System.out.println("Informe generado correctamente.");

        } catch (SQLException | IOException e) {
            
            //Se Muestra el error en caso de excepción
            e.printStackTrace();
        }
    }
}
