package Modelos;

/**
 *
 * @author isard
 */
public class Serie {

    private int codigo;
    protected String titulo;
    protected String creador;
    protected String anyos_Emision;
    protected int temporadas;
    protected int episodios;

    public Serie(int codigo, String titulo, String creador, String anyos_Emision, int temporadas, int episodios) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.creador = creador;
        this.anyos_Emision = anyos_Emision;
        this.temporadas = temporadas;
        this.episodios = episodios;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
