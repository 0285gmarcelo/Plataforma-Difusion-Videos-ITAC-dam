package Modelos;

import Excepciones.TipoPersonajeException;

/**
 *
 * @author isard
 */
public class Personaje_Película implements Interfaces.InterfazJSON{

    private int codigo_Pelicula;
    private int codigo_Actor;
    private String nombre;
    private String tipo;

    public Personaje_Película(int codigo_Pelicula,int codigo_Actor,String nombre, String tipo) throws TipoPersonajeException {
        this.codigo_Pelicula = codigo_Pelicula;
        this.codigo_Actor = codigo_Actor;
        this.nombre = nombre;
        this.tipo = tipo;
        if (!this.tipo.equalsIgnoreCase("Principal") || !this.tipo.equalsIgnoreCase("Secundario") || !this.tipo.equalsIgnoreCase("Cameo")) {
            throw new TipoPersonajeException("ERROR: El personaje debe ser de tipo Principal, Secundario o Cameo.");
        }
    }

    public int getCodigo_Pelicula() {
        return codigo_Pelicula;
    }

    public int getCodigo_Actor() {
        return codigo_Actor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return codigo_Pelicula + ";" + codigo_Actor + ";" + nombre + ";" + tipo;
    }

    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo_Pelicula\":" + getCodigo_Pelicula()+ ",\n"
                + "\"codigo_Serie\":" + getCodigo_Actor()+ ",\n"
                + "\"nombre\":" + getNombre()+ ",\n"
                + "\"tipo\":" + getTipo()+ ",\n"
                + "}"
                ;
    }
    
    

}
