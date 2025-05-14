package Clases;


import java.util.HashSet;
import java.util.Set;

public class ValidadorDescuento {
    private Set<String> cuponesValidos;

    public ValidadorDescuento(){
        cuponesValidos = new HashSet<>();
        cuponesValidos.add("DESC10");
        cuponesValidos.add("PROMO25");
        cuponesValidos.add("ENVIOGRATIS");
    }
    public boolean validarDescuento(String cupon) {
        return cuponesValidos.contains(cupon.toUpperCase());
    }

    public void agregarCupon(String nuevoCupon){
        cuponesValidos.add(nuevoCupon.toUpperCase());
    }
}
