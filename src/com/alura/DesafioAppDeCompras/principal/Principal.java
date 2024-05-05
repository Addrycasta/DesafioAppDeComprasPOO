package com.alura.DesafioAppDeCompras.principal;

import com.alura.DesafioAppDeCompras.modelos.Producto;

import java.util.*;

public class Principal extends Producto {
    public Principal(String nombre, double precio) {
        super(nombre, precio);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> historial = new ArrayList<>();
        int opcion;
        
        System.out.println("Escriba el valor de la tarjeta:");
        double valorTarjeta= scanner.nextDouble();
        System.out.println("El valor de la tarjeta es: $" + valorTarjeta);
        scanner.nextLine();

        do {

            String nombre;
            double precio;

            System.out.println("Escriba nombre del producto:");
            nombre = scanner.nextLine();
            while (nombre.trim().isEmpty()) {
                System.out.println("El nombre del producto no puede estar vacío. Inténtalo de nuevo:");
                nombre = scanner.nextLine();
            }
            System.out.println("Producto: " + nombre);

            System.out.println("Escriba el costo del producto:");
            precio = scanner.nextDouble();
            while (precio <= 0) {
                System.out.println("El precio del producto no puede ser negativo o cero. Inténtalo de nuevo:");
                precio = scanner.nextDouble();
            }
            System.out.println("El producto: " + nombre + " tiene un costo de $" + precio);

            if (precio > valorTarjeta) {
                System.out.println("Saldo insuficiente");
                System.out.println(" Su saldo restante es: $" + valorTarjeta);
            } else {
                valorTarjeta -= precio;
                System.out.println("Compra realizada");
                System.out.println(" Su saldo restante es: $" + valorTarjeta);
                historial.add(new Producto(nombre, precio));
            }

            System.out.println("Escriba 0 para continuar o 1 para salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

        }while (opcion == 0);

        System.out.println("Gracias por comprar con nosotros");
        System.out.println("Historial de compras:");
        for (Producto producto : historial) {
            System.out.println("Producto: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
        }
        scanner.close();
    }
}
