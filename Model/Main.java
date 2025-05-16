import Clases.*;
import Clases.Json.JsonManager;
import Clases.Json.JsonReader;
import Clases.Json.JsonWriter;
import Clases_Abstractas.ProductoMenu;
import Enum.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {

        JsonManager jsonManager = new JsonManager();
        Scanner scanner = new Scanner(System.in);

        Cliente c1 = new Cliente("Juan", "Pérez", "Calle Falsa 123", "12345678");

        Ingrediente i1 = new Ingrediente("Leche", "Leche entera", true);
        Ingrediente i2 = new Ingrediente("Harina", "Harina de trigo", false);
        Ingrediente i4 = new Ingrediente("Carne", "Carne de res", true);
        Ingrediente i3 = new Ingrediente("Tomate", "Tomate fresco", false);
        Ingrediente i5 = new Ingrediente("Pasta", "Pasta de trigo", false);
        Ingrediente i6 = new Ingrediente("Queso", "Queso mozzarella", true);
        Ingrediente i7 = new Ingrediente("Aceite", "Aceite de oliva", false);
        Ingrediente i8 = new Ingrediente("Sal", "Sal de mesa", false);
        Ingrediente i9 = new Ingrediente("Azúcar", "Azúcar blanca", false);
        Ingrediente i10 = new Ingrediente("Pimienta", "Pimienta negra", false);
        Ingrediente i11 = new Ingrediente("Cebolla", "Cebolla blanca", false);
        Ingrediente i12 = new Ingrediente("Ajo", "Ajo fresco", false);

        File menuFile = jsonManager.checkFile("menu.json");
        Menu menu = new Menu();
        if (menuFile.exists()){
            if (Files.readString(menuFile.toPath()).isEmpty()){
                System.out.println("Archivo no encontrado, Creando");
            } else {
                menu = (Menu) JsonReader.readObjectFromFile(menuFile, Menu.class);
            }
        }

        Chef chef1 = new Chef("Pedro", "123", "Pedro@gmail.com");
        Administrativo administrativo1 = new Administrativo("Jose", "456", "Jose@gmail.com");
        Mesero mesero1 = new Mesero("Carlos", "789","Carlos@gmail.com");


        Pedido pedido = new Pedido(c1);

        // INTERFAZ DE TERMINAL PARA PROBAR FUNCIONES

        System.out.println("Bienvenido al sistema de gestión de pedidos.");
        System.out.println("Bienvenido " + c1.getNombre() + ".");
        System.out.println("Por favor, elija una opción:");

        int opcion = 0;

        while (opcion != 9){
            System.out.println("1. Mostrar menú");
            System.out.println("2. Agregar producto");
            System.out.println("3. Sacar producto");
            System.out.println("4. Ver pedido");
            System.out.println("5. Pagar pedido");
            System.out.println("6. Cambiar estado de pedido");
            System.out.println("7. Agregar item a menú");
            System.out.println("8. Sacar item del menú");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Mostrando menú:");
                    menu.mostrarMenu();
                    break;

                case 2:

                    if (!pedido.estaConfirmado()) {
                        System.out.println("Agregando producto:");
                        System.out.println("Ingrese el ID del producto:");
                        int idProducto = scanner.nextInt();

                        boolean check = false;

                        for (ProductoMenu producto : menu.getCategoriasProductos()) {
                            if (producto.getIdProducto() == idProducto){
                                PedidoManager.agregarProducto(producto, pedido);
                                check = true;
                                System.out.println("¡"+ producto.getNombre() + " agregado correctamente!");
                            }
                        }
                        if (!check){
                            System.out.println("¡Item no encontrado!");
                        }

                    } else {
                        System.out.println("Pedido ya esta confirmado");
                    }
                    break;

                case 3:
                    if (!pedido.estaConfirmado()) {
                        if(!pedido.getProductos().isEmpty()){
                            System.out.println("Sacando producto: ");
                            System.out.println("Ingrese el ID del producto: ");
                            int idProductoSacar = scanner.nextInt();

                            boolean encontrado = false;

                            for (ProductoMenu producto : pedido.getProductos()) {
                                if (producto.getIdProducto() == idProductoSacar){
                                    System.out.println("Producto eliminado: " + producto.getNombre());
                                    PedidoManager.eliminarProducto(producto, pedido);
                                    encontrado = true;
                                    break;
                                }
                            }
                            //Si no encuentra el producto hace un sout
                            if(!encontrado) System.out.println("Producto no encontrado");

                        } else {
                            System.out.println("Error. El pedido está vacío");
                        }
                    } else {
                        System.out.println("Pedido ya esta confirmado");
                    }
                    break;

                case 4:
                    if (pedido.getProductos().isEmpty()){
                        System.out.println("No hay productos en el pedido");
                        break;
                    } else {
                        System.out.println("Productos dentro del pedido: ");
                        for (ProductoMenu producto : pedido.getProductos()) {
                            System.out.println(producto.getNombre());
                            System.out.println("Precio: " + producto.getPrecio());
                            System.out.println("---------------------------------------");
                        }
                    }
                    break;

                case 5:
                    if (!pedido.estaConfirmado()) {
                        if(pedido.getProductos().isEmpty()){
                                System.out.println("Error. El pedido está vacío.");
                        } else {
                            pedido.confirmarPedido();
                            System.out.println("Pagando pedido:");

                            System.out.println("Ingresar cupon de descuento (Opciones: DESC10, PROMO25, DESC50) " +
                                    "\n(Dejar en blanco si no hay cupón): ");

                            scanner.nextLine();
                            String cupon = scanner.nextLine();

                            pedido.setCupon(cupon);

                            float temp = pedido.calcularTotal();
                            System.out.println("Precio sin descuento: " + pedido.getTotalSinDescuento());
                            System.out.println("Precio con descuento aplicado (total a pagar): " + temp);

                            System.out.println("Elegir método de pago: ");

                            System.out.println("1. Tarjeta de Crédito");
                            System.out.println("2. Tarjeta de Debito");

                            int metodoPago = 0;
                            while (metodoPago != 1 & metodoPago != 2) {
                                metodoPago = scanner.nextInt();
                                if (metodoPago != 1 & metodoPago != 2) {
                                    System.out.println("Opción no válida. Por favor, elija 1 o 2.");
                                }
                            }

                            System.out.println("Ingrese el numero de tarjeta: ");
                            String numeroTarjeta = scanner.next();
                            System.out.println("Ingrese el nombre del titular: ");
                            String nombreTitular = scanner.next();
                            System.out.println("Ingrese la fecha de vencimiento: ");
                            String fechaVencimiento = scanner.next();
                            System.out.println("Ingrese el CVV: ");
                            String cvv = scanner.next();

                            if (metodoPago == 1){
                                c1.pagarPedido(pedido, new TarjetaCredito(numeroTarjeta, fechaVencimiento, cvv, nombreTitular));
                            } else {
                                c1.pagarPedido(pedido, new TarjetaDebito(numeroTarjeta, fechaVencimiento, cvv, nombreTitular));
                            }
                        }
                    } else {
                        System.out.println("Pedido ya esta confirmado");
                    }
                    break;

                case 6:

                    if (!pedido.estaConfirmado()) {
                        System.out.println("El pedido no está confirmado.");
                    } else {
                        System.out.println("Cambiar estado de pedido:");
                        System.out.println("Ingrese el nuevo estado del pedido: ");
                        System.out.println("1. En preparación");
                        System.out.println("2. Listo para servir");
                        System.out.println("3. Entregado");

                        int nuevoEstado = scanner.nextInt();

                        switch (nuevoEstado){
                            case 1:
                                pedido.cambiarEstado(EstadoPedido.EN_PREPARACION);
                                break;
                            case 2:
                                pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
                                break;
                            case 3:
                                pedido.cambiarEstado(EstadoPedido.ENTREGADO);
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                    }
                    break;

                case 7:
                    MenuManager.agregarItemMenu(menu, scanner);
                    break;

                case 8:
                    MenuManager.eliminarItemMenu(scanner, menu);
                    break;

                case 9:
                    System.out.println("Saliendo del sistema.");
                    JsonWriter.writeFile(menu,menuFile);
                    break;
                    
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }

        }

        scanner.close();
    }


}

