package com.taller.practico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número del día de la semana (1 = Lunes, 7 = Domingo): ");

        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida: debe ingresar un número entero.");
            sc.close();
            return;
        }

        int dia = sc.nextInt();

        System.out.println();
        System.out.println("--- Versión 1: switch tradicional ---");
        jornadaTradicional(dia);

        System.out.println();
        System.out.println("--- Versión 2: switch moderno ---");
        jornadaModerna(dia);

        sc.close();
    }

    static void jornadaTradicional(int dia) {
        String nombreDia;
        String tipoJornada;

        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                tipoJornada = "Jornada laboral";
                break;
            case 2:
                nombreDia = "Martes";
                tipoJornada = "Jornada laboral";
                break;
            case 3:
                nombreDia = "Miércoles";
                tipoJornada = "Jornada laboral";
                break;
            case 4:
                nombreDia = "Jueves";
                tipoJornada = "Jornada laboral";
                break;
            case 5:
                nombreDia = "Viernes";
                tipoJornada = "Jornada laboral";
                break;
            case 6:
                nombreDia = "Sábado";
                tipoJornada = "Fin de semana (descanso)";
                break;
            case 7:
                nombreDia = "Domingo";
                tipoJornada = "Fin de semana (descanso)";
                break;
            default:
                nombreDia = "Desconocido";
                tipoJornada = "Día inválido, debe ingresar un número entre 1 y 7";
                break;
        }

        System.out.println("Día: " + nombreDia);
        System.out.println("Tipo de jornada: " + tipoJornada);
    }

    static void jornadaModerna(int dia) {
        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Desconocido";
        };

        String tipoJornada = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Jornada laboral";
            case 6, 7 -> "Fin de semana (descanso)";
            default -> "Día inválido, debe ingresar un número entre 1 y 7";
        };

        System.out.println("Día: " + nombreDia);
        System.out.println("Tipo de jornada: " + tipoJornada);
    }
}
