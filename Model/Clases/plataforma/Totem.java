package Clases.plataforma;

import Clases.pedido.*;
import clases_abstractas.*;
import Clases.entidades.*;

public class Totem extends Plataforma{
    private PedidoFactory pedidoFactory;
    private String nombre;

    public Totem(String nombre) {
        super(nombre);
        this.pedidoFactory = new PedidoFactory();
    }


}
