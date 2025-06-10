package Clases.ModalidadEntrega;

import Clases.pedido.Pedido;
import Clases_Abstractas.Entrega;

public class Presencial extends Entrega {
    @Override
    public int tiempoDeEntrega(Pedido pedido) {
        return 0;
    }
}
