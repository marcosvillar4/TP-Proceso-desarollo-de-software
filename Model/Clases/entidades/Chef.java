package Clases.entidades;

import Clases.pedido.Pedido;
import Clases_Abstractas.Empleado;
import Enum.EstadoPedido;


public class Chef extends Empleado {

    public Chef(String nombre, String legajo, String email) {
        super(nombre, legajo, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado){
        if (nuevoEstado != EstadoPedido.EN_PREPARACION && nuevoEstado != EstadoPedido.LISTO_PARA_ENTREGAR) {
            System.out.println("El chef no puede cambiar el estado a: " + nuevoEstado);
            return;
        }

        pedido.cambiarEstado(nuevoEstado);
        notificador.enviarNotificacion(nuevoEstado);
        System.out.println("Chef cambio el estado: " + nuevoEstado);
        if(nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR){
            System.out.println("Notificando al mesero que el pedido esta listo para entregar");
        }
    }
}
