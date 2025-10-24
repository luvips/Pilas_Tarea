package com.ejercicio2;

public class Insertar implements Comando {

    private Texto editor;
    private String textoAInsertar;
    private int posicion;

    public Insertar(Texto editor, String textoAInsertar, int posicion) {
        this.editor = editor;
        this.textoAInsertar = textoAInsertar;
        this.posicion = posicion;
    }

    @Override
    public void ejecutar() {
        editor.insertar(posicion, textoAInsertar);
    }

    @Override
    public void deshacer() {
        editor.borrar(posicion, textoAInsertar.length());
    }

    @Override
    public boolean agrupar(Comando siguienteComando) {
        if (!(siguienteComando instanceof Insertar)) {
            return false;
        }

        Insertar cmdInsertar = (Insertar) siguienteComando;

        boolean posicionCoincide = (this.posicion + this.textoAInsertar.length()) == cmdInsertar.posicion;

        if (posicionCoincide) {
            this.textoAInsertar += cmdInsertar.textoAInsertar;
            return false;
        }

        return false;
    }
}
