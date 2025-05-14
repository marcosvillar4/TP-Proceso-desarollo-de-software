package Clases_Abstractas;

import Clases.Ingrediente;

import java.util.*;

public abstract class ProductoMenu {

    public ProductoMenu() {
    }

    private String nombre;

    private String descripcion;

    private Float precio;

    private List<Ingrediente> alergenos;

    public Boolean contieneAlergenos() {
        // TODO implement here
        return null;
    }

}