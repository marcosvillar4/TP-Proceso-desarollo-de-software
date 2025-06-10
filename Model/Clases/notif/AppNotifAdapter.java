package Clases.notif;

import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class AppNotifAdapter implements INotificacion{
    private String userId;

    public AppNotifAdapter(String userId) {
        this.userId = userId;
    }

    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        System.out.println("Enviando notificación a la app para el usuario " + userId + " con estado: " + estado);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
