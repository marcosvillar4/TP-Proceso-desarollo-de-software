package Clases;

import Interfaces.IPagable;

public class TarjetaDebito implements IPagable {
    @Override
    public boolean pagar(float monto) {
        // Implementación del pago con tarjeta de débito
        System.out.println("Pagando $" + monto + " con tarjeta de débito.");
        return true;
    }
}
