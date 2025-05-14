package Clases;

public class Ingrediente {
    private String nombre;
    private String descripcion;
    private boolean alergeno;

    public Ingrediente(String nombre, String descripcion, boolean alergeno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alergeno = alergeno;
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
}

