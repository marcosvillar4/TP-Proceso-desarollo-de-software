package Clases;

import java.util.*;
import Clases_Abstractas.ProductoMenu;
import Enum.EstadoPedido;

public class Pedido {

    public Pedido() {
    }

    private List<ProductoMenu> productos;

    private Boolean confirmado;

    public Float calcularTotal() {
        // TODO implement here
        return null;
    }

    public void confirmarPedido() {
        // TODO implement here
    }

    public boolean estaConfirmado() {
        return confirmado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {

    }
}
