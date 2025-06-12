package Clases.pago;

import interfaces.IPagable;

public class Efectivo implements IPagable {

    @Override
    public boolean pagar(float monto) {
        System.out.println();
        return true;
    }
}
