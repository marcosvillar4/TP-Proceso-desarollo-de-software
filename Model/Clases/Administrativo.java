package Clases;

import Clases_Abstractas.Empleado;
import Enum.EstadoPedido;
import Interfaces.INotificacion;

public class Administrativo extends Empleado {

    public Administrativo(String nombre, String legajo, String email){
        super(nombre, legajo, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        pedido.cambiarEstado(nuevoEstado);
        System.out.println("Administrativo cambio el estado: " + nuevoEstado);
    }
}
