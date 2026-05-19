/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

/**
 *
 * @author isard
 */
public class RegistroInsert {

    private String tabla;
    private String datos;

    public RegistroInsert(String tabla, String datos) {
        this.tabla = tabla;
        this.datos = datos;
    }

    public String getTabla() {
        return tabla;
    }

    public String getDatos() {
        return datos;
    }
}
