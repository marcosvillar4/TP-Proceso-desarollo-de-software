package Clases;

import java.util.*;

import Clases_Abstractas.ProductoMenu;

public class Menu {

    private List<ProductoMenu> categoriasProductos;

    public Menu() {
        categoriasProductos = new ArrayList<>();
    }

    public List<ProductoMenu> getCategoriasProductos() {
        return categoriasProductos;
    }

    public void setCategoriasProductos(List<ProductoMenu> categoriasProductos) {
        this.categoriasProductos = categoriasProductos;
    }
}