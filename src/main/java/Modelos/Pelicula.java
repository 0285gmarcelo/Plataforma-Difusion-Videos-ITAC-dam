package Modelos;

/**
 *
 * @author isard
 */
public class Pelicula implements Interfaces.InterfazJSON{

    private int codigo;
    private String titulo;
    private String director;
    private int anyo_estreno;
    private int duracion;

    public Pelicula(){
        
    }
    
    public Pelicula(int codigo, String titulo, String director, int anyo_entero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.anyo_estreno = anyo_entero;
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

    public int getAnyo_estreno() {
        return anyo_estreno;
    }

    public void setAnyo_estreno(int anyo_entero) {
        this.anyo_estreno = anyo_entero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String datosPelicula() {
        return  codigo + ";" + titulo + ";" + director + ";"+ anyo_estreno + ";"+ duracion;
    }

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
