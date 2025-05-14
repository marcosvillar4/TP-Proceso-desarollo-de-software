package Clases_Abstractas;

import Clases.Ingrediente;

import java.util.*;

public abstract class ProductoMenu {

    private String nombre;
    private String descripcion;
    private float precio;
    private List<Ingrediente> alergenos;

    public ProductoMenu(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alergenos = new ArrayList<>();
    }

    public boolean contieneAlergenos() {
        for(Ingrediente i : alergenos) {
            if(i.esAlergeno()) return true;
        }
        return false;
    }

    public void agregarAlergeno(Ingrediente ingrediente){
        alergenos.add(ingrediente);
    }

    //Getters
    public List<Ingrediente> getAlergenos() {
        return alergenos;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio(){
        return precio;
    }

}