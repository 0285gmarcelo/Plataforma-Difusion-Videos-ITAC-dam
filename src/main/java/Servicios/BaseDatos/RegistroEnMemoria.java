/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.util.ArrayList;
import java.util.List;

/**
 *Clase que actúa como almacenamiento en memoria de registros de inserción
 * 
 * @author Andre
 */
public class RegistroEnMemoria {
    
    // Lista estática que guarda todos los registros de tipo RegistroInsert
    // Es static, por lo que pertenece a la clase y no a instancias
    public static List<RegistroInsert> inserts = new ArrayList<>();
    
    // Método estático para añadir un nuevo registro a la lista en memoria
    public static void addInsert(String tabla, String datos) {
        // Crea un nuevo objeto RegistroInsert con los datos recibidos
        // y lo añade a la lista
        inserts.add(new RegistroInsert(tabla, datos));
    }
    
    // Método estático para obtener todos los registros almacenados en memoria
    public static List<RegistroInsert> getInserts() {
        return inserts;
    }
}
