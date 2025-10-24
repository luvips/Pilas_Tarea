package com.ejercicio1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String urlInicial="www.Google.com.mx";
        String urlCambio;
        int opcion;
        boolean salida=false;
        Scanner scr = new Scanner(System.in);
        Navegacion nav= new Navegacion(urlInicial);
        System.out.println("Bienvenido a Google");
        while (salida!=false) {


            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Visitar una nueva URL");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. Ver estado actual");
            System.out.println("5. Salir");
            opcion = scr.nextInt();
            scr.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe la URL a moverte ");
                    urlCambio = scr.nextLine();
                    nav.visitar(urlCambio);

                    break;
                case 2:
                    nav.retroceder();

                    break;
                case 3:
                    nav.avanzar();

                    break;
                case 4:
                    nav.mostrarEstado();
                    break;
                case 5:
                    salida=true;
                    break;
                default:
                    System.out.println("Selecciona una opción valida por favor");
                    break;
            }

        }
    }
}