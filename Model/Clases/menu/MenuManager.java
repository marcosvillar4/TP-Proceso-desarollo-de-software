package Clases.menu;

import clases_abstractas.ProductoMenu;

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

        System.out.println("Ingrese el tiempo de preparación del producto:");
        int tiempoPreparacionAgregar = scanner.nextInt();

        switch (categoria){
            case 1:
                System.out.println("Es una bebida alcoholica? (S/N) ");
                String esAlcoholicaInput = scanner.nextLine();
                while (!esAlcoholicaInput.equalsIgnoreCase("s") && !esAlcoholicaInput.equalsIgnoreCase("n")) {
                    System.out.println("Ingresar 'S'/'N' para continuar");
                    esAlcoholicaInput = scanner.nextLine();
                }
                boolean esAlcoholica = esAlcoholicaInput.equalsIgnoreCase("s");

                menu.getCategoriasProductos().add(new Bebida(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar, tiempoPreparacionAgregar, esAlcoholica));
                break;

            case 2:
                System.out.println("Es una entrada fria? (S/N) ");
                String esFriaInput = scanner.nextLine();
                while (!esFriaInput.equalsIgnoreCase("s") && !esFriaInput.equalsIgnoreCase("n")) {
                    System.out.println("Ingresar 'S'/'N' para continuar");
                    esFriaInput = scanner.nextLine();
                }
                boolean esFriaAgregar = esFriaInput.equalsIgnoreCase("s");

                menu.getCategoriasProductos().add(new Entrada(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar, tiempoPreparacionAgregar, esFriaAgregar));
                break;

            case 3:
                System.out.println("El plato apto para celiacos? (S/N) ");
                String esAptoCeliacoInput = scanner.nextLine();
                while (!esAptoCeliacoInput.equalsIgnoreCase("s") && !esAptoCeliacoInput.equalsIgnoreCase("n")) {
                    System.out.println("Ingresar 'S'/'N' para continuar");
                    esAptoCeliacoInput = scanner.nextLine();
                }
                boolean esAptoCeliacoAgregar = esAptoCeliacoInput.equalsIgnoreCase("s");
                menu.getCategoriasProductos().add(new PlatoPrincipal(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar, tiempoPreparacionAgregar, esAptoCeliacoAgregar));
                break;

            case 4:
                System.out.println("El postre contiene azucar? (S/N) ");
                String contieneAzucarInput = scanner.nextLine();
                while (!contieneAzucarInput.equalsIgnoreCase("s") && !contieneAzucarInput.equalsIgnoreCase("n")) {
                    System.out.println("Ingresar 'S'/'N' para continuar");
                    contieneAzucarInput = scanner.nextLine();
                }
                boolean contieneAzucarAgregar = contieneAzucarInput.equalsIgnoreCase("s");
                menu.getCategoriasProductos().add(new Postre(idProductoAgregar, nombreProductoAgregar, descripcionProductoAgregar, precioProductoAgregar, tiempoPreparacionAgregar, contieneAzucarAgregar));
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
}
