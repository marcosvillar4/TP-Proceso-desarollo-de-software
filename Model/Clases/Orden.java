package Clases;

public class Orden {
    private static int contador = 0;

    private String numero;
    private String cupon;
    private Pedido pedido;
    private ValidadorDescuento validador;

    public Orden(Pedido pedido){
        this.numero = "ORD-" + (++contador);
        this.pedido = pedido;
        this.validador = new ValidadorDescuento();
        this.cupon = null;
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

    public boolean aplicarCupon(String cuponIngresado){
        if(validador.validarDescuento(cuponIngresado)){
            this.cupon = cuponIngresado;
            System.out.println("Cupon aplicado: " + cuponIngresado);
            return true;
        }
        System.out.println("Cupon invalido: " + cuponIngresado);
        return false;
    }
}
