package Clases;

public class FacturaFactory {

    public static Factura crearFactura(Pedido pedido){
        if(pedido == null || !pedido.estaConfirmado()){
            throw new IllegalArgumentException("El pedido debe estar confirmado para generar la factura");
        }

        float total = pedido.getTotal();
        return new Factura(total);
    }
}
