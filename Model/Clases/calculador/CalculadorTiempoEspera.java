package Clases.calculador;

import Clases.entidades.Restaurante;
import Clases.pedido.Pedido;
import clases_abstractas.CalculadorTiempoStrategy;

public class CalculadorTiempoEspera extends CalculadorTiempoStrategy {
    @Override
    public int calcularTiempoRestante(Pedido pedido) {
        int pedidosTotales = Restaurante.getInstancia().getCantidadPedidos();
        return (pedidosTotales >= 10) ? 20 : 5;
    }
}

