package com.taller.practico;

import java.util.Scanner;

public class Seccion3_Switch {

    public static void main(String[] args) {
        System.out.println("===== SECCIÓN 3: GESTOR DE DÍAS DE LA SEMANA =====");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número del día (1=Lunes ... 7=Domingo): ");
        int dia = sc.hasNextInt() ? sc.nextInt() : 1;
        System.out.println("(día evaluado: " + dia + ")");

        System.out.println("Switch tradicional -> " + jornadaTradicional(dia));
        System.out.println("Switch moderno     -> " + jornadaModerna(dia));
        System.out.println();
    }

    // Versión 1: switch tradicional con case, break y default
    static String jornadaTradicional(int dia) {
        String nombreDia;
        String jornada;
        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                jornada = "Jornada laboral";
                break;
            case 2:
                nombreDia = "Martes";
                jornada = "Jornada laboral";
                break;
            case 3:
                nombreDia = "Miércoles";
                jornada = "Jornada laboral";
                break;
            case 4:
                nombreDia = "Jueves";
                jornada = "Jornada laboral";
                break;
            case 5:
                nombreDia = "Viernes";
                jornada = "Jornada laboral";
                break;
            case 6:
                nombreDia = "Sábado";
                jornada = "Fin de semana (descanso / guardia opcional)";
                break;
            case 7:
                nombreDia = "Domingo";
                jornada = "Fin de semana (descanso)";
                break;
            default:
                nombreDia = "Desconocido";
                jornada = "Día inválido: ingrese un número entre 1 y 7";
                break;
        }
        return nombreDia + " -> " + jornada;
    }

    // Versión 2: switch moderno (expresión con flecha, sin break)
    static String jornadaModerna(int dia) {
        final String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Desconocido";
        };
        final String jornada = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Jornada laboral";
            case 6 -> "Fin de semana (descanso / guardia opcional)";
            case 7 -> "Fin de semana (descanso)";
            default -> "Día inválido: ingrese un número entre 1 y 7";
        };
        return nombreDia + " -> " + jornada;
    }
}
