package Clases.entidades;

import Clases.pedido.Pedido;
import Clases.plataforma.Totem;
import clases_abstractas.Empleado;
import enums.EstadoPedido;

public class Administrativo extends Empleado {

    private String seccionAsignada;
    private String turno;

    public Administrativo(String nombre, String legajo, String email, String seccionAsignada, String turno){
        super(nombre, legajo, email);
        this.seccionAsignada = seccionAsignada;
        this.turno = turno;
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        pedido.cambiarEstado(nuevoEstado);
        System.out.println("Administrativo cambio el estado: " + nuevoEstado);

        if (pedido.getPlataforma().getClass() != Totem.class){
            if(nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR){
                notificador.enviarNotificacion(nuevoEstado);
                System.out.println("Notificando al mesero que el pedido esta listo para entregar");
            }
        }

    }
}
