package clases_abstractas;

import Clases.notif.EmailNotifAdapter;
import Clases.pedido.Pedido;
import interfaces.*;
import enums.EstadoPedido;

public abstract class Empleado {
    protected String nombre;
    protected String legajo;
    protected INotificacion notificador;
    protected String emailEmpleado;

    //Constructor
    public Empleado(String nombre, String legajo, String email) {
        if(nombre == null || legajo == null || email == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }

        this.nombre = nombre;
        this.legajo = legajo;
        this.notificador = new EmailNotifAdapter(email);
        this.emailEmpleado = email;
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

    public String getEmail() {
        return emailEmpleado;
    }

    public void setEmail(String email) {
        this.emailEmpleado = email;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre='" + nombre + '\'' + ", legajo='" + legajo + '\'' + '}';
    }
}
