package com.taller.practico;

public class ErrorAsignacion {
    public static void main(String[] args) {
        boolean cookieActiva = false;

        // ERROR ORIGINAL: if (cookieActiva = true)
        //   '=' ASIGNA true a la variable (y la expresión vale true), por lo que
        //   siempre entra al primer bloque. Se necesita '==' (comparación)
        //   o, mejor aún, usar directamente la variable booleana.
        // CORRECCIÓN:
        if (cookieActiva == true) {          // equivalente y más limpio: if (cookieActiva)
            System.out.println("Estado de sesión: Sesión del usuario activa.");
        } else {
            System.out.println("Estado de sesión: Sesión inactiva.");
        }
    }
}
