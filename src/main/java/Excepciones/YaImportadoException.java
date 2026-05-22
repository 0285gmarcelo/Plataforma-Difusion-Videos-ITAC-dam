/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción personalizada utilizada para indicar
 * que una tabla ya ha sido importada previamente.
 *
 * Se usa para evitar importar varias veces
 * el mismo fichero en la base de datos.
 *
 * Ejemplo:
 * - importar actor.txt dos veces
 * - importar pelicula.csv repetidamente
 *
 * Hereda de Exception, por lo que debe ser
 * controlada obligatoriamente mediante try-catch
 * o throws.
 *
 * @author Andre
 */
public class YaImportadoException extends Exception {

    /**
     * Constructor de la excepción.
     *
     * @param message mensaje descriptivo del error
     */
    public YaImportadoException(String message) {
        super(message);
    }

}
