package Clases.modalidad_entrega;

import Clases.pedido.Pedido;
import clases_abstractas.Entrega;
import Clases.api.ApiRappiAdapter;
import interfaces.IAdapterDeliveryAPI;

public class Delivery extends Entrega {

    private IAdapterDeliveryAPI apiRappiAdapter = new ApiRappiAdapter();

    @Override
    public int tiempoDeEntrega() {
        return apiRappiAdapter.tiempoDeViaje();
    }
}