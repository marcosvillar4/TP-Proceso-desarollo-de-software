package Clases.pago;

import interfaces.IPagable;
import clases_abstractas.Tarjeta;

public class TarjetaDebito extends Tarjeta implements IPagable {

    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvv;
    private String nombreTitular;

    public TarjetaDebito(String numeroTarjeta, String fechaExpiracion, String cvv, String nombreTitular) {
        super(numeroTarjeta, fechaExpiracion, cvv, nombreTitular);
    }

    @Override
    public boolean pagar(float monto) {
        // Implementación del pago con tarjeta de débito
        System.out.println("Pagando $" + monto + " con tarjeta de débito.");
        return true;
    }
}
