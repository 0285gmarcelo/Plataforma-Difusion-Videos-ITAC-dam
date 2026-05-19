/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios.BaseDatos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isard
 */
public class RegistroEnMemoria {

    public static List<RegistroInsert> inserts = new ArrayList<>();

    public static void addInsert(String tabla, String datos) {
        inserts.add(new RegistroInsert(tabla, datos));
    }

    public static List<RegistroInsert> getInserts() {
        return inserts;
    }
}
