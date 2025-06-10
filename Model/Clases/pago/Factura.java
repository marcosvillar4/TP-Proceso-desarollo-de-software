package Clases.pago;

import java.util.Date;

public class Factura {

    private float montoTotal;

    public Date fecha;

    public Factura(float montoTotal){
        this.montoTotal = montoTotal;
        this.fecha = new Date(); //Fecha actual
    }

    public void enviarPorCorreo(String correo){
        System.out.println("Factura enviada a: " + correo);
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
