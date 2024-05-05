package com.alura.DesafioAppDeCompras.calculos;

import com.alura.DesafioAppDeCompras.modelos.Producto;

import java.util.*;

public class HistorialCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> historial = new ArrayList<>();

        while (true) {
            System.out.println("Escriba el nombre del producto (o 'salir' para terminar):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Escriba el precio del producto:");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            historial.add(new Producto(nombre, precio));
        }

        // Ordenar el historial por precio de menor a mayor
        Collections.sort(historial, Comparator.comparingDouble(Producto::getPrecio));

        System.out.println("\nHistorial de compras (ordenado por precio):");
        for (Producto producto : historial) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }

        System.out.println("Hasta luego");
        scanner.close();
    }
}
