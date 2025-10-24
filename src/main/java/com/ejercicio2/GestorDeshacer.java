package com.ejercicio2;
import java.util.Stack;

public class GestorDeshacer {

    private Stack<Comando> pilaDeshacer = new Stack<>();
    private Stack<Comando> pilaRehacer = new Stack<>();

    public void ejecutarComando(Comando comando) {

        if (!pilaDeshacer.isEmpty() && pilaDeshacer.peek().agrupar(comando)) {

            comando.ejecutar();
            pilaRehacer.clear();

        } else {
            comando.ejecutar();
            pilaDeshacer.push(comando);
            pilaRehacer.clear();
        }
    }

    public void deshacer() {
        if (pilaDeshacer.isEmpty()) {
            return;
        }

        Comando comando = pilaDeshacer.pop();
        comando.deshacer();
        pilaRehacer.push(comando);
    }

    public void rehacer() {
        if (pilaRehacer.isEmpty()) {
            return;
        }
        Comando comando = pilaRehacer.pop();
        comando.ejecutar();
        pilaDeshacer.push(comando);
    }
}