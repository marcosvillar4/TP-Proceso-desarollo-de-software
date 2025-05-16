package Clases;

import Clases_Abstractas.ProductoMenu;

import java.util.Scanner;

public class MenuManager {
    //Singleton
    private static MenuManager instancia;
    private MenuManager(){}

    public static int idMax = 0;

    public static MenuManager getInstance(){
        if(instancia == null){
            instancia = new MenuManager();
        }
        return instancia;
    }


    public static void eliminarItemMenu(Menu menu, Scanner scanner) {
        System.out.println("Indique el ID del producto a eliminar:");
        int id = scanner.nextInt();

        boolean check = false;
        ProductoMenu productoEliminar = null;

        for (ProductoMenu producto : menu.getCategoriasProductos()) {
            if (producto.getIdProducto() == id){
                check = true;
                productoEliminar = producto;
                break;
            }
        }

        if(check){
            menu.getCategoriasProductos().remove(productoEliminar);
            System.out.println("Producto eliminado.");
        }else{
            System.out.println("Elemento no encontrado");
        }
    }

    public static void agregarItemMenu(Menu menu, Scanner scanner) {

        for(ProductoMenu producto : menu.getCategoriasProductos()){
            if (producto.getIdProducto() > idMax){
                idMax = producto.getIdProducto();
            }
        }

        System.out.println("Seleccione la categoria de producto a agregar:");
        System.out.println("1. Bebida");
        System.out.println("2. Entrada");
        System.out.println("3. Plato Principal");
        System.out.println("4. Postre");

        int categoria = scanner.nextInt();

        int idProductoAgregar = idMax + 1;

        System.out.println("Ingrese el nombre del producto:");
        scanner.nextLine();
        String nombreProductoAgregar = scanner.nextLine();


        System.out.println("Ingrese la descripcion del producto:");
        scanner.nextLine();
        String descripcionProductoAgregar = scanner.nextLine();


        System.out.println("Ingrese el precio del producto:");
        float precioProductoAgregar = scanner.nextFloat();
        switch (categoria){
            case 1:
                menu.getCategoriasProductos().add(new Bebida(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar));
                break;
            case 2:
                menu.getCategoriasProductos().add(new Entrada(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar));
                break;
            case 3:
                menu.getCategoriasProductos().add(new PlatoPrincipal(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar));
                break;
            case 4:
                menu.getCategoriasProductos().add(new Postre(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar));
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

}
