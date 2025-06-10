package Clases;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidadorDescuento {
    private Map<String, Float> cuponesValidos;

    public ValidadorDescuento(){
        cuponesValidos = new HashMap<>();
        cuponesValidos.put("DESC10", 0.9f);
        cuponesValidos.put("PROMO25", 0.75f);
        cuponesValidos.put("DESC50", 0.5f);
        cuponesValidos.put("EFECTIVO", 0.9f);
    }
    public boolean validarDescuento(String cupon) {
        return cuponesValidos.containsKey(cupon.toUpperCase());
    }

    public void agregarCupon(String nuevoCupon, float porcentaje){
        cuponesValidos.put(nuevoCupon.toUpperCase(), porcentaje);
    }

    public float getDescuento(String cupon){
        if(validarDescuento(cupon)){
            return cuponesValidos.get(cupon.toUpperCase());
        }
        return 1.0f; // Sin descuento
    }
}
