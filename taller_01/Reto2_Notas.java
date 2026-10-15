package com.taller.practico;

public class Reto2_Notas {
    public static void main(String[] args) {
        System.out.println("===== RETO 2: APROBACIÓN DE NOTAS Y ASISTENCIA =====");
        double[] notas = {85.0, 65.0, 75.0, 50.0};
        int[] asistencias = {90, 70, 70, 95};
        boolean[] proyectos = {true, true, false, true};

        for (int i = 0; i < notas.length; i++) {
            double calificacionFinal = notas[i];
            int porcentajeAsistencia = asistencias[i];
            boolean entregoProyectoFinal = proyectos[i];

            String dictamen;
            if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
                dictamen = "Aprobado";
            } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
                dictamen = "Pendiente de Examen Extraordinario";
            } else {
                dictamen = "Reprobado";
            }
            System.out.println("Nota: " + calificacionFinal + " | Asistencia: " + porcentajeAsistencia
                    + "% | Proyecto: " + entregoProyectoFinal + " -> Dictamen: " + dictamen);
        }
        System.out.println();
    }
}
