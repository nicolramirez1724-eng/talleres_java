package com.taller.practico;

public class Reto2Notas {

    public static void main(String[] args) {
        evaluarEstudiante(85.0, 90, true);
        evaluarEstudiante(70.0, 80, false);
        evaluarEstudiante(65.0, 70, true);
        evaluarEstudiante(85.0, 60, true);
        evaluarEstudiante(55.0, 95, true);
        evaluarEstudiante(75.0, 70, false);
    }

    static void evaluarEstudiante(double calificacionFinal, int porcentajeAsistencia, boolean entregoProyectoFinal) {
        String estado;

        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            estado = "Aprobado";
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            estado = "Pendiente de Examen Extraordinario";
        } else {
            estado = "Reprobado";
        }

        System.out.println("Calificación final: " + calificacionFinal);
        System.out.println("Asistencia: " + porcentajeAsistencia + "%");
        System.out.println("Entregó proyecto final: " + entregoProyectoFinal);
        System.out.println("Dictamen académico: " + estado);
        System.out.println();
    }
}
