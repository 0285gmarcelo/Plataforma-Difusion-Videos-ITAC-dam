package Excepciones;

/**
 * Excepción personalizada utilizada para indicar
 * que el tipo de personaje introducido no es válido.
 *
 * Se utiliza para validar campos como:
 * - Principal
 * - Secundario
 * - Cameo
 * - Recurrente
 * - Invitado
 *
 * Si el texto introducido no coincide con los tipos
 * permitidos, se lanza esta excepción.
 *
 * Hereda de RuntimeException.
 *
 * @author Andre
 */
public class TipoPersonajeException extends RuntimeException {

     /**
     * Constructor de la excepción.
     *
     * @param message mensaje descriptivo del error
     */
    public TipoPersonajeException(String message) {
        super(message);
        //Comentario
    }

}
