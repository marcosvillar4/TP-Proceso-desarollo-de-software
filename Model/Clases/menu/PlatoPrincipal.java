package Clases.menu;

import clases_abstractas.ProductoMenu;

public class PlatoPrincipal extends ProductoMenu {

    private boolean aptoCeliaco;

    public PlatoPrincipal(int id, String nombre, String descripcion, float precio, int tiempoPreparacion, boolean aptoCeliaco) {
        super(id, nombre, descripcion, precio, tiempoPreparacion);
        this.aptoCeliaco = aptoCeliaco;
    }

    public boolean isAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public PlatoPrincipal() {
    }
}