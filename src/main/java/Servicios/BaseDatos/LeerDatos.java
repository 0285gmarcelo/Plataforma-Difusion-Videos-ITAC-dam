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
 *
 * @author isard
 */
public class LeerDatos {

    public static void consultarTabla(String tabla, String columnaOrden, Connection con, javax.swing.JTable tablaVisual) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM " + tabla + " ORDER BY " + columnaOrden + " ASC"
            );

            //ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();

            int columnas = meta.getColumnCount();

            javax.swing.table.DefaultTableModel modelo
                    = new javax.swing.table.DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {

                    // intenta detectar el tipo real desde los datos cargados
                    for (int row = 0; row < getRowCount(); row++) {
                        Object value = getValueAt(row, columnIndex);

                        if (value != null) {
                            return value.getClass();
                        }
                    }

                    return Object.class;
                }
            };

            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

            //ArrayList<Object> listaObjetos
            while (rs.next()) {

                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                //listaObjetos.add(fila)
                modelo.addRow(fila);
            }

            tablaVisual.setModel(modelo);

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Actualizar_EliminarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return listaObjetos
    }

    public static void consultarFila(String tabla, String columnaId, Object valorId, Connection con, javax.swing.JTable tablaVisual) {

        try {
            String sql = "SELECT * FROM " + tabla + " WHERE " + columnaId + " = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, valorId);

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int columnas = meta.getColumnCount();

            javax.swing.table.DefaultTableModel modelo
                    = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }

            tablaVisual.setModel(modelo);

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LeerDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void consultarSQL(String sql, Connection con, JTable tablaVisual) {
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
            }

            tablaVisual.setModel(modelo);

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void consultarFilaCompuesta(
            String tabla,
            String columna1,
            int valor1,
            String columna2,
            int valor2,
            Connection con,
            JTable jTable) {

        try {

            String sql = "SELECT * FROM " + tabla
                    + " WHERE " + columna1 + " = ? AND " + columna2 + " = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, valor1);
            ps.setInt(2, valor2);

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (int i = 1; i <= columnas; i++) {
                model.addColumn(meta.getColumnName(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[columnas];

                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }

                model.addRow(fila);
            }

            jTable.setModel(model);

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
