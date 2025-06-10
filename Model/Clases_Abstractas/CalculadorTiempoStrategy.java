package Clases_Abstractas;

import Clases.pedido.Pedido;

public abstract class CalculadorTiempoStrategy {
    public abstract int calcularTiempoRestante(Pedido pedido);
}
