package Clases;

import Clases_Abstractas.Empleado;
import Enum.EstadoPedido;
import Interfaces.INotificacion;


public class Chef extends Empleado {

    public Chef(String nombre, String legajo, String email) {
        super(nombre, legajo, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado){
        if (nuevoEstado != EstadoPedido.EN_PREPARACION && nuevoEstado != EstadoPedido.LISTO) {
            System.out.println("El chef no puede cambiar el estado a: " + nuevoEstado);
            return;
        }

        INotificacion notificador = new EmailNotifAdapter(emailEmpleado);

        pedido.cambiarEstado(nuevoEstado);
        notificador.enviarNotificacion(nuevoEstado);
        System.out.println("Chef cambio el estado: " + nuevoEstado);
    }
}
