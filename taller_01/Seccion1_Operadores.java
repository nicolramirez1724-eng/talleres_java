package com.taller.practico;

public class Seccion1_Operadores {
    public static void main(String[] args) {
        System.out.println("===== SECCIÓN 1: OPERADORES =====");

        // Fila 1
        int seg = 86400 % 3600;
        System.out.println("86400 % 3600 -> seg = " + seg);                 // 0

        // Fila 2 (x parte en 7)
        int x = 7;
        int y = ++x + x++;
        System.out.println("++x + x++ -> y = " + y + ", x = " + x);          // y = 16, x = 9

        // Fila 3
        double div1 = 15 / 2;      // división entera (7) promovida a double -> 7.0
        double div2 = 15.0 / 2;    // división real -> 7.5
        System.out.println("div1 = " + div1 + ", div2 = " + div2);

        // Fila 4 (x vuelve a partir en 7, flag = false)
        x = 7;
        boolean flag = false;
        boolean res = flag && (++x > 0);   // cortocircuito: ++x NO se ejecuta
        System.out.println("flag && (++x > 0) -> res = " + res + ", x = " + x); // false, 7
        System.out.println();
    }
}
