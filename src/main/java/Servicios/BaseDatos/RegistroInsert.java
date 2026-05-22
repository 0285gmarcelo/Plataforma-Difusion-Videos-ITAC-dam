/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

/**
 *Clase que representa un registro de insercion en una base de datos
 * 
 * @author Andre
 */
public class RegistroInsert {
    
    // nombre de la tabla donde se hara la inserción
    private String tabla;
    
    // Datos que se quieren insertar en la tabla
    private String datos;
    
    // Constructor de la clase
    // Se usa para inicializar los valores de tabla y datos al crear el objeto
    public RegistroInsert(String tabla, String datos) {
        this.tabla = tabla;
        this.datos = datos;
    }
    
    // Método getter para obtener el nombre de la tabla
    public String getTabla() {
        return tabla;
    }
    
    // Método getter para obtener los datos a insertar
    public String getDatos() {
        return datos;
    }
}
