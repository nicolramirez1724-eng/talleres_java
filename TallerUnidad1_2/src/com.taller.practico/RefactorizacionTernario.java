package com.taller.practico;

public class RefactorizacionTernario {

    public static void main(String[] args) {
        boolean cookieSesionActiva = true;

        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";

        System.out.println("Estado de conexión: " + estadoConexion);
    }
}
