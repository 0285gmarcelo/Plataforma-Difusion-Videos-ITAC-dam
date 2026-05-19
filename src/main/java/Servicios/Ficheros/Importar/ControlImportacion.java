/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.Ficheros.Importar;

import java.util.HashSet;
import java.util.Set;
import Excepciones.*;
/**
 *
 * @author isard
 */
public class ControlImportacion {

    private static final Set<String> importadas = new HashSet<>();

    public static void comprobar(String tabla) throws YaImportadoException {
        if (importadas.contains(tabla)) {
            throw new YaImportadoException("La tabla " + tabla + " ya fue importada");
        }
        importadas.add(tabla);
    }
}
