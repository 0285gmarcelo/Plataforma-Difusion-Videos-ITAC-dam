package Modelos;

import Interfaces.InterfazPrueba;
import java.util.Date;

/**
 *
 * @author isard
 */
public class Actor {

    private int codigo;
    private String nombre;
    private Date fecha_Nacimiento;
    private String lugar_Residencia;
    private String nacionalidad;
    
    public Actor(){
        
    }
    
    public Actor(int codigo, String nombre, Date fecha_Nacimiento, String lugar_Residencia, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.lugar_Residencia = lugar_Residencia;
        this.nacionalidad = nacionalidad;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getLugar_Residencia() {
        return lugar_Residencia;
    }

    public void setLugar_Residencia(String lugar_Residencia) {
        this.lugar_Residencia = lugar_Residencia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

   
    public String datosActor() {
        return  codigo + ";" + nombre + ";" + fecha_Nacimiento + ";" + lugar_Residencia + ";" + nacionalidad;
    }
    
    

}
