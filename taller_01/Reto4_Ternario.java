package com.taller.practico;

public class Reto4_Ternario {
    public static void main(String[] args) {
        System.out.println("===== REFACTORIZACIÓN: OPERADOR TERNARIO =====");
        boolean cookieSesionActiva = true;
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Estado de conexión: " + estadoConexion);
        System.out.println();
    }
}
