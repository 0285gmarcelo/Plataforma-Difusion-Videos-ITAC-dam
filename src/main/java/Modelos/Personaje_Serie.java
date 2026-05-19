package Modelos;

import Excepciones.TipoPersonajeException;

/**
 *
 * @author isard
 */
public class Personaje_Serie implements Interfaces.InterfazJSON {

    private int codigo_Serie;
    private int codigo_Actor;
    private String nombre;
    private String tipo;
    private int episodios;
    private String duracion;

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

    public int getCodigo_Serie() {
        return codigo_Serie;
    }

    public int getCodigo_Actor() {
        return codigo_Actor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return codigo_Serie + ";" + codigo_Actor + ";" + nombre + ";" + tipo + ";" + episodios + ";" + duracion;
    }

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
