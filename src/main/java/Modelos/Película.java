package Modelos;

/**
 *
 * @author isard
 */
public class Película {

    private int codigo;
    private String titulo;
    private String director;
    private int anyo_entero;
    private int duracion;

    public Película(int codigo, String titulo, String director, int anyo_entero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.anyo_entero = anyo_entero;
        this.duracion = duracion;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo_entero() {
        return anyo_entero;
    }

    public void setAnyo_entero(int anyo_entero) {
        this.anyo_entero = anyo_entero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    

}
