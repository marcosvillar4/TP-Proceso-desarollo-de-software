package Clases.notif;

import enums.EstadoPedido;
import interfaces.INotificacion;

public class InternNotifAdapter implements INotificacion {

    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        System.out.println("Enviando notificación con estado: " + estado);
    }

}
