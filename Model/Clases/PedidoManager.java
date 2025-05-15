package Clases;

import Clases_Abstractas.ProductoMenu;

public class PedidoManager {

    public void agregarProducto(Pedido pedido, ProductoMenu producto) {
        if (producto != null) {
            pedido.getProductos().add(producto);
        }
    }

    public void eliminarProducto(Pedido pedido, ProductoMenu producto) {
        if (producto != null) {
            pedido.getProductos().remove(producto);
        }
    }
}
