package interfaces;

import enums.EstadoPedido;

public interface INotificacion {
    public void enviarNotificacion(EstadoPedido estado);
}
