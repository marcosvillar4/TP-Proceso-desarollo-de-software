package Clases.pedido;

import enums.EstadoPedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Planificador {

    public void programarPedido(Scanner scanner, Pedido pedido) {
        LocalDateTime fechaProgramada;
        while (true) {
            try {
                System.out.println("Ingrese la fecha de entrega programada (formato: dd/MM/yyyy HH:mm):");
                String input = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                fechaProgramada = LocalDateTime.parse(input, formatter);

                if (fechaProgramada.isAfter(LocalDateTime.now())) {
                    pedido.setHorarioProgramado(fechaProgramada);
                    pedido.setEstado(EstadoPedido.PROGRAMADO);
                    return;
                } else {
                    System.out.println("La fecha debe ser posterior al momento actual.");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Intente nuevamente.");
            }
        }
    }

    public void activarPedidoProgramado(Pedido pedido){
        if(pedido.getEstado() == EstadoPedido.PROGRAMADO && pedido.getHorarioProgramado() != null){
            if(LocalDateTime.now().isAfter(pedido.getHorarioProgramado())){
                pedido.cambiarEstado(EstadoPedido.EN_ESPERA);
                System.out.println("El pedido programado fue activado automáticamente");
            }
        }
    }

}
