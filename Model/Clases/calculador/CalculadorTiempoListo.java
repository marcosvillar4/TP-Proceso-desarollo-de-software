package Clases.calculador;

import Clases.pedido.Pedido;
import Clases.api.ApiRappiAdapter;
import Clases_Abstractas.CalculadorTiempoStrategy;

public class CalculadorTiempoListo extends CalculadorTiempoStrategy {
    @Override
    public int calcularTiempoRestante(Pedido pedido) {
        return pedido.getEntrega().tiempoDeEntrega(pedido);
    }
}

