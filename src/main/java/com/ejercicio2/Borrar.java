package com.ejercicio2;

public class Borrar implements Comando {

    private Texto editor;
    private String textoBorrado;
    private int posicion;
    private int longitud;

    public Borrar(Texto editor, int posicion, int longitud) {
        this.editor = editor;
        this.posicion = posicion;
        this.longitud = longitud;
    }

    @Override
    public void ejecutar() {
        this.textoBorrado = editor.getSubtexto(posicion, longitud);
        editor.borrar(posicion, longitud);
    }

    @Override
    public void deshacer() {
        editor.insertar(posicion, textoBorrado);
    }

    @Override
    public boolean agrupar(Comando siguienteComando) {
        return false;
    }
}