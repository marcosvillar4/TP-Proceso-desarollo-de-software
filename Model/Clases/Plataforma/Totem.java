package Clases.Plataforma;

import Clases.pedido.*;
import Clases.menu.*;
import Clases_Abstractas.*;
import Clases.entidades.*;
import java.util.List;

class Totem {
    private Plataforma plataforma;
    private PedidoFactory pedidoFactory;

    public Totem() {
        this.plataforma = new Totem();
        this.pedidoFactory = new PedidoFactory();
    }

    public Pedido generarPedido(Cliente cliente) {
        List<ProductoMenu> productosSeleccionados = mostrarMenuYSeleccionarProductos();
        Pedido pedido = pedidoFactory.crearPedido(plataforma, cliente, productosSeleccionados);
        System.out.println("Pedido creado desde el Tótem para: " + cliente.getNombreCompleto());
        return pedido;
    }

    private List<ProductoMenu> mostrarMenuYSeleccionarProductos() {
        // Para demo: menú fijo, pero podrías extender para input real
        List<ProductoMenu> menu = List.of(
                new Entrada(1, "Ensalada César", "Lechuga, pollo, queso", 3.0f),
                new PlatoPrincipal(2, "Milanesa con papas", "Milanesa + papas fritas", 7.5f),
                new Bebida(3, "Agua", "Agua mineral", 1.5f)
        );

        // Mostrar menú
        

        // Simulamos la selección fija, pero podría ser entrada usuario
        return menu;
    }
}
