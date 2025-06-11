package Clases.pago;

import interfaces.IPagable;

import java.util.Random;

public class MercadoPago implements IPagable {

    @Override
    public boolean pagar(float monto) {
        Random rand = new Random();
        System.out.println("Link de pago: https://mercadopago.com/pago/" + rand.nextInt(100000, 99999999));
        System.out.println("Pagando $" + monto + " con Mercado Pago");
        return true;
    }
}
