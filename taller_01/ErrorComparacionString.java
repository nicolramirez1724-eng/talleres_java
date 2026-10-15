package com.taller.practico;

public class ErrorComparacionString {
    public static void main(String[] args) {
        String proveedor1 = new String("OneTrust");   // objeto nuevo en el heap
        String proveedor2 = "OneTrust";               // literal en el String pool

        // ERROR ORIGINAL: proveedor1 == proveedor2
        //   '==' compara REFERENCIAS (direcciones de memoria), y son objetos distintos.
        // CORRECCIÓN: equals() compara el CONTENIDO.
        if (proveedor1.equals(proveedor2)) {
            System.out.println("Los proveedores coinciden exactamente.");
        } else {
            System.out.println("Los proveedores son distintos.");
        }
    }
}
