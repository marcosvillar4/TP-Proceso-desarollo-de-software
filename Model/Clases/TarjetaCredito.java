package Clases;

import Interfaces.IPagable;

public class TarjetaCredito implements IPagable {
    @Override
    public boolean pagar(float monto) {
        // Implementación del pago con tarjeta de crédito
        System.out.println("Pagando $" + monto + " con tarjeta de crédito.");
        return true;
    }
}

