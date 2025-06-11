package Clases.modalidad_entrega;

import Clases.pedido.Pedido;
import clases_abstractas.Entrega;
import Clases.api.ApiRappiAdapter;

public class Delivery extends Entrega {

    @Override
    public int tiempoDeEntrega(Pedido pedido) {
        return ApiRappiAdapter.tiempoDeViaje(pedido);
    }
}