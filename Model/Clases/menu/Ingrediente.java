package Clases.menu;

public class Ingrediente {
    private String nombre;
    private String descripcion;
    private boolean alergeno;

    public Ingrediente(String nombre, String descripcion, boolean alergeno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alergeno = alergeno;
    }

    public Ingrediente() {
    }

    public boolean esAlergeno() {
        return alergeno;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAlergeno() {
        return alergeno;
    }

    public void setAlergeno(boolean alergeno) {
        this.alergeno = alergeno;
    }
}

