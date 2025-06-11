package Clases.pedido;

import Clases.entidades.Cliente;
import clases_abstractas.Plataforma;

public class PedidoFactory {

    public static Pedido crearPedido(Plataforma plataforma, Cliente cliente){
        if (plataforma == null || cliente == null){
            throw new IllegalArgumentException("Parámetros inválidos para crear un pedido.");
        }

        Pedido pedido = new Pedido(cliente);
        return pedido;
    }
}