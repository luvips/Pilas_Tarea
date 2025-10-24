package com.ejercicio2;

public interface Comando {

    void ejecutar();
    void deshacer();

    boolean agrupar(Comando siguienteComando);
}
