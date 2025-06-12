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
        if(pedido.getEstado() == EstadoPedido.EN_ESPERA || pedido.getEstado() == EstadoPedido.PROGRAMADO) {
            pedido.getProductos().add(producto);
        } else{
            System.out.println("Solo se pueden agregar productos si el estado es del pedido está EN ESPERA o PROGRAMADO");
        }
    }

    public static void eliminarProducto(ProductoMenu producto, Pedido pedido) {
        pedido.getProductos().remove(producto);
    }

    public boolean cancelarPedido(Pedido pedido){
        if(pedido.getEstado() == EstadoPedido.EN_ESPERA){
            float montoReembolso = pedido.getTotal() * 0.75f;

            //Simulacion reembolso
            System.out.println("Reembolso de 75%: $" + montoReembolso);
            pedido.setEstado(EstadoPedido.CANCELADO);

            return true;
        } else if (pedido.getEstado() == EstadoPedido.EN_PREPARACION){
            //Simulacion cobro adicional
            float costoExtra = 0;
            for (ProductoMenu producto: pedido.getProductos()) {
                costoExtra += producto.getPrecio();
            }

            System.out.println("Cobro extra: $" + costoExtra);
            pedido.setEstado(EstadoPedido.CANCELADO);
            return true;
        }
        System.out.println("El pedido solo es cancelable si se encuentra en preparación o en espera. Actualmente: " + pedido.getEstado());
        return false;
    }

}
