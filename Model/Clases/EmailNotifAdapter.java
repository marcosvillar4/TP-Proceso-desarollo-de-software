package Clases;
import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class EmailNotifAdapter implements INotificacion {
    private String direccion;

    public EmailNotifAdapter(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void enviarNotificacion(EstadoPedido estado) {
        // Aquí se implementaría la lógica para enviar un correo electrónico
        // utilizando la dirección de correo electrónico proporcionada.
        System.out.println("Enviando notificación por correo a " + direccion + " con estado: " + estado);
    }
}
