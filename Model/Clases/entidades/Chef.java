package Clases.entidades;

import Clases.pedido.Pedido;
import Clases.plataforma.Totem;
import clases_abstractas.Empleado;
import enums.EstadoPedido;


public class Chef extends Empleado {

    private String especialidadCocina;
    private String nivelExperiencia;

    public Chef(String nombre, String legajo, String email, String especialidadCocina, String nivelExperiencia) {
        super(nombre, legajo, email);
        this.especialidadCocina = especialidadCocina;
        this.nivelExperiencia = nivelExperiencia;
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado){
        if (nuevoEstado != EstadoPedido.EN_PREPARACION && nuevoEstado != EstadoPedido.LISTO_PARA_ENTREGAR) {
            System.out.println("El chef no puede cambiar el estado a: " + nuevoEstado);
            return;
        }

        pedido.cambiarEstado(nuevoEstado);
        System.out.println("Chef cambio el estado: " + nuevoEstado);

        if (pedido.getPlataforma().getClass() != Totem.class){
            if(nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR){
                notificador.enviarNotificacion(nuevoEstado);
                System.out.println("Notificando al mesero que el pedido esta listo para entregar");
            }
        }

    }
}
