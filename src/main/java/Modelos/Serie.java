package Modelos;

/**
 *
 * @author isard
 */
public class Serie {

    private int codigo;
    private String titulo;
    private String creador;
    private String anyos_Emision;
    private int temporadas;
    private int episodios;

    public Serie() {
    }
    
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getAnyos_Emision() {
        return anyos_Emision;
    }

    public void setAnyos_Emision(String anyos_Emision) {
        this.anyos_Emision = anyos_Emision;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    

}
