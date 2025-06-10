package Clases.notif;
import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class EmailNotifAdapter implements INotificacion {
    private String direccion;

    public EmailNotifAdapter(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        System.out.println("Enviando notificación por correo a " + direccion + " con estado: " + estado);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
