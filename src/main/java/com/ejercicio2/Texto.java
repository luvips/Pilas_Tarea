package com.ejercicio2;

public class Texto {
    private StringBuilder texto ;

    public Texto (){
        this.texto = new StringBuilder();
    }


    public void insertar (int posicion, String textoInsertado){
        if (posicion > texto.length()){
            posicion= texto.length();
        }
        texto.insert(posicion,textoInsertado);
    }

    public void borrar(int posicion, int longitud) {
        int fin = Math.min(posicion + longitud, texto.length());
        if (posicion > fin) {
            return;
        }
        texto.delete(posicion, fin);
    }

    public String getSubtexto(int posicion, int longitud) {
        int fin = Math.min(posicion + longitud, texto.length());
        if (posicion > fin) {
            return "";
        }
        return texto.substring(posicion, fin);
    }

    @Override
    public String toString() {
        return texto.toString();
    }
}
