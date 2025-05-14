package Clases;

import Interfaces.IPagable;

public class Cliente {
    private String nombre;

    private String apellido;

    private String dni;

    private String email;

    public Factura factura;

    public Cliente(String nombre, String apellido, String dni, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = correo;
    }

    public void elegirProducto(Menu menu) {
        // TODO implement here
    }

    public Boolean pagarPedido(Pedido pedido, IPagable medio) {
        if(pedido == null || medio == null) return false;

        float total = pedido.calcularTotal();
        boolean pagoExitoso = medio.pagar(total);

        if(pagoExitoso){pedido.confirmarPedido();
            this.factura = FacturaFactory.crearFactura(pedido);
            this.factura.enviarPorCorreo(this.email);
            return true;
        }
        return false;
    }

    //Getters
    public Factura getFactura() {
        return factura;
    }

    public String getEmail() {
        return email;
    }
}