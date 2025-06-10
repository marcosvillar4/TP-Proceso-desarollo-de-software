package Clases.calculador;

import Clases.pedido.Pedido;
import Clases_Abstractas.CalculadorTiempoStrategy;
import Clases_Abstractas.ProductoMenu;

public class CalculadorTiempoPreparacion extends CalculadorTiempoStrategy {
    @Override
    public int calcularTiempoRestante(Pedido pedido) {
        int tiempoTotal = 0;
        for (ProductoMenu producto : pedido.getProductos()) {
            tiempoTotal += producto.getTiempoPreparacion();
        }
        return tiempoTotal;
    }
}
