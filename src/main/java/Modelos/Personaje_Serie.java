package Modelos;

import Excepciones.TipoPersonajeException;

/**
 *
 * @author isard
 */
public class Personaje_Serie {

    private int codigo_Serie;
    private int codigo_Actor;
    protected String nombre;
    protected String tipo;
    protected int episodios;
    protected String duracion;

    public Personaje_Serie(String nombre, String tipo, int episodios, String duracion) throws TipoPersonajeException {
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

    public void setCodigo_Serie(int codigo_Serie) {
        this.codigo_Serie = codigo_Serie;
    }

    public int getCodigo_Actor() {
        return codigo_Actor;
    }

    public void setCodigo_Actor(int codigo_Actor) {
        this.codigo_Actor = codigo_Actor;
    }

}
