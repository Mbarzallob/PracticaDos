/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.mateo.barzallo.vista;

import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Historial;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Inventario;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Producto;
import ec.edu.ups.practica.dos.mateo.barzallo.modelo.Transaccion;
import java.util.Scanner;

/**
 *
 * @author SOPORTETICS
 */
public class Vista {

    private Scanner scanner;
    private Inventario inventario;
    private Historial historial;

    public Vista() {
        scanner = new Scanner(System.in);
        inventario = new Inventario();
        historial = new Historial();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("======== Menú ========");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Mostrar Historial de Ventas");
            System.out.println("0. Salir");
            System.out.println("-----------------------");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    mostrarHistorialVentas();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    public void agregarProducto() {
        System.out.println("======== Agregar Producto ========");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Producto producto = new Producto(nombre, codigo, precio, cantidadDisponible);
        inventario.agregarProducto(producto);

        System.out.println("Producto agregado exitosamente.");
        System.out.println("-----------------------");
    }

    public void realizarVenta() {
        System.out.println("======== Realizar Venta ========");
        System.out.print("Código del producto: ");
        int codigo = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Producto producto = inventario.buscarProductoPorCodigo(codigo);
        if (producto != null) {
            int stockDisponible = producto.getCantidadDisponible();
            if (cantidad > stockDisponible) {
                System.out.println("No hay suficiente stock disponible para esa cantidad.");
            } else {
                double total = producto.getPrecio() * cantidad;

                // Actualizar la cantidad disponible en el inventario
                inventario.actualizarCantidadProducto(codigo, -cantidad);

                // Agregar una transacción al historial de ventas
                Transaccion transaccion = new Transaccion(producto, cantidad);
                historial.agregarTransaccion(transaccion);

                System.out.println("Venta realizada exitosamente.");
                System.out.println("Total: $" + total);
            }
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
        System.out.println("-----------------------");
    }

    public void mostrarInventario() {
        System.out.println("======== Inventario ========");
        inventario.mostrarInventario();
        System.out.println("-----------------------");
    }

    public void mostrarHistorialVentas() {
        System.out.println("======== Historial de Ventas ========");
        historial.mostrarHistorial();
        System.out.println("-----------------------");
    }

    public String leerLinea() {
        return scanner.nextLine();
    }

    public int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero válido.");
            }
        }
    }

    public double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
    }

}
