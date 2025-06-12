package Clases.entidades;

import Clases.pedido.Pedido;
import Clases.plataforma.Totem;
import clases_abstractas.Empleado;
import enums.EstadoPedido;

public class Mesero extends Empleado {
    private String departamento;
    private String nivelAcceso;

    public Mesero(String nombre, String legajo, String email, String departamento, String nivelAcceso) {
        super(nombre, legajo, email);
        this.departamento = departamento;
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        if (nuevoEstado == EstadoPedido.EN_PREPARACION){
            pedido.cambiarEstado(nuevoEstado);
            System.out.println("Mesero " + nombre + " cambio el estado a: " + nuevoEstado);

            if (pedido.getPlataforma().getClass() != Totem.class){
                notificador.enviarNotificacion(nuevoEstado);
            }

        } else{
            System.out.println("El mesero no puede cambiar el estado a: " + nuevoEstado);
        }
    }

}
