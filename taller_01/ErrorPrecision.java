package com.taller.practico;

public class ErrorPrecision {
    public static void main(String[] args) {
        int tareasCompletadas = 3;
        int tareasTotales = 4;

        // ERROR ORIGINAL: (tareasCompletadas / tareasTotales) es división ENTERA: 3/4 = 0,
        // y luego 0 * 100 = 0.0.
        // CORRECCIÓN: convertir (cast) un operando a double ANTES de dividir.
        double porcentajeAvance = ((double) tareasCompletadas / tareasTotales) * 100;

        System.out.println("El porcentaje de avance es: " + porcentajeAvance + "%");
    }
}
