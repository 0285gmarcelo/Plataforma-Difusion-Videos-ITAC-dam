package Modelos;

import Excepciones.TipoPersonajeException;

/**
 * Clase que representa la relación entre una Serie y un Actor,
 * indicando el personaje que interpreta el actor dentro de la serie.
 *
 * Esta clase actúa como entidad intermedia entre:
 * - una serie (codigo_Serie)
 * - un actor (codigo_Actor)
 *
 * Además almacena información adicional como:
 * - nombre del personaje
 * - tipo de personaje (principal, secundario, etc.)
 * - número de episodios en los que aparece
 * - duración asociada
 *
 * Implementa la interfaz InterfazJSON para permitir exportación en formato JSON.
 *
 * @author Carlos
 */
public class Personaje_Serie implements Interfaces.InterfazJSON {

    //Atributos
    private int codigo_Serie;
    private int codigo_Actor;
    private String nombre;
    private String tipo;
    private int episodios;
    private String duracion;

    //Constructor 
    public Personaje_Serie(int codigo_Actor,
            int codigo_Serie,
            String nombre,
            String tipo,
            int episodios,
            String duracion) throws TipoPersonajeException {

        this.codigo_Actor = codigo_Actor;
        this.codigo_Serie = codigo_Serie;
        this.nombre = nombre;
        this.episodios = episodios;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    //Metodos
    
    //Codigo de la serie
    public int getCodigo_Serie() {
        return codigo_Serie;
    }

    //Codigo del Actor
    public int getCodigo_Actor() {
        return codigo_Actor;
    }

    // Getter y setter de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter del tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter y setter de los episodios
    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // Getter y setter de la duracion
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    // Método de para exportacion
    @Override
    public String toString() {
        return codigo_Serie + ";" + codigo_Actor + ";" + nombre + ";" + tipo + ";" + episodios + ";" + duracion;
    }

    //Implementacion de exportacion JSON
    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo_Serie\":" + getCodigo_Serie() + ",\n"
                + "\"codigo_Actor\":" + getCodigo_Actor() + ",\n"
                + "\"nombre\":" + getNombre() + ",\n"
                + "\"tipo\":" + getTipo() + ",\n"
                + "\"episodios\":" + getEpisodios() + ",\n"
                + "\"duracion\":" + getDuracion()
                + "}";
    }

}
