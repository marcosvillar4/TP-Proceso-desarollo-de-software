package Clases;

import Clases_Abstractas.Empleado;
import Enum.EstadoPedido;
import Interfaces.INotificacion;


public class Chef extends Empleado {

    public Chef(String nombre, String legajo, INotificacion notificador, String email) {
        super(nombre, legajo, notificador, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado){
        pedido.cambiarEstado(nuevoEstado);
        notificador.enviarNotificacion(nuevoEstado);
        System.out.println("Chef cambio el estado: " + nuevoEstado);
    }
}
