package Clases.menu;

import clases_abstractas.ProductoMenu;

public class Postre extends ProductoMenu {

    private boolean contieneAzucar;

    public Postre(int id, String nombre, String descripcion, float precio, int tiempoPreparacion, boolean contieneAzucar) {
        super(id, nombre, descripcion, precio, tiempoPreparacion);
        this.contieneAzucar = contieneAzucar;
    }

    public boolean isContieneAzucar() {
        return contieneAzucar;
    }

    public void setContieneAzucar(boolean contieneAzucar) {
        this.contieneAzucar = contieneAzucar;
    }

    public Postre() {
    }
}