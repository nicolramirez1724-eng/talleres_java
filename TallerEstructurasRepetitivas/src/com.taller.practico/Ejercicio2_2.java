package com.taller.practico;

import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long saldo = 0;
        int opcion;

        do {
            System.out.println("\n1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Retiro");
            System.out.println("4. Salir del Sistema");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo es: $" + saldo);
                    break;
                case 2:
                    System.out.print("Monto a depositar: ");
                    long deposito = sc.nextLong();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Monto inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Monto a retirar: ");
                    long retiro = sc.nextLong();
                    if (retiro <= 0) {
                        System.out.println("Monto inválido.");
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro realizado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
