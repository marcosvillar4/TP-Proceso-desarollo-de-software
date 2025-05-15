import Clases.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JsonManager jsonManager = new JsonManager();
        File menuFile = jsonManager.getJson();


        Menu menu = new Menu();

        menu.getCategoriasProductos().add(new Bebida("Coca-cola", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Bebida("Sprite", "BBBBB", 100));
        menu.getCategoriasProductos().add(new Bebida("Fernet", "AAAAA", 100));
        menu.getCategoriasProductos().add(new Entrada("Empanada", "CCCCC", 100));
        menu.getCategoriasProductos().get(3).agregarAlergeno(new Ingrediente("Alergeno 1", "AAAAAAAAAAA", true));

        jsonManager.writeMenu(menu, menuFile);

    }
}
