import Clases.Bebida;
import Clases.Cliente;
import Clases.Ingrediente;
import Clases.PlatoPrincipal;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("Juan", "Pérez", "Calle Falsa 123", "12345678");

        Ingrediente i1 = new Ingrediente("Leche", "Leche entera", true);
        Ingrediente i2 = new Ingrediente("Harina", "Harina de trigo", false);
        Ingrediente i4 = new Ingrediente("Carne", "Carne de res", true);
        Ingrediente i3 = new Ingrediente("Tomate", "Tomate fresco", false);
        Ingrediente i5 = new Ingrediente("Pasta", "Pasta de trigo", false);
        Ingrediente i6 = new Ingrediente("Queso", "Queso mozzarella", true);
        Ingrediente i7 = new Ingrediente("Aceite", "Aceite de oliva", false);
        Ingrediente i8 = new Ingrediente("Sal", "Sal de mesa", false);
        Ingrediente i9 = new Ingrediente("Azúcar", "Azúcar blanca", false);
        Ingrediente i10 = new Ingrediente("Pimienta", "Pimienta negra", false);
        Ingrediente i11 = new Ingrediente("Cebolla", "Cebolla blanca", false);
        Ingrediente i12 = new Ingrediente("Ajo", "Ajo fresco", false);



        PlatoPrincipal p1 = new PlatoPrincipal("Pizza", "Pizza de pepperoni", 10.99f);
        Bebida b1 = new Bebida("Coca-Cola", "Refresco de cola", 2.50f);





    }
}
