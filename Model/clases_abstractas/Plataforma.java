package clases_abstractas;

import Clases.entidades.Cliente;
import Clases.pedido.Pedido;
import Clases.pedido.PedidoFactory;

import java.lang.reflect.InvocationTargetException;

public abstract class Plataforma {

    private String nombre;
    private static PedidoFactory pedidoFactory = new PedidoFactory();
    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public String getClassType() {
        return this.getClass().getTypeName();
    }

    public Pedido generarPedido(Cliente cliente) {

        try {
            Class<?> clazz = this.getClass();
            Object newObject = clazz.getConstructor(String.class).newInstance(clazz.getSimpleName());
            Pedido pedido = pedidoFactory.crearPedido((Plataforma) newObject, cliente);
            System.out.println("Pedido creado desde el " + this.getClass().getSimpleName() + " para: " + cliente.getNombreCompleto());
            return pedido;

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
