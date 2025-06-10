package Clases.entidades;

import Clases.notif.EmailNotifAdapter;
import Clases.pago.Factura;
import Clases.pago.FacturaFactory;
import Clases.pedido.Pedido;
import Interfaces.INotificacion;
import Interfaces.IPagable;
import Enum.EstadoPedido;

public class Cliente {
    private String nombre;

    private String apellido;

    private String dni;

    private String email;

    public Factura factura;

    private INotificacion notificador;

    public Cliente(String nombre, String apellido, String dni, String correo) {
        if(nombre == null || apellido == null || dni == null || correo == null){
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = correo;
        this.notificador = new EmailNotifAdapter(correo);
    }

    public Boolean pagarPedido(Pedido pedido, IPagable medio) {
        if (pedido == null || medio == null) return false;

        float total = pedido.getTotal();
        boolean pagoExitoso = medio.pagar(total);

        if (pagoExitoso) {
            pedido.confirmarPedido();
            this.factura = FacturaFactory.crearFactura(pedido);
            this.factura.enviarPorCorreo(this.email);
        }
        return pagoExitoso;
    }

    public void notificarCambioEstado(EstadoPedido nuevoEstado){
        if(notificador != null){
            notificador.enviarNotificacion(nuevoEstado);
        }
    }

    //Getters y setters
    public Factura getFactura() {
        return factura;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public INotificacion getNotificador() {
        return notificador;
    }

    public void setNotificador(INotificacion notificador) {
        this.notificador = notificador;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre='" + nombre + "', dni='" + dni + "'}";
    }

}