package Clases;

import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class AppNotifAdapter implements INotificacion{
    private String userId;

    public AppNotifAdapter(String userId) {
        this.userId = userId;
    }

    /**
     * Este método envía una notificación a la aplicación móvil del usuario.
     * @param estado El estado del pedido que se va a notificar.
     */
    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        // Aca se implementaría la lógica para enviar una notificación a la aplicación
        // utilizando el userId proporcionado.
        System.out.println("Enviando notificación a la app para el usuario " + userId + " con estado: " + estado);
    }
}
