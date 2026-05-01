package Modelos;

import Excepciones.TipoPersonajeException;

/**
 *
 * @author isard
 */
public class Personaje_Película {

    private int codigo_Pelicula;
    private int codigo_Actor;
    protected String nombre;
    protected String tipo;

    public Personaje_Película(String nombre, String tipo) throws TipoPersonajeException {
        this.nombre = nombre;
        this.tipo = tipo;
        if (!this.tipo.equalsIgnoreCase("Principal") || !this.tipo.equalsIgnoreCase("Secundario") || !this.tipo.equalsIgnoreCase("Cameo")) {
            throw new TipoPersonajeException("ERROR: El personaje debe ser de tipo Principal, Secundario o Cameo.");
        }
    }

    public int getCodigo_Pelicula() {
        return codigo_Pelicula;
    }

    public void setCodigo_Pelicula(int codigo_Pelicula) {
        this.codigo_Pelicula = codigo_Pelicula;
    }

    public int getCodigo_Actor() {
        return codigo_Actor;
    }

    public void setCodigo_Actor(int codigo_Actor) {
        this.codigo_Actor = codigo_Actor;
    }

}
