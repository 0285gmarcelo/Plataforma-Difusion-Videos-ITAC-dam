/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Validaciones;

import Modelos.*;
import Excepciones.DatoInvalidoException;
import Excepciones.TipoPersonajeException;
import java.time.LocalDate;
/**
 * Esta clase esta encargada de validar los datos antes de insertarlos
 * en la base de datos
 * 
 * Contiene metodos para validar:
 * - Actores
 * - Peliculas
 * - Series
 * - Personajes Series
 * - Personajes Pelicula
 * 
 * Tambien utiliza expresiones regulares para comprobar el formatos validos
 * 
 * Lanza excepciones personalizadas cuano los datos no son correctos
 * 
 * @author Carlos y Andre
 */
public class Validaciones {

// ================= REGEX =================
    /**
     * REGEX_SOLO_LETRAS permite unicamente letras y espacios
     */
    private static final String REGEX_SOLO_LETRAS
            = "[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+";
    /**
     * REGEX_TEXTO permite texto general con letras,
     * numeros y algunos simbolos
     */
    private static final String REGEX_TEXTO
            = "[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 .,:;()\\-]+";
    /**
     * REGEX_SOLO_NUMEROS permite unicamente numeros.
     */
    private static final String REGEX_SOLO_NUMEROS
            = "[0-9]+";

// ================= ACTOR (CAMPOS) =================
    /**
     * Validar el numero del actor.
     * 
     * @param nombre: el nombre del actor 
     */
    public static void validarNombreActor(String nombre) {
        //Se comprueba si esta vacio
        if (nombre == null || nombre.isBlank()) {
            throw new DatoInvalidoException("Nombre del actor vacío.");
        }
        //Se comprueba si el formato es valido
        if (!nombre.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El nombre del actor no es válido.");
        }
    }
    /**
     * Validar el lugar de residencia
     * 
     * @param residencia: El lugar de residencia
     */
    public static void validarResidencia(String residencia) {
        //Se comprueba si esta vacio
        if (residencia == null || residencia.isBlank()) {
            
            throw new DatoInvalidoException("Residencia vacía.");
        }
        //Se comprueba si el formato es valido
        if (!residencia.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Residencia no válida.");
        }
    }
    /**
     * Validar la nacionalidad
     * 
     * @param nacionalidad: la nacionalidad del actor
     */
    public static void validarNacionalidad(String nacionalidad) {
        //Se comprueba si esta vacio
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new DatoInvalidoException("Nacionalidad vacía.");
        }
        //Se comprueba si el formato es valido
        if (!nacionalidad.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Nacionalidad no válida.");
        }
    }
    /**
     * Validar la fecha de nacimiento
     * 
     * @param fecha: la fecha de nacimiento del actor 
     */
    public static void validarFechaNacimiento(LocalDate fecha) {
        //Se comprueba si exsiste la fecha
        if (fecha == null) {
            throw new DatoInvalidoException("Fecha de nacimiento obligatoria.");
        }
        //Se comprueba que no sea futura
        if (fecha.isAfter(LocalDate.of(2026, 12, 31))) {
            throw new DatoInvalidoException("Fecha de nacimiento inválida.");
        }
    }

// ================= PELÍCULA =================
    /**
     * Validar el titulo
     * 
     * @param titulo: el titulo de la pelicula o serie
     */
    public static void validarTitulo(String titulo) {
        //Se comprueba si esta vacio
        if (titulo == null || titulo.isBlank()) {
            throw new DatoInvalidoException("Título vacío.");
        }
    }
    /**
     * Validar el director de una pelicula
     * 
     * @param director:El nombre del director 
     */
    public static void validarDirector(String director) {
        //Se comprueba si esta vacio
        if (director == null || director.isBlank()) {
            throw new DatoInvalidoException("Director vacío.");
        }
        //Se comprueba si el formato es valido
        if (!director.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El nombre del director no es válido.");
        }
    }
    /**
     * Validar el año de estreno
     * 
     * @param anyo:El año de estreno 
     */
    public static void validarAnyo(int anyo) {

        // Se comprueba si esta vacio
        if (String.valueOf(anyo).isBlank()) {
            throw new DatoInvalidoException("Año vacío.");
        }
        // Se comprueba el rango valido
        if (anyo < 1888 || anyo > 2026) {
            throw new DatoInvalidoException("Año fuera de rango.");
        }
    }
    /**
     * Validar la duracion
     * 
     * @param duracion:La duracion en minutos 
     */
    public static void validarDuracion(int duracion) {

        // Se comprueba si esta vacio
        if (String.valueOf(duracion).isBlank()) {
            throw new DatoInvalidoException("Duración vacía.");
        }
        // Se comprueba que el rango sea valido
        if (duracion <= 0) {
            throw new DatoInvalidoException("Duración inválida.");
        }
    }

// ================= SERIE =================
    /**
     * Validar el creador de la serie
     * 
     * @param creador;El  nombre del creador 
     */
    public static void validarCreador(String creador) {
         // Se comprueba si esta vacio
        if (creador == null || creador.isBlank()) {
            throw new DatoInvalidoException("Creador vacío.");
        }
        //Se comprueba si el formato es valido
        if (!creador.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El creador solo puede contener letras.");
        }
    }
    /**
     * Validar los años de emisión
     * 
     * @param aniosEmision :El año de emision
     */
    public static void validarAniosEmision(String aniosEmision) {
        // Se comprueba si esta vacio
        if (aniosEmision == null || aniosEmision.isBlank()) {
            throw new DatoInvalidoException("Años de emisión vacío.");
        }
        //Se comprueba si el formato es valido
        if (!aniosEmision.matches(REGEX_SOLO_NUMEROS)) {
            throw new DatoInvalidoException("Años de emisión debe contener solo números.");
        }
    }
    /**
     * Validar el numero de temporadas
     * 
     * @param temporadas:El numero de temporadas
     */
    public static void validarTemporadas(int temporadas) {

        // Se comprueba si esta vacio
        if (String.valueOf(temporadas).isBlank()) {
            throw new DatoInvalidoException("Temporadas vacías.");
        }
        // Se comprueba que el rango sea valido
        if (temporadas <= 0) {
            throw new DatoInvalidoException("Temporadas no válidas.");
        }
    }
    /**
     * Validar el numero de episodios.
     * 
     * @param episodios :El numero de episodios
     */
    public static void validarEpisodios(int episodios) {

        // Se comprueba si esta vacio
        if (String.valueOf(episodios).isBlank()) {
            throw new DatoInvalidoException("Episodios vacíos.");
        }
        // Se comprueba que el rango sea valido
        if (episodios <= 0) {
            throw new DatoInvalidoException("Episodios no válidos.");
        }
    }

// ================= PERSONAJES =================
    /**
     * Validar el nombre de un personaje
     * 
     * @param nombre:El nombre del personaje 
     */
    public static void validarNombrePersonaje(String nombre) {
        // Se comprueba si esta vacio
        if (nombre == null || nombre.isBlank()) {
            throw new DatoInvalidoException("Nombre del personaje vacío.");
        }
        //Se comprueba si el formato es valido
        if (!nombre.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Nombre del personaje no válido.");
        }
    }

// ================= TIPO PERSONAJE PELÍCULA =================
    /**
     * Validar el tipo de personaje de pelicula
     * 
     * @param tipo;El tipo del personaje 
     */
    public static void validarTipoPersonaje(String tipo) {
        // Se comprueba si esta vacio
        if (tipo == null || tipo.isBlank()) {
            throw new TipoPersonajeException("Tipo vacío.");
        }
        //Se comprueba los tipos permitidos
        if (!tipo.equalsIgnoreCase("Principal")
                && !tipo.equalsIgnoreCase("Secundario")
                && !tipo.equalsIgnoreCase("Cameo")) {
            throw new TipoPersonajeException("Tipo de personaje inválido.");
        }
    }

// ================= TIPO PERSONAJE SERIE =================
    /**
     * Validar el tipo de personaje de serie
     * 
     * @param tipo:El tipo de personaje 
     */
    public static void validarTipoPersonajeSerie(String tipo) {
        // Se comprueba si esta vacio
        if (tipo == null || tipo.isBlank()) {
            throw new TipoPersonajeException("Tipo vacío.");
        }
        //Se comprueba los tipos permitidos
        if (!tipo.equalsIgnoreCase("Principal")
                && !tipo.equalsIgnoreCase("Recurrente")
                && !tipo.equalsIgnoreCase("Invitado")) {
            throw new TipoPersonajeException("Tipo de personaje inválido.");
        }
    }

// ================= PERSONAJE SERIE =================
    
    /**
     * Validar el duracion textual de un personaje
     * 
     * @param duracion:La duracion textual
     */
    public static void validarDuracionPersonajeSerie(String duracion) {
        // Se comprueba si esta vacio
        if (duracion == null || duracion.isBlank()) {
            throw new DatoInvalidoException("Duración vacía.");
        }
        //Se comprueba si el formato es valido
        if (duracion.matches(REGEX_SOLO_NUMEROS)) {
            throw new DatoInvalidoException("La duración debe ser texto.");
        }
        //Se comprueba si el formato es valido
        if (!duracion.matches(REGEX_TEXTO)) {
            throw new DatoInvalidoException("Duración no válida.");
        }
    }
    /**
     * Validar episodios del personaje de serie
     * 
     * @param episodios:El numero de episodios 
     */
    public static void validarEpisodiosPersonajeSerie(int episodios) {

        // Se comprueba si esta vacio
        if (String.valueOf(episodios).isBlank()) {
            throw new DatoInvalidoException("Episodios vacíos.");
        }
        // Se comprueba que el rango sea valido
        if (episodios < 0) {
            throw new DatoInvalidoException("Episodios inválidos.");
        }
    }

// ================= MODELOS COMPLETOS =================
    /**
     * Validar todos los datos de un actor
     * 
     * @param actor:El actor a validar 
     */
    public static void validarActor(Actor actor) {
        validarNombreActor(actor.getNombre());
        validarFechaNacimiento(actor.getFecha_Nacimiento());
        validarResidencia(actor.getLugar_Residencia());
        validarNacionalidad(actor.getNacionalidad());
    }
    /**
     * Validar todos los datos de una pelicula
     * 
     * @param p:La pelicula a validar 
     */
    public static void validarPelicula(Pelicula p) {
        validarTitulo(p.getTitulo());
        validarDirector(p.getDirector());
        validarAnyo(p.getAnyo_estreno());
        validarDuracion(p.getDuracion());
    }
    /**
     * Validar todos los datos de una serie
     * 
     * @param s:La serie a validar 
     */
    public static void validarSerie(Serie s) {
        validarTitulo(s.getTitulo());
        validarCreador(s.getCreador());
        validarAniosEmision(s.getAnyos_Emision());
        validarTemporadas(s.getTemporadas());
        validarEpisodios(s.getEpisodios());
    }
    /**
     * Validar todas los datos de personaje de peliculas
     * 
     * @param pp:El personaje pelicula 
     */
    public static void validarPersonajePelicula(Personaje_Pelicula pp) {
        validarNombrePersonaje(pp.getNombre());
        validarTipoPersonaje(pp.getTipo());
    }
    /**
     * Validar todas los datos de un personje de pelicula
     * 
     * @param ps:El personaje serie 
     */
    public static void validarPersonajeSerie(Personaje_Serie ps) {
        validarNombrePersonaje(ps.getNombre());
        validarTipoPersonajeSerie(ps.getTipo());
        validarEpisodiosPersonajeSerie(ps.getEpisodios());
        validarDuracionPersonajeSerie(ps.getDuracion());
    }
}
