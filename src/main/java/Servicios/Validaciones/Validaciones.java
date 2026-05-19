/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Validaciones;

import Excepciones.DatoInvalidoException;
import Excepciones.TipoPersonajeException;
import Modelos.*;
import java.time.LocalDate;

import Excepciones.DatoInvalidoException;
import Excepciones.TipoPersonajeException;
import Modelos.*;
import java.time.LocalDate;

public class Validaciones {

// ================= REGEX =================
    private static final String REGEX_SOLO_LETRAS
            = "[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+";

    private static final String REGEX_TEXTO
            = "[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 .,:;()\\-]+";

    private static final String REGEX_SOLO_NUMEROS
            = "[0-9]+";

// ================= ACTOR (CAMPOS) =================
    public static void validarNombreActor(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DatoInvalidoException("Nombre del actor vacío.");
        }

        if (!nombre.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El nombre del actor no es válido.");
        }
    }

    public static void validarResidencia(String residencia) {
        if (residencia == null || residencia.isBlank()) {
            throw new DatoInvalidoException("Residencia vacía.");
        }

        if (!residencia.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Residencia no válida.");
        }
    }

    public static void validarNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new DatoInvalidoException("Nacionalidad vacía.");
        }

        if (!nacionalidad.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Nacionalidad no válida.");
        }
    }

    public static void validarFechaNacimiento(LocalDate fecha) {
        if (fecha == null) {
            throw new DatoInvalidoException("Fecha de nacimiento obligatoria.");
        }

        if (fecha.isAfter(LocalDate.of(2026, 12, 31))) {
            throw new DatoInvalidoException("Fecha de nacimiento inválida.");
        }
    }

// ================= PELÍCULA =================
    public static void validarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new DatoInvalidoException("Título vacío.");
        }
    }

    public static void validarDirector(String director) {
        if (director == null || director.isBlank()) {
            throw new DatoInvalidoException("Director vacío.");
        }

        if (!director.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El nombre del director no es válido.");
        }
    }

    public static void validarAnyo(int anyo) {

        // ✔ añadido null/blank lógico
        if (String.valueOf(anyo).isBlank()) {
            throw new DatoInvalidoException("Año vacío.");
        }

        if (anyo < 1888 || anyo > 2026) {
            throw new DatoInvalidoException("Año fuera de rango.");
        }
    }

    public static void validarDuracion(int duracion) {

        // ✔ añadido null/blank lógico
        if (String.valueOf(duracion).isBlank()) {
            throw new DatoInvalidoException("Duración vacía.");
        }

        if (duracion <= 0) {
            throw new DatoInvalidoException("Duración inválida.");
        }
    }

// ================= SERIE =================
    public static void validarCreador(String creador) {
        if (creador == null || creador.isBlank()) {
            throw new DatoInvalidoException("Creador vacío.");
        }

        if (!creador.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("El creador solo puede contener letras.");
        }
    }

    public static void validarAniosEmision(String aniosEmision) {
        if (aniosEmision == null || aniosEmision.isBlank()) {
            throw new DatoInvalidoException("Años de emisión vacío.");
        }

        if (!aniosEmision.matches(REGEX_SOLO_NUMEROS)) {
            throw new DatoInvalidoException("Años de emisión debe contener solo números.");
        }
    }

    public static void validarTemporadas(int temporadas) {

        // ✔ añadido
        if (String.valueOf(temporadas).isBlank()) {
            throw new DatoInvalidoException("Temporadas vacías.");
        }

        if (temporadas <= 0) {
            throw new DatoInvalidoException("Temporadas no válidas.");
        }
    }

    public static void validarEpisodios(int episodios) {

        // ✔ añadido
        if (String.valueOf(episodios).isBlank()) {
            throw new DatoInvalidoException("Episodios vacíos.");
        }

        if (episodios <= 0) {
            throw new DatoInvalidoException("Episodios no válidos.");
        }
    }

// ================= PERSONAJES =================
    public static void validarNombrePersonaje(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DatoInvalidoException("Nombre del personaje vacío.");
        }

        if (!nombre.matches(REGEX_SOLO_LETRAS)) {
            throw new DatoInvalidoException("Nombre del personaje no válido.");
        }
    }

// ================= TIPO PERSONAJE PELÍCULA =================
    public static void validarTipoPersonaje(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new TipoPersonajeException("Tipo vacío.");
        }

        if (!tipo.equalsIgnoreCase("Principal")
                && !tipo.equalsIgnoreCase("Secundario")
                && !tipo.equalsIgnoreCase("Cameo")) {
            throw new TipoPersonajeException("Tipo de personaje inválido.");
        }
    }

// ================= TIPO PERSONAJE SERIE =================
    public static void validarTipoPersonajeSerie(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new TipoPersonajeException("Tipo vacío.");
        }

        if (!tipo.equalsIgnoreCase("Principal")
                && !tipo.equalsIgnoreCase("Recurrente")
                && !tipo.equalsIgnoreCase("Invitado")) {
            throw new TipoPersonajeException("Tipo de personaje inválido.");
        }
    }

// ================= PERSONAJE SERIE =================
    public static void validarDuracionPersonajeSerie(String duracion) {
        if (duracion == null || duracion.isBlank()) {
            throw new DatoInvalidoException("Duración vacía.");
        }

        if (duracion.matches(REGEX_SOLO_NUMEROS)) {
            throw new DatoInvalidoException("La duración debe ser texto.");
        }

        if (!duracion.matches(REGEX_TEXTO)) {
            throw new DatoInvalidoException("Duración no válida.");
        }
    }

    public static void validarEpisodiosPersonajeSerie(int episodios) {

        // ✔ añadido
        if (String.valueOf(episodios).isBlank()) {
            throw new DatoInvalidoException("Episodios vacíos.");
        }

        if (episodios < 0) {
            throw new DatoInvalidoException("Episodios inválidos.");
        }
    }

// ================= MODELOS COMPLETOS =================
    public static void validarActor(Actor actor) {
        validarNombreActor(actor.getNombre());
        validarFechaNacimiento(actor.getFecha_Nacimiento());
        validarResidencia(actor.getLugar_Residencia());
        validarNacionalidad(actor.getNacionalidad());
    }

    public static void validarPelicula(Pelicula p) {
        validarTitulo(p.getTitulo());
        validarDirector(p.getDirector());
        validarAnyo(p.getAnyo_estreno());
        validarDuracion(p.getDuracion());
    }

    public static void validarSerie(Serie s) {
        validarTitulo(s.getTitulo());
        validarCreador(s.getCreador());
        validarAniosEmision(s.getAnyos_Emision());
        validarTemporadas(s.getTemporadas());
        validarEpisodios(s.getEpisodios());
    }

    public static void validarPersonajePelicula(Personaje_Pelicula pp) {
        validarNombrePersonaje(pp.getNombre());
        validarTipoPersonaje(pp.getTipo());
    }

    public static void validarPersonajeSerie(Personaje_Serie ps) {
        validarNombrePersonaje(ps.getNombre());
        validarTipoPersonajeSerie(ps.getTipo());
        validarEpisodiosPersonajeSerie(ps.getEpisodios());
        validarDuracionPersonajeSerie(ps.getDuracion());
    }
}
