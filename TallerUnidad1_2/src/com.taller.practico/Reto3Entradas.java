package com.taller.practico;

public class Reto3Entradas {

    public static void main(String[] args) {
        double precioBase = 100.0;

        calcularPrecio("VIP", precioBase);
        calcularPrecio("ESTUDIANTE", precioBase);
        calcularPrecio("GENERAL", precioBase);
        calcularPrecio("ADULTO_MAYOR", precioBase);
    }

    static void calcularPrecio(String tipoEntrada, double precioBase) {
        double montoFinal;

        if (tipoEntrada.equals("VIP")) {
            montoFinal = precioBase + precioBase * 0.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            montoFinal = precioBase - precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            montoFinal = precioBase - precioBase * 0.40;
        } else {
            montoFinal = precioBase;
        }

        System.out.println("Tipo de entrada: " + tipoEntrada);
        System.out.printf("Precio base: $%.2f%n", precioBase);
        System.out.printf("Monto final a pagar: $%.2f%n", montoFinal);
        System.out.println();
    }
}
