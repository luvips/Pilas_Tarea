package com.ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Texto editor = new Texto();
        GestorDeshacer gestor = new GestorDeshacer();
        Scanner scanner = new Scanner(System.in);


        System.out.println("--- Mini Editor de Texto ---");
        System.out.println("Escribe texto y presiona Enter para añadirlo.");
        System.out.println("Escribe 'z' y presiona Enter para DESHACER.");
        System.out.println("Escribe 'y' y presiona Enter para REHACER.");
        System.out.println("Escribe 'q' y presiona Enter para SALIR.");
        System.out.println("---------------------------------");


        while (true) {

            System.out.println("\n--- Texto actual: [" + editor.toString() + "]");
            System.out.print("> ");

            String input = scanner.nextLine();



            // equalsIgnoreCase no distingue mayúsculas/minúsculas
            if (input.equalsIgnoreCase("z")) {
                // DESHACER (HU-04)
                gestor.deshacer();

            } else if (input.equalsIgnoreCase("y")) {
                // REHACER (HU-05)
                gestor.rehacer();

            } else if (input.equalsIgnoreCase("q")) {
                // SALIR
                System.out.println("¡Adiós!");
                break;

            } else {
                // Si no es un comando, es TEXTO PARA INSERTAR

                // Calculamos la posición (siempre al final)
                int posicion = editor.toString().length();

                // Inserción
                Comando cmd = new Insertar(editor, input, posicion);


                gestor.ejecutarComando(cmd);
            }
        }


        scanner.close();
    }
}