package Clases.ModalidadEntrega;

import Clases.pedido.Pedido;
import Clases_Abstractas.Entrega;
import Clases.api.ApiRappiAdapter;

public class Delivery extends Entrega {

    @Override
    public int tiempoDeEntrega(Pedido pedido) {
        return ApiRappiAdapter.tiempoDeViaje(pedido);
    }
}