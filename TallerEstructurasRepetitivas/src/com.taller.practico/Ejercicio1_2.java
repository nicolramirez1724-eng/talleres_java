package com.taller.practico;

import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long acumulado = 0;
        long limite = 1000000;
        boolean procesando = true;
        String causa = "";

        while (procesando) {
            System.out.print("Ingrese el monto de la transacción: ");
            long monto = sc.nextLong();

            if (monto < 0) {
                procesando = false;
                causa = "Monto negativo";
            } else {
                acumulado += monto;
                if (acumulado > limite) {
                    procesando = false;
                    causa = "Se superó el límite de $1'000.000";
                }
            }
        }

        System.out.println("Saldo final acumulado: $" + acumulado);
        System.out.println("Causa de finalización: " + causa);
        sc.close();
    }
}
