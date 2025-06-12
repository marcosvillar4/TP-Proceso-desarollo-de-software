package Clases.menu;

import clases_abstractas.ProductoMenu;

public class Entrada extends ProductoMenu {

    private boolean fria;

    public Entrada(int id, String nombre, String descripcion, float precio, int tiempoPreparacion, boolean fria) {
        super(id, nombre, descripcion, precio, tiempoPreparacion);
        this.fria = fria;
    }

    public Entrada() {
    }

    public boolean isFria() {
        return fria;
    }

    public void setFria(boolean fria) {
        this.fria = fria;
    }
}