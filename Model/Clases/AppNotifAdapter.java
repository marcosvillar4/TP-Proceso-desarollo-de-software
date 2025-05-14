package Clases;

import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class AppNotifAdapter implements INotificacion{
    private String userId;

    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        // Aquí se implementaría la lógica para enviar una notificación a la aplicación
        // utilizando el userId proporcionado.
        System.out.println("Enviando notificación a la app para el usuario " + userId + " con estado: " + estado);
    }
}
