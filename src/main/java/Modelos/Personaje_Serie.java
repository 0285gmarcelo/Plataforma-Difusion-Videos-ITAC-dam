package Modelos;

import Excepciones.TipoPersonajeException;

/**
 *
 * @author isard
 */
public class Personaje_Serie {

    private int codigo_Serie;
    private int codigo_Actor;
    private String nombre;
    private String tipo;
    private int episodios;
    private String duracion;

    public Personaje_Serie(int codigo_Actor,int codigo_Serie,String nombre, String tipo, int episodios, String duracion) throws TipoPersonajeException {
        this.codigo_Actor = codigo_Actor;
        this.codigo_Serie = codigo_Serie;
        this.nombre = nombre;
        this.tipo = tipo;
        this.episodios = episodios;
        this.duracion = duracion;

        if (!this.tipo.equalsIgnoreCase("Principal") || !this.tipo.equalsIgnoreCase("Recurrente") || !this.tipo.equalsIgnoreCase("Invitado")) {
            throw new TipoPersonajeException("ERROR: El personaje debe ser de tipo Principal, Recurrente o Invitado.");
        }
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
    
    

}
