package Clases;

import Enum.EstadoPedido;

public class AppNotifAdapter {
    private String userId;
    public void enviarNotificacion(EstadoPedido estado) {
        // Aquí se implementaría la lógica para enviar una notificación a la aplicación
        // utilizando el userId proporcionado.
        System.out.println("Enviando notificación a la app para el usuario " + userId + " con estado: " + estado);
    }
}
