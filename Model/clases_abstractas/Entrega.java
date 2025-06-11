package clases_abstractas;

import Clases.pedido.Pedido;

public abstract class Entrega {
    protected String direccionEntrega;

    public abstract int tiempoDeEntrega(Pedido pedido);
}
