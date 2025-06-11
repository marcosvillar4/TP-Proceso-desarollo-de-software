package Clases.plataforma;

import Clases.pedido.PedidoFactory;
import clases_abstractas.Plataforma;

public class AppMovil extends Plataforma {
    private String nombre;
    private PedidoFactory pedidoFactoryAppMovil;

    public AppMovil(String nombre){
        super(nombre);
        this.pedidoFactoryAppMovil = new PedidoFactory();
    }
}
