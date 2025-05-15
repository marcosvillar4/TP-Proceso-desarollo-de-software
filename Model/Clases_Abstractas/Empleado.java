package Clases_Abstractas;

import Clases.Pedido;
import Interfaces.*;
import Enum.EstadoPedido;

public abstract class Empleado {
    protected String nombre;
    protected String legajo;
    protected INotificacion notificador;
    protected String email;

    //Constructor
    public Empleado(String nombre, String legajo, INotificacion notificador, String email) {
        if(nombre == null || legajo == null || notificador == null || email == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }

        this.nombre = nombre;
        this.legajo = legajo;
        this.notificador = notificador;
        this.email = email;
    }

    public abstract void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado);


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public INotificacion getNotificador() {
        return notificador;
    }

    public void setNotificador(INotificacion notificador) {
        this.notificador = notificador;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre='" + nombre + '\'' + ", legajo='" + legajo + '\'' + '}';
    }

}
