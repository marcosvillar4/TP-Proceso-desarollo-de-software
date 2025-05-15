package Clases_Abstractas;

import Clases.Ingrediente;

import java.util.*;

public abstract class ProductoMenu {

    private String nombre;
    private String descripcion;
    private float precio;
    private List<Ingrediente> listaIngredientes;

    public ProductoMenu(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.listaIngredientes = new ArrayList<>();
    }

    public boolean contieneAlergenos() {
        for(Ingrediente i : listaIngredientes) {
            if(i.esAlergeno()) return true;
        }
        return false;
    }

    public void agregarIngrediente(Ingrediente ingrediente){
        listaIngredientes.add(ingrediente);
    }

    //Getters
    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio(){
        return precio;
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
}