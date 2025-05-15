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


    public boolean aplicarCupon(String cuponIngresado){
        if(validador.validarDescuento(cuponIngresado)){
            this.cupon = cuponIngresado;
            System.out.println("Cupon aplicado: " + cuponIngresado);
            return true;
        }
        System.out.println("Cupon invalido: " + cuponIngresado);
        return false;
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
}
