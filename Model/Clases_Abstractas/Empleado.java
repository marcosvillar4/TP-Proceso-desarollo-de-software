package Clases_Abstractas;

import Clases.Pedido;
import Interfaces.*;
import Enum.EstadoPedido;

public abstract class Empleado {
    protected String nombre;
    protected String legajo;
    protected INotificacion notificador;

    public Empleado(String nombre, String legajo, INotificacion notificador) {
        if(nombre == null || legajo == null || notificador == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }

        this.nombre = nombre;
        this.legajo = legajo;
        this.notificador = notificador;
    }

    public abstract void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado);

    @Override
    public String toString() {
        return "Empleado{" + "nombre='" + nombre + '\'' + ", legajo='" + legajo + '\'' + '}';
    }

}
