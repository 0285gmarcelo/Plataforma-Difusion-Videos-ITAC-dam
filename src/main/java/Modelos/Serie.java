package Modelos;

/**
 * Clase que representa una Serie dentro del sistema.
 *
 * Esta clase modela la entidad Serie correspondiente a la tabla Serie
 * de la base de datos.
 *
 * Cada objeto Serie almacena información básica como:
 * - código identificador único
 * - título de la serie
 * - creador
 * - años de emisión
 * - número de temporadas
 * - número de episodios
 *
 * Además, incluye métodos getter/setter y métodos de exportación
 * en formato texto y JSON.
 *
 * Implementa la interfaz InterfazJSON para permitir la exportación en JSON.
 *
 * @author Carlos
 */
public class Serie  implements Interfaces.InterfazJSON{

    // Atributos
    private int codigo;
    private String titulo;
    private String creador;
    private String anyos_Emision;
    private int temporadas;
    private int episodios;

    // Constructor
    public Serie(int codigo, String titulo, String creador, String anyos_Emision, int temporadas, int episodios) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.creador = creador;
        this.anyos_Emision = anyos_Emision;
        this.temporadas = temporadas;
        this.episodios = episodios;

    }

    // Metodos
    
    // Getters del codigo
    public int getCodigo() {
        return codigo;
    }

    // Getters y Setters de titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    // Getters y Setters del creador
    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
    
    // Getters y Setters del anyo_emision
    public String getAnyos_Emision() {
        return anyos_Emision;
    }

    public void setAnyos_Emision(String anyos_Emision) {
        this.anyos_Emision = anyos_Emision;
    }

    // Getters y Setters de las temporadas
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Getters y Setters de los episodios
    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // Método de para exportacion
    @Override
    public String toString() {
        return codigo + ";" + titulo + ";" + creador + ";" + anyos_Emision + ";" + temporadas + ";" + episodios;
    }

    //Implementacion de exportacion JSON
    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo\":" + getCodigo()+ ",\n"
                    + "\"titulo\":" + getTitulo()+ ",\n"
                    + "\"creador\":" + getCreador()+ ",\n"
                    + "\"anyo de emision\":" + getAnyos_Emision()+ ",\n"
                    + "\"temporada\":" + getTemporadas()+ ",\n"
                    + "\"episodios\":" + getEpisodios()
                    + "}"
                    ;
    }

    

}
