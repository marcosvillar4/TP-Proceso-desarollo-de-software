package Clases.pedido;

import clases_abstractas.ProductoMenu;
import enums.EstadoPedido;

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
        if(pedido.getEstado() != EstadoPedido.EN_ESPERA) {
            pedido.getProductos().add(producto);
        } else{
            System.out.println("Solo se pueden agregar productos si el estado es del pedido está EN ESPERA");
        }
    }

    public static void eliminarProducto(ProductoMenu producto, Pedido pedido) {
        pedido.getProductos().remove(producto);
    }

    public boolean cancelarPedido(Pedido pedido){
        return pedido.cancelarPedido();
    }

}
