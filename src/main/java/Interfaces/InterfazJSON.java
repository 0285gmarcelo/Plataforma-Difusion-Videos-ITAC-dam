/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 * Interfaz genérica utilizada para convertir objetos a formato JSON.
 *
 * La interfaz obliga a que cualquier clase que la implemente
 * tenga un método llamado diseñoJSON().
 *
 * El objetivo es:
 * - Estandarizar la generación de JSON
 * - Facilitar exportaciones a ficheros .json
 * - Permitir que distintas clases generen su propia estructura JSON
 *
 * La <T> indica que es una interfaz genérica y puede adaptarse
 * a distintos tipos de objetos.
 *
 * @param <T> tipo de objeto que implementará la interfaz
 *
 * @author Carlos
 */
public interface InterfazJSON<T> {
    
     /**
     * Genera una representación del objeto en formato JSON.
     *
     * Cada clase implementará este método según su estructura.
     *
     * @return cadena de texto en formato JSON
     */
   public String diseñoJSON();
}
