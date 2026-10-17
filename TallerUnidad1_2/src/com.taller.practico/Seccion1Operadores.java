package com.taller.practico;

public class Seccion1Operadores {

    public static void main(String[] args) {
        int x = 7;
        boolean flag = false;

        int seg = 86400 % 3600;
        System.out.println("int seg = 86400 % 3600; -> seg = " + seg);

        int y = ++x + x++;
        System.out.println("int y = ++x + x++; -> y = " + y + ", x = " + x);

        double div1 = 15 / 2;
        double div2 = 15.0 / 2;
        System.out.println("double div1 = 15 / 2; -> div1 = " + div1);
        System.out.println("double div2 = 15.0 / 2; -> div2 = " + div2);

        x = 7;
        boolean res = flag && (++x > 0);
        System.out.println("boolean res = flag && (++x > 0); -> res = " + res + ", x = " + x);
    }
}
