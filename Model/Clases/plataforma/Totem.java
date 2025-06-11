package Clases.plataforma;

import Clases.pedido.*;
import clases_abstractas.*;

public class Totem extends Plataforma{
    private PedidoFactory pedidoFactoryTotem;
    private String nombre;

    public Totem(String nombre) {
        super(nombre);
        this.pedidoFactoryTotem = new PedidoFactory();
    }


}
