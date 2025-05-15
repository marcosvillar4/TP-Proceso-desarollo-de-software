import Clases.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.nio.file.Files;

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


        JsonManager jsonManager = new JsonManager();
        File menuFile = jsonManager.checkFile("menu.json");
        Menu menu = new Menu();
        if (menuFile.exists()){
            if (Files.readString(menuFile.toPath()).isEmpty()){
                System.out.println("File not found, Creating");
            } else {
                menu = (Menu) JsonReader.readObjectFromFile(menuFile, Menu.class);
            }
        }

        menu.getCategoriasProductos().add(new Bebida("Coca-cola", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Bebida("Sprite", "BBBBB", 100));
        menu.getCategoriasProductos().add(new Bebida("Fernet", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Entrada("Empanada", "CCCCC", 100));

        JsonWriter.writeFile(menu,menuFile);



        Chef chef1 = new Chef("Pedro", "123", "Pedro@gmail.com");
        Administrativo administrativo1 = new Administrativo("Jose", "456", "Jose@gmail.com");
        Mesero mesero1 = new Mesero("Carlos", "789","Carlos@gmail.com");




    }
}
