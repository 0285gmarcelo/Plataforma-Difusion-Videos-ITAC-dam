package Modelos;

/**
 *
 * @author isard
 */
public class Película {

    private int codigo;
    protected String titulo;
    protected String director;
    protected int anyo_entero;
    protected int duracion;

    public Película(int codigo, String titulo, String director, int anyo_entero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.anyo_entero = anyo_entero;
        this.duracion = duracion;

    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

}
