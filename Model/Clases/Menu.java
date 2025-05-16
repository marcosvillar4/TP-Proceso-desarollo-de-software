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
        System.out.println();
        for (ProductoMenu producto : categoriasProductos) {
            System.out.println("Nombre: " + producto.getNombre() + " - Id: " + producto.getIdProducto() + " - Precio: " + producto.getPrecio());
            System.out.println();
        }
    }

    public List<ProductoMenu> getCategoriasProductos() {
        return categoriasProductos;
    }

    public void setCategoriasProductos(List<ProductoMenu> categoriasProductos) {
        this.categoriasProductos = categoriasProductos;
    }
}