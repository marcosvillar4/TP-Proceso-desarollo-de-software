package Clases_Abstractas;

public abstract class Plataforma {

    private String nombre;

    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public String getClassType() {
        return this.getClass().getTypeName();
    }
}
