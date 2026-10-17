package com.taller.practico;

public class Ejercicio4_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                continue;
            }
            if (i % 5 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
