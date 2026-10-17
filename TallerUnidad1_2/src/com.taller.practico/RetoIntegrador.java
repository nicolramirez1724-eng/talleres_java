package com.taller.practico;

public class RetoIntegrador {

    public static void main(String[] args) {
        System.out.println("=== Caso de Prueba A ===");
        calcularFactura(3, "VIP", "PROMO1 año");

        System.out.println("=== Caso de Prueba B ===");
        calcularFactura(1, "NUEVO", "PROMO1 año");
    }

    static void calcularFactura(int cantidad, String tipoCliente, String cupon) {
        double subtotalBase = cantidad * 250.00;

        double porcentajeDescuento;
        switch (tipoCliente) {
            case "VIP":
                porcentajeDescuento = 0.20;
                break;
            case "REGULAR":
                porcentajeDescuento = 0.10;
                break;
            case "NUEVO":
                porcentajeDescuento = 0.05;
                break;
            default:
                porcentajeDescuento = 0.0;
                break;
        }

        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;

        double descuentoCupon;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double totalFinal = baseImponible + iva;

        System.out.printf("Subtotal base: $%.2f%n", subtotalBase);
        System.out.printf("Descuento %s: -$%.2f%n", tipoCliente, descuentoCliente);
        System.out.printf("Subtotal con descuento: $%.2f%n", subtotalConDescuento);
        System.out.printf("Descuento por cupón: -$%.2f%n", descuentoCupon);
        System.out.printf("Base imponible: $%.2f%n", baseImponible);
        System.out.printf("IVA (16%%): +$%.2f%n", iva);
        System.out.printf("Total a pagar = $%.2f%n", totalFinal);
        System.out.println();
    }
}
