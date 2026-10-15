package com.taller.practico;

public class Seccion4_RetoIntegrador {

    public static void main(String[] args) {
        System.out.println("===== SECCIÓN 4: RETO INTEGRADOR =====");
        System.out.println("--- Caso de Prueba A (esperado: 638.00) ---");
        facturar(3, "VIP", "PROMO1 año");
        System.out.println("--- Caso de Prueba B (esperado: 275.50) ---");
        facturar(1, "NUEVO", "PROMO1 año");
        System.out.println();
    }

    static void facturar(int cantidad, String tipoCliente, String cupon) {
        final double COSTO_UNITARIO = 250.00;

        // 1. Subtotal base
        double subtotalBase = cantidad * COSTO_UNITARIO;

        // 2. Descuento por categoría (switch)
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

        // 3. Cupón (if-else con operador lógico)
        double descuentoCupon;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        // 4. Impuestos y total
        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double total = baseImponible + iva;

        System.out.printf("Subtotal base: $%.2f%n", subtotalBase);
        System.out.printf("Descuento %s (%.0f%%): -$%.2f -> Subtotal con descuento: $%.2f%n",
                tipoCliente, porcentajeDescuento * 100, descuentoCliente, subtotalConDescuento);
        System.out.printf("Descuento por cupón: -$%.2f%n", descuentoCupon);
        System.out.printf("Base imponible: $%.2f%n", baseImponible);
        System.out.printf("IVA (16%%): +$%.2f%n", iva);
        System.out.printf("Total a pagar = $%.2f%n", total);
    }
}
