package Clases.api;

import interfaces.IAdapterDeliveryAPI;

import java.util.Random;

public class ApiRappiAdapter implements IAdapterDeliveryAPI {
    public int tiempoDeViaje() {
        return new Random().nextInt(11) + 10; // Simula entre 10 y 20 mins de demora
    }
}
