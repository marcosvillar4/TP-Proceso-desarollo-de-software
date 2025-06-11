package clases_abstractas;

import Clases.pedido.Pedido;

public abstract class CalculadorTiempoStrategy {
    public abstract int calcularTiempoRestante(Pedido pedido);
}
