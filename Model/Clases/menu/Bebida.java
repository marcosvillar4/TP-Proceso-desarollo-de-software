package Clases.menu;

import clases_abstractas.ProductoMenu;

public class Bebida extends ProductoMenu {

    private boolean esAlcoholica;

    public Bebida(int id, String nombre, String descripcion, float precio, int tiempoPreparacion, boolean esAlcoholica) {
        super(id, nombre, descripcion, precio, tiempoPreparacion);
        this.esAlcoholica = esAlcoholica;
    }

    public Bebida(){
    }

    public boolean isEsAlcoholica() {
        return esAlcoholica;
    }

    public void setEsAlcoholica(boolean esAlcoholica) {
        this.esAlcoholica = esAlcoholica;
    }
}