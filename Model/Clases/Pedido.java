package Clases;

import java.util.*;
import Clases_Abstractas.ProductoMenu;
import Enum.EstadoPedido;

public class Pedido {

    private Cliente cliente;
    private List<ProductoMenu> productos = new ArrayList<>();
    private boolean confirmado;
    private EstadoPedido estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(ProductoMenu producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    public void eliminarProducto(ProductoMenu producto) {
        if (producto != null) {
            productos.remove(producto);
        }
    }
    public float calcularTotal() {
        float total = 0;
        for(ProductoMenu producto: productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void confirmarPedido() {
        this.estado = EstadoPedido.EN_ESPERA;
        this.confirmado = true;
    }

    public boolean estaConfirmado() {
        return confirmado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        if(cliente != null){
            cliente.notificarCambioEstado(nuevoEstado);
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
