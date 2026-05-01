package Modelos;

import java.util.Date;

/**
 *
 * @author isard
 */
public class Actor {

    private int codigo;
    protected String nombre;
    protected Date fecha_Nacimiento;
    protected String lugar_Residencia;
    protected String nacionalidad;

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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
