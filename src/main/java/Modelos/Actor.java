package Modelos;


import java.time.LocalDate;


/**
 * Clase que representa la tabla Actor de la base de datos.
 *
 * Cada objeto Actor almacena la información de:
 * - código identificador
 * - nombre
 * - fecha de nacimiento
 * - residencia
 * - nacionalidad
 *
 * También incluye métodos getter/setter y exportación JSON.
 *
 * @author Carlos
 */
public class Actor implements Interfaces.InterfazJSON{
    
    //Atributos
    private int codigo;
    private String nombre;
    private LocalDate fecha_Nacimiento;
    private String lugar_Residencia;
    private String nacionalidad;
    
    
    //Constructores
    public Actor(int codigo, String nombre,LocalDate fecha_Nacimiento, String lugar_Residencia, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.lugar_Residencia = lugar_Residencia;
        this.nacionalidad = nacionalidad;
    }
    
    //Metodos
    
    //Getters del codigo
    public int getCodigo() {
        return codigo;
    }
    
    // Getter y setter de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter de fecha nacimiento
    public LocalDate getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(LocalDate fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    // Getter y setter de residencia
    public String getLugar_Residencia() {
        return lugar_Residencia;
    }

    public void setLugar_Residencia(String lugar_Residencia) {
        this.lugar_Residencia = lugar_Residencia;
    }

    // Getter y setter de nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Método de para exportacion
    public String datosActor() {
        return  codigo + ";" + nombre + ";" + fecha_Nacimiento + ";" + lugar_Residencia + ";" + nacionalidad;
    }

    //Implementacion de exportacion JSON
    @Override
    public String diseñoJSON() {
        return "{" + "\"codigo\":" + getCodigo() + ",\n"
                + "\"nombre\":" + getNombre() + ",\n"
                + "\"fecha_nacimiento\":" + getFecha_Nacimiento() + ",\n"
                + "\"lugar_Residencia\":" + getLugar_Residencia() + ",\n"
                + "\"nacionalidad\":" + getNacionalidad()
                + "}"
                ;
    }
    
    

}
