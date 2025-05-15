import Clases.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        JsonManager jsonManager = new JsonManager();

        Scanner scanner = new Scanner(System.in);

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

        File menuFile = jsonManager.checkFile("menu.json");
        Menu menu = new Menu();
        if (menuFile.exists()){
            if (Files.readString(menuFile.toPath()).isEmpty()){
                System.out.println("File not found, Creating");
            } else {
                menu = (Menu) JsonReader.readObjectFromFile(menuFile, Menu.class);
            }
        }

        menu.getCategoriasProductos().add(new Bebida(1,"Coca-cola", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Bebida(2,"Sprite", "BBBBB", 100));
        menu.getCategoriasProductos().add(new Bebida(3,"Fernet", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Entrada(4,"Empanada", "CCCCC", 100));
        menu.getCategoriasProductos().get(3).agregarIngrediente(new Ingrediente("Alergeno 1", "AAAAAAAAAAA", true));

        Chef chef1 = new Chef("Pedro", "123", "Pedro@gmail.com");
        Administrativo administrativo1 = new Administrativo("Jose", "456", "Jose@gmail.com");
        Mesero mesero1 = new Mesero("Carlos", "789","Carlos@gmail.com");



        // INTERFAZ DE TERMINAL PARA PROBAR FUNCIONES

        System.out.println("Bienvenido al sistema de gestión de pedidos.");
        System.out.println("Bienvenido" + c1.getNombre() + ".");
        System.out.println("Por favor, elija una opción:");

        int respuesta = 0;

        while (respuesta != 5){
            System.out.println("1. Mostrar menú");
            System.out.println("2. Realizar pedido");
            System.out.println("3. Pagar pedido");
            System.out.println("4. Cambiar estado de pedido");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
        }





    }
}
