package interfaces;

import enums.EstadoPedido;

public interface INotificacion {
    void enviarNotificacion(EstadoPedido estado);
}
