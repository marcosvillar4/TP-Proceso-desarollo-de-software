package Clases;

import Clases_Abstractas.Empleado;
import Interfaces.INotificacion;
import Enum.EstadoPedido;

public class Mesero extends Empleado {


    public Mesero(String nombre, String legajo, INotificacion notificador, String email) {
        super(nombre, legajo, notificador, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        if (nuevoEstado == EstadoPedido.EN_PREPARACION){
            pedido.cambiarEstado(nuevoEstado);
            System.out.println("Mesero " + nombre + " cambio el estado a: " + nuevoEstado);
            notificador.enviarNotificacion(nuevoEstado);
        } else {
            System.out.println("El mesero no puede cambiar el estado a: " + nuevoEstado);
        }
    }

}
