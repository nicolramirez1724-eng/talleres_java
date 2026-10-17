package com.taller.practico;

import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Ingrese un número entero positivo N (máximo 20): ");
            n = sc.nextInt();
            if (n < 1 || n > 20) {
                System.out.println("Error: N debe estar entre 1 y 20 para evitar desbordamiento.");
            }
        } while (n < 1 || n > 20);

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("\nParte A");
        System.out.println(n + "! = " + factorial);

        System.out.println("\nParte B");
        for (int fila = 1; fila <= n; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        sc.close();
    }
}
