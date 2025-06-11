package Clases.entidades;

import Clases.pedido.Pedido;
import clases_abstractas.Empleado;
import enums.EstadoPedido;

public class Administrativo extends Empleado {

    public Administrativo(String nombre, String legajo, String email){
        super(nombre, legajo, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        pedido.cambiarEstado(nuevoEstado);
        System.out.println("Administrativo cambio el estado: " + nuevoEstado);
        if(nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR){
            notificador.enviarNotificacion(nuevoEstado);
            System.out.println("Notificando al mesero que el pedido esta listo para entregar");
        }
    }
}
