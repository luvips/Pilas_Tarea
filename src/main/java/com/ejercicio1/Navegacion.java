package com.ejercicio1;

import java.util.Stack;

public class Navegacion {

    // Pila para las páginas "detrás" de la página actual
    private Stack<String> pilaAtras;

    // Pila para las páginas "adelante" de la página actual
    private Stack<String> pilaAdelante;

    // La URL de la página que el usuario está viendo en este momento
    private String paginaActual;


    public Navegacion(String paginaInicio) {
        this.pilaAtras = new Stack<>();
        this.pilaAdelante = new Stack<>();
        this.paginaActual = paginaInicio;

    }


    public void visitar(String url) {
        System.out.println("Visitando: " + url);


        if (this.paginaActual != null) {
            this.pilaAtras.push(this.paginaActual);
        }


        this.paginaActual = url;

        if (!this.pilaAdelante.isEmpty()) {
            System.out.println("Limpiando historial 'Adelante'...");
            this.pilaAdelante.clear();
        }
    }


    public void retroceder() {

        if (pilaAtras.isEmpty()) {
            System.out.println("No se puede retroceder más.");
            return;
        }


        this.pilaAdelante.push(paginaActual);


        this.paginaActual=this.pilaAtras.pop();

        System.out.println("Retrocediendo a: " + this.paginaActual);
    }


    public void avanzar() {



        if (pilaAdelante.isEmpty()){
            System.out.println("No hay más Paginas");
            return;
        }
        this.pilaAtras.push(paginaActual);
        this.paginaActual=this.pilaAdelante.pop();


        System.out.println("Avanzando a: " + this.paginaActual);
    }


    public void mostrarEstado() {
        System.out.println("--- Estado del Historial ---");
        System.out.println("Pila Atrás: " + pilaAtras);
        System.out.println("Página Actual: " + paginaActual);
        System.out.println("Pila Adelante: " + pilaAdelante);
        System.out.println("-----------------------------");
    }
}
