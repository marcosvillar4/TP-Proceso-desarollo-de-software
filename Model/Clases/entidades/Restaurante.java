package Clases.entidades;

import java.util.LinkedList;

import Clases.pedido.Pedido;
public class Restaurante {
    private static Restaurante instancia = new Restaurante("Desarrollini de Softwarini");
    private String nombreRestaurante;
    private LinkedList<Pedido> pedidos = new LinkedList<>();

    private Restaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public static Restaurante getInstancia() {
        return instancia;
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public int getCantidadPedidos() {
        return pedidos.size();
    }
}

