package com.taller.practico;

import java.util.Scanner;

public class EjercicioIntegrador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CAPACIDAD = 500;
        int unidadesTotales = 0;
        long valorTotal = 0;
        int registrados = 0;
        int descontinuados = 0;
        int opcion;

        do {
            System.out.println("\n===== ALMACÉN =====");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos productos tiene el lote? ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\nProducto " + i + " de " + n);
                        System.out.print("¿Está descontinuado? (s/n): ");
                        String respuesta = sc.next();

                        if (respuesta.equalsIgnoreCase("s")) {
                            descontinuados++;
                            System.out.println("Producto descontinuado, se omite.");
                            continue;
                        }

                        System.out.print("Precio: ");
                        long precio = sc.nextLong();
                        while (precio <= 0) {
                            System.out.println("El precio debe ser mayor que cero.");
                            System.out.print("Precio: ");
                            precio = sc.nextLong();
                        }

                        System.out.print("Cantidad en stock: ");
                        int stock = sc.nextInt();
                        while (stock <= 0) {
                            System.out.println("La cantidad debe ser mayor que cero.");
                            System.out.print("Cantidad en stock: ");
                            stock = sc.nextInt();
                        }

                        if (unidadesTotales + stock > CAPACIDAD) {
                            System.out.println("ALERTA: sobrecupo, se superó la capacidad de " + CAPACIDAD + " unidades.");
                            break;
                        }

                        unidadesTotales += stock;
                        valorTotal += precio * stock;
                        registrados++;
                    }
                    break;
                case 2:
                    System.out.println("\n===== ESTADO DEL ALMACÉN =====");
                    System.out.println("Productos registrados: " + registrados);
                    System.out.println("Productos descontinuados: " + descontinuados);
                    System.out.println("Unidades en almacén: " + unidadesTotales + " de " + CAPACIDAD);
                    System.out.println("Valor total del inventario: $" + valorTotal);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
