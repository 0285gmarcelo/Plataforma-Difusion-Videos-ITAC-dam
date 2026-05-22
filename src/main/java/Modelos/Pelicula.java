package Modelos;

/**
 * Clase que representa una Película dentro del sistema.
 *
 * Esta clase modela la entidad Pelicula correspondiente a la tabla Pelicula
 * de la base de datos.
 *
 * Cada objeto Pelicula almacena información básica como:
 * - código identificador único
 * - título de la película
 * - director
 * - año de estreno
 * - duración en minutos
 *
 * Además, incluye métodos getter/setter y métodos de exportación
 * en formato texto y JSON.
 *
 * Implementa la interfaz InterfazJSON para garantizar la exportación en JSON.
 *
 * @author Carlos
 */
public class Pelicula implements Interfaces.InterfazJSON{
    
//Atributos
    private int codigo;
    private String titulo;
    private String director;
    private int anyo_estreno;
    private int duracion;

    
    //Constructores
    public Pelicula(int codigo, String titulo, String director, int anyo_entero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.anyo_estreno = anyo_entero;
        this.duracion = duracion;

    }

    //Metodos
    
    //Getters del codigo
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

    // Getters y Setters de Director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getters y Setters de Anyo_estreno
    public int getAnyo_estreno() {
        return anyo_estreno;
    }

    public void setAnyo_estreno(int anyo_entero) {
        this.anyo_estreno = anyo_entero;
    }

    // Getters y Setters de durecion
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // Método de para exportacion
    public String datosPelicula() {
        return  codigo + ";" + titulo + ";" + director + ";"+ anyo_estreno + ";"+ duracion;
    }

    //Implementacion de exportacion JSON
    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo\":" + getCodigo() + ",\n"
                + "\"titulo\":" + getTitulo()+ ",\n"
                + "\"director\":" + getDirector()+ ",\n"
                + "\"anyo de estreno\":" + getAnyo_estreno()+ ",\n"
                + "\"duracion\":" + getDuracion()
                + "}"
                ;
    }
    
    

}
