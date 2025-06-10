package Clases.pedido;

import Clases_Abstractas.ProductoMenu;

public class PedidoManager {
    //Singleton
    private static PedidoManager instancia;



    private PedidoManager() {
    }

    public static PedidoManager getInstance() {
        if (instancia == null) {
            instancia = new PedidoManager();
        }
        return instancia;
    }

    public static void agregarProducto(ProductoMenu producto, Pedido pedido) {
        pedido.getProductos().add(producto);
    }

    public static void eliminarProducto(ProductoMenu producto, Pedido pedido) {
        pedido.getProductos().remove(producto);
    }


}
