package Clases.pedido;

import java.time.LocalDateTime;
import java.util.*;

import Clases.pago.Orden;
import Clases.entidades.Cliente;
import Clases_Abstractas.CalculadorTiempoStrategy;
import Clases_Abstractas.Entrega;
import Clases_Abstractas.ProductoMenu;
import Enum.EstadoPedido;

public class Pedido {

    private int id;
    private Cliente cliente;
    private List<ProductoMenu> productos = new ArrayList<>();
    private boolean confirmado;
    private EstadoPedido estado;
    private Orden orden;
    private String cupon;
    private float total;
    private float totalSinDescuento;
    private boolean totem;
    private boolean programado;
    private LocalDateTime horarioProgramado;
    private CalculadorTiempoStrategy calculadorTiempo;
    private boolean esDelivery;
    private Entrega entrega;

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
        this.orden = new Orden(this, esDelivery);
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

    public void activarPedidoProgramado(){
        if(estado == EstadoPedido.PROGRAMADO && horarioProgramado != null){
            if(LocalDateTime.now().isAfter(horarioProgramado)){
                cambiarEstado(EstadoPedido.EN_ESPERA);
                System.out.println("El pedido programado fue activado automáticamente");
            }
        }
    }


    public int calcularTiempoRestante() {
        if (calculadorTiempo != null) {
            return calculadorTiempo.calcularTiempoRestante(this);
        }
        return -1;
    }

    public void setCalculadorTiempo(CalculadorTiempoStrategy calculador) {
        this.calculadorTiempo = calculador;
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

    public boolean isProgramado() {
        return programado;
    }

    public void setProgramado(boolean programado) {
        this.programado = programado;
    }

    public LocalDateTime getHorarioProgramado() {
        return horarioProgramado;
    }

    public void setHorarioProgramado(LocalDateTime horarioProgramado) {
        this.horarioProgramado = horarioProgramado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public boolean isDelivery() {
        return esDelivery;
    }

    public void setDelivery(boolean esDelivery) {
        this.esDelivery = esDelivery;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}
