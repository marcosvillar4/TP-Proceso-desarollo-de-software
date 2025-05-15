package Clases;

import java.util.*;

import Clases_Abstractas.ProductoMenu;

public class Menu {

    private List<ProductoMenu> categoriasProductos;


    public Menu() {
        categoriasProductos = new ArrayList<>();
    }

    public void mostrarMenu() {
        System.out.println("Productos disponibles:");
        for (ProductoMenu p : getCategoriasProductos()) {
            System.out.println("- " + p.getNombre());
        }
    }

    public List<ProductoMenu> getCategoriasProductos() {
        return categoriasProductos;
    }

    public void setCategoriasProductos(List<ProductoMenu> categoriasProductos) {
        this.categoriasProductos = categoriasProductos;
    }
}