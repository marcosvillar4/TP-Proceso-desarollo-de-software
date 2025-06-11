package clases_abstractas;

import Clases.menu.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.*;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bebida.class, name = "Bebida"),
        @JsonSubTypes.Type(value = Entrada.class, name = "Entrada"),
        @JsonSubTypes.Type(value = PlatoPrincipal.class, name = "PlatoPrincipal"),
        @JsonSubTypes.Type(value = Postre.class, name = "Postre"),
})
public abstract class ProductoMenu {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private float precio;
    private List<Ingrediente> listaIngredientes;
    private int tiempoPreparacion;

    public ProductoMenu(int id, String nombre, String descripcion, float precio) {
        this.idProducto = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.listaIngredientes = new ArrayList<>();
    }


    public ProductoMenu() {
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

    @JsonIgnore
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }
    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

}