/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción personalizada utilizada para indicar
 * que un dato introducido no es válido.
 *
 * Esta excepción se usa principalmente en las validaciones
 * de:
 * - actores
 * - películas
 * - series
 * - personajes pelicula
 * - personajes serie
 *
 * Hereda de RuntimeException, por lo que no es obligatorio
 * capturarla con try-catch.
 *
 * Ejemplo:
 * - nombre vacío
 * - duración negativa
 * - fecha incorrecta
 *
 * @author Andre
 */
public class DatoInvalidoException extends RuntimeException{
    
    /**
     * Constructor de la excepción.
     *
     * @param message mensaje descriptivo del error
     */
    public DatoInvalidoException(String message) {
        super(message);
    }
    
}
