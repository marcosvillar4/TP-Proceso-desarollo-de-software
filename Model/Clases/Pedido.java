package Clases;

import java.util.*;
import Clases_Abstractas.ProductoMenu;
import Enum.EstadoPedido;

public class Pedido {

    private Cliente cliente;
    private List<ProductoMenu> productos = new ArrayList<>();
    private boolean confirmado;
    private EstadoPedido estado;
    private Orden orden;
    private String cupon;
    private float total;
    private float totalSinDescuento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public float calcularTotal() {
        float total = 0;
        for(ProductoMenu producto: productos) {
            total += producto.getPrecio();
        }
        this.totalSinDescuento = total;
        total *= orden.aplicarCupon(cupon); //Aplica el cupón al total
        this.total = total;
        return total;
    }

    public void confirmarPedido() {
        this.estado = EstadoPedido.EN_ESPERA;
        this.confirmado = true;
        this.orden = new Orden(this);
    }

    public boolean estaConfirmado() {
        return confirmado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        if(nuevoEstado == EstadoPedido.ENTREGADO){
            System.out.println("Pedido entregado! Finalizando programa...");
            System.exit(0);
        }
        if(cliente != null && estaConfirmado() || this.estado != nuevoEstado){
            cliente.notificarCambioEstado(nuevoEstado);
        }

        if (this.estado == nuevoEstado){
            System.out.println("El nuevo estado es el mismo que el anterior");
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductoMenu> getProductos() {
        return productos;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setCupon(String cupon){
        this.cupon = cupon;
    }
    public Orden getOrden() {
        return orden;
    }

    public float getTotal(){
        return total;
    }

    public float getTotalSinDescuento(){
        return totalSinDescuento;
    }
}
