package Clases.pago;

import Clases.pedido.Pedido;

public class Orden {
    private static int contador = 0;

    private String numero;
    private String cupon;
    private Pedido pedido;
    private ValidadorDescuento validador;
    private boolean delivery;

    public Orden(Pedido pedido, boolean delivery) {
        this.numero = "ORD-" + (++contador);
        this.pedido = pedido;
        this.validador = new ValidadorDescuento();
        this.delivery = delivery;
    }


    public float aplicarCupon(String cupon){
        this.cupon = cupon;
        if(cupon == null || cupon.isBlank()) {
            System.out.println("No se ingreso cupon");
        } else{
            System.out.println("Cupon aplicado: " + cupon);
        }
        return validador.getDescuento(cupon);
    }


    public String getNumero(){
        return numero;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public String getCupon(){
        return cupon;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Orden.contador = contador;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public ValidadorDescuento getValidador() {
        return validador;
    }

    public void setValidador(ValidadorDescuento validador) {
        this.validador = validador;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean esDelivery() {
        return delivery;
    }
}
