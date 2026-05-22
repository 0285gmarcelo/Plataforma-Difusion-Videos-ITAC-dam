/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Importar;

import java.util.HashSet;
import java.util.Set;
import Excepciones.*;
/**
 * Clase encargada de controlar las importaciones realizadas.
 * 
 * Su función es evitar que una misma tabla se importe
 * más de una vez durante la ejecución del programa.
 * 
 * Para ello utiliza un Set, ya que esta colección
 * no permite elementos repetidos.
 * 
 * @author Andre
 */
public class ControlImportacion {
   /**
     * Set que almacena el nombre de las tablas
     * que ya han sido importadas.
     * 
     * static -> pertenece a la clase y se comparte.
     * final -> no puede cambiar de referencia.
     */
    private static final Set<String> importadas = new HashSet<>();
    /**
     * Método que comprueba si una tabla ya fue importada.
     * 
     * Funcionamiento:
     * 1. Comprueba si el nombre de la tabla existe en el Set.
     * 2. Si ya existe, lanza la excepción personalizada
     *    YaImportadoException.
     * 3. Si no existe, añade la tabla al Set.
     *
     * @param tabla:El nombre de la tabla a comprobar
     * @throws YaImportadoException excepción lanzada
     * cuando la tabla ya fue importada anteriormente
     */
    public static void comprobar(String tabla) throws YaImportadoException {
        if (importadas.contains(tabla)) {
            throw new YaImportadoException("La tabla " + tabla + " ya fue importada");
        }
        importadas.add(tabla);
    }
}
