/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTable;

/**
 *Clase encargada de realizar consultas a la base de datos
 * y mostrar los resultados en componentes JTable de Swing
 * 
 * @author Andre
 */
public class LeerDatos {
    /**
     * Este método realiza una consulta "SELECT *" sobre una tabla completa
     * y permite ordenar los resultados por una columna específica.
     * Luego convierte el resultado en un modelo de JTable para mostrarlo en pantalla.
     * 
     * @param tabla:El nombre de la tabla de la base de datos que se desea consultar
     * @param columnaOrden:El nombre de la columna utilizada para ordenar los resultados de forma ascendente
     * @param con:La conexión activa con la base de datos
     * @param tablaVisual:El componente JTable donde se mostrarán los datos obtenidos de la consulta
     */
    public static void consultarTabla(String tabla, String columnaOrden, Connection con, javax.swing.JTable tablaVisual) {
        try {
            // Construye la consulta SQL dinámicamente (ordenada por una columna)
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM " + tabla + " ORDER BY " + columnaOrden + " ASC"
            );

            // Ejecuta la consulta
            ResultSet rs = ps.executeQuery();
            
            // Obtiene metadatos del resultado (nombres de columnas, tipos, etc.)
            ResultSetMetaData meta = rs.getMetaData();
            
            // Número total de columnas de la tabla
            int columnas = meta.getColumnCount();
            
            // Modelo de tabla de Swing personalizado
            javax.swing.table.DefaultTableModel modelo
                    = new javax.swing.table.DefaultTableModel() {
                        
                // Evita que las celdas sean editable
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                // Intenta inferir el tipo de dato de cada columna
                @Override
                public Class<?> getColumnClass(int columnIndex) {

                    // intenta detectar el tipo real desde los datos cargados
                    for (int row = 0; row < getRowCount(); row++) {
                        Object value = getValueAt(row, columnIndex);
                        
                        // Si encontramos un valor no nulo, usamos su clase como tipo
                        if (value != null) {
                            return value.getClass();
                        }
                    }
                    // Si no hay datos aún, devolvemos Object genérico
                    return Object.class;
                }
            };
            // Añade los nombres de las columnas al modelo
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

             // Recorre el ResultSet fila por fila
            while (rs.next()) {
                
                // Array que representa una fila de la tabla
                Object[] fila = new Object[columnas];
                
                 // Rellena cada columna de la fila
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // Añade la fila al modelo
                modelo.addRow(fila);
            }
            // Asigna el modelo construido al JTable visual
            tablaVisual.setModel(modelo);
            
            // Cierra recursos para liberar memoria
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            // Registra errores en caso de fallo en la consulta
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return listaObjetos
    }
    
    /**
     * Realiza una consulta a una tabla filtrando por una columna específica
     * y muestra el resultado en un JTable.
     * 
     * @param tabla:El nombre de la tabla en la base de datos
     * @param columnaId:El nombre de la columna que se usará como filtro (ej: id, dni, codigo)
     * @param valorId:El valor que se buscará en la columna indicada
     * @param con:La conexión activa a la base de datos
     * @param tablaVisual:La JTable donde se mostrarán los resultados de la consulta
     */
    public static void consultarFila(String tabla, String columnaId, Object valorId, Connection con, javax.swing.JTable tablaVisual) {

        try {
            
            // Consulta con parámetro seguro (evita inyección en el valor)
            String sql = "SELECT * FROM " + tabla + " WHERE " + columnaId + " = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            
            // Asigna el valor del filtro
            ps.setObject(1, valorId);

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int columnas = meta.getColumnCount();
            
            // Creamos modelo de tabla no editable
            javax.swing.table.DefaultTableModel modelo
                    = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            // Añadimos nombres de columnas al modelo
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }
            
            // Recorremos resultados de la consulta
            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }
            // Mostramos resultado en JTabl
            tablaVisual.setModel(modelo);

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LeerDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Este método permite ejecutar cualquier consulta SQL SELECT pasada como texto.
     * Es el más flexible, pero también el más peligroso si no se controla bien.
     * 
     *@param sql:La consulta SQL SELECT personalizada que se ejecutará en la base de datos
     *@param con:La conexión activa a la base de datos
     *@param tablaVisual:El JTable donde se mostrarán los resultados obtenidos de la consulta
     */
    public static void consultarSQL(String sql, Connection con, JTable tablaVisual) {
        try {
            
            // Preparamos la consulta directamente desde el String recibido
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();
            
            // Modelo de tabla no editable
            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            // Añadimos columnas dinámicamente
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }
            
             // Añadimos filas al modelo
            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }
            
            // Mostramos resultados
            tablaVisual.setModel(modelo);

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Permite buscar registros que cumplan DOS condiciones simultáneas
     * Ejemplo: WHERE id = ? AND estado = ?
     * 
     * @param tabla:El nombre de la tabla en la base de datos donde se realizará la búsqueda
     * @param columna1:El nombre de la primera columna utilizada como condición
     * @param valor1:El valor que debe cumplir la primera columna
     * @param columna2:El nombre de la segunda columna utilizada como condición
     * @param valor2:El valor que debe cumplir la segunda columna
     * @param con:La conexión activa a la base de datos
     * @param jTable:El JTable donde se mostrarán los resultados de la consulta
     */
    public static void consultarFilaCompuesta(
            String tabla,
            String columna1,
            int valor1,
            String columna2,
            int valor2,
            Connection con,
            JTable jTable) {

        try {
            
            // Construcción de consulta con dos filtros
            String sql = "SELECT * FROM " + tabla
                    + " WHERE " + columna1 + " = ? AND " + columna2 + " = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            
            // Construcción de consulta con dos filtros
            ps.setInt(1, valor1);
            ps.setInt(2, valor2);

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();
            
            // Modelo de tabla no editable
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            // Añadimos nombres de columnas
            for (int i = 1; i <= columnas; i++) {
                model.addColumn(meta.getColumnName(i));
            }
            
            // Recorremos resultados
            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }

                model.addRow(fila);
            }
            
            // Mostramos en JTable
            jTable.setModel(model);

            rs.close();
            ps.close();

        } catch (Exception e) {
            
            // Captura cualquier tipo de error (SQL u otros)
            e.printStackTrace();
        }
    }
}
