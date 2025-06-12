package Clases.calculador;

import Clases.pedido.Pedido;
import clases_abstractas.CalculadorTiempoStrategy;

public class CalculadorTiempoListo extends CalculadorTiempoStrategy {
    @Override
    public int calcularTiempoRestante(Pedido pedido) {
        return pedido.getEntrega().tiempoDeEntrega();
    }
}

