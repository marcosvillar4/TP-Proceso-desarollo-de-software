package Clases;

import Interfaces.IPagable;
import Clases_Abstractas.Tarjeta;

public class TarjetaCredito extends Tarjeta implements IPagable {

    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvv;
    private String nombreTitular;

    public TarjetaCredito(String numeroTarjeta, String fechaExpiracion, String cvv, String nombreTitular) {
        super(numeroTarjeta, fechaExpiracion, cvv, nombreTitular);
    }

    @Override
    public boolean pagar(float monto) {
        // Implementación del pago con tarjeta de crédito
        System.out.println("Pagando $" + monto + " con tarjeta de crédito.");
        return true;
    }
}

