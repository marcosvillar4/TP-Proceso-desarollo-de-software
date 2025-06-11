package Clases.modalidad_entrega;

import Clases.pedido.Pedido;
import clases_abstractas.Entrega;

public class Presencial extends Entrega {
    @Override
    public int tiempoDeEntrega(Pedido pedido) {
        return 0;
    }
}
