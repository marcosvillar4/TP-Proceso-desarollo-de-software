package clases_abstractas;

import Clases.entidades.Cliente;
import Clases.pedido.Pedido;
import Clases.pedido.PedidoFactory;

public abstract class Plataforma {

    private String nombre;
    private static PedidoFactory pedidoFactory;


    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public String getClassType() {
        return this.getClass().getTypeName();
    }

    public Pedido generarPedido(Cliente cliente) {
        Pedido pedido = pedidoFactory.crearPedido(this.getClass().cast(this.getClassType()), cliente);
        System.out.println("Pedido creado desde el " + this.getClass().getSimpleName() + " para: " + cliente.getNombreCompleto());
        return pedido;
    }
}
