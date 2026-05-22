package Modelos;

import Excepciones.TipoPersonajeException;

/**
 * Clase que representa la relación entre una Película y un Actor,
 * indicando el personaje que interpreta el actor dentro de la película.
 *
 * Esta clase funciona como una entidad intermedia que conecta:
 * - una película (codigo_Pelicula)
 * - un actor (codigo_Actor)
 *
 * Además almacena información adicional como:
 * - nombre del personaje
 * - tipo de personaje (principal, secundario, etc.)
 *
 * Implementa la interfaz InterfazJSON para exportación en formato JSON.
 *
 * @author isard
 */
public class Personaje_Pelicula implements Interfaces.InterfazJSON {

    //Atributos
    private int codigo_Pelicula;
    private int codigo_Actor;
    private String nombre;
    private String tipo;
    
    //Constructor
    public Personaje_Pelicula(int codigo_Pelicula,
            int codigo_Actor,
            String nombre,
            String tipo) throws TipoPersonajeException {

        this.codigo_Pelicula = codigo_Pelicula;
        this.codigo_Actor = codigo_Actor;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //Metodos
    
    //Getters del codigo de pelicula
    public int getCodigo_Pelicula() {
        return codigo_Pelicula;
    }

    //Getters del codigo de actor
    public int getCodigo_Actor() {
        return codigo_Actor;
    }
    
    // Getter y setter de nombre
    public String getNombre() {
        return nombre;
    }

    // Getter y setter del tipo
    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método de para exportacion
    @Override
    public String toString() {
        return codigo_Pelicula + ";" + codigo_Actor + ";" + nombre + ";" + tipo;
    }

    //Implementacion de exportacion JSON
    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo_Pelicula\":" + getCodigo_Pelicula() + ",\n"
                + "\"codigo_Serie\":" + getCodigo_Actor() + ",\n"
                + "\"nombre\":" + getNombre() + ",\n"
                + "\"tipo\":" + getTipo() + ",\n"
                + "}";
    }

}
