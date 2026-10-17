package com.educacion.ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String[] palabras = {"JAVA", "CLASE", "OBJETO", "VARIABLE", "BUCLE", "METODO",
            "COMPILADOR", "CADENA", "ARREGLO", "INTELLIJ", "PROGRAMA", "CONSTANTE"};

    static String nombreJugador = "";
    static int partidas = 0;
    static int victorias = 0;
    static int derrotas = 0;
    static double puntajeTotal = 0;
    static double mejorPuntaje = 0;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("      AHORCADO DE CONSOLA");
            System.out.println("==============================");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadisticas");
            System.out.println("3. Salir");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    verEstadisticas();
                    break;
                case 3:
                    System.out.println("Gracias por jugar, hasta pronto!");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    public static int leerOpcion() {
        int opcion = 0;
        boolean valida = false;

        while (!valida) {
            System.out.print("Elija una opcion (1-3): ");
            String linea = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(linea);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.println("Error: la opcion debe ser 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero, no \"" + linea + "\".");
            }
        }
        return opcion;
    }

    public static void pedirNombre() {
        String nombre = "";
        while (nombre.length() == 0) {
            System.out.print("Ingrese su nombre: ");
            nombre = sc.nextLine().trim().toUpperCase();
            if (nombre.length() == 0) {
                System.out.println("Error: el nombre no puede estar vacio.");
            }
        }
        nombreJugador = nombre;
    }

    public static void jugar() {
        if (nombreJugador.length() == 0) {
            pedirNombre();
        }

        Random random = new Random();
        String palabra = palabras[random.nextInt(palabras.length)];

        int longitud = palabra.length();
        final int MAX_INTENTOS;
        if (longitud <= 4) {
            MAX_INTENTOS = 5;
        } else if (longitud <= 6) {
            MAX_INTENTOS = 6;
        } else if (longitud <= 8) {
            MAX_INTENTOS = 7;
        } else {
            MAX_INTENTOS = 8;
        }

        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 0.0;
        boolean juegoGanado = false;
        boolean rendido = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int fallos = 0;
        int turnos = 0;

        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            mascara.append("_");
            if (i < longitud - 1) {
                mascara.append(" ");
            }
        }
        StringBuilder historial = new StringBuilder();

        System.out.println("\nSuerte " + nombreJugador + "! La palabra tiene " + longitud
                + " letras y tienes " + MAX_INTENTOS + " intentos.");
        System.out.println("Escriba una letra por turno o RENDIRSE para abandonar.");

        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\nPalabra: " + mascara);
            if (historial.length() == 0) {
                System.out.println("Letras usadas: ninguna");
            } else {
                System.out.println("Letras usadas: " + historial);
            }
            System.out.println("Intentos restantes: " + intentosRestantes + " / " + MAX_INTENTOS);

            if (intentosRestantes == 1) {
                System.out.println("PISTA: la palabra empieza con la letra " + palabra.substring(0, 1));
            }

            System.out.print("Ingrese una letra: ");
            String entrada = sc.nextLine().trim();

            if (entrada.length() == 0) {
                System.out.println("Error: no ingreso nada.");
                continue;
            }

            if (entrada.equalsIgnoreCase("RENDIRSE")) {
                rendido = true;
                break;
            }

            if (entrada.length() > 1) {
                System.out.println("Error: ingrese solo una letra.");
                continue;
            }

            ultimaLetra = Character.toUpperCase(entrada.charAt(0));

            if (!Character.isLetter(ultimaLetra)) {
                System.out.println("Error: \"" + entrada + "\" no es una letra.");
                continue;
            }

            if (historial.indexOf(String.valueOf(ultimaLetra)) != -1) {
                System.out.println("Ya habia intentado la letra " + ultimaLetra + ".");
                continue;
            }

            historial.append(ultimaLetra).append(" ");
            turnos++;

            boolean acierto = false;
            for (int i = 0; i < longitud; i++) {
                String letraPalabra = String.valueOf(palabra.charAt(i));
                if (letraPalabra.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, ultimaLetra);
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                intentosRestantes--;
                fallos++;
            }

            System.out.println(acierto ? "Bien! La letra " + ultimaLetra + " esta en la palabra."
                    : "Fallaste! La letra " + ultimaLetra + " no esta en la palabra.");

            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;
            }
        }

        if (juegoGanado) {
            double bonoVelocidad = Math.max(0, longitud * 2 - turnos) * 2.5;
            double bonoSinFallos = 0;
            if (fallos == 0) {
                bonoSinFallos = 25;
            }
            puntaje = 100.0 + intentosRestantes * 10 + bonoVelocidad + bonoSinFallos;
        } else {
            puntaje = aciertos * 5.0;
        }

        partidas++;
        if (juegoGanado) {
            victorias++;
        } else {
            derrotas++;
        }
        puntajeTotal += puntaje;
        if (puntaje > mejorPuntaje) {
            mejorPuntaje = puntaje;
        }

        String estado;
        if (juegoGanado) {
            estado = "VICTORIA!";
        } else if (rendido) {
            estado = "RENDICION";
        } else {
            estado = "DERROTA";
        }

        double porcentaje = 0;
        if (turnos > 0) {
            porcentaje = (double) aciertos / turnos * 100;
        }

        System.out.printf("%n====================================================%n");
        System.out.printf("RESUMEN DE LA PARTIDA%n");
        System.out.printf("====================================================%n");
        System.out.printf("Jugador: %s%n", nombreJugador);
        System.out.printf("Estado Final: %s%n", estado);
        System.out.printf("Palabra Secreta: %s%n", palabra);
        System.out.printf("Intentos Restantes: %d / %d%n", intentosRestantes, MAX_INTENTOS);
        System.out.printf("Porcentaje Aciertos: %.2f%%%n", porcentaje);
        System.out.printf("Puntaje Final: %.2f pts%n", puntaje);
        System.out.printf("====================================================%n");
    }

    public static void verEstadisticas() {
        System.out.printf("%n====================================================%n");
        System.out.printf("ESTADISTICAS DE LA SESION%n");
        System.out.printf("====================================================%n");
        if (partidas == 0) {
            System.out.printf("Todavia no ha jugado ninguna partida.%n");
        } else {
            System.out.printf("Partidas jugadas: %d%n", partidas);
            System.out.printf("Victorias: %d%n", victorias);
            System.out.printf("Derrotas: %d%n", derrotas);
            System.out.printf("Puntaje acumulado: %.2f pts%n", puntajeTotal);
            System.out.printf("Mejor puntaje: %.2f pts%n", mejorPuntaje);
            System.out.printf("Porcentaje de victorias: %.2f%%%n", (double) victorias / partidas * 100);
        }
        System.out.printf("====================================================%n");
    }
}
