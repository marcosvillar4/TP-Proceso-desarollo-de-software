package Clases.api;

import Clases.pedido.Pedido;

import java.util.Random;

public class ApiRappiAdapter {
    public static int tiempoDeViaje(Pedido pedido) {
        return new Random().nextInt(11) + 10; // Simula entre 10 y 20 mins de demora
    }
}
